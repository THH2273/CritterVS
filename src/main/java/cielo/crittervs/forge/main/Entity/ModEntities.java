package cielo.crittervs.forge.main.Entity;

import cielo.crittervs.forge.main.CritterVs;
import cielo.crittervs.forge.main.Entity.MedBeam.MedBeamProjectile;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import rbasamoyai.createbigcannons.index.CBCMunitionPropertiesHandlers;
import rbasamoyai.createbigcannons.multiloader.EntityTypeConfigurator;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonProjectileRenderer;
import rbasamoyai.createbigcannons.munitions.config.MunitionPropertiesHandler;
import rbasamoyai.createbigcannons.munitions.config.PropertiesTypeHandler;
import rbasamoyai.ritchiesprojectilelib.RPLTags;

import java.util.function.Consumer;

import static cielo.crittervs.forge.main.CritterVs.REGISTRATE;
import static net.minecraft.core.registries.Registries.*;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ENTITY_TYPE, CritterVs.MOD_ID);





    public static final EntityEntry<MedBeamProjectile> BEAMPROJ = autocannonProjectile("beam_projectile", MedBeamProjectile::new, "bweam :3", CBCMunitionPropertiesHandlers.INERT_AUTOCANNON_PROJECTILE);

    public static void register() {
    }



    private static <T extends AbstractAutocannonProjectile> EntityEntry<T>
    autocannonProjectile(String id, EntityType.EntityFactory<T> factory, String enUSdiffLang, PropertiesTypeHandler<EntityType<?>, ?> handler) {
        return REGISTRATE
                .entity(id, factory, MobCategory.MISC)
                .properties(autocannonProperties())
                .renderer(() -> AutocannonProjectileRenderer::new)
                .lang(enUSdiffLang)
                .tag(RPLTags.PRECISE_MOTION)
                .onRegister(type -> MunitionPropertiesHandler.registerProjectileHandler(type, handler))
                .register();
    }

    private static <T> NonNullConsumer<T> configure(Consumer<EntityTypeConfigurator> cons) {
        return b -> cons.accept(EntityTypeConfigurator.of(b));
    }
    private static <T> NonNullConsumer<T> autocannonProperties() {
        return configure(c -> c.size(0.2f, 0.2f)
                .fireImmune()
                .updateInterval(1)
                .updateVelocity(false) // Mixin ServerEntity to not track motion
                .trackingRange(16));
    }
}

