package cheri.tradewinds;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cheri.tradewinds.register.ModItems;
import cheri.tradewinds.register.ModBlocks;

public class Tradewinds implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("tradewinds");
		
	@Override
	public void onInitialize() {

		ModItems.register();
		ModBlocks.register();

		LOGGER.info("[Tradewinds] Initialized!");
	}
}
