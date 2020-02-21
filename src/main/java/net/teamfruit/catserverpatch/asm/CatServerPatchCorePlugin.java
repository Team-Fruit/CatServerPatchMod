package net.teamfruit.catserverpatch.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.teamfruit.catserverpatch.Reference;

import javax.annotation.Nullable;
import java.util.Map;

public class CatServerPatchCorePlugin implements IFMLLoadingPlugin {
	@Override
	public @Nullable String[] getASMTransformerClass() {
		return new String[] {
				Reference.TRANSFORMER
		};
	}

	@Override
	public @Nullable String getModContainerClass() {
		return null;
	}

	@Override
	public @Nullable String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(final @Nullable Map<String, Object> data) {
	}

	@Override
	public @Nullable String getAccessTransformerClass() {
		return null;
	}
}