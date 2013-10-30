package noahp78.mods.noahsmod.blocks;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;

public class LiquidStill extends BlockStationary {

	public LiquidStill(int par1, Material par2Material) {
		super(504, Material.water);
		this.disableStats();
        this.blockHardness = 100.0F;
        this.setLightOpacity(3);
        this.setLightValue(1F);
        
		// TODO Auto-generated constructor stub
	}

}
