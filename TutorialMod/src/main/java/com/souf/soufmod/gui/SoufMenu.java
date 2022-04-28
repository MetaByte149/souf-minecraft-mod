package com.souf.soufmod.gui;

import com.souf.soufmod.SoufMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class SoufMenu extends Screen {

    private static final int WIDTH = 179;
    private static final int HEIGHT = 151;


    protected SoufMenu() {
        super(new TranslatableComponent("screen." + SoufMod.MOD_ID + ".Menu"));
    }

    @Override
    protected void init() {
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;

        addRenderableWidget(new Button(relX + 10, relY + 10, 160, 20, new TextComponent("Button test"), button -> sendMessage("Press recived")));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static void open() {
        Minecraft.getInstance().setScreen(new SoufMenu());
    }
}
