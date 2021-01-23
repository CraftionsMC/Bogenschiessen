package net.craftions.bogenschiessen.events;

import net.craftions.bogenschiessen.Vars;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EventArrowHit implements Listener {
	
	@EventHandler
	public void onHit(ProjectileHitEvent e)
	{
		if(e.getEntity().getShooter() instanceof Player)
		{
			if(e.getHitBlock().getType() == Material.ORANGE_WOOL)
			{
				if(Vars.points.containsKey((Player) e.getEntity().getShooter()))
				{
					Vars.points.put((Player) e.getEntity().getShooter(), Vars.points.get(e.getEntity().getShooter()) + 1);
				}else
				{
					Vars.points.put((Player) e.getEntity().getShooter(), 1);
				}
				Player p = (Player) e.getEntity().getShooter();
				p.sendMessage("[�a+�r]");
			}

			if(e.getHitBlock().getType() == Material.WHITE_WOOL)
			{
				if(Vars.points.containsKey((Player) e.getEntity().getShooter()))
				{
					Vars.points.put((Player) e.getEntity().getShooter(), Vars.points.get(e.getEntity().getShooter()) + 2);
				}else
				{
					Vars.points.put((Player) e.getEntity().getShooter(), 2);
				}
				Player p = (Player) e.getEntity().getShooter();
				p.sendMessage("[�a+�r]");
			}

			if(e.getHitBlock().getType() == Material.RED_WOOL)
			{
				if(Vars.points.containsKey((Player) e.getEntity().getShooter()))
				{
					Vars.points.put((Player) e.getEntity().getShooter(), Vars.points.get(e.getEntity().getShooter()) + 5);
				}else
				{
					Vars.points.put((Player) e.getEntity().getShooter(), 5);
				}
				Player p = (Player) e.getEntity().getShooter();
				p.sendMessage("[�a+�r]");
			}

			if(e.getHitBlock().getType() == Material.BLACK_WOOL)
			{
				if(Vars.points.containsKey((Player) e.getEntity().getShooter()))
				{
					Vars.points.put((Player) e.getEntity().getShooter(), Vars.points.get(e.getEntity().getShooter()) + 10);
				}else
				{
					Vars.points.put((Player) e.getEntity().getShooter(), 10);
				}
				Player p = (Player) e.getEntity().getShooter();
				p.sendMessage("[�a+�r]");
//				p.sendMessage("Du hast nun " + Vars.points.get(e.getEntity().getShooter()) + " Punkte!");
			}
			System.out.println(Vars.points.get(e.getEntity().getShooter()));
		}
	}
}