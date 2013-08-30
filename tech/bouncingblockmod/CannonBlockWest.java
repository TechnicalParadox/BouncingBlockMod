package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CannonBlockWest extends Block{
	private Reference ref;
	
	public CannonBlockWest(int par1, Material par2Material) {
		super(par1, par2Material);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("cannonBlockWest");
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon("bouncingblockmod:cannon_blockWest");
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.motionY = 2.5;
		par5Entity.motionX = -2.5;
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		par5Entity.motionY = 2.5;
		par5Entity.motionX = -2.5;
	}
	
}
