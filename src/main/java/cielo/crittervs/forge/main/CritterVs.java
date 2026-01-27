package cielo.crittervs.forge.main;


import cielo.crittervs.forge.main.Blocks.ModBlockEntities;
import cielo.crittervs.forge.main.Blocks.ModBlocks;
import cielo.crittervs.forge.main.Entity.ModEntities;
import cielo.crittervs.forge.main.Entity.Renderer.BeamEntityRenderer;
import cielo.crittervs.forge.main.Items.ModCreativeTabs;
import cielo.crittervs.forge.main.Items.ModItems;
import cielo.crittervs.forge.main.client.Particles.BeamParticle;
import cielo.crittervs.forge.main.client.Particles.ModParticles;
import cielo.crittervs.forge.main.menu.MenuInit;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cielo.crittervs.forge.main.CritterVs.MOD_ID;

@Mod(MOD_ID)
public class CritterVs {
public static final String MOD_ID = "crittervs";
public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

public CritterVs(FMLJavaModLoadingContext ctx) {
    IEventBus eventBus = ctx.getModEventBus();

   ModBlocks.BLOCKS.register(eventBus);
   ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
    ModEntities.ENTITY_TYPES.register(eventBus);
    ModParticles.PARTICLE_TYPES.register(eventBus);
    ModItems.ITEMS.register(eventBus);
    ModCreativeTabs.CREATIVE_MODE_TABS.register(eventBus);
    MenuInit.MENU_TYPES.register(eventBus);







}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents  {

    @SubscribeEvent
        public static void RegisterParticleProvider(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.BEAMPARTICLE.get(), BeamParticle.Provider::new);

    }



    }
    public static double getDimensionScale(Level level) {
        ResourceLocation dimension = level.dimension().location();
        if (
                dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "great_unknown")) ||
                        dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "nowhere")) ||
                        dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "great_unknown"))
        ) {
            return 1.0 / 16.0;
        } else {
            return 1.0;
        }
    }





}


