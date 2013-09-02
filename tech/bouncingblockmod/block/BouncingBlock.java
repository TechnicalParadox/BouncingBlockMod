package tech.bouncingblockmod.block;

import tech.bouncingblockmod.Accessors;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BouncingBlock extends Block
{
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
	
	// Causes the Player to launch when block is stepped on
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		Accessors.setUpwardVelocity(1.5F, par5Entity);
	}
	
	// Causes the Player to not take fall damage when fallen on
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		Accessors.setUpwardVelocity(1.5F, par5Entity);
	}
	
}
