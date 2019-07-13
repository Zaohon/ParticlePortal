package cn.blockmc.Zao_hon.creator;

import java.util.HashMap;
import java.util.UUID;

public class PortalCacheManager {
	private HashMap<UUID,PortalCache> portalcaches;
	public PortalCacheManager(){
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
