package net.rexbrx.mynt.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.rexbrx.mynt.morehitboxes.internal.MultiPartEntityHitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Shadow
    @Nullable
    public HitResult hitResult;

    /**
     * Replace target in attack call with the multipart that was saved in {@link ProjectileUtilMixin}
     */
    @WrapOperation(method = "startAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;attack(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;)V"))
    private void redirectAttackTarget(MultiPlayerGameMode gameMode, Player player, Entity targetEntity, Operation<Void> original) {
        if (hitResult instanceof MultiPartEntityHitResult entityHitResult && entityHitResult.moreHitboxes$getMultiPart() != null) {
            original.call(gameMode, player, entityHitResult.moreHitboxes$getMultiPart().getEntity());
        } else {
            original.call(gameMode, player, targetEntity);
        }
    }
}
