package cielo.crittervs.forge.main.Entity;

import cielo.crittervs.forge.main.CritterVs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.core.registries.Registries.*;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ENTITY_TYPE, CritterVs.MOD_ID);

    public static final RegistryObject<EntityType<BeamEntity>> BEAMENTITY =
            ENTITY_TYPES.register("beam_entity", () -> EntityType.Builder.<BeamEntity>of(BeamEntity::new, MobCategory.MISC)
                    .sized(.5F, .5F) // Small hitbox
                    .clientTrackingRange(10) // Sync range in chunks
                    .updateInterval(10) // Update every 10 ticks
                    .build("beam_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}

