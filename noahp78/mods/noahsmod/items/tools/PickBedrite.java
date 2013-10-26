package noahp78.mods.noahsmod.items.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.block.material.Material;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;


public class PickBedrite extends ItemPickaxe {

	public PickBedrite(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
		this.setTextureName("noahsmod:BedritePick");
		
	}
	@Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
           if (entityPlayer.experienceLevel < 99) {
        	   //wonder what this does ;)
        	   entityPlayer.addChatMessage("Not Enough XP to do this");
        	   
           }
           if (entityPlayer.experienceLevel > 2) {
        	   int randomInt6 = 43;
        	   //Preparation For the new Experience System..
        			   
           }
           if (entityPlayer.experienceLevel > 99) {
        	   entityPlayer.experienceLevel = (entityPlayer.experienceLevel-99);
        	   entityPlayer.addChatMessage("WOW!");
        	   System.out.println("Sending Packet");
        	   
        		   Random random = new Random();
                   int randomInt5 = random.nextInt(100)+1;
                   int randomInt2 = random.nextInt();
                   
                   ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
                   DataOutputStream outputStream = new DataOutputStream(bos);
                   try {
                           outputStream.writeInt(x);
                           outputStream.writeInt(y);
                           outputStream.writeInt(z);
                           outputStream.writeInt(randomInt5);
                           //outputStream.writeByte(world);
                           
                   } catch (Exception ex) {
                           ex.printStackTrace();
                   }
                   
                   Packet250CustomPayload packet = new Packet250CustomPayload();
                   packet.channel = "NoahsmodBlock";
                   packet.data = bos.toByteArray();
                   packet.length = bos.size();
                   
                   Side side = FMLCommonHandler.instance().getEffectiveSide();
                   if (side == Side.SERVER) {
                           // We are on the server side.
                           // Doing nothing cause we want the Server to get the New Use
                   } else if (side == Side.CLIENT) {
                           // We are on the client side.
                	System.out.println("sending packet...2");
                	
                           EntityClientPlayerMP player = (EntityClientPlayerMP) entityPlayer;
                           //player.sendQueue.addToSendQueue(packet);
                           ((EntityClientPlayerMP)entityPlayer).sendQueue.addToSendQueue(packet);
                           System.out.println("Packet Almost sent...");
                           
                          // world.setBlock(x, y, z, 57);
                           // this gets done server side
                           
                   } else {
                           // We are on the Bukkit server.
                   }
                   
                   return false;
           }   
        	   
        	   
        return true;
    }
	

}
