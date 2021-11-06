package carpet.bastion;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.bastion.command.AlertCommand;
import carpet.bastion.command.CommandSignal;
import carpet.bastion.command.HostCommand;
import carpet.bastion.command.IPCommand;
import carpet.bastion.rules.timed.DescuentoRule;
import carpet.bastion.rules.timed.JohanPtoRule;
import carpet.bastion.rules.timed.TimedRuleInterface;
import carpet.bastion.utils.MCTime;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

import java.util.ArrayList;
import java.util.List;

public class BastionCarpetServer implements CarpetExtension, ModInitializer {

    public static final String compactName = "bastion-carpet";
    private final List<TimedRuleInterface> timedRules = new ArrayList<>();

    @Override
    public String version(){
        return compactName;
    }

    public static void loadExtension()
    {
        CarpetServer.manageExtension(new BastionCarpetServer());
    }

    @Override
    public void onInitialize()
    {
        BastionCarpetServer.loadExtension();
    }

    @Override
    public void onGameStarted()
    {
        // let's /carpet handle our few simple settings
        CarpetServer.settingsManager.parseSettingsClass(BastionCarpetSettings.class);

        timedRules.add(new JohanPtoRule(20, MCTime.MINUTES));
        timedRules.add(new DescuentoRule(20, MCTime.MINUTES));
    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        CommandSignal.register(dispatcher);
        AlertCommand.register(dispatcher);
        IPCommand.register(dispatcher);
        HostCommand.register(dispatcher);
    }

    @Override
    public void onTick(MinecraftServer server) {
        timedRules.forEach(timedRule -> timedRule.execute(server));
    }
}
