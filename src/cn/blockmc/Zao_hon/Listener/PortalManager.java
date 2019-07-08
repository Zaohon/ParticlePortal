package cn.blockmc.Zao_hon.Listener;

import java.util.HashMap;

import cn.blockmc.Zao_hon.ParticlePortal;

public class PortalManager {
	private ParticlePortal plugin;
	
	private HashMap<String,Portal> portals;

	public PortalManager() {
		this.plugin = ParticlePortal.getInstance();
		
		portals = new HashMap<String,Portal>();
	}
	public void addPortal(String name,Portal portal){
		portals.put(name,portal);
	}
	public void removePortal(String name){
		portals.remove(name).destroy();
	}
	
	public boolean isExist(String name){
		return portals.containsKey(name);
	}
	
}
