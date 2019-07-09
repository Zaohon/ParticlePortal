package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import cn.blockmc.Zao_hon.ParticlePortal;

public class Portal {
	private final ParticlePortal plugin;
	private final String name;
	private final Location[] locs;
	private PortalListener listener;
	private ParticleGenerator particlegenerator;
	private BukkitTask task;

	public Portal(String name, Location[] locs) {
		this.plugin = ParticlePortal.getInstance();
		this.name = name;
		this.locs = locs;
		listener = new PortalListener(this);
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);

		particlegenerator = new ParticleGenerator(locs[0]);
		BukkitTask task = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, particlegenerator, 0, (long) 1);

	}

	public String getName() {
		return name;
	}

	public Location[] getLocations() {
		return locs;
	}

	public void destroy() {
		HandlerList.unregisterAll(listener);
		task.cancel();
	}
}
