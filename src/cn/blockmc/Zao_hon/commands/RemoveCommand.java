package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.Listener.PortalManager;

public class RemoveCommand implements ICommand {
	private ParticlePortal plugin;

	public RemoveCommand() {
		this.plugin = ParticlePortal.getInstance();
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
		return new String[] { "§bcreate §dname §8--删除一个粒子传送门" };
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public boolean canBeConsole() {
		return true;
	}

	@Override
	public boolean canBeCommandBlock() {
		// TODO Auto-generated method stub
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
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

}
