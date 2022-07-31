package cheri.tradewinds.common.good_types;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cheri.tradewinds.common.Tradewinds;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public class GoodTypeManager {
	public static List<GoodType> GoodTypes = new ArrayList<GoodType>();

	public static void RegisterGoodTypeDatapackType() {
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {

			@Override
			public Identifier getFabricId() {
				return new Identifier("tradewinds", "good_type");
			}
	 
			@Override
			public void reload(ResourceManager manager) {

				GoodTypes.clear();
	 
				for(Identifier id : manager.findResources("tradewinds_good_types", path -> path.endsWith(".json"))) {
					try(InputStream stream = manager.getResource(id).getInputStream()) {
						JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(stream, "UTF-8")).getAsJsonObject();

						GoodType newGoodType = new GoodType(
							Paths.get(id.getPath()).getFileName().toString().split("\\.json")[0], // this complicated daisy chain gets the resource filename minus the ".json" part
							jsonObject.get("name").getAsString(),
							jsonObject.get("icon").getAsString(),
							jsonObject.get("desc").getAsString()
							);

						GoodTypes.add(newGoodType);
					} catch(Exception e) {
						Tradewinds.LOGGER.error("Error occurred while loading resource json " + id.toString(), e);
					}
				}
				
				Tradewinds.LOGGER.info("Loaded " + GoodTypes.size() + " good types");
			}
		});
	}
}
