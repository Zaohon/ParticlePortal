package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class NearbyPlayersFinder implements Runnable{
	private final Portal portal; 
	private final Location loc1;
	private final Location loc2;
	public NearbyPlayersFinder(Portal portal){
		this.portal = portal;
		loc1 = portal.getLocations()[0];
		loc2 = portal.getLocations()[1];
	}
	@Override
	public void run() {
		for(Player player:Bukkit.getOnlinePlayers()){
			if(isNearby(player)){
				portal.getNearbyPlayers().add(player);
			}else{
				portal.getNearbyPlayers().remove(player);
			}
		}
	}
	public boolean isNearby(Player player){
		Location ploc = player.getLocation();
		World world = ploc.getWorld();
		if(world.equals(loc1.getWorld())||world.equals(loc2.getWorld())){
			if(ploc.distance(loc1)<=5||ploc.distance(loc2)<=5){
				return true;
			}
		}
		return false;
		
	}
	

}
