package cn.blockmc.Zao_hon;

import org.bukkit.plugin.java.JavaPlugin;

import cn.blockmc.Zao_hon.Listener.PortalManager;
import cn.blockmc.Zao_hon.commands.CommandDispatcher;
import cn.blockmc.Zao_hon.commands.CreateCommand;
import cn.blockmc.Zao_hon.creator.PortalCacheManager;

public class ParticlePortal extends JavaPlugin {
	private Sqlite sqlite;
	
	private CommandDispatcher commanddispatcher;
	private PortalCacheManager portalcachemanager;
	private PortalManager portalmanager;
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		sqlite = new Sqlite();
		
		commanddispatcher = new CommandDispatcher("ParticlePortal","particleportal");
		getCommand("ParticlePortal").setExecutor(commanddispatcher);
		getCommand("ParticlePortal").setTabCompleter(commanddispatcher);
		commanddispatcher.registerCommand(new CreateCommand());
		
		portalcachemanager = new PortalCacheManager();
		
		portalmanager = new PortalManager();
		
	}
	
	public Sqlite getSqlite(){
		return sqlite;
	}
	public PortalCacheManager getPortalCacheManager(){
		return portalcachemanager;
	}
	public PortalManager getPortalManagerr(){
		return portalmanager;
	}

	public void PR(String str) {
		this.getLogger().info(str);
	}

	private static ParticlePortal instance;

	public static ParticlePortal getInstance() {
		return instance;
	}

}