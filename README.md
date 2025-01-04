# command_extractor

***Command Extractor*** is a Minecraft mod that extracts available in-game commands to a JSON file, using the same mechanism as the Minecraft built-in data generator.

This mod is useful if you are a Minecraft datapack developer/programmer working in an environment with modded or user-defined commands. Several Minecraft datapack and command-related tools, such as [MCDatapacker](https://github.com/IoeCmcomc/MCDatapacker) and [Spyglass](https://github.com/SpyglassMC/Spyglass), accept a user-defined `commands.json` file. That JSON file defines structures and arguments of various Minecraft commands. You can utilize the file exported by Command Extractor to make these tools aware of these custom commands.

This mod requires [Architectury API mod](https://modrinth.com/mod/architectury-api "Architectury API mod") to be installed.

This mod currently supports Minecraft 1.20.1, tested on Forge, Quilt, and Fabric. Use older versions of the mod for Minecraft 1.19.2 and 1.19.4.

## Usage

Run `/cmdextr` command inside the game to extract commands.

The extracted JSON command tree file will be saved into `extracted/commands.json` in the game folder.

By default, the `cmdextr` command itself is not included in the output file unless `/cmdextr all` is used. Nevertheless, the output file contains both vanilla and non-vanilla commands.

## Mods incompatibilities
Since the mod uses the built-in logic to export data, it can't gracefully ignore problematic commands. Therefore, this mod may not play well with some other mods.

In my tests, the following mods don't work with Command Extractor: 
* Spartan Weaponry (SpartanWeaponry-1.20.1-forge-3.1.3-all.jar)