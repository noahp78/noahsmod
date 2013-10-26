package noahp78.mods.noahsmod.blocks;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;

public class LiquidFlowing extends BlockFlowing{

	public LiquidFlowing(int par1, Material par2Material) {
		super(503, Material.water);
        this.blockHardness = 100.0F;
        this.setLightOpacity(3);
        this.setTextureName("noahsmod:movingtexture.png");
        
		// TODO Auto-generated constructor stub
	}

}
