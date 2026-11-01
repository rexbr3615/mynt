package net.rexbrx.mynt.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
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

			MinecraftGeometry[] vanilla = JsonUtil.jsonArrayToObjectArray(
					GsonHelper.getAsJsonArray(obj, VANILLA_KEY, new JsonArray(0)), context, MinecraftGeometry.class);
			MinecraftGeometry[] custom = JsonUtil.jsonArrayToObjectArray(
					GsonHelper.getAsJsonArray(obj, MYNT_KEY, new JsonArray(0)), context, MinecraftGeometry.class);
			//MinecraftGeometry[] minecraftGeometry = JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "minecraft:geometry", new JsonArray(0)), context, MinecraftGeometry.class);

			MinecraftGeometry[] all = new MinecraftGeometry[vanilla.length + custom.length];
			System.arraycopy(vanilla, 0, all, 0, vanilla.length);
			System.arraycopy(custom, 0, all, vanilla.length, custom.length);

			return new Model(formatVersion, all);

			//return new Model(formatVersion, minecraftGeometry);
		};
	}
}
