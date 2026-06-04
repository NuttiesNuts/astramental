package uk.sigma_co.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import uk.sigma_co.AstraMod;
import uk.sigma_co.item.OrbItem;

import java.util.function.Supplier;

public class AstraItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(AstraMod.MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Item> ASTRA_ORB;

    public static void init() {
        ASTRA_ORB = registerItem("astra_orb", () -> new OrbItem(new Item.Properties().arch$tab(CreativeModeTabs.COMBAT)));

        //Write to the game registries
        ITEMS.register();
    }

    //Register an item
    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item){
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(AstraMod.MOD_ID, name), item);
    }
}
