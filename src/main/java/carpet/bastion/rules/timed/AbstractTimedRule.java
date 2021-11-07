package carpet.bastion.rules.timed;

import carpet.bastion.utils.MCTime;
import net.minecraft.server.MinecraftServer;

public abstract class AbstractTimedRule {
    private final int time;
    private final MCTime unit;
    public AbstractTimedRule(int time, MCTime unit) {
        this.time = time;
        this.unit = unit;
    }

    public int getTime() {
        return time;
    }

    public MCTime getUnit() {
        return unit;
    }

    public abstract void execute(MinecraftServer server);
}
