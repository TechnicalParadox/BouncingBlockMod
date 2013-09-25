package tech.bouncingblockmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import tech.bouncingblockmod.bouncingblocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBounce extends Block{
	bouncingblocks main;
	
	public BlockBounce(int par1) {
		super(par1, Material.ground);
		
		this.setHardness(1.0F);
		this.setStepSound(Block.soundClothFootstep);
		this.setCreativeTab(main.tab);
		this.setResistance(1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	// Texture
	public void registerIcons(IconRegister reg) {}
	
	// Causes the Player to launch when block is stepped on
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {}
	
	// Causes the Player to not take fall damage when fallen on
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6) {}
	
	//Algorithms/Block Velocity Starts Here==========================================================================================================
	
	/**
	 * Launch an entity (up)
	 * @param par
	 * @param par5Entity
	 */
	public static void setUpwardVelocity(float par, Entity par5Entity){
		par5Entity.motionY = par;
	}
	
	/**
	 * Launch an entity (East)
	 * @param par
	 * @param par5Entity
	 */
	public static void setForwardVelocityEast(float par, Entity par5Entity){
		par5Entity.motionX = par;
		
	}
	
	/**
	 * launch an entity (West)
	 * @param par
	 * @param par5Entity
	 */
	public static void setForwardVelocityWest(float par, Entity par5Entity){
		par5Entity.motionX = -1 * par;
		
	}
	
	/**
	 * Launch an entity (North)
	 * @param par
	 * @param par5Entity
	 */
	public static void setForwardVelocityNorth(float par, Entity par5Entity){
		par5Entity.motionZ = -1 * par;
		
	}
	
	/**
	 * Launch an entity (South)
	 * @param par
	 * @param par5Entity
	 */
	public static void setForwardVelocitySouth(float par, Entity par5Entity){
		par5Entity.motionZ = par;
		
	}
	
	/**
	 * Launches the entity (up and east)
	 * @param par
	 * @param var
	 * @param par5Entity
	 */
	public static void setLaunchVelocityEast(float par, float var, Entity par5Entity){
		par5Entity.motionY = par;
		par5Entity.motionX = var;
		
	}
	
	/**
	 * Launches the entity (up and west)
	 * @param par
	 * @param var
	 * @param par5Entity
	 */
	public static void setLaunchVelocityWest(float par, float var, Entity par5Entity){
		par5Entity.motionY = par;
		par5Entity.motionX = -1 * var;
		
	}

	/**
	 * Launches the entity (up and south)
	 * @param par
	 * @param var
	 * @param par5Entity
	 */
	public static void setLaunchVelocitySouth(float par, float var, Entity par5Entity){
		par5Entity.motionY = par;
		par5Entity.motionZ = var;
		
	}

	/**
	 * Launches the entity (up and north)
	 * @param par
	 * @param var
	 * @param par5Entity
	 */
	public static void setLaunchVelocityNorth(float par, float var, Entity par5Entity){
		par5Entity.motionY = par;
		par5Entity.motionZ = -1 * var;
		
	}
	
	//Algorithms/Block Velocity Ends==========================================================================================================
}
