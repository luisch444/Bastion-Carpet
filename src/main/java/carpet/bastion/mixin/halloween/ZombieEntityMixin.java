package carpet.bastion.mixin.halloween;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {
    @Redirect(method = "initialize", at = @At(value = "INVOKE", target = "Ljava/time/LocalDate;now()Ljava/time/LocalDate;"))
    private LocalDate customLocale()  {
        if (BastionCarpetSettings.isHalloween) {
            return LocalDate.now().withMonth(Calendar.NOVEMBER).with(TemporalAdjusters.lastDayOfMonth());
        }
        else {
            return LocalDate.now();
        }
    }
}
