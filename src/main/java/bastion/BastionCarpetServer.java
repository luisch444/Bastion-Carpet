package bastion;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;

public class BastionCarpetServer implements CarpetExtension, ModInitializer {

    public static final String compactName = "bastion-carpet";

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
    }


}
