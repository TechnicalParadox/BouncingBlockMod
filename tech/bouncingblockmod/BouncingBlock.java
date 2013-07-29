package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BouncingBlock extends Block {

	public BouncingBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// Variables for the block
		this.setHardness(1.0F);
		this.setStepSound(Block.soundSnowFootstep);
		this.setUnlocalizedName("bouncingBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(1F);	
	}

	// Block Texture
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("bouncingblockmod:bouncing_block");
	}
	
	// Player Bounces when block is stepped on
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionY += 2.9d;
    }
    
    // Players fall distance set to 0 when fallen on block
    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
    {
    	par5Entity.fallDistance=0;
    }
	

}
