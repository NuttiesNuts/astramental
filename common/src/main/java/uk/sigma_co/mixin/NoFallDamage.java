package uk.sigma_co.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.sigma_co.init.AstraItems;

@Mixin(Player.class)
public class NoFallDamage {
    @Unique
    Player player = (Player) (Object) this;

    @Inject(method = "causeFallDamage", at = @At("HEAD"), cancellable = true)
    private void MacelVanitate(float f, float g, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir){
        if (player.isHolding(AstraItems.ASTRA_ORB.get()))
            cir.cancel();
    }
}
