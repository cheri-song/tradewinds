package cheri.tradewinds.register;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final Item GOLD_PIECE = new Item(new Item.Settings().group(ModItemGroup.GENERAL));

	public static void register() {
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "gold_piece"), GOLD_PIECE);
	}
	
}
