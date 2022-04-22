package com.souf.soufmod.init;

import com.google.common.base.Supplier;
import com.souf.soufmod.SoufMod;
import com.souf.soufmod.item.ExampleItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoufMod.MOD_ID);

	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
			() -> new ExampleItem(new Item.Properties().tab(SoufMod.SOUF_MOD_TAB)));

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
