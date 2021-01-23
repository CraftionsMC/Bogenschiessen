package net.craftions.bogenschiessen;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class Start {
	
	public static Integer id;
	public static Integer time = 60;
	
	public static void start()
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			p.teleport(new Location(Bukkit.getWorld("bogens"), 219.37, 86.00, 349.42));
			p.getInventory().clear();
			ItemStack item = new ItemStack(Material.ARROW);
			item.setAmount(1);
			p.getInventory().addItem(new ItemStack(Material.BOW));
			p.getInventory().addItem(item);
			p.setGameMode(GameMode.CREATIVE);
			p.setAllowFlight(false);
			Vars.points.put(p, 0);
		}
		
		id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Init.plugin, new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				time -= 1;
				for(Player p : Bukkit.getOnlinePlayers())
				{
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("Noch " + time + " Sekunden").color(ChatColor.AQUA).create());
				}
				if(time == 10)
				{
					for(Player p : Bukkit.getOnlinePlayers())
					{
						p.sendTitle("�4�lNoch 10 Sekunden", "");
					}
				}else if(time == 3)
				{
					for(Player p : Bukkit.getOnlinePlayers())
					{
						p.sendTitle("�4�l3", "");
					}
				}else if(time == 2)
				{
					for(Player p : Bukkit.getOnlinePlayers())
					{
						p.sendTitle("�4�l2", "");
					}
				}else if(time == 1)
				{
					for(Player p : Bukkit.getOnlinePlayers())
					{
						p.sendTitle("�4�l1", "");
					}
				}else if(time <= 0)
				{
					new Start().result();
					Bukkit.getScheduler().cancelTask(id);
				}
			}
		}, 0L, 20L);
		
	}
	
	@SuppressWarnings("deprecation")
	public void result()
	{
		Player first = null;
		Integer firi = 0;
		
		for(Player p : Bukkit.getOnlinePlayers())
		{
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage("Das Spiel ist vorbei!");
			Bukkit.broadcastMessage("-" + p.getName() + " (" + Vars.points.get(p) + ")");
			if(first == null)
			{
				first = p;
				firi = Vars.points.get(first);
			}else
			{
				if(Vars.points.get(p) > firi)
				{
					first = p;
					firi = Vars.points.get(p);
				}
			}
		}
		Bukkit.broadcastMessage("Gewonnen hat �e�l" + first.getName() + "�r mit �e�l" + firi + "�r Punkten!");
		for(Player p : Bukkit.getOnlinePlayers())
		{
			p.sendTitle("�e�l" + first.getName(), "Hat das Spiel �aGEWONNEN!");
		}
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(Init.plugin, "BungeeCord");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Init.plugin, new Runnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers())
				{
					ByteArrayDataOutput out = ByteStreams.newDataOutput();
					out.writeUTF("Connect");
					out.writeUTF("lobby");
					System.out.println(p.getName());
					p.sendPluginMessage(Init.plugin, "BungeeCord", out.toByteArray());
				}
				Bukkit.reload();
			}
		}, 6*20L);
	}
}