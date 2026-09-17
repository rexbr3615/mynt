package net.rexbrx.mynt.morehitboxes.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.loader.api.FabricLoader;
import net.rexbrx.mynt.morehitboxes.platform.services.IPlatformHelper;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@AutoService(IPlatformHelper.class)
public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
