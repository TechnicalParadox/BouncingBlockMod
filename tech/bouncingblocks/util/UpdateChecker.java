package tech.bouncingblocks.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import tech.bouncingblocks.BouncingBlocks;

public class UpdateChecker {
	
	public static final String URL = "http://www.planetminecraft.com/mod/bouncing-block-mod/";
	private static String version = BouncingBlocks.VERSION;
	
	public static void lookForUpdates()
	{
		try{

			BufferedReader reader = new BufferedReader(new InputStreamReader(new URI(URL).toURL().openStream()));
			String code;

			while((code = reader.readLine()) != null)
			{
				if(code.contains("<title>"))
				{
					String k = code.substring(code.indexOf("k Mod"), code.indexOf(" Minecraft Mod"));
					k = k.substring(6, k.length());
					version = k;
				}
			}
		}catch(Exception err)
		{
			err.printStackTrace();
		}
	}
	
	public static String getVersion()
	{
		return version;
	}
}
