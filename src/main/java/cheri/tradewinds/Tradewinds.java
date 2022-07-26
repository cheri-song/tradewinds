package cheri.tradewinds;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tradewinds implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("tradewinds");

	// Define items
	public static final Item GOLD_PIECE = new Item(new FabricItemSettings().group(Tradewinds.ITEM_GROUP));

	// Define item group for creative inventory
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("tradewinds", "general"),
		() -> new ItemStack(GOLD_PIECE)); // use gold piece for icon
		
	@Override
	public void onInitialize() {

		// Register items
		Registry.register(Registry.ITEM, new Identifier("tradewinds", "gold_piece"), GOLD_PIECE);

		LOGGER.info("[Tradewinds] Initialized!");
	}
}
