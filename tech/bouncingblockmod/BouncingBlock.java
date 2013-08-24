package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BouncingBlock extends Block
{
	// Integers required for the bouncing mechanic
	double FallDistance;
	double BounceHeight;

	public BouncingBlock(int bouncingBlockID, Material par2Material)
	{
		super(bouncingBlockID, par2Material);
		
		// Variables for Block
		this.setHardness(1.0F);
		this.setStepSound(Block.soundClothFootstep);
		this.setUnlocalizedName("bouncingBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(1.0F);
	}
	
	// Texture
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("bouncingblockmod:bouncing_block");
	}
	
	// Causes the Player to not take fall damage and bounce when fallen on
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		FallDistance = par5Entity.fallDistance;
		
		par5Entity.fallDistance = 0;
		
		BounceHeight = FallDistance + .1;
		if (BounceHeight >= 2.9) {
			BounceHeight = 2.9;
		}
		
		par5Entity.motionY += BounceHeight;
	}
	
}
