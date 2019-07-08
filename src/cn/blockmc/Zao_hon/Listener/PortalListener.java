package cn.blockmc.Zao_hon.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import cn.blockmc.Zao_hon.ParticlePortal;

public class PortalListener implements Listener {
	private ParticlePortal plugin;
	private final Portal portal;
	public PortalListener(Portal portal){
		this.portal = portal;
		this.plugin = ParticlePortal.getInstance();
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		
	}
}
