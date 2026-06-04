package uk.sigma_co.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import uk.sigma_co.init.AstraItems;

import java.util.concurrent.CompletableFuture;

public class AstraModEnglishLangProvider extends FabricLanguageProvider {
    protected AstraModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(AstraItems.ASTRA_ORB.get(), "Astra Orb");
    }
}
