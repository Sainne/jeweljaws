package io.github.sainne.jeweljaws.item;

import io.github.sainne.jeweljaws.jeweljaws;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // prepare register of items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, jeweljaws.MODID);

    public static final RegistryObject<Item> AMETHYST_HEART = ITEMS.register("amethyst_heart",
            () -> new Item(new Item.Properties()));

    // Register the items ;D
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
