package ioecmcomc.command_extractor.fabric;

import ioecmcomc.command_extractor.fabriclike.CommandExtractorFabricLike;
import net.fabricmc.api.ModInitializer;

public class CommandExtractorFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandExtractorFabricLike.init();
    }
}
