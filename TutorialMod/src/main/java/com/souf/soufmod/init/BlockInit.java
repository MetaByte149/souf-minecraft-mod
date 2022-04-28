package com.souf.soufmod.init;

import java.util.function.Function;

import com.google.common.base.Supplier;
import com.souf.soufmod.SoufMod;
import com.souf.soufmod.block.ExampleBlock;
import com.souf.soufmod.block.SoufBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			SoufMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
			() -> new ExampleBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE)
					.strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(SoufMod.SOUF_MOD_TAB)));

	public static final RegistryObject<Block> ROTATABLE_BLOCK = register("rotatable_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).dynamicShape().sound(SoundType.STONE)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(SoufMod.SOUF_MOD_TAB)));
	
	public static final RegistryObject<Block> SOUF_BLOCK = register("souf_block",
			() -> new SoufBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).dynamicShape().noOcclusion().sound(SoundType.STONE)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(SoufMod.SOUF_MOD_TAB)));

	private static <T extends Block> RegistryObject<T> registerBlock(final String name,
			final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
