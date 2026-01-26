package cielo.crittervs.forge.main.client.Handler;

import cielo.crittervs.forge.main.CritterVs;

import cielo.crittervs.forge.main.client.Screens.MinovskyReactorScreen;
import cielo.crittervs.forge.main.menu.MenuInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CritterVs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModHandler {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

            MenuScreens.register(MenuInit.MINOVSKYGENERATORMENU.get(), MinovskyReactorScreen::new);

        });
    }

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entities


        // Block Entities

    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }
}
