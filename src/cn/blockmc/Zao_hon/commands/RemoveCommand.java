package cn.blockmc.Zao_hon.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.listener.PortalManager;

public class RemoveCommand implements ICommand {
	private ParticlePortal plugin;

	public RemoveCommand(ParticlePortal plugin) {
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "remove";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getPermission() {
		return "ParticlePortal.Admin";
	}

	@Override
	public String[] getUsageString(String label, CommandSender sender) {
		return new String[] { "§b/sc remove §dname §b删除名为§dname§b的传送门" };
	}

	@Override
	public String getDescription() {
		return "删除一个粒子传送门";
	}

	@Override
	public boolean canBeConsole() {
		return true;
	}

	@Override
	public boolean canBeCommandBlock() {
		return true;
	}

	@Override
	public boolean onCommand(CommandSender sender, String label, String[] args) {
		if (args.length != 1)
			return false;
		String name = args[0];
		PortalManager pm = plugin.getPortalManager();
		if (!pm.isExist(name)) {
			sender.sendMessage(name + "不存在");
		} else {
			pm.removePortal(name);
			sender.sendMessage("已成功删除" + name + "传送门");
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		return new ArrayList<String>(plugin.getPortalManager().getPortals().keySet());
	}

}
