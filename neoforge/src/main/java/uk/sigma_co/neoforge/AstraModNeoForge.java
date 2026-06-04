package uk.sigma_co.neoforge;

import net.neoforged.fml.common.Mod;

import uk.sigma_co.AstraMod;

@Mod(AstraMod.MOD_ID)
public final class AstraModNeoForge {
    public AstraModNeoForge() {
        // Run our common setup.
        AstraMod.init();
    }
}
