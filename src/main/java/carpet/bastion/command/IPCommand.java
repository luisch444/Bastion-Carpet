package carpet.bastion.command;

import carpet.bastion.BastionCarpetSettings;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.literal;

public class IPCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("ip").
                requires(enabled -> BastionCarpetSettings.ipCommand).
                executes(context -> {
                    context.getSource().sendFeedback(new LiteralText("bastion.com"), false);
                    return 1;
                }));
    }
}
