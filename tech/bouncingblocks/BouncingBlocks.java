package tech.bouncingblocks;

import tech.bouncingblocks.events.EventUpdateCheck;
import tech.bouncingblocks.util.UpdateChecker;
import tech.bouncingblocks.util.Utilities;
import tech.bouncingblocks.util.thread.ThreadCreateLang;
import tech.bouncingblocks.util.thread.ThreadCreateModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = BouncingBlocks.MODID, version = BouncingBlocks.VERSION)
public class BouncingBlocks
{
    public static final String MODID = "Bouncing Blocks";
    public static final String VERSION = "v3.0";
    public static final String FOLDER = "bouncingblock:";
    
    public static CreativeTabs tabBB = new TabBouncingBlock("tabBounce");
    
    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) 
    {
    	try{
			UpdateChecker.lookForUpdates();
		}
    	catch (Exception e) 
		{
			e.printStackTrace();
		}
    	
    	MinecraftForge.EVENT_BUS.register(new EventUpdateCheck());
    	BBBlocks.addBlocks();
    	
    	new Thread(new ThreadCreateLang(event)).start();
    	new Thread(new ThreadCreateModInfo(event)).start();
    }
    
    @EventHandler
    public void onInit(FMLInitializationEvent event) throws Exception
    {
    	Recipes.addRecipes(GameRegistry.class.newInstance());
    }
}
