package net.rexbrx.mynt.oasis;

import net.minecraft.resources.ResourceLocation;
import net.rexbrx.mynt.Mynt;

public class myPath {
    public static ResourceLocation MyntPath(String path) {
        return ResourceLocation.fromNamespaceAndPath(Mynt.MODID, path);
    }

    public static ResourceLocation ModPath(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }

    public static ResourceLocation ModParse(String path) {
        return ResourceLocation.parse(path);
    }
}
