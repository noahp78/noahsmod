package noahp78.mods.noahsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BedriteOre extends Block 
{


		public BedriteOre (int id, Material material) 
        {
                super(id, material);
                this.blockHardness=1.0F;
                this.setTextureName("noahsmod:BedriteOre");
                

                		
                		
        }
		@Override
		public boolean onBlockActivated(World world, int bx, int by, int bz, 
                EntityPlayer player, int side, float px, float py, float pz) {
        return false;
		}
}

