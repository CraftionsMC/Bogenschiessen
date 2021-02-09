package net.craftions.bogenschiessen;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class Vars {
	
	public static HashMap<Player ,Integer> points 	= new HashMap<Player, Integer>();
	public static Integer round 					= 0; 
	public static Boolean started					= false;
	public static Boolean starting 					= false;
	public static String prefix 					= "[§4Bogenschießen§r] ";
}
