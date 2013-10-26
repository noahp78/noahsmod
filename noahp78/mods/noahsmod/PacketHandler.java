package noahp78.mods.noahsmod;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager,
                        Packet250CustomPayload packet, Player playerEntity) {
                // TODO Auto-generated method stub
        }
        private void handleRandom(Packet250CustomPayload packet) {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
            
            int randomInt1;
            int randomInt2;
            int randomInt3;
            
            
            
            int world;
            
			try {
                    randomInt1 = inputStream.readInt();
                    randomInt2 = inputStream.readInt();
                    randomInt3 = inputStream.readInt();
                    //world = inputStream.read();
                    
                    		
                    
            } catch (IOException e) {
                    e.printStackTrace();
                    return;
            }
            
			System.out.println(randomInt1 + " " + randomInt2 + " " + randomInt3); //world*);
			
            
    }

}
