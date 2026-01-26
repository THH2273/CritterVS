package cielo.crittervs.forge.main.client;


import cielo.crittervs.forge.main.Blocks.ModBlockEntities;
import cielo.crittervs.forge.main.Blocks.ModBlocks;
import cielo.crittervs.forge.main.CritterVs;
import cielo.crittervs.forge.main.Entity.BeamEntity;
import cielo.crittervs.forge.main.Entity.ModEntities;
import cielo.crittervs.forge.main.Entity.Renderer.BeamEntityRenderer;
import cielo.crittervs.forge.main.client.Particles.BeamParticle;
import cielo.crittervs.forge.main.client.Particles.ModParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CritterVs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class CritterVsClient {



    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.BEAMENTITY.get(), BeamEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.BEAMPARTICLE.get(), BeamParticle.Provider::new);
    }




}
