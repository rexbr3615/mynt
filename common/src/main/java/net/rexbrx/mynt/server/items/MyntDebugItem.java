package net.rexbrx.mynt.server.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class MyntDebugItem extends Item {
    public MyntDebugItem(Properties properties) {
        super(properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
    }
}
