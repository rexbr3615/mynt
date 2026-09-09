package net.rexbrx.mynt.server.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class MyntStoneOreBlock extends Block {
    public MyntStoneOreBlock(Properties properties) {
        super(properties.strength(3f).explosionResistance(3f).requiresCorrectToolForDrops().sound(SoundType.STONE));
    }
}
