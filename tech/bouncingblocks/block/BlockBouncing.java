package tech.bouncingblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import tech.bouncingblocks.BBBlocks;
import tech.bouncingblocks.BouncingBlocks;

public class BlockBouncing extends Block {

	public BlockBouncing() 
	{
		super(Material.ground);
		this.setStepSound(this.soundTypeCloth);
		this.setCreativeTab(BouncingBlocks.tabBB);
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		if(this == BBBlocks.bouncingBlock)
		{
			this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + "bouncing_block");
		}
		else if(this == BBBlocks.launcherBlock)
		{
			this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + "launcher_block");
		}
		else if(this == BBBlocks.cannonBlock)
		{
			this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + "cannon_block");
		}
		else if(this == BBBlocks.paddingBlock)
		{
			this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + "padding_block");
		}
		else
		{
			this.blockIcon = icon.registerIcon(BouncingBlocks.FOLDER + this.getUnlocalizedName().substring(5));
		}
	}
	
	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if(this == BBBlocks.bouncingBlock)
		{
			par5Entity.motionY = 1.5D;
		}
		else if(this == BBBlocks.launcherBlock)
		{
			par5Entity.motionY = 2.9D;
		}
		else if(this == BBBlocks.cannonBlock)
		{
			par5Entity.motionX = -MathHelper.sin((par5Entity.rotationYaw / 180F) * 3.141593F) * MathHelper.cos((par5Entity.rotationPitch / 180F) * 3.141593F) * 4.0D;
			par5Entity.motionY = 2.5D;
			par5Entity.motionZ = MathHelper.cos((par5Entity.rotationYaw / 180F) * 3.141593F) * MathHelper.cos((par5Entity.rotationPitch / 180F) * 3.141593F) * 4.0D;
		}
	}

	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		if(this == BBBlocks.bouncingBlock)
		{
			par5Entity.motionY = 1.5D;
		}
		else if(this == BBBlocks.launcherBlock)
		{
			par5Entity.motionY = 2.9D;
		}
		else if(this == BBBlocks.cannonBlock)
		{
			par5Entity.motionX = -MathHelper.sin((par5Entity.rotationYaw / 180F) * 3.141593F) * MathHelper.cos((par5Entity.rotationPitch / 180F) * 3.141593F);
			par5Entity.motionY = 2.5D;
			par5Entity.motionZ = -MathHelper.sin((par5Entity.rotationPitch / 180F) * 3.141593F);
		}
		else if(this == BBBlocks.paddingBlock)
		{
			par5Entity.fallDistance = 0;
		}
	}
	
}
