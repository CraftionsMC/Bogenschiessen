package net.craftions.bogenschiessen.events;

import net.craftions.bogenschiessen.Init;
import net.craftions.bogenschiessen.Start;
import net.craftions.bogenschiessen.Vars;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		if(!Vars.started){
			Integer players = 0;
			for(Player p : Bukkit.getOnlinePlayers())
			{
				players += 1;
				p.getInventory().clear();
			}
			if(players >= 2)
			{
				if(!Vars.started)
				{
					Vars.starting = true;
					Bukkit.broadcastMessage("Starte das Spiel in 10 Sekunden!");

					Bukkit.getScheduler().scheduleSyncDelayedTask(Init.plugin, new Runnable() {

						@Override
						public void run() {
							Vars.points.clear();
							Start.start();
						}
					}, 10*20L);
				}else
				{
					e.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
			}else
			{
				Bukkit.broadcastMessage("Spieler benötigt: >2");
				Bukkit.broadcastMessage("Spieler online: " + players);
			}
			if(Vars.points.containsKey(e.getPlayer()))
			{
				Vars.points.remove(e.getPlayer());
			}
		}
	}
}