package carpet.bastion.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import carpet.bastion.BastionCarpetSettings;

@Mixin(ZombifiedPiglinEntity.class)
public abstract class ZombifiedPiglinEntityMixin extends Entity{

    public ZombifiedPiglinEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    public void onDeath(DamageSource source) {

        if(BastionCarpetSettings.zombifiedpiglindropsgoldenapple){
            int rand = (int) (Math.random()*100000+1);
            if(rand==444) {
                ItemStack stack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
                this.dropStack(stack);
            }
        }
    }

}
