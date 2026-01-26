package cielo.crittervs.forge.main.Blocks;

import cielo.crittervs.forge.main.Blocks.Custom.BeamLauncher.BeamLauncherBlock;
import cielo.crittervs.forge.main.Blocks.Custom.MinovskyReactor;
import cielo.crittervs.forge.main.CritterVs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, CritterVs.MOD_ID);

    public static final RegistryObject<Block> BEAMLAUNCHERBLOCK = BLOCKS.register("beam_launcher_block",
            () -> new BeamLauncherBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    public static final RegistryObject<Block> MINOVSKYREACTOR = BLOCKS.register("minovsky_reactor",
            () -> new MinovskyReactor());


}
