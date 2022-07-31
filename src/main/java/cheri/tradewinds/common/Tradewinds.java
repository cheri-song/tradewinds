package cheri.tradewinds.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.api.PatchouliAPI.IPatchouliAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oroarmor.config.Config;
import com.oroarmor.config.command.ConfigCommand;

import cheri.tradewinds.common.config.CommonConfig;
import cheri.tradewinds.common.good_types.GoodTypeManager;
import cheri.tradewinds.common.register.*;

public class Tradewinds implements ModInitializer {
	// Initialize logger
	public static final Logger LOGGER = LoggerFactory.getLogger("Tradewinds");

	// Initialize config objects
	public static Config COMMON_CONFIG = new CommonConfig();

	// get Patchouli api so we can set the config flag later
	private static IPatchouliAPI api = null;
	private static IPatchouliAPI getPatchouliAPI() {
		{
			if (api == null) {
				api = PatchouliAPI.get();
				if (api.isStub())
				{
					LOGGER.warn("Failed to intercept Patchouli API. Problems may occur");
				}
			}
			return api;
		}
	}
		
	@Override
	public void onInitialize() {
		
		// Get configs
		COMMON_CONFIG.readConfigFromFile();
		COMMON_CONFIG.saveConfigToFile();
		ServerLifecycleEvents.SERVER_STOPPED.register(instance -> COMMON_CONFIG.saveConfigToFile());
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> new ConfigCommand<ServerCommandSource>(COMMON_CONFIG).register(dispatcher, p -> p.hasPermissionLevel(2)));
		
		// Initialize the built-in "Tradewinds Default Settings" resource pack if the game rule is enabled
    	ModContainer tradewindsMod = FabricLoader.getInstance().getModContainer("tradewinds").orElseThrow(RuntimeException::new);
		if (COMMON_CONFIG.getValue("advanced.use_default_datapack", Boolean.class)) {
			ResourceManagerHelper.registerBuiltinResourcePack(
				new Identifier("tradewinds_default_settings"), 
				tradewindsMod, 
				"Tradewinds Default Datapack", 
				ResourcePackActivationType.ALWAYS_ENABLED
				);
			getPatchouliAPI().setConfigFlag("tradewinds:show_default_goods", true); // this will show the goods even if you log into a different world later that has it off, but i really cba to fix it
		}

		// Set up the system for loading good types from datapacks
		GoodTypeManager.RegisterGoodTypeDatapackType();
		
		// Register blocks and items
		ModBlocks.register();
		ModItems.register();

		LOGGER.info("[Tradewinds] Initialized!");
	}
}
