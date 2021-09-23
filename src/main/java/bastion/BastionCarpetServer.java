package bastion;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.minecraft.server.MinecraftServer;

public class BastionCarpetServer implements CarpetExtension {

    public static final BastionCarpetServer INSTANCE = new BastionCarpetServer();
    public static final String name = BastionCarpetMod.getModId();
    public static final String fancyName = "Bastion Carpet";
    public static final String compactName = name;
    public static MinecraftServer minecraft_server;

    @Override
    public String version(){
        return name;
    }

    public static void registerExtension(){
        CarpetServer.manageExtension(INSTANCE);
    }

    @Override
    public void onGameStarted(){
        CarpetServer.settingsManager.parseSettingsClass(BastionCarpetSettings.class);
    }



}
