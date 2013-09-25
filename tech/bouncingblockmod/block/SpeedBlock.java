package tech.bouncingblockmod.block;

import net.minecraft.client.renderer.texture.IconRegister;
import tech.bouncingblockmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SpeedBlock extends BlockBounce{

	public SpeedBlock(int par1) {
		super(par1);
		//Don't go above 10.0F. May crash game
		this.slipperiness = 1.5F;
		this.setStepSound(soundGlassFootstep);
		this.setResistance(0.5F);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon){
		this.blockIcon = icon.registerIcon(Reference.getResFolder() + "speed_Block");
	}
}
