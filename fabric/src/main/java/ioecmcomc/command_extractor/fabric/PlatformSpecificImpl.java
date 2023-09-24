package ioecmcomc.command_extractor.fabric;

import ioecmcomc.command_extractor.PlatformSpecific;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class PlatformSpecificImpl {
    /**
     * This is our actual method to {@link PlatformSpecific#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
