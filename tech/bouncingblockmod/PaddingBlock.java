package tech.bouncingblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PaddingBlock extends Block {

	public PaddingBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// Variables for the block
		this.setHardness(1.0F);
		this.setStepSound(Block.soundSnowFootstep);
		this.setUnlocalizedName("paddingBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(1F);
		
	}
	
	// Block Texture
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("bouncingblockmod:padding_block");
	}

    // Players fall distance set to 0 when fallen on block
    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
    {
    	par5Entity.fallDistance=0;
    }
	

}
