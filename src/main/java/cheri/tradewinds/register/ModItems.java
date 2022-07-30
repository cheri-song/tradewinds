package cheri.tradewinds.register;

import cheri.tradewinds.item.GoldPieceItem;
import cheri.tradewinds.item.TradersManualItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final GoldPieceItem GOLD_PIECE = new GoldPieceItem(new FabricItemSettings().group(ModItemGroup.GENERAL));
	public static final TradersManualItem TRADERS_MANUAL = new TradersManualItem(new FabricItemSettings().group(ModItemGroup.GENERAL));;

	public static void register() {
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "gold_piece"), GOLD_PIECE);
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "traders_manual"), TRADERS_MANUAL);
	}
}
