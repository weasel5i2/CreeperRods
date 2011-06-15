package net.weasel.CreeperRods;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

import net.weasel.CreeperRods.CreeperListener;

public class CreeperRods extends JavaPlugin 
{
	public static EntityListener entityListener;
	public static String pluginName = "";
	public static String pluginVersion = "";
	
	public void logOutput( String message ) 
	{
		System.out.println( "[" + pluginName + "] " + message );
	}
	
	@Override 
	public void onDisable() 
	{
		logOutput( "CreeperRods disabled." );
	}

	@Override
	public void onEnable() 
	{
		pluginName = getDescription().getName();
		pluginVersion = getDescription().getVersion();
		
		entityListener = new CreeperListener( this );
		
		getServer().getPluginManager().registerEvent( Type.ENTITY_EXPLODE, 
				entityListener, Priority.High, this );

		logOutput( "Creepers are now walking lightning rods. Be careful." );
	}
}
