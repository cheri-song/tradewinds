package cheri.tradewinds.register;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

	// Define item group for creative inventory
	public static final ItemGroup GENERAL = FabricItemGroupBuilder.create(
		new Identifier("tradewinds", "general"))
		.icon(() -> new ItemStack(ModItems.GOLD_PIECE))
		.build();
    
}
