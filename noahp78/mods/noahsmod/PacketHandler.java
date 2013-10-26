package noahp78.mods.noahsmod;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager,
                        Packet250CustomPayload packet, Player playerEntity) {
        	EntityPlayer player = (EntityPlayer) playerEntity;
        	System.out.println("packet got");
            if (packet.channel.equals("NoahsmodBlock")) {
                handleRandom(packet, (EntityPlayer)playerEntity);
            }
                // TODO Auto-generated method stub
        	
        }
        private void handleRandom(Packet250CustomPayload packet, EntityPlayer player) {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
            System.out.println("Handling Packet");
            
            int randomInt1;
            int randomInt2;
            int randomInt3;
            int randomInt5;
            
            
			try {
                    randomInt1 = inputStream.readInt();
                    randomInt2 = inputStream.readInt();
                    randomInt3 = inputStream.readInt();
                    randomInt5 = inputStream.readInt();
                    
                    
                    //world = inputStream.read();
                    
                    		
                    
            } catch (IOException e) {
                    e.printStackTrace();
                    return;
            }
			
			((EntityPlayer)player).worldObj.setBlock(randomInt1, randomInt2, randomInt3, randomInt5);
			((EntityPlayer)player).addChatMessage("You got a:" + randomInt5);
        
			System.out.println(randomInt1 + " " + randomInt2 + " " + randomInt3 + " " + randomInt5); //world*);
            
    }

}
