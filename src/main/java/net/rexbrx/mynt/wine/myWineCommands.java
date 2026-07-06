package net.rexbrx.mynt.wine;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.rexbrx.mynt.utils.myMathUtils;

public class myWineCommands {

    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(createRootCommand());
    }

    private static LiteralArgumentBuilder<CommandSourceStack> createRootCommand() {
        return Commands.literal("wyne")
                .requires(source -> source.hasPermission(0))
                .then(Commands.literal("random")
                        .then(Commands.argument("min", IntegerArgumentType.integer())
                                .then(Commands.argument("max", IntegerArgumentType.integer())
                                        .executes(ctx -> executeRandom(ctx.getSource(), IntegerArgumentType.getInteger(ctx, "min"), IntegerArgumentType.getInteger(ctx, "max"))))))
                .then(Commands.literal("say")
                        .then(Commands.argument("message", StringArgumentType.greedyString())
                                .executes(ctx -> executeSay(ctx.getSource(), StringArgumentType.getString(ctx, "message")))));

    }

    private static int executeRandom(CommandSourceStack source, int min, int max) {
        if (min > max) {
            sendMessage(source, "§cMin must be less than or equal to max.");
            return 0;
        }

        int value = myMathUtils.getRandomNumberInRange(min, max);
        sendMessage(source, "Random value between " + min + " and " + max + ": " + value);
        return 1;
    }

    private static int executeSay(CommandSourceStack source, String message) {
        sendMessage(source, "[mywine] " + message);
        return 1;
    }

    private static void sendMessage(CommandSourceStack source, String message) {
        source.sendSuccess(() -> Component.literal(message), false);
    }
}
