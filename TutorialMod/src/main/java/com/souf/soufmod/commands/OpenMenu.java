package com.souf.soufmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.souf.soufmod.gui.SoufMenu;

import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class OpenMenu {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("bruh").executes((command) -> {
			return execute(command);
		}));

	}

	private static int execute(CommandContext<CommandSourceStack> command) {
		if (!(command.getSource().getEntity() instanceof Player))
			return -1;

		Player player = (Player) command.getSource().getEntity();
		player.sendMessage(new TextComponent("bruh"), Util.NIL_UUID);
		SoufMenu.open();

		return Command.SINGLE_SUCCESS;
	}

}
