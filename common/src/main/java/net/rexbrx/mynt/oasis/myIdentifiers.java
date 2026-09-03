package net.rexbrx.mynt.oasis;

import net.minecraft.resources.ResourceLocation;
import net.rexbrx.mynt.Mynt;

public class myIdentifiers {

    public static ResourceLocation fromNamespaceAndPath(String namespace, String location) {
        return ResourceLocation.fromNamespaceAndPath(namespace, location);
    }

    public static ResourceLocation fromVanillaNamespaceAndPath(String location) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", location);
    }

    public static ResourceLocation fromParse(String location) {
        return ResourceLocation.parse(location);
    }
}
