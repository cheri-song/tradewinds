package cheri.tradewinds.item;

import java.util.List;

import cheri.tradewinds.Tradewinds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import vazkii.patchouli.api.PatchouliAPI;

public class TradersManualItem extends Item {
	public TradersManualItem(Settings settings) {
		super(settings);
	}


	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add( new TranslatableText("item.tradewinds.traders_manual.tooltip1").formatted(Formatting.DARK_GRAY) );
		if (Tradewinds.patchouli.isLoaded()) {
			tooltip.add( new TranslatableText("item.tradewinds.traders_manual.tooltip2").formatted(Formatting.DARK_GRAY) );
		} else {
			tooltip.add(new TranslatableText("item.tradewinds.traders_manual.patchouli_not_installed").formatted(Formatting.RED));
		}

	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		ItemStack stack = user.getStackInHand(hand);

		if (user instanceof ServerPlayerEntity && Tradewinds.patchouli.isLoaded()) {
            ServerPlayerEntity player = (ServerPlayerEntity) user;
			PatchouliAPI.get().openBookGUI(player, Registry.ITEM.getId(this));
		}

		return new TypedActionResult<>(ActionResult.SUCCESS, stack);
	}
}
