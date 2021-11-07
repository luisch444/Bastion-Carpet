package carpet.bastion.command;

import carpet.bastion.BastionCarpetSettings;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.MessageArgumentType;
import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Identifier;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class AlertCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("alert").
                requires(player -> BastionCarpetSettings.alertCommand).
                then(argument("player", EntityArgumentType.players()).
                        then(argument("text", MessageArgumentType.message()).
                                executes(context -> alert(context.getSource(), EntityArgumentType.getPlayers(context, "player"), MessageArgumentType.getMessage(context, "text"))))).
                then(literal("all").
                        then(argument("text", MessageArgumentType.message()).
                                executes(context -> alert(context.getSource(), null, MessageArgumentType.getMessage(context, "text"))))));

    }

    private static int alert(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Text text) throws CommandSyntaxException {
        if (targets == null) {
            targets = source.getMinecraftServer().getPlayerManager().getPlayerList();
        }
        for (ServerPlayerEntity player : targets) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("minecraft:block.note_block.cow_bell"), SoundCategory.MASTER, player.getPos(), 5, 1));
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.bell.use"), SoundCategory.MASTER, player.getPos(), 5, 1));
            player.networkHandler.sendPacket(new TitleS2CPacket(TitleS2CPacket.Action.TITLE, Texts.parse(source, text, player, 0)));
        }
        return 1;
    }
}
