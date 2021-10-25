package carpet.bastion.mixin;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

@Mixin(AbstractSkeletonEntity.class)
public class AbstractSkelettonEntityMixin extends HostileEntity {

    protected AbstractSkelettonEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


    @Redirect(method = "Lnet/minecraft/entity/mob/AbstractSkeletonEntity;initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/entity/EntityData;",
            at = @At(value = "INVOKE",
            target = "Ljava/time/LocalDate;now()Ljava/time/LocalDate;"))
    private LocalDate customLocale()  {
        if(BastionCarpetSettings.isHalloween) return LocalDate.now().withMonth(Calendar.NOVEMBER).with(TemporalAdjusters.lastDayOfMonth());
        else return LocalDate.now();
    }
}
