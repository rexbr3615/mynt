package net.rexbrx.mynt.global.server.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class MyntDeepslateOreBlock extends Block {
    public MyntDeepslateOreBlock(Properties properties) {
        super(properties.strength(3.5f).explosionResistance(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE));
    }
}
