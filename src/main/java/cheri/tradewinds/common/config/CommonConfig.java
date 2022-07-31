package cheri.tradewinds.common.config;

import java.io.File;
import java.util.List;

import com.oroarmor.config.*;

import net.fabricmc.loader.api.FabricLoader;
import static com.google.common.collect.ImmutableList.of;

// most of this is copied from the Oro Config documentation

public class CommonConfig extends Config {

	// General Config Group
	public static final ConfigItemGroup GENERAL_GROUP = new GeneralConfigItemGroup();

	public static class GeneralConfigItemGroup extends ConfigItemGroup {

		// nothing lol

		// build general config group
		public GeneralConfigItemGroup() {
			super(of(
				), "general");
		}
	}

	// Build list of all config groups
	public static final List<ConfigItemGroup> configs = of(
		GENERAL_GROUP
		);

	public CommonConfig() {
		// Associate configs to file
		super(configs, new File(FabricLoader.getInstance().getConfigDir().toFile(), "tradewinds.json"), "tradewinds");
	}
}