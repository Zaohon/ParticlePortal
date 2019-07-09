package cn.blockmc.Zao_hon.Listener;

import java.util.HashMap;

import cn.blockmc.Zao_hon.ParticlePortal;

public class PortalManager {
	private ParticlePortal plugin;

	private HashMap<String, Portal> portals;

	public PortalManager() {
		plugin = ParticlePortal.getInstance();
		loadPortals();
	}

	public void addPortal(String name, Portal portal) {
		portals.put(name, portal);
	}

	public void addNewPortal(String name, Portal portal) {
		addPortal(name, portal);
		savePortal(portal);
	}

	public void removePortal(String name) {
		portals.remove(name).destroy();
		plugin.getSqlite().removePortal(name);
	}

	public boolean isExist(String name) {
		return portals.containsKey(name);
	}

	public HashMap<String, Portal> getPortals() {
		return portals;
	}

	public void loadPortals() {
		portals = plugin.getSqlite().selectPortals();
	}

	public void savePortal(Portal portal) {
		plugin.getSqlite().insertPortal(portal);
	}

}
