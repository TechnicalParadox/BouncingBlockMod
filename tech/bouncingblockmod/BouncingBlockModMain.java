package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Info for Minecraft Forge
@Mod (modid="bouncingblockmod", name="Bouncing Block Mod", version="1.5 for MC 1.6.2 - FORGE 9.10.0.789")
@NetworkMod (clientSideRequired=true, serverSideRequired=false)

public class BouncingBlockModMain {
	
	// Item IDs
	int bouncingBlockID;
	int paddingBlockID;
	int minecraftShearsID;
	
	// Blocks
	public static BouncingBlock bouncingBlock;
	public static PaddingBlock paddingBlock;
	
	// Minecraft shears so we can harvest with them
	public static ItemShears minecraftShears;
	
	// Instance of Mod
	public static BouncingBlockModMain instance;
	
	// PreInitialization Events
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		
		// Config Code
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		// Load config
		config.load();
		
		// Get Block IDs from config file
		bouncingBlockID = config.get("Block IDs", "Bouncing Block ID", 1475).getInt();
		paddingBlockID = config.get("Block IDs", "Padding Block ID", 1476).getInt();
		
		// Get Item IDs from config file
		minecraftShearsID = config.get("Item IDs", "Minecraft Shears ID", 359).getInt();
		
		// Save config
		config.save();
		
		// Initialize Blocks
		this.bouncingBlock = new BouncingBlock (bouncingBlockID, Material.ground);
		this.paddingBlock = new PaddingBlock (paddingBlockID, Material.ground);
		
		// Information needed for the Bouncing Block
		LanguageRegistry.addName(bouncingBlock, "Bouncing Block");
		MinecraftForge.setBlockHarvestLevel(bouncingBlock, "anything", 0);
		GameRegistry.registerBlock(bouncingBlock, "bouncingBlock");
		
		// Information needed for the Padding Block
		LanguageRegistry.addName(paddingBlock, "Padding Block");
		MinecraftForge.setBlockHarvestLevel(paddingBlock, "anything", 0);
		GameRegistry.registerBlock(paddingBlock, "paddingBlock");
		
		// Crafting Recipes
			// Bouncing Block
			GameRegistry.addRecipe(new ItemStack(bouncingBlock, 1),
					"xsx",
					"sys",
					"xsx",
					'x', new ItemStack(Block.cloth, 1, 15), 's', Item.silk, 'y', Item.slimeBall
					);
			// Padding Block
			GameRegistry.addRecipe(new ItemStack(paddingBlock, 1),
					"zsz",
					"szs",
					"zsz",
					'z', new ItemStack(Block.cloth, 1, 0), 's', Item.silk);
		
	}
	
}
