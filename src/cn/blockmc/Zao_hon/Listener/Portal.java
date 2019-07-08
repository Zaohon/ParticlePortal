package cn.blockmc.Zao_hon.Listener;

import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class Portal {
	private final String name;
	private final Location[] locs;
	private PortalListener listener;
	public Portal(String name ,Location[] locs){
		this.name = name;
		this.locs = locs;
		listener = new PortalListener(this);
		
	}
	public String getName(){
		return name;
	}
	public Location[] getLocations(){
		return locs;
	}
	public void destroy(){
		HandlerList.unregisterAll(listener);
	}
}
