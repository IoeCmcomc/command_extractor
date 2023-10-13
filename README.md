# command_extractor

***Command Extractor*** is a Minecraft mod to extract available in-game commands to a JSON file, using the same mechanism as the Minecraft built-in data generator.

This mod requires [Architectury API mod](https://modrinth.com/mod/architectury-api "Architectury API mod") to be installed. 

This mod currently only support Minecraft 1.19.4, tested on Forge, Quilt and Fabric.

## Usage

Run `/cmdextr` command inside the game to extract commands.

The extracted JSON command tree file will be saved into `extracted/commands.json` in the game folder.

By default, the `cmdextr` command itself is not included in the output file unless `/cmdextr all` is used.
