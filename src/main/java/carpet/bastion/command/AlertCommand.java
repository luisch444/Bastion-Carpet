package carpet.bastion.command;

import carpet.bastion.BastionCarpetSettings;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Texts;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Iterator;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class AlertCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("alert")
                    .requires(player -> BastionCarpetSettings.commandAlert)
                .then(argument("player", EntityArgumentType.entities())
                        .then(argument("text", StringArgumentType.string())
                                .executes(context -> alert((ServerCommandSource)context.getSource(), EntityArgumentType.getPlayers(context, "player"), StringArgumentType.getString(context, "text"), TitleS2CPacket.Action.TITLE))))
                .then(literal("all")
                        .then(argument("text", StringArgumentType.string())
                                .executes(context -> alert((ServerCommandSource)context.getSource(), StringArgumentType.getString(context, "text"), TitleS2CPacket.Action.TITLE)))));

    }

    private static int alert(ServerCommandSource source, Collection< ServerPlayerEntity > targets, String text, TitleS2CPacket.Action type) throws CommandSyntaxException {
        Iterator var4 = targets.iterator();

        while(var4.hasNext()) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var4.next();
            serverPlayerEntity.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("minecraft:block.note_block.cow_bell"), SoundCategory.MASTER, serverPlayerEntity.getPos(), 5, 1));
            serverPlayerEntity.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.bell.use"), SoundCategory.MASTER, serverPlayerEntity.getPos(), 5, 1));
            serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(type, Texts.parse(source, new LiteralText(text), serverPlayerEntity, 0)));
        }

        return targets.size();
    }

    private static int alert(ServerCommandSource source, String text, TitleS2CPacket.Action type) throws CommandSyntaxException {
        Iterator var4 = source.getWorld().getPlayers().listIterator();

        while(var4.hasNext()) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var4.next();
            serverPlayerEntity.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("minecraft:block.note_block.cow_bell"), SoundCategory.MASTER, serverPlayerEntity.getPos(), 5, 1));
            serverPlayerEntity.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.bell.use"), SoundCategory.MASTER, serverPlayerEntity.getPos(), 5, 1));
            serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(type, Texts.parse(source, new LiteralText(text), serverPlayerEntity, 0)));
        }

        return 1;
    }
}
