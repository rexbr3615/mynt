package net.rexbrx.mynt.fabric.client.api;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.rexbrx.mynt.fabric.client.FactoryManagerImpl;

import java.util.Objects;

public class AthenaModelLoadingPlugin implements ModelLoadingPlugin {

    @Override
    public void onInitializeModelLoader(Context context) {
        FactoryManagerImpl.LOADERS.forEach((id, loader) ->
            context.modifyModelBeforeBake().register((model, ctx) ->
                Objects.requireNonNullElse(loader.loadModel(ctx.topLevelId()), model)
            )
        );
    }
}
