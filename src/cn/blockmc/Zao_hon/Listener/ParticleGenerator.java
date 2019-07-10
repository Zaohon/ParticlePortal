package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class ParticleGenerator implements Runnable {
	// center location
	private final Portal portal;
	private final float x1;
	private final float y1;
	private final float z1;
	private final float x2;
	private final float y2;
	private final float z2;
	//
	private static final double PI = Math.PI;
	private static final double TPI = PI * 2;
	private static final double PI2 = PI / 2;
//	private static final double PI4 = PI / 4;
//	private static final double PI8 = PI / 8;
	private static final double PI180 = PI / 180;
	private static final Color COLOR = Color.fromRGB(0, 191, 255);
	private static final Particle.DustOptions OPTION = new Particle.DustOptions(COLOR, 0.25f);
	private static final float SCALE = 1.7f;
	private double i = 0;

	public ParticleGenerator(Portal portal) {
		this.portal = portal;
		Location loc1 = portal.getLocations()[0];
		Location loc2 = portal.getLocations()[1];
		x1 = loc1.getBlockX() + 0.5f;
		y1 = loc1.getBlockY();
		z1 = loc1.getBlockZ() + 0.5f;
		x2 = loc2.getBlockX() + 0.5f;
		y2 = loc2.getBlockY();
		z2 = loc2.getBlockZ() + 0.5f;

	}

	@Override
	public void run() {
		for (double j = 0; j <= TPI; j = j + PI180) {
			double xx1 = x1 + Math.sin(j) / SCALE;
			double yy1 = y1;
			double zz1 = z1 + Math.cos(j) / SCALE;

			double xx2 = x2 + Math.sin(j) / SCALE;
			double yy2 = y2;
			double zz2 = z2 + Math.cos(j) / SCALE;
			// world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
			// OPTION);
			for (Player player : portal.getNearbyPlayers()) {
				player.spawnParticle(Particle.REDSTONE, xx1, yy1, zz1, 0, 0, 0, 0, 0, OPTION);
				player.spawnParticle(Particle.REDSTONE, xx2, yy2, zz2, 0, 0, 0, 0, 0, OPTION);
			}

		}
		for (double j = 0, k = 0; j <= PI2 * 4 / 3; j = j + PI / 180 * 4 / 3 * 3 / 8, k++) {
			double xx1;
			double yy1;
			double zz1;

			double xx2;
			double yy2;
			double zz2;

			double ij;
			ij = i + j;
			xx1 = x1 + Math.sin(ij) / SCALE;
			yy1 = y1 + k / 45 * 3 / 8;
			zz1 = z1 + Math.cos(ij) / SCALE;

			xx2 = x2 + Math.sin(ij) / SCALE;
			yy2 = y2 + k / 45 * 3 / 8;
			zz2 = z2 + Math.cos(ij) / SCALE;

			for (Player player : portal.getNearbyPlayers()) {
				player.spawnParticle(Particle.REDSTONE, xx1, yy1, zz1, 0, 0, 0, 0, 0, OPTION);
				player.spawnParticle(Particle.REDSTONE, xx2, yy2, zz2, 0, 0, 0, 0, 0, OPTION);
			}
			// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0,
			// 0, OPTION);
			ij = i + PI2 + j;
			xx1 = x1 + Math.sin(ij) / SCALE;
			zz1 = z1 + Math.cos(ij) / SCALE;

			xx2 = x2 + Math.sin(ij) / SCALE;
			zz2 = z2 + Math.cos(ij) / SCALE;

			for (Player player : portal.getNearbyPlayers()) {
				player.spawnParticle(Particle.REDSTONE, xx1, yy1, zz1, 0, 0, 0, 0, 0, OPTION);
				player.spawnParticle(Particle.REDSTONE, xx2, yy2, zz2, 0, 0, 0, 0, 0, OPTION);
			}
			// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0,
			// 0, OPTION);
			ij = i + PI + j;
			xx1 = x1 + Math.sin(ij) / SCALE;
			zz1 = z1 + Math.cos(ij) / SCALE;

			xx2 = x2 + Math.sin(ij) / SCALE;
			zz2 = z2 + Math.cos(ij) / SCALE;
			for (Player player : portal.getNearbyPlayers()) {
				player.spawnParticle(Particle.REDSTONE, xx1, yy1, zz1, 0, 0, 0, 0, 0, OPTION);
				player.spawnParticle(Particle.REDSTONE, xx2, yy2, zz2, 0, 0, 0, 0, 0, OPTION);
			}
			// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0,
			// 0, OPTION);
			ij = i + PI / 2 * 3 + j;
			xx1 = x1 + Math.sin(ij) / SCALE;
			zz1 = z1 + Math.cos(ij) / SCALE;

			xx2 = x2 + Math.sin(ij) / SCALE;
			zz2 = z2 + Math.cos(ij) / SCALE;

			for (Player player : portal.getNearbyPlayers()) {
				player.spawnParticle(Particle.REDSTONE, xx1, yy1, zz1, 0, 0, 0, 0, 0, OPTION);
				player.spawnParticle(Particle.REDSTONE, xx2, yy2, zz2, 0, 0, 0, 0, 0, OPTION);
			}
			// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0,
			// 0, OPTION);
		}

		// for (double j = 0; j <= TPI; j = j + PI180) {
		// double xx = x1 + Math.sin(j) / SCALE;
		// double yy = y1;
		// double zz = z1 + Math.cos(j) / SCALE;
		// // world.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// // OPTION);
		// for(Player player:portal.getNearbyPlayers()){
		// player.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		//
		// }
		// for (double j = 0, k = 0; j <= PI2 * 4 / 3; j = j + PI / 180 * 4 / 3
		// * 3 / 8, k++) {
		// double xx;
		// double yy;
		// double zz;
		// double ij;
		// ij = i + j;
		// xx = x2 + Math.sin(ij) / SCALE;
		// yy = y2 + k / 45 * 3 / 8;
		// zz = z2 + Math.cos(ij) / SCALE;
		// for(Player player:portal.getNearbyPlayers()){
		// player.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		//// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// ij = i + PI2 + j;
		// xx = x2 + Math.sin(ij) / SCALE;
		// zz = z2 + Math.cos(ij) / SCALE;
		// for(Player player:portal.getNearbyPlayers()){
		// player.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		//// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// ij = i + PI + j;
		// xx = x2 + Math.sin(ij) / SCALE;
		// zz = z2 + Math.cos(ij) / SCALE;
		// for(Player player:portal.getNearbyPlayers()){
		// player.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		//// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// ij = i + PI / 2 * 3 + j;
		// xx = x2 + Math.sin(ij) / SCALE;
		// zz = z2 + Math.cos(ij) / SCALE;
		// for(Player player:portal.getNearbyPlayers()){
		// player.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		//// world1.spawnParticle(Particle.REDSTONE, xx, yy, zz, 0, 0, 0, 0, 0,
		// OPTION);
		// }
		i = i + PI180 * 20;
	}
}