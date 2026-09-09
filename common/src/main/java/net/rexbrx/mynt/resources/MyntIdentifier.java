package net.rexbrx.mynt.resources;

import net.minecraft.resources.ResourceLocation;

public class MyntIdentifier {

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
