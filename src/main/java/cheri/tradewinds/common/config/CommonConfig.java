package cheri.tradewinds.common.config;

import java.io.File;
import java.util.List;

import com.oroarmor.config.*;

import net.fabricmc.loader.api.FabricLoader;
import static com.google.common.collect.ImmutableList.of;

// most of this is copied from the Oro Config documentation

public class CommonConfig extends Config {

	// Advanced Config Group
	public static final ConfigItemGroup ADVANCED = new AdvancedConfigItemGroup();

	public static class AdvancedConfigItemGroup extends ConfigItemGroup {

		public static final BooleanConfigItem USE_DEFAULT_DATAPACK = new BooleanConfigItem(
			"use_default_datapack", 
			true, 
			"Use default datapack? (requires restart)"
			);

		// build general config group
		public AdvancedConfigItemGroup() {
			super(of(
				USE_DEFAULT_DATAPACK
				), "advanced");
		}
	}

	// Build list of all config groups
	public static final List<ConfigItemGroup> CONFIGS = of(
		ADVANCED
		);

	public CommonConfig() {
		// Associate configs to file
		super(CONFIGS, new File(FabricLoader.getInstance().getConfigDir().toFile(), "tradewinds-common.json"), "tradewinds");
	}
}