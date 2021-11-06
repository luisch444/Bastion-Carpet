package carpet.bastion.rules.timed;

import carpet.bastion.BastionCarpetSettings;
import carpet.bastion.utils.MCTime;
import net.minecraft.network.MessageType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;

public class DescuentoRule extends GenericTimedRule {
    public DescuentoRule(int time, MCTime unit) {
        super(time, unit);
    }

    @Override
    public void execute(MinecraftServer server) {
        if (!BastionCarpetSettings.discountTimedMessage) {
            return;
        }
        if (server.getTicks() % (this.getTime() * this.getUnit().getTime()) == 0) {
            server.getPlayerManager().broadcastChatMessage(new LiteralText("20% de descuento con el código abaddon en averroshosting"), MessageType.CHAT, Util.NIL_UUID);
        }
    }
}
