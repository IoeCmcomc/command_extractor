package ioecmcomc.command_extractor.forge;

import ioecmcomc.command_extractor.PlatformSpecific;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class PlatformSpecificImpl {
    /**
     * This is our actual method to {@link PlatformSpecific#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
