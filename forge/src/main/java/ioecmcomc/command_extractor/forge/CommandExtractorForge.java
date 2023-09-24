package ioecmcomc.command_extractor.forge;

import dev.architectury.platform.forge.EventBuses;
import ioecmcomc.command_extractor.CommandExtractor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CommandExtractor.MOD_ID)
public class CommandExtractorForge {
    public CommandExtractorForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(CommandExtractor.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        CommandExtractor.init();
    }
}
