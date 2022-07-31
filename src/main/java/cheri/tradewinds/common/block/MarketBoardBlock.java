package cheri.tradewinds.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MarketBoardBlock extends Block {
	public MarketBoardBlock(Settings settings) {
		super(settings);
	}
 
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			player.sendMessage(Text.of("Hello, world!"), false);
		}
 
		return ActionResult.SUCCESS;
	}

	@Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
    
        tooltip.add( new TranslatableText("block.tradewinds.market_board.tooltip1").formatted(Formatting.DARK_GRAY) );
        tooltip.add( new TranslatableText("block.tradewinds.market_board.tooltip2").formatted(Formatting.DARK_GRAY) );
    }
}
