package com.souf.soufmod.events;

import com.souf.soufmod.SoufMod;
import com.souf.soufmod.commands.OpenMenu;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SoufMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterEvents {

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		OpenMenu.register(event.getDispatcher());
	}
}