package cielo.crittervs.forge.main.Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class FERedstoneBlockItem extends BlockItem {
    public FERedstoneBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.empty()
                .append(Component.literal("Needs ").withStyle(ChatFormatting.GRAY))
                .append(Component.literal("FE").withStyle(ChatFormatting.YELLOW))
                .append(Component.literal(" and a ").withStyle(ChatFormatting.GRAY))
                .append(Component.literal("Redstone Pulse").withStyle(ChatFormatting.RED)));
        super.appendHoverText(itemStack, level, components, flag);
    }
}