package net.rexbrx.mynt.geckolib.loading.json.raw;

import com.google.gson.*;
import com.google.gson.JsonDeserializationContext;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;
import net.rexbrx.mynt.geckolib.loading.json.FormatVersion;
import net.rexbrx.mynt.geckolib.util.JsonUtil;

/**
 * Container class for model information, only used in deserialization at startup
 */
public record Model(@Nullable FormatVersion formatVersion, MinecraftGeometry[] minecraftGeometry) {
	public static final String VANILLA_KEY = "minecraft:geometry";
	public static final String MYNT_KEY = "mynt:geometry";

	public static JsonDeserializer<Model> deserializer() throws JsonParseException {
		return (json, type, context) -> {
			JsonObject obj = json.getAsJsonObject();
			FormatVersion formatVersion = context.deserialize(obj.get("format_version"), FormatVersion.class);

			MinecraftGeometry[] vanilla = readGeometry(obj, VANILLA_KEY, context);
			MinecraftGeometry[] custom = readGeometry(obj, MYNT_KEY, context);
			//MinecraftGeometry[] minecraftGeometry = JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "minecraft:geometry", new JsonArray(0)), context, MinecraftGeometry.class);

			MinecraftGeometry[] all = new MinecraftGeometry[vanilla.length + custom.length];
			System.arraycopy(vanilla, 0, all, 0, vanilla.length);
			System.arraycopy(custom, 0, all, vanilla.length, custom.length);

			return new Model(formatVersion, all);

			//return new Model(formatVersion, minecraftGeometry);
		};
	}

	private static MinecraftGeometry[] readGeometry(JsonObject obj, String key, JsonDeserializationContext context) {
		return JsonUtil.jsonArrayToObjectArray(
				GsonHelper.getAsJsonArray(obj, key, new JsonArray(0)), context, MinecraftGeometry.class);
	}
}
