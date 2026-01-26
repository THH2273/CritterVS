package cielo.crittervs.forge.main.menu;

import cielo.crittervs.forge.main.CritterVs;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CritterVs.MOD_ID);

    public static final RegistryObject<MenuType<MinovskyGeneratorMenu>> MINOVSKYGENERATORMENU = MENU_TYPES.register("generator_block",
            () -> IForgeMenuType.create((windowId, inv, data) -> new MinovskyGeneratorMenu(windowId, inv.player, data.readBlockPos())));
}
