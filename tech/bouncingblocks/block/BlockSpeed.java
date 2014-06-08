package tech.bouncingblocks.block;

import tech.bouncingblocks.BouncingBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockSpeed extends Block {

	public BlockSpeed() 
	{
		super(Material.ground);
		this.setStepSound(this.soundTypeGlass);
		this.setResistance(0.5F);
		this.slipperiness = 1.5F;
		this.setCreativeTab(BouncingBlocks.tabBB);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + "speed_Block");
	}

}
