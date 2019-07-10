package cn.blockmc.Zao_hon.Listener;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitTask;

import cn.blockmc.Zao_hon.ParticlePortal;

public class Portal {
	private final ParticlePortal plugin;
	private final String name;
	private final Location[] locs;
	private PortalListener listener;
	private BukkitTask particleTask;
	private BukkitTask findTask;
	private Set<Player> nearbyPlayers;

	public Portal(String name, Location[] locs) {
		this.plugin = ParticlePortal.getInstance();
		this.name = name;
		this.locs = locs;
		listener = new PortalListener(this);
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
		

		particleTask = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,
				new ParticleGenerator(this), 200, 5);
		nearbyPlayers = new HashSet<Player>();
		
		NearbyPlayersFinder particleCloser = new NearbyPlayersFinder(this);
		findTask = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,particleCloser, 0, 20);
		
		plugin.PR("f");
		
	}

	public String getName() {
		return name;
	}

	public Location[] getLocations() {
		return locs;
	}
	public Set<Player> getNearbyPlayers(){
		return nearbyPlayers;
	}

	public void destroy() {
		HandlerList.unregisterAll(listener);
		findTask.cancel();
		particleTask.cancel();
	}
}
