package cielo.crittervs.forge.main.Blocks;

import cielo.crittervs.forge.main.Blocks.Custom.BeamLauncher.BeamLauncherBE;
import cielo.crittervs.forge.main.Blocks.Custom.MinovskyReactorBE;
import cielo.crittervs.forge.main.CritterVs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CritterVs.MOD_ID);

    public static final RegistryObject<BlockEntityType<BeamLauncherBE>> BEAMLAUNCHER =
            BLOCK_ENTITIES.register("beam_launcher_block_entity", ()-> BlockEntityType.Builder.of(BeamLauncherBE::new,ModBlocks.BEAMLAUNCHERBLOCK.get()).build(null));


    public static final RegistryObject<BlockEntityType<MinovskyReactorBE>> MINOVSKYREACTORBE =
            BLOCK_ENTITIES.register("minovsky_reactor_block_entity",
                    ()-> BlockEntityType.Builder.of(MinovskyReactorBE::new,ModBlocks.MINOVSKYREACTOR.get())
                    .build(null));



}
