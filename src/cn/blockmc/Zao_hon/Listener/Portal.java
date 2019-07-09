package cn.blockmc.Zao_hon.Listener;

import java.util.HashSet;

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
	private HashSet<BukkitTask> tasks;

	public Portal(String name, Location[] locs) {
		this.plugin = ParticlePortal.getInstance();
		this.name = name;
		this.locs = locs;
		listener = new PortalListener(this);
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);

		tasks = new HashSet<BukkitTask>(2);
		BukkitTask task1 = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,
				new ParticleGenerator(locs[0]), 10, 2);
//		BukkitTask task2 = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin,
//				new ParticleGenerator(locs[1]), 10, 2);
		tasks.add(task1);
//		tasks.add(task2);

	}

	public String getName() {
		return name;
	}

	public Location[] getLocations() {
		return locs;
	}

	public void destroy() {
		HandlerList.unregisterAll(listener);
		tasks.forEach(task -> {
			task.cancel();
		});
	}
}
