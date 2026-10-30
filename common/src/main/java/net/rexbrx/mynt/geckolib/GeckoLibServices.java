package net.rexbrx.mynt.geckolib;

import net.rexbrx.mynt.geckolib.service.GeckoLibEvents;
import net.rexbrx.mynt.geckolib.service.GeckoLibNetworking;
import net.rexbrx.mynt.geckolib.service.GeckoLibPlatform;
import net.rexbrx.mynt.geckolib.service.GeckoLibClient;

import java.util.ServiceLoader;

public final class GeckoLibServices {
    public static final GeckoLibPlatform PLATFORM = load(GeckoLibPlatform.class);
    public static final GeckoLibNetworking NETWORK = load(GeckoLibNetworking.class);

    public static class Client {
        public static final GeckoLibEvents EVENTS = load(GeckoLibEvents.class);
        public static final GeckoLibClient ITEM_RENDERING = load(GeckoLibClient.class);
    }

    private static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        GeckoLibConstants.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }
}
