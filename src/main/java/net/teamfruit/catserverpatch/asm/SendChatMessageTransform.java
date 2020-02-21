package net.teamfruit.catserverpatch.asm;

import net.teamfruit.catserverpatch.asm.lib.*;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class SendChatMessageTransform implements INodeTreeTransformer {
	@Override
	public ClassName getClassName() {
		return ClassName.of("net.minecraft.network.NetHandlerPlayServer");
	}

	@Override
	public ClassNode apply(final ClassNode node) {
		final ASMValidate validator = ASMValidate.create(getSimpleName());
		validator.test("chat");

		final MethodMatcher matcher = new MethodMatcher(getClassName(), DescHelper.toDescMethod(void.class, ClassName.of("java.lang.String"), boolean.class), ASMDeobfNames.NetHandlerPlayServerChat);
		node.methods.stream().filter(matcher).forEach(method -> {
			{
				/*
				L0
				 LINENUMBER 14 L0
				 NEW net/minecraft/util/text/TextComponentTranslation
				 DUP
				 LDC "chat.type.text"
				 ICONST_2
				 ANEWARRAY java/lang/Object
				 DUP
				 ICONST_0
				 ALOAD 0
				 GETFIELD net/minecraft/network/NetHandlerPlayServer.player : Lnet/minecraft/entity/player/EntityPlayerMP;
				 INVOKEVIRTUAL net/minecraft/entity/player/EntityPlayerMP.getDisplayName ()Lnet/minecraft/util/text/ITextComponent;
				 AASTORE
				 DUP
				 ICONST_1
				 ALOAD 1
				 INVOKESTATIC net/minecraftforge/common/ForgeHooks.newChatWithLinks (Ljava/lang/String;)Lnet/minecraft/util/text/ITextComponent;
				 AASTORE
				 INVOKESPECIAL net/minecraft/util/text/TextComponentTranslation.<init> (Ljava/lang/String;[Ljava/lang/Object;)V
				 ASTORE 3
				L1
				 LINENUMBER 15 L1
				 ALOAD 0
				 ALOAD 1
				 ALOAD 3
				 INVOKESTATIC net/minecraftforge/common/ForgeHooks.onServerChatEvent (Lnet/minecraft/network/NetHandlerPlayServer;Ljava/lang/String;Lnet/minecraft/util/text/ITextComponent;)Lnet/minecraft/util/text/ITextComponent;
				 ASTORE 3
				L2
				 LINENUMBER 16 L2
				 ALOAD 3
				 IFNONNULL L3
				 RETURN
				*/
				final InsnList insertion = new InsnList();
				// L0
				insertion.add(new TypeInsnNode(Opcodes.NEW, ClassName.of("net.minecraft.util.text.TextComponentTranslation").getBytecodeName()));
				insertion.add(new InsnNode(Opcodes.DUP));
				insertion.add(new LdcInsnNode("chat.type.text"));
				insertion.add(new InsnNode(Opcodes.ICONST_2));
				insertion.add(new TypeInsnNode(Opcodes.ANEWARRAY, ClassName.of("java.lang.Object").getBytecodeName()));
				insertion.add(new InsnNode(Opcodes.DUP));
				insertion.add(new InsnNode(Opcodes.ICONST_0));
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 0));
				insertion.add(new FieldInsnNode(Opcodes.GETFIELD, ClassName.of("net.minecraft.network.NetHandlerPlayServer").getBytecodeName(), ASMDeobfNames.NetHandlerPlayServerPlayer.name(), DescHelper.toDesc(ClassName.of("net.minecraft.entity.player.EntityPlayerMP"))));
				insertion.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, ClassName.of("net.minecraft.entity.player.EntityPlayerMP").getBytecodeName(), ASMDeobfNames.EntityPlayerMPGetDisplayName.name(), DescHelper.toDescMethod(ClassName.of("net.minecraft.util.text.ITextComponent")), false));
				insertion.add(new InsnNode(Opcodes.AASTORE));
				insertion.add(new InsnNode(Opcodes.DUP));
				insertion.add(new InsnNode(Opcodes.ICONST_1));
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 1));
				insertion.add(new MethodInsnNode(Opcodes.INVOKESTATIC, ClassName.of("net.minecraftforge.common.ForgeHooks").getBytecodeName(), ASMDeobfNames.ForgeHooksNewChatWithLinks.name(), DescHelper.toDescMethod(ClassName.of("net.minecraft.util.text.ITextComponent"), ClassName.of("java.lang.String")), false));
				insertion.add(new InsnNode(Opcodes.AASTORE));
				insertion.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, ClassName.of("net.minecraft.util.text.TextComponentTranslation").getBytecodeName(), "<init>", DescHelper.toDescMethod(void.class, ClassName.of("java.lang.String"), Object[].class), false));
				insertion.add(new VarInsnNode(Opcodes.ASTORE, 3));
				// L1
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 0));
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 1));
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 3));
				insertion.add(new MethodInsnNode(Opcodes.INVOKESTATIC, ClassName.of("net.minecraftforge.common.ForgeHooks").getBytecodeName(), ASMDeobfNames.ForgeHooksOnServerChatEvent.name(), DescHelper.toDescMethod(ClassName.of("net.minecraft.util.text.ITextComponent"), ClassName.of("net.minecraft.network.NetHandlerPlayServer"), ClassName.of("java.lang.String"), ClassName.of("net.minecraft.util.text.ITextComponent")), false));
				insertion.add(new VarInsnNode(Opcodes.ASTORE, 3));
				// L2
				insertion.add(new VarInsnNode(Opcodes.ALOAD, 3));
				LabelNode jump = new LabelNode();
				insertion.add(new JumpInsnNode(Opcodes.IFNONNULL, jump));
				insertion.add(new InsnNode(Opcodes.RETURN));
				insertion.add(jump);

				method.instructions.insert(insertion);
				validator.check("chat");
			}
		});

		validator.validate();
		return node;
	}
}