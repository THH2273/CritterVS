package cielo.crittervs.forge.main.Entity.MedBeam;

import javax.annotation.Nonnull;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.index.CBCEntityTypes;
import rbasamoyai.createbigcannons.index.CBCMunitionPropertiesHandlers;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;
import rbasamoyai.createbigcannons.munitions.autocannon.config.AutocannonProjectilePropertiesComponent;

public class MedBeamReflectorItem extends AutocannonRoundItem {

    public MedBeamReflectorItem(Properties properties) {
        super(properties);
    }

	@Override
    public AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
        return CBCEntityTypes.AP_AUTOCANNON.create(level);
    }

	@Nonnull
	@Override
	public AutocannonProjectilePropertiesComponent getAutocannonProperties(ItemStack itemStack) {
		return CBCMunitionPropertiesHandlers.INERT_AUTOCANNON_PROJECTILE.getPropertiesOf(this.getEntityType(itemStack)).autocannonProperties();
	}

	@Override
	public EntityType<?> getEntityType(ItemStack stack) {
		return CBCEntityTypes.AP_AUTOCANNON.get();
	}

}
