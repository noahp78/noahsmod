package noahp78.mods.noahsmod;

import cpw.mods.fml.common.Mod.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import noahp78.mods.noahsmod.blocks.BedriteOre;

public class CommonProxy {
	public final static net.minecraft.block.Block BedriteOre = new BedriteOre(500, Material.ground)
    .setHardness(0.5F).setStepSound(net.minecraft.block.Block.soundStoneFootstep)
    .setUnlocalizedName("BedriteOre").setCreativeTab(CreativeTabs.tabBlock);

	public void registerRenderers() {
		// TODO Auto-generated method stub
		
	}

	public void registerBlocks() {
		
		// TODO Auto-generated method stub
		
	}

}
