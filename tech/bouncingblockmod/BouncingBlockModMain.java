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
@Mod (modid="bouncingblockmod", name="Bouncing Block Mod", version="1.6 for MC 1.6.2 - FORGE 9.10.0.804")
@NetworkMod (clientSideRequired=true, serverSideRequired=false)

public class BouncingBlockModMain {
	
	// Item IDs
	int bouncingBlockID;
	int paddingBlockID;
	int launcherBlockID;
	
	// Blocks
	public static BouncingBlock bouncingBlock;
	public static PaddingBlock paddingBlock;
	public static LauncherBlock launcherBlock;
	
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
		launcherBlockID = config.get("Block IDs", "Launcher Block ID", 1477).getInt();
		
		// Save config
		config.save();
		
		// Initialize Blocks
		this.bouncingBlock = new BouncingBlock (bouncingBlockID, Material.ground);
		this.paddingBlock = new PaddingBlock (paddingBlockID, Material.ground);
		this.launcherBlock = new LauncherBlock (launcherBlockID, Material.ground);
		
		// Information needed for the Bouncing Block
		LanguageRegistry.addName(bouncingBlock, "Bouncing Block");
		MinecraftForge.setBlockHarvestLevel(bouncingBlock, "anything", 0);
		GameRegistry.registerBlock(bouncingBlock, "bouncingBlock");
		
		// Information needed for the Padding Block
		LanguageRegistry.addName(paddingBlock, "Padding Block");
		MinecraftForge.setBlockHarvestLevel(paddingBlock, "anything", 0);
		GameRegistry.registerBlock(paddingBlock, "paddingBlock");
		
		// Information needed for the Launcher Block
		LanguageRegistry.addName(launcherBlock, "Launcher Block");
		MinecraftForge.setBlockHarvestLevel(launcherBlock, "anything", 0);
		GameRegistry.registerBlock(launcherBlock, "launcherBlock");
		
		// Crafting Recipes
			// Bouncing Block
			GameRegistry.addRecipe(new ItemStack(bouncingBlock, 3),
					"xsx",
					"sys",
					"xsx",
					'x', new ItemStack(Block.cloth, 1, 15), 's', Item.silk, 'y', Item.slimeBall
					);
			// Padding Block
			GameRegistry.addRecipe(new ItemStack(paddingBlock, 3),
					"zsz",
					"szs",
					"zsz",
					'z', new ItemStack(Block.cloth, 1, 0), 's', Item.silk);
			// Launcher Block
			GameRegistry.addRecipe(new ItemStack(launcherBlock, 3),
					"ipi",
					"iri",
					"iii",
					'i', Item.ingotIron, 'p', Block.pistonBase, 'r', Block.torchRedstoneActive);
		
	}
	
}
