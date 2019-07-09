package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleGenerator implements Runnable {
	// center location
	private final World world;
	private final float x;
	private final float y;
	private final float z;
	//
	private static final double PI = Math.PI;
	private static final Color COLOR = Color.fromRGB(0, 191, 255);
	private static final Particle.DustOptions OPTION = new Particle.DustOptions(COLOR, 0.1f);
	private static final float SCALE = 1.7f;
	private double i = 0;

	public ParticleGenerator(Location location) {
		world = location.getWorld();
		x = location.getBlockX() + 0.5f;
		y = location.getBlockY();
		z = location.getBlockZ() + 0.5f;

	}

	@Override
	public void run() {
		for (double j = 0; j <= PI * 2; j = j + PI / 180) {
			double xx = x + Math.sin(j) / SCALE;
			double yy = y;
			double zz = z + Math.cos(j) / SCALE;
			world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0, OPTION);
		}
		for (double j = 0, k = 0; j <= PI / 2 * 4 / 3; j = j + PI / 180 * 4 / 3, k++) {
			double xx;
			double yy;
			double zz;
			xx = x + Math.sin(i + j) / SCALE;
			yy = y + k / 45;
			zz = z + Math.cos(i + j) / SCALE;
			world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0, OPTION);
			xx = x + Math.sin(i + PI / 2 + j) / SCALE;
			zz = z + Math.cos(i + PI / 2 + j) / SCALE;
			world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0, OPTION);
			xx = x + Math.sin(i + PI + j) / SCALE;
			zz = z + Math.cos(i + PI + j) / SCALE;
			world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0, OPTION);
			xx = x + Math.sin(i + PI / 2 * 3 + j) / SCALE;
			zz = z + Math.cos(i + PI / 2 * 3 + j) / SCALE;
			world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0, OPTION);
		}
		i = i + Math.PI / 180;
	}
}