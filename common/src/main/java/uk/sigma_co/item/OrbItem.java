package uk.sigma_co.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import uk.sigma_co.util.Utils;

public class OrbItem extends Item {
    public OrbItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        var cooldown = player.getCooldowns();
        level.playSound(null, player.blockPosition(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.PLAYERS, 4f, 1.8f);
        level.playSound(null, player.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 3f, 0f);

        float rot = (player.getYRot() + 90F) * Mth.DEG_TO_RAD;
        Vec3 playerLook = Vec3.ZERO.add(Mth.cos(rot), 0, Mth.sin(rot)).normalize().scale(1.2F);
        Vec3 dashVec = new Vec3(playerLook.x(), player.getDeltaMovement().y(), playerLook.z());
        player.setDeltaMovement(dashVec);

        cooldown.addCooldown(this, 50);

        // Dash particles
        for (int a = 0; a < 35; a++) {
            Vec3 motion = dashVec.scale(Utils.random.nextDouble() * .25f);
            level.addParticle(ParticleTypes.ELECTRIC_SPARK, player.getRandomX(.4f), player.getRandomY(), player.getRandomZ(.4f), motion.x, motion.y, motion.z);
        }
        for (int a = 0; a < 5; a++) {
            Vec3 motion = dashVec.scale(Utils.random.nextDouble() * .25f);
            level.addParticle(ParticleTypes.ENCHANT, player.getRandomX(.4f), player.getRandomY(), player.getRandomZ(.4f), motion.x, motion.y, motion.z);
        }

        return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
    }
}
