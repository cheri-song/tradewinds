package cheri.tradewinds.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import net.minecraft.server.command.ServerCommandSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oroarmor.config.Config;
import com.oroarmor.config.command.ConfigCommand;

import cheri.tradewinds.common.config.CommonConfig;
import cheri.tradewinds.common.dependencies.Patchouli;
import cheri.tradewinds.common.register.*;

public class Tradewinds implements ModInitializer {
	// Create logger
	public static final Logger LOGGER = LoggerFactory.getLogger("tradewinds");

	// Objects to check for optional dependencies
	public static Patchouli patchouli = new Patchouli();

	// Oro Config
	public static Config COMMON_CONFIG = new CommonConfig();
		
	@Override
	public void onInitialize() {
		
		COMMON_CONFIG.readConfigFromFile();
		COMMON_CONFIG.saveConfigToFile();
		ServerLifecycleEvents.SERVER_STOPPED.register(instance -> COMMON_CONFIG.saveConfigToFile());
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> new ConfigCommand<ServerCommandSource>(COMMON_CONFIG).register(dispatcher, p -> p.hasPermissionLevel(2)));

		ModItems.register();
		ModBlocks.register();

		LOGGER.info("[Tradewinds] Initialized!");
	}
}
