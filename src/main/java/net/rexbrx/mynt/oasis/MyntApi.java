package net.rexbrx.mynt.oasis;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.Vec3;
import net.rexbrx.mynt.utils.myLogger;
import net.rexbrx.mynt.utils.myMathUtils;

import java.util.Optional;

public class MyntApi {

    public static void testApi() {
        logDebug("MyntApi: API check starting...");
        int value = randomInt(1, 100);
        logDebug("MyntApi: Generated random value = " + value);
        logInfo("MyntApi: API check complete.");
    }

    // Logging helpers
    public static void logDebug(String message) {
        myLogger.myDebug(message);
    }

    public static void logInfo(String message) {
        myLogger.myInfo(message);
    }

    public static void logWarn(String message) {
        myLogger.myWarn(message);
    }

    public static void logError(String message) {
        myLogger.myError(message);
    }

    // Math helpers
    public static int randomInt(int min, int max) {
        return myMathUtils.getRandomNumberInRange(min, max);
    }

    public static boolean isInteger(String value) {
        return myMathUtils.isInteger(value);
    }

    public static boolean isDouble(String value) {
        return myMathUtils.isDouble(value);
    }

    public static boolean isLong(String value) {
        return myMathUtils.isLong(value);
    }

    public static boolean isFloat(String value) {
        return myMathUtils.isFloat(value);
    }

    public static boolean isNumeric(String value) {
        return myMathUtils.isIntegerOrDouble(value);
    }

    public static void placeStructure(Level level, String modid, String path, int posX, int posY, int posZ, boolean loadEntities) {
        myWorldPlacements.PlaceStructure(level, modid, path, posX, posY, posZ, loadEntities);
    }

    public static void placeBlock(Level level, BlockPos pos, BlockState state) {
        myWorldPlacements.PlaceBlock(level, pos, state);
    }

    public static void placeEntity(Level level, Vec3 position, EntityType<?> entityType) {
        myWorldPlacements.PlaceEntity(level, position, entityType);
    }

}
