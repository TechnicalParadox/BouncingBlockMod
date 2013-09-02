package tech.bouncingblockmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class SpeedBlock extends Block{

	public SpeedBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		//Don't go above 10.0F. May crash game
		this.slipperiness = 1.5F;
		this.setUnlocalizedName("blockspeedy");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundGlassFootstep);
		this.setResistance(0.5F);
	}
	
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon("bouncingblockmod:speed_Block");
	}
}
