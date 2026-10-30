package net.rexbrx.mynt.geckolib.animation.keyframe.event;

import net.rexbrx.mynt.geckolib.animatable.GeoAnimatable;
import net.rexbrx.mynt.geckolib.animation.AnimationController;
import net.rexbrx.mynt.geckolib.animation.keyframe.event.data.ParticleKeyframeData;

/**
 * The {@link KeyFrameEvent} specific to the {@link AnimationController#particleKeyframeHandler}
 * <p>
 * Called when a particle instruction keyframe is encountered
 */
public class ParticleKeyframeEvent<T extends GeoAnimatable> extends KeyFrameEvent<T, ParticleKeyframeData> {
	public ParticleKeyframeEvent(T animatable, double animationTick, AnimationController<T> controller, ParticleKeyframeData particleKeyFrameData) {
		super(animatable, animationTick, controller, particleKeyFrameData);
	}

	/**
	 * Get the {@link ParticleKeyframeData} relevant to this event call
	 */
	@Override
	public ParticleKeyframeData getKeyframeData() {
		return super.getKeyframeData();
	}
}
