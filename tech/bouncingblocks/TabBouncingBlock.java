package tech.bouncingblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TabBouncingBlock extends CreativeTabs {
	
	public TabBouncingBlock(String par2Str)
	{
		super(par2Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(BBBlocks.launcherBlock);
	}

}
