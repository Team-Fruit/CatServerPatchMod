package net.teamfruit.catserverpatch;

import javax.annotation.Nonnull;

public class VersionReference {
	public static final @Nonnull String VERSION = "${version}";
	public static final @Nonnull String FORGE = "${forgeversion}";
	public static final @Nonnull String MINECRAFT = "${mcversion}";
}
