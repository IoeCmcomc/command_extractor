package ioecmcomc.command_extractor.quilt;

import ioecmcomc.command_extractor.fabriclike.CommandExtractorFabricLike;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class CommandExtractorQuilt implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandExtractorFabricLike.init();
    }
}
