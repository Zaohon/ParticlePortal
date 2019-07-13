package cn.blockmc.Zao_hon.listener;

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

	public Portal(PortalManager manager,String name, Location[] locs) {
		this.plugin = manager.getPlugin();
		this.name = name;
		this.locs = locs;
		listener = new PortalListener(this);
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
		
		startParticle();
		nearbyPlayers = new HashSet<Player>();
		
		NearbyPlayersFinder narybyPlayerFinder = new NearbyPlayersFinder(this);
		findTask = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,narybyPlayerFinder, 0, 20);
		
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
	public void startParticle(){
		stopParticle();
		particleTask=  plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,
				new ParticleGenerator(this), 200, 5);
	}
	public void stopParticle(){
		if(particleTask!=null&&!particleTask.isCancelled())particleTask.cancel();
	}
}
