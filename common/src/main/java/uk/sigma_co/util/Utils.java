package uk.sigma_co.util;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Just a bunch of silly useful code
 */
public class Utils {
    public static final RandomSource random = RandomSource.createThreadSafe();

    public static ItemStack inventoryContainsItem(Player player, Class<? extends Item> itemClass) {
        ItemStack itemstack = null;
        for (ItemStack s : player.getInventory().items) {
            if (s != null && itemClass.isInstance(s.getItem())) {
                itemstack = s;
                break;
            }
        }
        return itemstack;
    }
}
