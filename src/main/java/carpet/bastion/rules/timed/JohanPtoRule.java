package carpet.bastion.rules.timed;

import carpet.bastion.BastionCarpetSettings;
import carpet.bastion.utils.MCTime;
import net.minecraft.network.MessageType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;


public class JohanPtoRule extends GenericTimedRule {
    public JohanPtoRule(int time, MCTime unit) {
        super(time, unit);
    }

    @Override
    public void execute(MinecraftServer server) {
        if (!BastionCarpetSettings.isJohanPto) {
            return;
        }
        if (server.getTicks() % this.getTime() * this.getUnit().getTime() == 0) {
            server.getPlayerManager().broadcastChatMessage(new LiteralText("Johan Pto"), MessageType.CHAT, Util.NIL_UUID);
        }
    }
}
