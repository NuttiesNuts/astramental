package uk.sigma_co;

import dev.architectury.event.events.common.PlayerEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.sigma_co.init.AstraItems;
import uk.sigma_co.item.OrbItem;
import uk.sigma_co.util.Utils;

public final class AstraMod {
    public static final String MOD_ID = "astramental";

    public static void init() {
        AstraItems.init();
    }
}
