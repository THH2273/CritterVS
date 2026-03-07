package cielo.crittervs.forge.main.Blocks;

import cielo.crittervs.forge.main.Blocks.Custom.BeamLauncher.BeamLauncherBlock;
import cielo.crittervs.forge.main.Blocks.Custom.MinovskyReactor;
import cielo.crittervs.forge.main.Blocks.Custom.PhaseShiftBlock.PhaseShiftBlock;
import cielo.crittervs.forge.main.CritterVs;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static cielo.crittervs.forge.main.CritterVs.REGISTRATE;
import static com.simibubi.create.api.behaviour.display.DisplaySource.displaySource;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, CritterVs.MOD_ID);

    public static final RegistryObject<Block> BEAMLAUNCHERBLOCK = BLOCKS.register("beam_launcher_block",
            () -> new BeamLauncherBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .dynamicShape()));

    public static final RegistryObject<Block> MINOVSKYREACTOR = BLOCKS.register("minovsky_reactor",
            () -> new MinovskyReactor());

//Phase Shift
    public static final RegistryObject<Block> WHITEPSARMOR = BLOCKS.register("white_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> LGRAYPSARMOR = BLOCKS.register("light_grey_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> GRAYPSARMOR = BLOCKS.register("grey_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BLACKPSARMOR = BLOCKS.register("black_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BROWNPSARMOR = BLOCKS.register("brown_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> REDPSARMOR = BLOCKS.register("red_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ORANGEPSARMOR = BLOCKS.register("orange_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> YELLOWPSARMOR = BLOCKS.register("yellow_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> LIMEPSARMOR = BLOCKS.register("lime_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> GREENPSARMOR = BLOCKS.register("green_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CYANPSARMOR = BLOCKS.register("cyan_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> LBLUEPSARMOR = BLOCKS.register("light_blue_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BLUEPSARMOR = BLOCKS.register("blue_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PURPLEPSARMOR = BLOCKS.register("purple_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MAGENTAPSARMOR = BLOCKS.register("magenta_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PINKPSARMOR = BLOCKS.register("pink_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> MIDNIGHTBLUEPSARMOR = BLOCKS.register("midnight_blue_phase_shift", () -> new PhaseShiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

}
