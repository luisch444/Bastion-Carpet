package bastion;

import net.fabricmc.api.ModInitializer;

public class BastionCarpetMod implements ModInitializer {

    private static final String MOD_ID = "bastion";

    @Override
    public void onInitialize() {
        System.out.println("Bastion-carpet loaded");
    }

    public static String getModId(){
        return MOD_ID;
    }

}
