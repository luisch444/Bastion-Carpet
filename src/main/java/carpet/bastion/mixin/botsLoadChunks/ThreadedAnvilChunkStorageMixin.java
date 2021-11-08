package carpet.bastion.mixin.botsLoadChunks;

import carpet.bastion.BastionCarpetSettings;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ThreadedAnvilChunkStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ThreadedAnvilChunkStorage.class)
public class ThreadedAnvilChunkStorageMixin {
    @Inject(method = "updateCameraPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ThreadedAnvilChunkStorage;doesNotGenerateChunks(Lnet/minecraft/server/network/ServerPlayerEntity;)Z"), cancellable = true)
    private void onLoad(ServerPlayerEntity player, CallbackInfo ci) {
        if (!BastionCarpetSettings.botsLoadChunks && player.getClass() != ServerPlayerEntity.class) {
            ci.cancel();
        }
    }
}


