// created by RexBRX
//
// common entity class used by my mods

package net.rexbrx.mynt.server.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public abstract class MyntEukaryaEntity extends Animal {
    //public IDomainClassification MYNTDOMAIN;
    //public IDomainClassification getClassfication() {return this.MYNTDOMAIN;}

    public MyntEukaryaEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);

        // redundant but important
        setPersistenceRequired();
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
