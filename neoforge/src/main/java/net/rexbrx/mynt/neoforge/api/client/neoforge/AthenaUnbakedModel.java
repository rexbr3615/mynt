package net.rexbrx.mynt.neoforge.api.client.neoforge;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.rexbrx.mynt.athena.api.client.models.AthenaBlockModel;
import net.rexbrx.mynt.athena.api.client.models.NotNullUnbakedModel;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class AthenaUnbakedModel implements NotNullUnbakedModel {

    private final Supplier<AthenaBlockModel> model;

    public AthenaUnbakedModel(Supplier<AthenaBlockModel> model) {
        this.model = model;
    }

    @Override
    public @NotNull Collection<ResourceLocation> getDependencies() {
        return List.of();
    }

    @Override
    public void resolveParents(@NotNull Function<ResourceLocation, UnbakedModel> function) {

    }

    @NotNull
    @Override
    public BakedModel bake(@NotNull ModelBaker modelBaker, @NotNull Function<Material, TextureAtlasSprite> function, @NotNull ModelState modelState) {
        return new AthenaBakedModel(this.model.get(), function);
    }
}
