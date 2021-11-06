package carpet.bastion.mixin;


import carpet.bastion.BastionCarpetSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BatEntity.class)
public abstract class BatEntityMixin extends LivingEntity {
    protected BatEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    public void onDeath(DamageSource source) {
        if(BastionCarpetSettings.batsSayUwUonDeath && source.getAttacker()!=null && source.getAttacker().getType()==EntityType.PLAYER) {
            PlayerEntity p = (PlayerEntity) source.getAttacker();
            p.sendMessage(new TranslatableText("UwU").formatted(Formatting.GREEN), false);
        }
    }
}
