package uk.sigma_co.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import uk.sigma_co.util.Utils;

public class OrbItem extends Item {
    public OrbItem(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }

    private static final double DASH_SPEED = 10;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        var cooldown = player.getCooldowns();
        level.playSound(null, player.blockPosition(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.PLAYERS, 4f, 1.8f);
        level.playSound(null, player.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 3f, 0f);

        Vec3 playerLook = player.getLookAngle();
        Vec3 dashVec = new Vec3(playerLook.x(), playerLook.y(), playerLook.z());
        player.setDeltaMovement(dashVec.scale(DASH_SPEED * 0.1));

        cooldown.addCooldown(this, 50);

        // Dash particles
        var width = player.getBbWidth() / 2;
        var height = player.getBbHeight() * 0.3F;
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.POOF, player.getX(), player.getY() + height, player.getZ(), 10, width, height, width, 0.08F);
            serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, player.getX(), player.getY() + height, player.getZ(), 10, width, height, width, 0.02F);
        }

        return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
    }
}
