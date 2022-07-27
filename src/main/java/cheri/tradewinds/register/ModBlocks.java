package cheri.tradewinds.register;

import cheri.tradewinds.block.MarketBoardBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

  public static final MarketBoardBlock MARKET_BOARD = new MarketBoardBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f));

	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier("tradewinds", "market_board"), MARKET_BOARD);
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "market_board"), new BlockItem(MARKET_BOARD, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.GENERAL)));
	}
	
}
