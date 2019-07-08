package cn.blockmc.Zao_hon.creator;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;

import cn.blockmc.Zao_hon.ParticlePortal;

public class PortalCacheManager {
	private ParticlePortal plugin;
	private HashMap<UUID,PortalCache> portalcaches;
	public PortalCacheManager(){
		plugin = ParticlePortal.getInstance();
		 portalcaches = new HashMap<UUID,PortalCache>();
	}
	public boolean containCache(UUID uuid){
		return portalcaches.containsKey(uuid);
	}
	public void addCache(UUID uuid,String portalname){
		portalcaches.put(uuid, new PortalCache(portalname));
	}
	public void removeCache(UUID uuid){
		portalcaches.remove(uuid);
	}
	public PortalCache getCache(UUID uuid){
		return portalcaches.get(uuid);
	}
	
}
