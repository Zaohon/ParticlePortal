package cn.blockmc.Zao_hon;

import org.bukkit.plugin.java.JavaPlugin;

import cn.blockmc.Zao_hon.commands.CommandDispatcher;
import cn.blockmc.Zao_hon.commands.CreateCommand;
import cn.blockmc.Zao_hon.commands.ListCommand;
import cn.blockmc.Zao_hon.commands.ParticleCommand;
import cn.blockmc.Zao_hon.commands.RemoveCommand;
import cn.blockmc.Zao_hon.commands.SetCommand;
import cn.blockmc.Zao_hon.creator.PortalCacheManager;
import cn.blockmc.Zao_hon.listener.PortalManager;
import cn.blockmc.Zao_hon.storage.Sqlite;

public class ParticlePortal extends JavaPlugin {
	private Sqlite sqlite;

	private CommandDispatcher commanddispatcher;
	private PortalCacheManager portalcachemanager;
	private PortalManager portalmanager;

	@Override
	public void onEnable() {
//		instance = this;
		saveDefaultConfig();
		sqlite = new Sqlite(this);

		commanddispatcher = new CommandDispatcher(this,"ParticlePortal", "particleportal");
		getCommand("ParticlePortal").setExecutor(commanddispatcher);
		getCommand("ParticlePortal").setTabCompleter(commanddispatcher);
		commanddispatcher.registerCommand(new CreateCommand(this));
		commanddispatcher.registerCommand(new SetCommand(this));
		commanddispatcher.registerCommand(new ListCommand(this));
		commanddispatcher.registerCommand(new RemoveCommand(this));
		commanddispatcher.registerCommand(new ParticleCommand(this));

		portalcachemanager = new PortalCacheManager();
		portalmanager = new PortalManager(this);
		

	}

	public Sqlite getSqlite() {
		return sqlite;
	}

	public PortalCacheManager getPortalCacheManager() {
		return portalcachemanager;
	}

	public PortalManager getPortalManager() {
		return portalmanager;
	}

	public void PR(String str) {
		this.getLogger().info(str);
	}
//
//	private static ParticlePortal instance;
//
//	public static ParticlePortal getInstance() {
//		return instance;
//	}

}
