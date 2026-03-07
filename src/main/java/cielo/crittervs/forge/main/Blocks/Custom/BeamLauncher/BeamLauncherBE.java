package cielo.crittervs.forge.main.Blocks.Custom.BeamLauncher;

import cielo.crittervs.forge.main.Blocks.ModBlockEntities;
import cielo.crittervs.forge.main.Entity.MedBeam.MedBeamProjectile;
import cielo.crittervs.forge.main.Entity.MedBeam.MedBeamReflectorItem;
import cielo.crittervs.forge.main.Entity.ModEntities;
import cielo.crittervs.forge.main.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import org.jetbrains.annotations.NotNull;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BeamLauncherBE extends BlockEntity {
    private static final int MAX_ENERGY = 1_000;
    private static final int MAX_TRANSFER = 500;
    private static final int ENERGY_PER_SHOT = 1000;

    private int tickCounter = 0;

    private final EnergyStorage energyStorage = new EnergyStorage(MAX_ENERGY, MAX_TRANSFER, 0) {
        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            // Allow internal extraction by directly modifying energy
            if (!simulate) {
                int energyExtracted = Math.min(energy, maxExtract);
                energy -= energyExtracted;
                return energyExtracted;
            }
            return Math.min(energy, maxExtract);
        }
    };
    private final LazyOptional<EnergyStorage> energyHandler = LazyOptional.of(() -> new EnergyStorage(MAX_ENERGY, MAX_TRANSFER, 0) {
        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            return energyStorage.receiveEnergy(maxReceive, simulate);
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            // Prevent external extraction
            return 0;
        }

        @Override
        public int getEnergyStored() {
            return energyStorage.getEnergyStored();
        }

        @Override
        public int getMaxEnergyStored() {
            return energyStorage.getMaxEnergyStored();
        }

        @Override
        public boolean canExtract() {
            return false;
        }

        @Override
        public boolean canReceive() {
            return energyStorage.canReceive();
        }
    });

    public BeamLauncherBE(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.BEAMLAUNCHER.get(), pos, blockState);
    }

    @Override
    public <T> @Nonnull LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return energyHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        energyHandler.invalidate();
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Energy")) {
            energyStorage.deserializeNBT(tag.get("Energy"));
        }
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Energy", energyStorage.serializeNBT());
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BeamLauncherBE blockEntity) {
        if (level.isClientSide) return;

        boolean isPowered = level.hasNeighborSignal(pos);

        if (isPowered) {
            if (blockEntity.tickCounter == 0) {
                // Check if there's enough energy to fire
                if (blockEntity.energyStorage.getEnergyStored() >= ENERGY_PER_SHOT) {
                    // Extract the energy and fire
                    blockEntity.energyStorage.extractEnergy(ENERGY_PER_SHOT, false);
                    blockEntity.fireBeam(level, pos, state);
                }
            }
        }
        if (blockEntity.tickCounter != 0 || isPowered) {
            int TICKS_PER_SHOT = 20;
            blockEntity.tickCounter = (blockEntity.tickCounter + 1) % TICKS_PER_SHOT;
        }
    }

    private void fireBeam(Level level, BlockPos pos, BlockState state) {

ItemStack foundProjectile = new ItemStack(ModItems.MEDIUM_BEAM_REFLECTOR.get());

if (!(foundProjectile.getItem() instanceof AutocannonRoundItem roundItem)) {
    return;
}


        AbstractAutocannonProjectile projectile = roundItem.getAutocannonProjectile(foundProjectile,level);


        Vec3 direction = BeamLauncherBlock.getAimVector(state);
        Vec3 blockCenter = Vec3.atCenterOf(pos);
        Vec3 spawnPos = blockCenter.add(direction.scale(0.6));
        float speed = 2f;
        float spread = 1f;

            projectile.setPos(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ());
            projectile.setChargePower(4F);
            projectile.setTracer(true);
            projectile.setLifetime(80);
            projectile.shoot(spawnPos.x, spawnPos.y, spawnPos.z, speed, spread);
            projectile.xRotO = projectile.getXRot();
            projectile.yRotO = projectile.getYRot();



            level.addFreshEntity(projectile);

        }


    }



