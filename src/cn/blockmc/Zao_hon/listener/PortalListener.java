package cn.blockmc.Zao_hon.listener;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PortalListener implements Listener {
	private final Location loc1;
	private final Location loc2;
	private HashMap<UUID,Long> cooltime;

	public PortalListener(Portal portal) {
		loc1 = portal.getLocations()[0];
		loc2 = portal.getLocations()[1];
		cooltime = new HashMap<UUID,Long>();
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location from = event.getFrom();
		Long ptime= cooltime.getOrDefault(player.getUniqueId(), 0l);
		
		if(ptime<System.currentTimeMillis()-3000){
			if(isIn(from,loc1)){
				player.teleport(loc2);
				cooltime.put(player.getUniqueId(), System.currentTimeMillis());
				return;
			}
			if(isIn(from,loc2)){
				player.teleport(loc1);
				cooltime.put(player.getUniqueId(), System.currentTimeMillis());
				return;
			}
		}
	}

	public boolean isIn(Location ploc, Location loc) {
		if (!ploc.getWorld().equals(loc.getWorld())) {
			return false;
		}
		double x = ploc.getX();
		double y = ploc.getY();
		double z = ploc.getZ();
		int bx = loc.getBlockX();
		int by = loc.getBlockY();
		int bz = loc.getBlockZ();
		
		return x >= bx && y >= by && z >= bz && x <= bx + 1 && y <= by + 1 && z <= bz + 1;

	}
}
