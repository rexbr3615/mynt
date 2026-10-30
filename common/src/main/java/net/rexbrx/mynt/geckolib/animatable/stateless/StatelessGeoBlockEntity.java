package net.rexbrx.mynt.geckolib.animatable.stateless;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.rexbrx.mynt.geckolib.GeckoLibServices;
import net.rexbrx.mynt.geckolib.animatable.GeoBlockEntity;
import net.rexbrx.mynt.geckolib.animation.RawAnimation;
import net.rexbrx.mynt.geckolib.network.packet.StatelessBlockEntityPlayAnimPacket;
import net.rexbrx.mynt.geckolib.network.packet.StatelessBlockEntityStopAnimPacket;

/**
 * Extension of {@link StatelessAnimatable} for {@link GeoBlockEntity} animatables
 */
public non-sealed interface StatelessGeoBlockEntity extends StatelessAnimatable, GeoBlockEntity {
    /**
     * Start or continue a pre-defined animation
     */
    @Override
    default void playAnimation(RawAnimation animation) {
        if (!(this instanceof BlockEntity self))
            throw new ClassCastException("Cannot use StatelessGeoBlockEntity on a non-blockentity animatable!");

        if (self.getLevel() instanceof ServerLevel level) {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingBlock(new StatelessBlockEntityPlayAnimPacket(self.getBlockPos(), animation), level, self.getBlockPos());
        }
        else {
            handleClientAnimationPlay(this, 0, animation);
        }
    }

    /**
     * Stop an already-playing animation
     */
    @Override
    default void stopAnimation(String animation) {
        if (!(this instanceof BlockEntity self))
            throw new ClassCastException("Cannot use StatelessGeoBlockEntity on a non-blockentity animatable!");

        if (self.getLevel() instanceof ServerLevel level) {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingBlock(new StatelessBlockEntityStopAnimPacket(self.getBlockPos(), animation), level, self.getBlockPos());
        }
        else {
            handleClientAnimationStop(this, 0, animation);
        }
    }
}