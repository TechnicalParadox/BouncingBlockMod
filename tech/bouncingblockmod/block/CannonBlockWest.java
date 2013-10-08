package tech.bouncingblockmod.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CannonBlockWest extends BlockBounce{
	public CannonBlockWest(int par1) {
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon(Reference.getResFolder() + "cannon_blockWest");
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		this.setLaunchVelocityWest(2.5F, 2.5F, par5Entity);
		
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		this.setLaunchVelocityWest(2.5F, 2.5F, par5Entity);
	}
	
}
