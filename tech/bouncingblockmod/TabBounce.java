package tech.bouncingblockmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBounce extends CreativeTabs {

	public TabBounce(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return Reference.MOD_NAME;
    }
    
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return BBBlocks.launcherBlock.blockID;
    }

}
