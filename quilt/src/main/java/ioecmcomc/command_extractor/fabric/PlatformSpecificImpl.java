package ioecmcomc.command_extractor.fabric;

import ioecmcomc.command_extractor.PlatformSpecific;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class PlatformSpecificImpl {
    /**
     * This is our actual method to {@link PlatformSpecific#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
