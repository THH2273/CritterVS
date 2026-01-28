package cielo.crittervs.forge.main.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {

    private int BurnTime = 0;

    public FuelItem(Properties arg, int BurnTime) {
        super(arg);

        this.BurnTime = BurnTime;

    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.BurnTime;
    }
}
