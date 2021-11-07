package carpet.bastion.mixin.botsLoadChunks;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.world.ThreadedAnvilChunkStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ThreadedAnvilChunkStorage.class)
public class ThreadedAnvilChunkStorageMixin {
    @Shadow @Final private ServerWorld world;

    @Inject(method = "updateCameraPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ThreadedAnvilChunkStorage;doesNotGenerateChunks(Lnet/minecraft/server/network/ServerPlayerEntity;)Z"), cancellable = true)
    private void onLoad(ServerPlayerEntity player, CallbackInfo ci) {
        if (!BastionCarpetSettings.botsLoadChunks && !world.getServer().getPlayerManager().isWhitelisted(player.getGameProfile())) {
            ci.cancel();
        }
    }
}


