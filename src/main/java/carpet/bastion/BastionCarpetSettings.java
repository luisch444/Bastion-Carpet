package carpet.bastion;

import carpet.settings.Rule;
import static carpet.settings.RuleCategory.*;

public class BastionCarpetSettings {

    public static final String BASTION = "Bastion-Carpet";

    @Rule(desc = "Zombified Piglin drops enchanted golden apple", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean zombifiedpiglindropsgoldenapple = false;

    @Rule(desc = "Disable lighting fire", category = {BASTION, FEATURE})
    public static boolean disablelightingfire = false;

    @Rule(desc = "Disable lighting", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean disablelighting = false;

    @Rule(desc = "When storm the elder guardian can spawn", category = {BASTION, SURVIVAL, FEATURE, EXPERIMENTAL})
    public static boolean elderguardianspawnonthunder = false;

}
