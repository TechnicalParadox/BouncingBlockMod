package tech.bouncingblockmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import tech.bouncingblockmod.Accessors;
import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CannonBlockEast extends Block{
	private Reference ref;
	private Accessors acc;
	
	public CannonBlockEast(int par1, Material par2Material) {
		super(par1, par2Material);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("cannonBlockEast");
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon("bouncingblockmod:cannon_blockEast");
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
//		par5Entity.motionY = 2.5;
//		par5Entity.motionX = 2.5;
		Accessors.setLaunchVelocityEast(2.5F, 2.5F, par5Entity);
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
//		par5Entity.motionY = 2.5;
//		par5Entity.motionX = 2.5;
		Accessors.setLaunchVelocityEast(2.5F, 2.5F, par5Entity);
	}
	
}
