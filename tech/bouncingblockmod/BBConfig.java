package tech.bouncingblockmod;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class BBConfig {
	//Item Ids
	static int bouncingBlockID, paddingBlockID, launcherBlockID, speedBlockID, cannonBlockNorthID, cannonBlockEastID, cannonBlockSouthID, cannonBlockWestID;
	
	public static void Config(FMLPreInitializationEvent event){
		Configuration cfgFile = new Configuration(event.getSuggestedConfigurationFile());
		cfgFile.load();
		
		bouncingBlockID = cfgFile.get("Block IDs", "Bouncing Block ID", 1475).getInt();
		paddingBlockID = cfgFile.get("Block IDs", "Padding Block ID", 1476).getInt();
		launcherBlockID = cfgFile.get("Block IDs", "Launcher Block ID", 1477).getInt();
		speedBlockID = cfgFile.get("Block IDs", "Speed Block ID", 1478).getInt();
		cannonBlockNorthID = cfgFile.get("Block IDs", "Cannon Block North ID", 1479).getInt();
		cannonBlockEastID = cfgFile.get("Block IDs", "Cannon Block East ID", 1480).getInt();
		cannonBlockSouthID = cfgFile.get("Block IDs", "Cannon Block South ID", 1481).getInt();
		cannonBlockWestID = cfgFile.get("Block IDs", "Cannon Block West ID", 1482).getInt();
		
		cfgFile.save();
	}
}
