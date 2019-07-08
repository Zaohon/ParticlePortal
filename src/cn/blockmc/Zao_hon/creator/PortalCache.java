package cn.blockmc.Zao_hon.creator;

import org.bukkit.Location;

public class PortalCache {
	private final String portalname;
	private Location loc1;
	private Location loc2;

	public PortalCache(final String portalname) {
		this.portalname = portalname;
	}

	public void addLocation(Location loc) {
		if (loc1 == null) {
			loc1 = loc;
		} else {
			loc2 = loc;
		}
	}

	public boolean isFull() {
		return loc1 != null && loc2 != null;
	}
	public Location[] getLocations(){
		return new Location[]{loc1,loc2};
	}

	public String getName() {
		return portalname;
	}
}
