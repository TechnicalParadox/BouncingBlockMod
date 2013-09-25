package tech.bouncingblockmod.block;

import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PaddingBlock extends BlockBounce
{
	public PaddingBlock(int paddingBlockID)
	{
		super(paddingBlockID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon(Reference.getResFolder() + "padding_block");
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		par5Entity.fallDistance = 0;
	}

}
