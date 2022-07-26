package cheri.tradewinds.register;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item GOLD_PIECE = new Item(new Item.Settings());

	// Define item group for creative inventory
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
		new Identifier("tradewinds", "general"))
		.icon(() -> new ItemStack(GOLD_PIECE))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(GOLD_PIECE));
		})
		.build();

    public static void init() {
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "gold_piece"), GOLD_PIECE);
    }
    
}
