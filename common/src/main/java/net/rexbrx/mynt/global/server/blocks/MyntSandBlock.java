package net.rexbrx.mynt.global.server.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class MyntSandBlock extends Block {
    public MyntSandBlock(Properties properties) {
        super(properties.strength(0.5f).explosionResistance(0.5f).sound(SoundType.SAND));
    }

}
