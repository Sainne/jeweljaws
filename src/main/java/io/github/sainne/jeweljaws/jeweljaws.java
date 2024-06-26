package io.github.sainne.jeweljaws;

import com.mojang.logging.LogUtils;
import io.github.sainne.jeweljaws.item.CreativeTab;
import io.github.sainne.jeweljaws.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//The value here should match an entry in the META-INF/mods.toml file
@Mod(jeweljaws.MODID)

public class jeweljaws
{
	// Establish modid to use(namespace)
	public static final String MODID = "jeweljaws";
    private static final Logger LOGGER = LogUtils.getLogger();
	
	public jeweljaws()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);
		// Register Creative Mode Tab
		CreativeTab.register(modEventBus);
		// Register Items
		ModItems.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("Loading common Setup");
    }
	
	private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
		// Some common setup code
        LOGGER.info("Adding creative tab");
    }
}