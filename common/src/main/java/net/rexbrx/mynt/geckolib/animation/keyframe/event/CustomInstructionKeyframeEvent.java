/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package net.rexbrx.mynt.geckolib.animation.keyframe.event;

import net.rexbrx.mynt.geckolib.animatable.GeoAnimatable;
import net.rexbrx.mynt.geckolib.animation.AnimationController;
import net.rexbrx.mynt.geckolib.animation.keyframe.event.data.CustomInstructionKeyframeData;

/**
 * The {@link KeyFrameEvent} specific to the {@link AnimationController#customKeyframeHandler}
 * <p>
 * Called when a custom instruction keyframe is encountered
 */
public class CustomInstructionKeyframeEvent<T extends GeoAnimatable> extends KeyFrameEvent<T, CustomInstructionKeyframeData> {
	public CustomInstructionKeyframeEvent(T entity, double animationTick, AnimationController<T> controller,
										  CustomInstructionKeyframeData customInstructionKeyframeData) {
		super(entity, animationTick, controller, customInstructionKeyframeData);
	}

	/**
	 * Get the {@link CustomInstructionKeyframeData} relevant to this event call
	 */
	@Override
	public CustomInstructionKeyframeData getKeyframeData() {
		return super.getKeyframeData();
	}
}
