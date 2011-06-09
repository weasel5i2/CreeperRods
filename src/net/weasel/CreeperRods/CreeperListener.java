package net.weasel.CreeperRods;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperListener implements Listener 
{
	private CreeperRods plugin;
	
	public CreeperListener( CreeperRods instance ) 
	{
		plugin = instance;
		plugin.logOutput( "Monitoring for exploding Creepers." );
	}
	
	public void onEntityExplode(EntityExplodeEvent event) 
	{
		if(event.isCancelled()) 
		{
			return;
		}
		
		Entity entity = event.getEntity();
		
		System.out.println( "ENTITY_EXPLODE: " + entity.getClass().getSimpleName() );
		
		if( entity.getClass().getSimpleName().equals( "CraftCreeper" ) )
		{
			Location loc = entity.getLocation();
			World world = entity.getWorld();
			
			if( event.getEntity() != null ) world.strikeLightning( loc );
			if( event.getEntity() != null ) world.strikeLightning( loc );
			if( event.getEntity() != null ) world.strikeLightning( loc );
			if( event.getEntity() != null ) world.strikeLightning( loc );
			if( event.getEntity() != null ) world.strikeLightning( loc );

			event.setCancelled(true);			
		}
	}
}
