package tech.bouncingblocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void addRecipes(GameRegistry game)
	{
		GameRegistry.addRecipe(new ItemStack(BBBlocks.bouncingBlock, 3),
				"xsx",
				"sys",
				"xsx",
				'x', new ItemStack(Blocks.wool, 1, 15), 's', Items.string, 'y', Items.slime_ball
				);

		// Padding Block
		GameRegistry.addRecipe(new ItemStack(BBBlocks.paddingBlock, 3),
				"zsz",
				"szs",
				"zsz",
				'z', new ItemStack(Blocks.wool, 1, 0), 's', Items.string);

		// Launcher Block
		GameRegistry.addRecipe(new ItemStack(BBBlocks.launcherBlock, 3),
				"isi",
				"ipi",
				"iri",
				'i', Items.iron_ingot, 'p', Blocks.piston, 'r', Blocks.redstone_torch, 's', Blocks.light_weighted_pressure_plate);

		// Cannon Block
		GameRegistry.addRecipe(new ItemStack(BBBlocks.cannonBlock, 3),
				"sps",
				"iri",
				"iii",
				'i', Items.iron_ingot, 'p', Blocks.piston, 'r', Blocks.redstone_torch, 's', Blocks.light_weighted_pressure_plate);

		// Speed Block - Recipe 1
		GameRegistry.addRecipe(new ItemStack(BBBlocks.speedBlock, 3),
				"iii",
				"sss",
				"sss",
				'i', Blocks.ice, 's', Items.snowball);
	}
}
