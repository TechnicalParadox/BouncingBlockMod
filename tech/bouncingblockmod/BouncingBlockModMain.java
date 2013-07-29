package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Info for Forge
@Mod (modid="bouncingblockmod", name="Bouncing Block Mod", version="1.1-MC1.6.2-FORGE9.10.0.789")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class BouncingBlockModMain {
	
	//Item IDs
	int bouncingBlockID;
	int paddingBlockID;
	
	// Block Section
	public static Block bouncingBlock;
	public static PaddingBlock paddingBlock;
	
	// Instance of Mod
	public static BouncingBlockModMain instance;
	
	// PreInitialization Events
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		// Configuration Code
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		bouncingBlockID = config.get("Block IDs", "Bouncing Block ID", 1475).getInt();
		paddingBlockID = config.get("Block IDs", "Padding Block ID", 1476).getInt();
		
		config.save();
		
		// Initialize Block
		this.bouncingBlock = new BouncingBlock(bouncingBlockID, Material.snow);
		this.paddingBlock = new PaddingBlock(paddingBlockID, Material.snow);
		
		// Bouncing Block Stuff
		LanguageRegistry.addName(bouncingBlock, "Bouncing Block");
		MinecraftForge.setBlockHarvestLevel(bouncingBlock, "axe", 1);
		GameRegistry.registerBlock(bouncingBlock, "bouncingBlock");
		
		// Padding Block Stuff
		LanguageRegistry.addName(paddingBlock, "Padding Block");
		MinecraftForge.setBlockHarvestLevel(paddingBlock, "axe", 1);
		GameRegistry.registerBlock(paddingBlock, "paddingBlock");
		
		// Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(bouncingBlock, 1),
				"xsx",
				"sys",
				"xsx",
				'x', new ItemStack(Block.cloth, 1, 15), 's', Item.silk, 'y', Item.slimeBall
				);
		
		GameRegistry.addRecipe(new ItemStack(paddingBlock, 1),
				"zsz",
				"szs",
				"zsz",
				'z', new ItemStack(Block.cloth, 1, 0), 's', Item.silk
				);
		
	}
	
	// Loading Events
	@EventHandler
	public void load(FMLLoadEvent event) {
		
	}
	
	// PostInitialization Events
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
