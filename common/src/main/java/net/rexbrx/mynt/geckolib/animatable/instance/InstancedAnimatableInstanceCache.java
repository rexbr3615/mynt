package net.rexbrx.mynt.geckolib.animatable.instance;

import net.rexbrx.mynt.geckolib.animatable.GeoAnimatable;
import net.rexbrx.mynt.geckolib.animation.AnimatableManager;

/**
 * AnimatableInstanceCache implementation for instantiated objects such as Entities or BlockEntities. Returns a single {@link AnimatableManager} instance per cache
 * <p>
 * You should <b><u>NOT</u></b> be instantiating this directly unless you know what you are doing.
 * Use {@link net.rexbrx.mynt.geckolib.util.GeckoLibUtil#createInstanceCache GeckoLibUtil.createInstanceCache} instead
 */
public class InstancedAnimatableInstanceCache extends AnimatableInstanceCache {
	protected AnimatableManager<?> manager;

	public InstancedAnimatableInstanceCache(GeoAnimatable animatable) {
		super(animatable);
	}

	/**
	 * Gets the {@link AnimatableManager} instance from this cache
	 * <p>
	 * Because this cache subclass expects a 1:1 relationship of cache to animatable, only one {@code AnimatableManager} instance is used
	 */
	@Override
	public AnimatableManager<?> getManagerForId(long uniqueId) {
		if (this.manager == null)
			this.manager = new AnimatableManager<>(this.animatable);

		return this.manager;
	}
}