package cielo.crittervs.forge.main.client.Particles;

import cielo.crittervs.forge.main.CritterVs;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CritterVs.MOD_ID);



    public static final RegistryObject<SimpleParticleType> BEAMPARTICLE =
            PARTICLE_TYPES.register("beam_particle", () -> new SimpleParticleType(true));


}
