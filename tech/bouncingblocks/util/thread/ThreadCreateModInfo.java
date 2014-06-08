package tech.bouncingblocks.util.thread;

import java.io.File;
import java.io.PrintStream;

import tech.bouncingblocks.BouncingBlocks;
import tech.bouncingblocks.util.UpdateChecker;
import tech.bouncingblocks.util.Utilities;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ThreadCreateModInfo extends Thread implements Runnable
{
	File mcmodInfo;
	FMLPreInitializationEvent event;
	
	public ThreadCreateModInfo(FMLPreInitializationEvent event)
	{
		this.event = event;
	}
	
	public void run()
	{
		File modDir = new File(this.event.getModConfigurationDirectory() + "\\BouncingBlocks");
		if(!modDir.exists()) modDir.mkdirs();
		
		mcmodInfo = new File(modDir, Utilities.getCurrentVersion() + "-mcmod.info");
		
		try
		{
			PrintStream writer = new PrintStream(mcmodInfo);
			String fileStart = "[{";
			String fileEnd = "}]";
			
			writer.println("// This is a temp file. Nothing will change if you modify this file");
			writer.println();
			writer.println(fileStart);
			writer.println("\"modid\": \"" + BouncingBlocks.MODID + "\",");
			writer.println("\"name\": \"" + BouncingBlocks.MODID + "\",");
			writer.println("\"description\": \"Adds new blocks to the game that enable even more possibilites!\",");
			writer.println("\"version\": \"${version}\",");
			writer.println("\"mcversion\": \"${mcversion}\",");
			writer.println("\"url\": \"" + UpdateChecker.URL + "\",");
			writer.println("\"updateurl\": \"\",");
			writer.println("\"authorList\": [\"TechnicalParadox\", \"Gim949\"],");
			writer.println("\"credits\": \"TechnicalParadox and Gim949\",");
			writer.println("\"screenshots\": [],");
			writer.println("\"dependencies\": []");
			writer.println(fileEnd);
			writer.close();
			
		}catch(Exception err)
		{
			err.printStackTrace();
		}
	}
}
