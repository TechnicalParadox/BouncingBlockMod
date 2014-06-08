package tech.bouncingblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import tech.bouncingblocks.block.BlockBouncing;
import tech.bouncingblocks.block.BlockSpeed;
import tech.bouncingblocks.util.Utilities;
import net.minecraft.block.Block;

public class BBBlocks 
{
	public static Block bouncingBlock, paddingBlock, launcherBlock, speedBlock, cannonBlock;
	
	public static void addBlocks()
	{
		bouncingBlock = new BlockBouncing().setBlockName("bouncingBlock");
		paddingBlock = new BlockBouncing().setBlockName("paddingBlock");
		launcherBlock = new BlockBouncing().setBlockName("launcherBlock");
		cannonBlock = new BlockBouncing().setBlockName("cannonBlock");
		
		speedBlock = new BlockSpeed().setBlockName("speedBlock");
		
		{
			Utilities.addBlockName("Bouncing Block", bouncingBlock);
			Utilities.addBlockName("Padding Block", paddingBlock);
			Utilities.addBlockName("Launcher Block", launcherBlock);
			Utilities.addBlockName("Speed Block", speedBlock);
			Utilities.addBlockName("Cannon Block", cannonBlock);
		}
		
		GameRegistry.registerBlock(bouncingBlock, "bouncingBlock");
		GameRegistry.registerBlock(paddingBlock, "paddingBlock");
		GameRegistry.registerBlock(launcherBlock, "launcherBlock");
		GameRegistry.registerBlock(cannonBlock, "cannonBlock");
		GameRegistry.registerBlock(speedBlock, "speedBlock");
	}
}
