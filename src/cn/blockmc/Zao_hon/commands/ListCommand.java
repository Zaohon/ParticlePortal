package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.listener.Portal;

public class ListCommand implements ICommand {
	private ParticlePortal plugin;

	public ListCommand(ParticlePortal plugin) {
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "list";
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
		return new String[] { "/sc list 显示所有的传送门" };
	}

	@Override
	public String getDescription() {
		return "显示所有的传送门";
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
		if (args.length > 0) {
			return false;
		}
		sender.sendMessage("传送门:");
		for (Portal portal : plugin.getPortalManager().getPortals().values()) {
			sender.sendMessage(portal.getName());
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		return null;
	}

}
