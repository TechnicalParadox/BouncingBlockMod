package tech.bouncingblocks.events;

import tech.bouncingblocks.util.Utilities;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventUpdateCheck {
	
	boolean startMess = true;
	
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		if(startMess)
		{
			Utilities.addMessage("Checking for updates...");
			
			if(Utilities.getCurrentVersion().startsWith(Utilities.getLatestVersion()))
			{
				Utilities.addMessage("No updates found!");
			}
			else
			{
				Utilities.addMessage("BouncingBlocks \247e" + Utilities.getLatestVersion() + "\247r is now availible!");
				Utilities.addMessage("Go to " + Utilities.getLink() + " to get it now.");
			}
			
			System.out.println(Utilities.getCurrentVersion().startsWith(Utilities.getLatestVersion()));
			
			this.startMess = false;
		}
	}
}
