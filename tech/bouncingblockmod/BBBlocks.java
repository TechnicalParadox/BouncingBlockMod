package tech.bouncingblockmod;

import net.minecraft.block.Block;
import tech.bouncingblockmod.block.BouncingBlock;
import tech.bouncingblockmod.block.CannonBlockEast;
import tech.bouncingblockmod.block.CannonBlockNorth;
import tech.bouncingblockmod.block.CannonBlockSouth;
import tech.bouncingblockmod.block.CannonBlockWest;
import tech.bouncingblockmod.block.LauncherBlock;
import tech.bouncingblockmod.block.PaddingBlock;
import tech.bouncingblockmod.block.SpeedBlock;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BBBlocks extends bouncingblocks{
	static bouncingblocks main;
	static BBConfig config;
	
	static Block bouncingBlock, paddingBlock, launcherBlock, speedBlock, cannonBlockNorth, cannonBlockEast, cannonBlockSouth, cannonBlockWest;
	
	//Method used in PreInit
	public static void registers(){
		Blocks();
		NamesAndRegisters();
	}
	
	public static void Blocks(){
		bouncingBlock = new BouncingBlock(config.bouncingBlockID);
		paddingBlock = new PaddingBlock(config.paddingBlockID);
		launcherBlock = new LauncherBlock(config.launcherBlockID);
		speedBlock = new SpeedBlock(config.speedBlockID);
		cannonBlockNorth = new CannonBlockNorth(config.cannonBlockNorthID);
		cannonBlockEast = new CannonBlockEast(config.cannonBlockEastID);
		cannonBlockSouth = new CannonBlockSouth(config.cannonBlockSouthID);
		cannonBlockWest = new CannonBlockWest(config.cannonBlockWestID);
	}
	
	public static void NamesAndRegisters(){
		main.registerBlock(bouncingBlock, "bouncingBlock");
		main.registerBlock(paddingBlock, "paddingBlock");
		main.registerBlock(launcherBlock, "launcherBlock");
		main.registerBlock(speedBlock, "speedBlock");
		main.registerBlock(cannonBlockNorth, "cannonBlockNorth");
		main.registerBlock(cannonBlockEast, "cannonBlockEast");
		main.registerBlock(cannonBlockSouth, "cannonBlockSouth");
		main.registerBlock(cannonBlockWest, "cannonBlockWest");
		
		LanguageRegistry.addName(bouncingBlock, "Bouncing Block");
		LanguageRegistry.addName(paddingBlock, "Padding Block");
		LanguageRegistry.addName(launcherBlock, "Launcher Block");
		LanguageRegistry.addName(speedBlock, "Speed Block");
		LanguageRegistry.addName(cannonBlockNorth, "Cannon Block - North");
		LanguageRegistry.addName(cannonBlockEast, "Cannon Block - East");
		LanguageRegistry.addName(cannonBlockSouth, "Cannon Block - South");
		LanguageRegistry.addName(cannonBlockWest, "Cannon Block - West");
	}
}
