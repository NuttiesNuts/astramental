package uk.sigma_co.fabric;

import net.fabricmc.api.ModInitializer;

import uk.sigma_co.AstraMod;

public final class AstraModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        AstraMod.init();
    }
}
