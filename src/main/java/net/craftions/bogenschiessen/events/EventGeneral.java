package net.craftions.bogenschiessen.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EventGeneral implements Listener{
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e)
	{
		if(!e.getPlayer().hasPermission("dropitem"))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerInteract(InventoryClickEvent e)
	{
		if(!e.getWhoClicked().hasPermission("interact"))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e)	
	{
		if(!e.getPlayer().hasPermission("breakblock"))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e)
	{
		if(!e.getPlayer().hasPermission("placeblock"))
		{
			e.setCancelled(true);
		}
	}
}
