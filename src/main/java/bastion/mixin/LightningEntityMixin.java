package bastion.mixin;

import bastion.BastionCarpetSettings;
import carpet.CarpetSettings;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin extends Entity {

    @Shadow private boolean cosmetic;

    public LightningEntityMixin (EntityType<? extends LightningEntity> entityType, World world) {
        super(entityType, world);
    }

    private void spawnFire(int spreadAttempts) {
        if (!this.cosmetic && !this.world.isClient && this.world.getGameRules().getBoolean(GameRules.DO_FIRE_TICK) && !BastionCarpetSettings.disablelightingfire) {
            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = AbstractFireBlock.getState(this.world, blockPos);
            if (this.world.getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.world, blockPos)) {
                this.world.setBlockState(blockPos, blockState);
            }

            for(int i = 0; i < spreadAttempts; ++i) {
                BlockPos blockPos2 = blockPos.add(this.random.nextInt(3) - 1, this.random.nextInt(3) - 1, this.random.nextInt(3) - 1);
                blockState = AbstractFireBlock.getState(this.world, blockPos2);
                if (this.world.getBlockState(blockPos2).isAir() && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState);
                }
            }

        }
    }
}
