package net.craftions.bogenschiessen;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.craftions.bogenschiessen.events.EventArrowHit;
import net.craftions.bogenschiessen.events.EventGeneral;
import net.craftions.bogenschiessen.events.EventJoin;

public class Init extends JavaPlugin{

	public static Init plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new EventArrowHit(), this);
		Bukkit.getPluginManager().registerEvents(new EventJoin(), this);
		Bukkit.getPluginManager().registerEvents(new EventGeneral(), this);
		super.onEnable();
	}
}
