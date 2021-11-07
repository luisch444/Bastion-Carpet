package carpet.bastion.mixin.disableLightingFire;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.entity.LightningEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin {
    @Shadow protected abstract void spawnFire(int spreadAttempts);

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LightningEntity;spawnFire(I)V"))
    private void customSpawnFire(LightningEntity le, int spreadAttempts) {
        if (BastionCarpetSettings.disableLightingFire) {
            return;
        }
        spawnFire(spreadAttempts);
    }
}
