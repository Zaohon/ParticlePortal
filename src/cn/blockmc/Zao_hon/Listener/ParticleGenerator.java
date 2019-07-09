package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleGenerator implements Runnable{
	private static final double PI = Math.PI;
	// center location
	private final World world;
	private final float x;
	private final float y;
	private final float z;
	private double i =0;

	public ParticleGenerator(Location location) {
		world = location.getWorld();
		x = location.getBlockX() + 0.5f;
		y = location.getBlockY();
		z = location.getBlockZ() + 0.5f;
	}

	@Override
	public void run() {
		for(double j =0,k=0;j<=Math.PI/2;j=j+Math.PI/180,k++){
			double xx = x +Math.sin(i+j)/2/(90-k)/90;
			double yy = y +k/45;
			double zz = z +Math.cos(i+j)/2;
			world.spawnParticle(Particle.SUSPENDED, xx, yy, zz,1);
		}
		for(double j =0,k=0;j<=Math.PI/2;j=j+Math.PI/180,k++){
			double xx = x +Math.sin(i+PI/2+j)/2;
			double yy = y +k/45;
			double zz = z +Math.cos(i+PI/2+j)/2;
			world.spawnParticle(Particle.SUSPENDED_DEPTH, xx, yy, zz,1);
		}
		for(double j =0,k=0;j<=Math.PI/2;j=j+Math.PI/180,k++){
			double xx = x +Math.sin(i+PI+j)/2;
			double yy = y +k/45;
			double zz = z +Math.cos(i+PI+j)/2;
			world.spawnParticle(Particle.SUSPENDED, xx, yy, zz,1);
		}
		for(double j =0,k=0;j<=Math.PI/2;j=j+Math.PI/180,k++){
			double xx = x +Math.sin(i+PI/2*3+j)/2;
			double yy = y +k/45;
			double zz = z +Math.cos(i+PI/2*3+j)/2;
			world.spawnParticle(Particle.SUSPENDED, xx, yy, zz,1);
		}
//		double xx = x + Math.sin(i);
//		double yy = y+0.5;
//		double zz = z+Math.cos(i);
//		world.spawnParticle(Particle.SUSPENDED, xx, yy, zz,10);
		
		i=i+Math.PI/180;
	}
}