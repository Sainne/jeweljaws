package io.github.sainne.jeweljaws;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

//The value here should match an entry in the META-INF/mods.toml file
@Mod(jeweljaws.MODID)

public class jeweljaws
{
	// Establish modid to use(namespace)
	public static final String MODID = "jeweljaws";
    private static final Logger LOGGER = LogUtils.getLogger();
	// Since im going to create an item, first prepare the register
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	// And now prepare registry for creative mode tab
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
	// Create a test item
	public static final RegistryObject<Item> test_item = ITEMS.register("test_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
			.alwaysEat().nutrition(1).saturationMod(2f).build())));
	public static final RegistryObject<CreativeModeTab> test_tab = CREATIVE_MODE_TABS.register("test_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> test_item.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(test_item.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
	
	public jeweljaws()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);
		// Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("Loading common Setup");
    }
	
	private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
		// Some common setup code
        LOGGER.info("Adding test creative tab");
    }
}