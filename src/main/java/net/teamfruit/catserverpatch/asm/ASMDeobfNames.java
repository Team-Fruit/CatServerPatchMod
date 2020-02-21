package net.teamfruit.catserverpatch.asm;

import net.teamfruit.catserverpatch.asm.lib.RefName;

import javax.annotation.Nonnull;

public class ASMDeobfNames {
	public static final @Nonnull RefName NetHandlerPlayServerChat = RefName.name("chat");
	public static final @Nonnull RefName NetHandlerPlayServerPlayer = RefName.deobName("player", "field_147369_b");
	public static final @Nonnull RefName EntityPlayerMPGetDisplayName = RefName.deobName("getDisplayName", "func_145748_c_");
	public static final @Nonnull RefName ForgeHooksNewChatWithLinks = RefName.name("newChatWithLinks");
	public static final @Nonnull RefName ForgeHooksOnServerChatEvent = RefName.name("onServerChatEvent");
}
