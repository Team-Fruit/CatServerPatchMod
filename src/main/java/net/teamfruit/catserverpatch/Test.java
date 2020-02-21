package net.teamfruit.catserverpatch;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.ForgeHooks;

public class Test {
    public EntityPlayerMP player;

    public static void chat(NetHandlerPlayServer net, String s, boolean async) {
        ITextComponent itextcomponent = new TextComponentTranslation("chat.type.text", net.player.getDisplayName(), ForgeHooks.newChatWithLinks(s));
        itextcomponent = ForgeHooks.onServerChatEvent(net, s, itextcomponent);
        if (itextcomponent == null) return;

        if (s.isEmpty() || net.player.getChatVisibility() == EntityPlayer.EnumChatVisibility.HIDDEN) {
            return;
        }
    }
}
