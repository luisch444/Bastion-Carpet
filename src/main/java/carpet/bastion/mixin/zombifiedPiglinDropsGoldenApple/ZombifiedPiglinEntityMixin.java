package carpet.bastion.mixin.zombifiedPiglinDropsGoldenApple;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombifiedPiglinEntity.class)
public abstract class ZombifiedPiglinEntityMixin extends MobEntity {
    protected ZombifiedPiglinEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        if (BastionCarpetSettings.zombifiedPiglinDropsGoldenApple) {
            int rand = (int) (Math.random() * 100000 + 1);
            if (rand == 444) {
                this.dropStack(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
            }
        }
    }
}
