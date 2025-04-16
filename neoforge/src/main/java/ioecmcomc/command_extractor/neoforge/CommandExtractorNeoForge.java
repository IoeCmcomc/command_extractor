package ioecmcomc.command_extractor.neoforge;

// import dev.architectury.platform.forge.EventBuses;
import ioecmcomc.command_extractor.CommandExtractor;
import net.neoforged.fml.common.Mod;
// import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CommandExtractor.MOD_ID)
public class CommandExtractorNeoForge {
    public CommandExtractorNeoForge() {
        // Submit our event bus to let architectury register our content on the right time
        // EventBuses.registerModEventBus(CommandExtractor.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        CommandExtractor.init();
    }
}
