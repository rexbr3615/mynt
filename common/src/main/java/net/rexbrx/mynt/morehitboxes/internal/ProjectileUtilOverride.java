package net.rexbrx.mynt.morehitboxes.internal;

import net.minecraft.world.phys.EntityHitResult;
import net.rexbrx.mynt.morehitboxes.api.MultiPart;

public class ProjectileUtilOverride {

    /**
     * Uses {@link MultiPartEntityHitResult} to add the correct part to the EntityHitResult
     */
    public static EntityHitResult modifyPartEntity(EntityHitResult original) {
        if (original == null) {
            return null;
        }
        if (original.getEntity() instanceof MultiPart<?> part) {
            EntityHitResult hitResult = new EntityHitResult(part.getParent(), original.getLocation());
            ((MultiPartEntityHitResult) hitResult).moreHitboxes$setMultiPart(part);
            return hitResult;
        }
        return original;
    }
}
