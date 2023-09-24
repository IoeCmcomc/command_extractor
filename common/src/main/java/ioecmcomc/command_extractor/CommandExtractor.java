package ioecmcomc.command_extractor;

import static net.minecraft.commands.Commands.literal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.synchronization.ArgumentUtils;
import net.minecraft.network.chat.Component;

public class CommandExtractor {
    public static final String MOD_ID = "command_extractor";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
    
    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
            dispatcher.register(
                literal("commandextractor")
                    .then(literal("extract")
                            .executes(ctx -> {
                                return extractCommands(ctx);
                            })
                    )
            );
            dispatcher.register(
                literal("cmdextr").executes(ctx -> {
                    return extractCommands(ctx);
                })
            );
        });

        System.out.println(PlatformSpecific.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Extract currently avaliable commands from the game to a file.
     * 
     * @param ctx the command context
     * @return 0 if succeed, 1 if failed
     */
    private static int extractCommands(CommandContext<CommandSourceStack> ctx) {
        sendSystemMessage(ctx, "Extracting commands...");
        
        Commands commands = ctx.getSource().getServer().getCommands();
        CommandDispatcher<CommandSourceStack> disp = commands.getDispatcher();
        
        // String path = PlatformSpecific.getConfigDirectory().resolve("extracted_commands.json").toString();
        String path = java.nio.file.Path.of("./extracted/commands.json", "").toAbsolutePath().normalize().toString();
        new File("extracted").mkdir();
        try (FileWriter writer = new FileWriter(path)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
		    // gson.toJson(nodeToJson(disp.getRoot()), gson.newJsonWriter(writer));
            JsonObject obj = ArgumentUtils.serializeNodeToJson(disp, disp.getRoot());
            gson.toJson(obj, gson.newJsonWriter(writer));
            sendSystemMessage(ctx, "Extracted commands to '" + path + "'");
            return Command.SINGLE_SUCCESS;
        } catch (IOException e) {
            sendSystemMessage(ctx, "Can not extract commands: " + e.getLocalizedMessage());
            e.printStackTrace();
            return 0;
        }
    }

    // Unfinised and unused
    private static <S> JsonObject nodeToJson(CommandNode<S> node) {
        JsonObject obj = new JsonObject();
        CommandNode<S> redirect = node.getRedirect();
        if (redirect != null) {
            JsonArray arr = new JsonArray(1);
            arr.add(node.getName());
            obj.add("redirect", arr);
        }
        if (node.getCommand() != null) {
            obj.addProperty("executable", true);
        }
        if (node instanceof RootCommandNode) {
            obj.addProperty("type", "root");
        } else {
            for (CommandNode<S> child: node.getChildren()) {
                obj.add(child.getName(), nodeToJson(child));
            }
            obj.addProperty("type", (node instanceof LiteralCommandNode) ? "literal" : "argument");
            if (node instanceof ArgumentCommandNode argNode) {
                obj.addProperty("parser", argNode.getType().toString());
            }
        }
        return obj;
    }

    private static void sendSystemMessage(CommandContext<CommandSourceStack> ctx, String message) {
        ctx.getSource().sendSystemMessage(Component.empty().append(message));
    }
}
