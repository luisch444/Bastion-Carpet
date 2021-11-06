package carpet.bastion.rules.timed;

import net.minecraft.server.MinecraftServer;

public interface TimedRuleInterface {
    void execute(MinecraftServer server);
}
