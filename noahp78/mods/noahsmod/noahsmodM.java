package noahp78.mods.noahsmod;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import net.minecraft.src.ModLoader;
import net.minecraft.item.*;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import noahp78.mods.noahsmod.*;
import noahp78.mods.noahsmod.blocks.BedriteBlock;
import noahp78.mods.noahsmod.WorldGen;



import noahp78.mods.noahsmod.blocks.BedriteOre;
import noahp78.mods.noahsmod.items.tools.PickBedrite;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
/**
 * 
 * @author noahp78
 * @license CC-By-No Comercial
 * Code is Messy, Works for FORGE 1.6.4
 * 
 */

@Mod(modid="noahsmod", name="NoahsMod", version="Build #3")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"NoahsmodBlock"}, packetHandler= noahp78.mods.noahsmod.PacketHandler.class)
		

public class noahsmodM {
	static EnumToolMaterial BEDRITE = EnumHelper.addToolMaterial("BEDRITE",3,2542,20.0F,3.0F,20);
	public static Item BedriteIngot;
	public static Block BedriteBlock;
	
	
	public final static Block LiquidStill = new noahp78.mods.noahsmod.blocks.LiquidStill (503, Material.water);
	public final static Block LiquidFlowing = new noahp78.mods.noahsmod.blocks.LiquidFlowing(504, Material.water);
	public static net.minecraft.block.Block BedriteOre;
	public static net.minecraft.item.ItemPickaxe PickBedrite;
	public static WorldGen worldGen = new WorldGen();
	
	
        // The instance of your mod that Forge uses.
        @Instance(value = "NoahsMod")
        public static noahsmodM instance;
        
        // Says where the client and server 'proxy' code is loaded.
      // @SidedProxy(clientSide="noahp78.mods.noahsmod.client.ClientProxy", serverSide="noahp78.mods.noahsmod.CommonProxy")(seems bugged)
        // 
        public static CommonProxy proxy;
        
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            config.load();
            int BedriteOreID = config.get(Configuration.CATEGORY_BLOCK, "BedriteOreID" , 500).getInt();
            int PickBedriteID = config.get(Configuration.CATEGORY_ITEM, "Bedrite Pick ID" , 501).getInt();
            int BedriteIngotID = config.get(Configuration.CATEGORY_ITEM, "Bedrite Ingot ID" , 505).getInt();
            int BedriteBlockID = config.get(Configuration.CATEGORY_BLOCK, "BedriteBlockID" , 506).getInt();
            boolean debugEnabled = config.get(Configuration.CATEGORY_GENERAL, "Debug", true).getBoolean(true);
            boolean LagSafe = config.get(Configuration.CATEGORY_GENERAL, "LagMode", true).getBoolean(true);
            if (debugEnabled) {
            	System.out.println("[Noahsmod][Debug] Debug Option is working... Loads of Config Output!");
            }
            
            config.save();

            if (debugEnabled) {
            	System.out.println("[Noahsmod][Debug]Registering BedriteOre");
            }
        	BedriteBlock = new BedriteBlock(BedriteBlockID, Material.rock)
            .setHardness(1.5F)
            .setResistance(10.0F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("BedriteBlock")
        	.setCreativeTab(CreativeTabs.tabBlock);
        	
        	BedriteOre = new BedriteOre(BedriteOreID, Material.rock)
            .setHardness(1.5F)
            .setResistance(10.0F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("BedriteOre")
        	.setCreativeTab(CreativeTabs.tabBlock);
        	if (debugEnabled) {
        		System.out.println("[Noahsmod][Debug]Registering PickBedrite");
        		
        	}
        	PickBedrite = (ItemPickaxe) new PickBedrite(PickBedriteID, BEDRITE)
        	.setCreativeTab(CreativeTabs.tabTools)
        	.setUnlocalizedName("PickBedrite");
        	BedriteIngot = new noahp78.mods.noahsmod.items.BedriteIngot(BedriteIngotID)
        	.setCreativeTab(CreativeTabs.tabMaterials)
        	.setUnlocalizedName("BedriteIngot");

        	
            		
            		
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
        	GameRegistry.registerWorldGenerator(worldGen);
        	GameRegistry.registerBlock(BedriteOre, "BedriteOre");
        	GameRegistry.registerBlock(LiquidFlowing, "LiquidFlowing");
        	GameRegistry.registerBlock(LiquidStill, "LiquidStill");
        	GameRegistry.registerBlock(BedriteBlock, "BedriteBlock");
        	GameRegistry.registerItem(BedriteIngot, "BedriteIngot");
        	LanguageRegistry.addName(BedriteOre, "Bedrite Ore");
        	LanguageRegistry.addName(PickBedrite, "Bedrite Pick");
        	LanguageRegistry.addName(LiquidStill, "Chocolate");
        	LanguageRegistry.addName(BedriteIngot, "Bedrite Ingot");
        	LanguageRegistry.addName(BedriteBlock, "Bedrite Block");
        	ItemStack BedriteOre2 = new ItemStack (BedriteOre);
        	ItemStack BedriteIngot2 = new ItemStack (BedriteIngot);
        	ItemStack Sticks = new ItemStack (Item.stick);
        	ItemStack BedriteBLock2 = new ItemStack (BedriteBlock);
        	
        	
        	GameRegistry.addSmelting(BedriteOre.blockID, BedriteIngot2, 1F);
        	GameRegistry.addRecipe(new ItemStack(PickBedrite), "yyy", " x ", " x ",
        	        'x', Sticks, 'y', BedriteIngot);
        	GameRegistry.addRecipe(new ItemStack (BedriteBlock), "iii", "iii", "iii", 'i', BedriteIngot);
        	GameRegistry.addShapelessRecipe(new ItemStack(BedriteIngot, 9), new ItemStack(BedriteBlock));
        	
        	
                
        }
        @EventHandler
        public void worldjoin(EntityJoinWorldEvent event) {
        	System.out.println("[Noahsmod][Debug] Fired EntityJoinWorldEvent");
        	
        			
        }
        
        
        	
       // }
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
        	
                // Stub Method
        }
        @EventHandler
        public void serverLoad(FMLServerStartingEvent event)
        {
          event.registerServerCommand(new SampleCommand());
          System.out.println("[Noahs mod] Server side Starting")
        }
}
