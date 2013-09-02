package tech.bouncingblockmod.block;

import tech.bouncingblockmod.Accessors;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class LauncherBlock extends Block
{
	public LauncherBlock (int launcherBlockID, Material par2Material)
	{
		super(launcherBlockID, par2Material);
		
		// Variables for Block
		this.setHardness(1.0F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName("launcherBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(2.0F);
	}
	
	// Texture
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("bouncingblockmod:launcher_block");
	}

	// Causes the Player to launch when the block is stepped on
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		//par5Entity.motionY = 2.9;
		Accessors.setUpwardVelocity(2.9F, par5Entity);
	}
	
	// Causes the Player to launch when the block is fallen on
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		//par5Entity.motionY = 2.9;
		Accessors.setUpwardVelocity(2.9F, par5Entity);
	}
	
}