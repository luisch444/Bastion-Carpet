package carpet.bastion;

import carpet.settings.Rule;
import static carpet.settings.RuleCategory.*;

public class BastionCarpetSettings {
    public static final String BASTION = "Bastion-Carpet";

    @Rule(desc = "Enables /signal command to get a container with comparator value.", category = { BASTION, CREATIVE, COMMAND })
    public static boolean signalCommand = false;

    @Rule(desc = "Enables /ip command.", category = {BASTION, COMMAND})
    public static boolean ipCommand = false;

    @Rule(desc = "Enables /host command.", category = {BASTION, COMMAND})
    public static boolean hostCommand = false;

    @Rule(desc = "Enables /alert command.", category = { BASTION, COMMAND })
    public static boolean alertCommand = false;

    @Rule(desc = "Zombified Piglin drops enchanted golden apple.", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean zombifiedPiglinDropsGoldenApple = false;

    @Rule(desc = "Disable lighting fire.", category = {BASTION, FEATURE})
    public static boolean disableLightingFire = false;

    @Rule(desc = "When storm the elder guardian can spawn.", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean elderGuardianSpawnOnThunder = false;

    @Rule(desc = "Can disable bots load new chunks.", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean botsLoadChunks = true;

    @Rule(desc = "It's Halloween for Mobs.", category = {BASTION, CREATIVE, FEATURE, EXPERIMENTAL})
    public static boolean isHalloween = false;

    @Rule(desc = "Bats say UwU on death.", category = { BASTION, COMMAND })
    public static boolean batsSayUwUOnDeath = false;

    @Rule(desc = "Sends the message 'Johan pto' every 20 minutes.", category = {BASTION, FEATURE})
    public static boolean isJohanPto = false;

    @Rule(desc = "Sends the averroes hosting discount message every 20 minutes.", category = BASTION)
    public static boolean discountMessage = false;
}
