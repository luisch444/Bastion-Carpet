package carpet.bastion.rules;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.network.MessageType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;


public class JohanPtoRule {
    public static void send(MinecraftServer server) {
        if (!BastionCarpetSettings.isJohanPto) {
            return;
        }
        // Cada 20 minutos, 20 * 60 * 20
        if (server.getTicks() % 24_000 == 0) {
            server.getPlayerManager().broadcastChatMessage(new LiteralText("Johan Pto"), MessageType.CHAT, Util.NIL_UUID);
        }
    }
}
