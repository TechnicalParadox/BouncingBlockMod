package tech.bouncingblocks.util;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import tech.bouncingblocks.BouncingBlocks;

public class Utilities 
{
	private static ArrayList<String> blockName = new ArrayList();
	
    public static void addMessage(String msg)
    {
    	Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("\2477[\2476BouncingBlocks\2477]\247r " + msg));
    }
	
    public static String getLink()
    {
    	return UpdateChecker.URL;
    }
    
	public static String getCurrentVersion()
	{
		return BouncingBlocks.VERSION;
	}
	
	public static String getLatestVersion()
	{
		return UpdateChecker.getVersion();
	}
	
	public static void addBlockName(String name, Block block)
	{
		blockName.add(block.getLocalizedName() + "=" + name);
	}
	
	public static ArrayList<String> getBlockNameList()
	{
		return blockName;
	}
}
