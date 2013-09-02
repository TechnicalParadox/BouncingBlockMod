/*
 * This class is used for setters and getters only. Its an easy way to alter one piece of code without changing anything else.
 * 
 *  -Gim949
 */

package tech.bouncingblockmod;

import tech.bouncingblockmod.BouncingBlockModMain.BBCommand;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Accessors{
	
	public static String getModId(){
		return Reference.MOD_ID;
	}
	
	public static String getModName(){
		return Reference.MOD_NAME;
	}
	
	public static String getModVersion(){
		return Reference.MOD_VERSION;
	}
	
	public static String getProcessCommand(){
		return "\2478Bouncing block Mod Version: " + getModVersion();
	}
	
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
	
	/**
	 * Creates a random float number from 1 - 100
	 * @param par
	 */
	public static float createRandomNumber(float par){ 
		//In order to create a random number, you have to enter a number 
		//e.g createRandomNumber(enter float here) = some random number
		
		float f = (float) ((float) ((float) Math.sqrt(Math.PI) * Math.sin(4.614745)) / 0.2648 + par);
		
		if(f >= 100){
			f = f / 10;
		}
		else if(f <= 0){
			f = f * -1;
		}
		else if(f <= 100 || f >= 1){
			return f;
		}
		
		return f;
	}
	
	//Algorithms/Block Velocity Ends==========================================================================================================
}
