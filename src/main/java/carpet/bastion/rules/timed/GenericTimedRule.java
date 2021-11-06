package carpet.bastion.rules.timed;

import carpet.bastion.utils.MCTime;
import net.minecraft.server.MinecraftServer;

public class GenericTimedRule implements TimedRuleInterface {
    private final int time;
    private final MCTime unit;
    public GenericTimedRule(int time, MCTime unit) {
        this.time = time;
        this.unit = unit;
    }

    public int getTime() {
        return time;
    }

    public MCTime getUnit() {
        return unit;
    }

    @Override
    public void execute(MinecraftServer server) { }
}
