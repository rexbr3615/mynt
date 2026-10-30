package net.rexbrx.mynt.geckolib.animatable.stateless;

import net.rexbrx.mynt.geckolib.animatable.GeoAnimatable;
import net.rexbrx.mynt.geckolib.animation.RawAnimation;

/**
 * Extension of {@link StatelessAnimatable} for custom {@link GeoAnimatable}s
 * <p>
 * Implementation of {@link StatelessAnimatable#playAnimation(RawAnimation)} and {@link StatelessAnimatable#stopAnimation(String)} is left up
 * to the implementers of this interface, as well as any additional handling required
 */
public non-sealed interface StatelessGeoObject extends StatelessAnimatable, GeoAnimatable {}
