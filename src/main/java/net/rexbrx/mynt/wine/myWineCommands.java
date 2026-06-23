package net.rexbrx.mynt.wine;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.rexbrx.mynt.oasis.MyntApi;

import java.util.function.Supplier;

import static net.minecraft.commands.arguments.ResourceArgument.getEntityType;
import static net.minecraft.commands.arguments.blocks.BlockStateArgument.getBlock;

public class myWineCommands {

    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(createRootCommand());
    }

    private static LiteralArgumentBuilder<CommandSourceStack> createRootCommand() {
        return Commands.literal("mywine")
                .requires(source -> source.hasPermission(0))
                .then(Commands.literal("ping")
                        .executes(ctx -> executePing(ctx.getSource())))
                .then(Commands.literal("random")
                        .then(Commands.argument("min", IntegerArgumentType.integer())
                                .then(Commands.argument("max", IntegerArgumentType.integer())
                                        .executes(ctx -> executeRandom(ctx.getSource(), IntegerArgumentType.getInteger(ctx, "min"), IntegerArgumentType.getInteger(ctx, "max"))))))
                .then(Commands.literal("say")
                        .then(Commands.argument("message", StringArgumentType.greedyString())
                                .executes(ctx -> executeSay(ctx.getSource(), StringArgumentType.getString(ctx, "message")))))
                .then(Commands.literal("structure")
                        .then(Commands.argument("modid", StringArgumentType.word())
                                .then(Commands.argument("path", StringArgumentType.word())
                                        .then(Commands.argument("x", IntegerArgumentType.integer())
                                                .then(Commands.argument("y", IntegerArgumentType.integer())
                                                        .then(Commands.argument("z", IntegerArgumentType.integer())
                                                                .then(Commands.argument("loadEntities", BoolArgumentType.bool())
                                                                        .executes(ctx -> executePlaceStructure(ctx.getSource(), StringArgumentType.getString(ctx, "modid"), StringArgumentType.getString(ctx, "path"), IntegerArgumentType.getInteger(ctx, "x"), IntegerArgumentType.getInteger(ctx, "y"), IntegerArgumentType.getInteger(ctx, "z"), BoolArgumentType.getBool(ctx, "loadEntities"))))))))));
    }

    private static int executePing(CommandSourceStack source) {
        sendMessage(source, "Pong from MyWineCommands!");
        MyntApi.logDebug("Executed /mywine ping");
        return 1;
    }

    private static int executeRandom(CommandSourceStack source, int min, int max) {
        if (min > max) {
            sendMessage(source, "§cMin must be less than or equal to max.");
            return 0;
        }

        int value = MyntApi.randomInt(min, max);
        sendMessage(source, "Random value between " + min + " and " + max + ": " + value);
        return 1;
    }

    private static int executeSay(CommandSourceStack source, String message) {
        sendMessage(source, "[mywine] " + message);
        return 1;
    }


    private static int executePlaceStructure(CommandSourceStack source, String modid, String path, int x, int y, int z, boolean loadEntities) {
        Level level = source.getLevel();
        MyntApi.placeStructure(level, modid, path, x, y, z, loadEntities);
        sendMessage(source, "Placed structure " + modid + ":" + path + " at " + x + ", " + y + ", " + z + ".");
        return 1;
    }

    private static void sendMessage(CommandSourceStack source, String message) {
        source.sendSuccess(() -> Component.literal(message), false);
    }
}
