package cielo.crittervs.forge.main.Entity;

import cielo.crittervs.forge.main.CritterVs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.core.registries.Registries.*;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ENTITY_TYPE, CritterVs.MOD_ID);

    public static final RegistryObject<EntityType<BeamEntity>> BEAMENTITY =
            ENTITY_TYPES.register("beamentity", () -> EntityType.Builder.<BeamEntity>of(
                            BeamEntity::new,
                            MobCategory.MISC
                    )
                    .sized(0.25F, 0.25F) // Small hitbox
                    .clientTrackingRange(4) // Sync range in chunks
                    .updateInterval(10) // Update every 10 ticks
                    .build("beamentity"));
}

