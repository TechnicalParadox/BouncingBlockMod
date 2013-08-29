package Gim949.mods.boucingblockAddon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.common.Configuration;

import tech.bouncingblockmod.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Bouncing Blocks Addon version 1.0 for MC 1.6.2
 * @author Gim949
 * 
 * @Note Mod will not work without BouncingBlockModMain.java
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class BBAddon extends BouncingBlockModMain{
	/** Intervals for Config**/
	static int cannonBlockNorthID = 1478, cannonBlockSouthID = 1479, cannonBlockEastID = 1480, cannonBlockWestID = 1481, speedyBlockID = 1482;
	/**Custom Blocks**/
	static Block cannonBlockNorth, cannonBlockSouth, cannonBlockEast, cannonBlockWest, speedyBlock;
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		cannonBlockNorth = new BlockCannonNorth(cannonBlockNorthID, Material.ground);
		cannonBlockSouth = new BlockCannonSouth(cannonBlockSouthID, Material.ground);
		cannonBlockEast = new BlockCannonEast(cannonBlockEastID, Material.ground);
		cannonBlockWest = new BlockCannonWest(cannonBlockWestID, Material.ground);
		speedyBlock = new BlockSpeedy(speedyBlockID, Material.ground);
		
		GameRegistry game = new GameRegistry();
		LanguageRegistry lang = new LanguageRegistry();
		
		game.registerBlock(cannonBlockNorth, cannonBlockNorth.getUnlocalizedName());
		game.registerBlock(cannonBlockSouth, cannonBlockSouth.getUnlocalizedName());
		game.registerBlock(cannonBlockEast, cannonBlockEast.getUnlocalizedName());
		game.registerBlock(cannonBlockWest, cannonBlockWest.getUnlocalizedName());
		game.registerBlock(speedyBlock, speedyBlock.getUnlocalizedName());
		
		
		lang.addName(cannonBlockNorth, "Cannon Block(North)");
		lang.addName(cannonBlockSouth, "Cannon Block(South)");
		lang.addName(cannonBlockEast, "Cannon Block(East)");
		lang.addName(cannonBlockWest, "Cannon Block(West)");
		lang.addName(speedyBlock, "Speedy Block");
		
		recipes();
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Overwrites config file in BouncingBlockModMain. If the file is renamed, make sure to rename "bouncingblockmod.cfg" as well
		Configuration cfgFile = new Configuration(new File(Minecraft.getMinecraft().mcDataDir + "/config/bouncingblockmod.cfg"));
		
		cfgFile.load();
		
		cannonBlockNorthID = cfgFile.get("Block IDs", "Cannon Block North ID", cannonBlockNorthID).getInt();
		cannonBlockSouthID = cfgFile.get("Block IDs", "Cannon Block South ID", cannonBlockSouthID).getInt();
		cannonBlockEastID = cfgFile.get("Block IDs", "Cannon Block East ID", cannonBlockEastID).getInt();
		cannonBlockWestID = cfgFile.get("Block IDs", "Cannon Block West ID", cannonBlockWestID).getInt();
		speedyBlockID = cfgFile.get("Block IDs", "Speedy Block ID", speedyBlockID).getInt();
		
		cfgFile.save();
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new BBCommand());
	}
	
	/** Feel free to change/add crafting recipes if you'd like **/
	public static void recipes(){
		/*GameRegistry.addRecipe(new ItemStack(cannonBlockNorth, 3),
				"rpr", "ipi", "iii", 'i', Item.ingotIron, 'p', Block.pistonBase, 'r', Block.torchRedstoneActive);
		*/
	}
	/**
	 * Class must stay private in order to stay hidden from other class files. 
	 * This class is only used in BBAddon.java
	 * @author Przemek
	 *
	 */
	private class BBCommand implements ICommand{
		private List allias;
		protected String commandName;
		
		/** Constructor (Commands go here, use allias.add() to add new allias command) **/
		public BBCommand(){
			allias = new ArrayList();
			allias.add("bb");
			allias.add("bouncingblocks");
			
			this.commandName = "bouncingblocks";
		}

		/** Getter for String commandName **/
		@Override
		public String getCommandName() {
			return this.commandName;
		}

		/**
		 * If command input is wrong, the output will be the command usage
		 */
		@Override
		public String getCommandUsage(ICommandSender icommandsender) {
			throw new WrongUsageException("\2478Tells you the version for Bouncing Blocks mod", new Object[0]);
		}

		/**
		 * @return Returns out list of allias 
		 */
		@Override
		public List getCommandAliases() {
			return this.allias;
		}

		/**
		 * If command input is right, the output will be processCommand
		 */
		@Override
		public void processCommand(ICommandSender icommandsender, String[] astring) {
			//Not sure if i have to use func_11066_d, func_111077_e or func_111078_c
			icommandsender.sendChatToPlayer(ChatMessageComponent.func_111066_d("\2477Bouncing Blocks Mod Version: 1.6 for MC 1.6.2 - FORGE 9.10.0.804"));
		}

		@Override
		public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
			return true;
		}

		@Override
		public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
			return null;
		}

		@Override
		public boolean isUsernameIndex(String[] astring, int i) {
			return false;
		}

		@Override
		public int compareTo(Object o) {
			return 0;
		}
		
	}
}
