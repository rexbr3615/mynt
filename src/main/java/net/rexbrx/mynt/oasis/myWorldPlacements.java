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

import java.util.Optional;

public class myWorldPlacements
{

    /**
     * Carrega um arquivo de estrutura (.nbt) dos data packs/assets e o coloca no mundo.
     * * @param level   O mundo atual (precisa ser do lado do servidor para alterar blocos).
     * @param modid   O ID do mod que possui a estrutura (ex: "meumod").
     * @param path    O caminho/nome do arquivo de estrutura (ex: "minha_casa" ou "maquinas/gerador").
     * @param posX    Coordenada X inicial.
     * @param posY    Coordenada Y inicial.
     * @param posZ    Coordenada Z inicial.
     */
    public static void PlaceStructure(Level level, String modid, String path, int posX, int posY, int posZ, boolean LoadEntities) {
        // Estruturas só podem ser geradas com segurança no ServerSide (ServerLevel)
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        // 1. Cria a identificação do arquivo (ex: "meumod:minha_casa")
        ResourceLocation structureLocation = ResourceLocation.fromNamespaceAndPath(modid, path);

        // 2. Pega o gerenciador de estruturas do servidor
        StructureTemplateManager manager = serverLevel.getStructureManager();

        // 3. Tenta carregar o arquivo .nbt da estrutura
        Optional<StructureTemplate> templateOptional = manager.get(structureLocation);

        // Se o arquivo existir, faz o spawn
        if (templateOptional.isPresent()) {
            StructureTemplate template = templateOptional.get();
            BlockPos targetPos = new BlockPos(posX, posY, posZ);

            // 4. Configurações de posicionamento (rotação, espelhamento, etc.)
            StructurePlaceSettings settings = new StructurePlaceSettings()
                    .setRotation(Rotation.NONE) // Você pode mudar para girar a estrutura
                    .setMirror(Mirror.NONE)     // Você pode mudar para espelhar
                    .setIgnoreEntities(LoadEntities);  // Define se vai spawnar entidades (como mobs/molduras) salvas junto

            // 5. Coloca a estrutura no mundo com blocos, NBTs e tudo mais
            template.placeInWorld(
                    serverLevel,
                    targetPos,
                    targetPos,
                    settings,
                    serverLevel.getRandom(),
                    2 // Flag de atualização de bloco padrão
            );
        } else {
            // Um aviso caso você erre o nome do arquivo ou a pasta
            System.err.println("A API não conseguiu encontrar a estrutura: " + structureLocation);
        }
    }

    public static void PlaceBlock(Level level, BlockPos pos, BlockState state) {
        // Minecraft requires updates to happen safely, typically on the logical server.
        if (!level.isClientSide()) {
            // Flag 3 (UPDATE_ALL) updates neighbors and sends the change to clients instantly.
            level.setBlock(pos, state, 3);
        }
    }

    /**
     * Spawns a dynamic entity into the level safely.
     */
    public static void PlaceEntity(Level level, Vec3 position, EntityType<?> entityType) {
        // Checking for ServerLevel guarantees we are running code safely on the server side.
        if (level instanceof ServerLevel serverLevel) {

            // Approach A: Standard entity instantiation
            Entity entity = entityType.create(serverLevel);
            if (entity != null) {
                entity.moveTo(position.x, position.y, position.z, 0.0F, 0.0F);
                serverLevel.addFreshEntity(entity);
            }

            // Approach B: Alternative for Living Mobs (Runs extra logic like equipment generation)
            // entityType.spawn(serverLevel, BlockPos.containing(position), MobSpawnType.COMMAND);
        }
    }
}
