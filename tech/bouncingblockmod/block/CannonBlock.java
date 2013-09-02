package tech.bouncingblockmod.block;

import tech.bouncingblockmod.Accessors;
import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class CannonBlock extends Block{
	private Reference ref;
	private static Accessors acc;
	
	public CannonBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("cannonBlock");
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon("bouncingblockmod:cannon_block");
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		launchAlgorithm(par5Entity);
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		launchAlgorithm(par5Entity);
	}	
	
	public void launchAlgorithm(Entity par5Entity){
		//Slightly glitchy, still working on it -Gim949
		float f = 4F;

		Accessors.setUpwardVelocity(2.5F, par5Entity);

		if(par5Entity.isAirBorne){
			this.slipperiness = 2.5F * f;

			if(par5Entity.onGround){
				par5Entity.noClip = false;
			}
		}
	}
}
