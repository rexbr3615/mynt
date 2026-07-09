package net.rexbrx.mynt.oasis;

import net.minecraft.client.gui.GuiGraphics;

public class myInterfaceUtils
{
    public static void drawHorizontalLine(GuiGraphics guiGraphics, int startX, int endX, int y, int color) {
        if (endX < startX) {
            int i = startX;
            startX = endX;
            endX = i;
        }
        guiGraphics.fill(startX, y, endX + 1, y + 1, color);
    }

    public static void drawVerticalLine(GuiGraphics guiGraphics, int x, int startY, int endY, int color) {
        if (endY < startY) {
            int i = startY;
            startY = endY;
            endY = i;
        }
        guiGraphics.fill(x, startY + 1, x + 1, endY, color);
    }
}
