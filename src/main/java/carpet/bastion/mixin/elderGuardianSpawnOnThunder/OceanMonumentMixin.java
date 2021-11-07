package carpet.bastion.mixin.elderGuardianSpawnOnThunder;

import carpet.CarpetServer;
import carpet.bastion.BastionCarpetSettings;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.OceanMonumentFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(OceanMonumentFeature.class)
public abstract class OceanMonumentMixin extends StructureFeature<DefaultFeatureConfig> {
    private static final List<SpawnSettings.SpawnEntry> MONSTER_SPAWNS = ImmutableList.of(
            new SpawnSettings.SpawnEntry(EntityType.GUARDIAN, 1, 2, 4)
    );
    private static final List<SpawnSettings.SpawnEntry> THUNDER_MONSTER_SPAWNS = ImmutableList.of(
            new SpawnSettings.SpawnEntry(EntityType.GUARDIAN, 10, 2, 4),
            new SpawnSettings.SpawnEntry(EntityType.ELDER_GUARDIAN, 1, 1, 1)
    );
    public OceanMonumentMixin(Codec<DefaultFeatureConfig> codec){
        super(codec);
    }

    @Override
    public List<SpawnSettings.SpawnEntry> getMonsterSpawns() {
        if (BastionCarpetSettings.elderGuardianSpawnOnThunder && CarpetServer.minecraft_server.getOverworld().isThundering()){
            return THUNDER_MONSTER_SPAWNS;
        }
        return MONSTER_SPAWNS;
    }
}
