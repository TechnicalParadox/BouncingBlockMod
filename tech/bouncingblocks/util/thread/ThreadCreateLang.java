package tech.bouncingblocks.util.thread;

import java.io.File;
import java.io.PrintStream;

import tech.bouncingblocks.BouncingBlocks;
import tech.bouncingblocks.util.Utilities;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ThreadCreateLang extends Thread implements Runnable{
	
	File langFile;
	FMLPreInitializationEvent event;
	
	public ThreadCreateLang(FMLPreInitializationEvent event)
	{
		this.event = event;
	}
	
	public void run() 
	{
		File modDir = new File(this.event.getModConfigurationDirectory() + "\\BouncingBlocks");
		if(!modDir.exists()) modDir.mkdirs();
		
		langFile = new File(modDir, BouncingBlocks.VERSION + ".lang");
		
		try
		{
			PrintStream writer = new PrintStream(langFile);
			writer.println("// This is a temp file. Whatever you change in here will not affect the game!");
			writer.println("// If you want to change the name of the blocks, you have to go inside the mod.zip");
			writer.println("// and go into assets/bouncingblocks/lang/en_US.lang!");
			writer.println();
			
			for(int x = 0; x < Utilities.getBlockNameList().size(); x++)
			{
				String blockName = Utilities.getBlockNameList().get(x);
				writer.println(blockName);
			}
			
			writer.close();
			
		}catch(Exception err)
		{
			err.printStackTrace();
		}
	}
}
