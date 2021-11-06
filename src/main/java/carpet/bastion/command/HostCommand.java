package carpet.bastion.command;

import carpet.bastion.BastionCarpetSettings;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.literal;

public class HostCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("host").
                requires(enabled -> BastionCarpetSettings.hostCommand).
                executes(context -> {
                    context.getSource().sendFeedback(new LiteralText("averroesHosting ofc"), false);
                    return 1;
                }));
    }
}
