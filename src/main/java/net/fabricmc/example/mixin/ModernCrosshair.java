package net.fabricmc.example.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(InGameHud.class)
public class ModernCrosshair extends DrawableHelper {

    @Shadow @Final private MinecraftClient client;


	@Inject( method = "showCrosshair()Z", at = @At("TAIL"), cancellable = true)
	private void modernCrosshair(CallbackInfoReturnable<Boolean> ci) {
        if(client.options.perspective > 0) {
            ci.setReturnValue(false);
        }
    }
}
