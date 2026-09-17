package net.rexbrx.mynt.athena.api.client.models.fabric;

import net.minecraft.resources.ResourceLocation;
import net.rexbrx.mynt.athena.api.client.fabric.AthenaUnbakedModel;
import net.rexbrx.mynt.athena.api.client.models.AthenaModelFactory;
import net.rexbrx.mynt.athena.api.client.utils.AthenaUnbakedModelLoader;

import java.util.HashMap;
import java.util.Map;

public class FactoryManagerImpl {

    public static final Map<ResourceLocation, AthenaUnbakedModelLoader> LOADERS = new HashMap<>();

    public static void register(ResourceLocation type, AthenaModelFactory factory) {
        LOADERS.put(type, new AthenaUnbakedModelLoader(type, factory, AthenaUnbakedModel::new));
    }
}
