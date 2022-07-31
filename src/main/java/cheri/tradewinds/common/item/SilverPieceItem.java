package cheri.tradewinds.common.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class SilverPieceItem extends Item {
	public SilverPieceItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add( new TranslatableText("item.tradewinds.silver_piece.tooltip1").formatted(Formatting.DARK_GRAY) );
		tooltip.add( new TranslatableText("item.tradewinds.silver_piece.tooltip2").formatted(Formatting.DARK_GRAY) );
	}
}
