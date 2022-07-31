package cheri.tradewinds.common.register;

import cheri.tradewinds.common.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final GoldPieceItem GOLD_PIECE = new GoldPieceItem(new FabricItemSettings().group(ModItemGroup.GENERAL));
	public static final SilverPieceItem SILVER_PIECE = new SilverPieceItem(new FabricItemSettings().group(ModItemGroup.GENERAL));
	public static final TradersManualItem TRADERS_MANUAL = new TradersManualItem(new FabricItemSettings().group(ModItemGroup.GENERAL));;

	public static void register() {
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "gold_piece"), GOLD_PIECE);
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "silver_piece"), SILVER_PIECE);
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "traders_manual"), TRADERS_MANUAL);
	}
}
