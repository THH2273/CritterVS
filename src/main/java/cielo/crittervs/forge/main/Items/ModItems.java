package cielo.crittervs.forge.main.Items;

import cielo.crittervs.forge.main.Blocks.Custom.MinovskyReactor;
import cielo.crittervs.forge.main.Blocks.ModBlocks;
import cielo.crittervs.forge.main.CritterVs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, CritterVs.MOD_ID);


    public static final RegistryObject<BlockItem> ENERGY_ORB_LAUNCHER_ITEM = ITEMS.register("photon_pulse_blaster",
            () -> new FERedstoneBlockItem(ModBlocks.BEAMLAUNCHERBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> MINOVSKY_REACTOR_ITEM = ITEMS.register("minovsky_reactor",
            () -> new BlockItem(ModBlocks.MINOVSKYREACTOR.get(), new Item.Properties()));

}
