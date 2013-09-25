package tech.bouncingblockmod.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LauncherBlock extends BlockBounce
{
	public LauncherBlock (int launcherBlockID)
	{
		super(launcherBlockID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon(Reference.getResFolder() + "launcher_block");
	}
	
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		this.setUpwardVelocity(2.9F, par5Entity);
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		this.setUpwardVelocity(2.9F, par5Entity);
	}
	
}
