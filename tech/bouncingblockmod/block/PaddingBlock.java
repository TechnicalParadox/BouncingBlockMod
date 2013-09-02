package tech.bouncingblockmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PaddingBlock extends Block
{

	public PaddingBlock(int paddingBlockID, Material par2Material)
	{
		super(paddingBlockID, par2Material);
		
		// Variables for Block
		this.setHardness(1.0F);
		this.setStepSound(Block.soundClothFootstep);
		this.setUnlocalizedName("paddingBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(1.0F);
	}
	
	// Texture
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("bouncingblockmod:padding_block");
	}
	
	// Stops fall damage
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		par5Entity.fallDistance = 0;
	}

}
