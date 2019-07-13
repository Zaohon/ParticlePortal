package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.creator.PortalCacheManager;

public class CreateCommand implements ICommand {
	private ParticlePortal plugin;

	public CreateCommand(ParticlePortal plugin) {
		this.plugin =plugin;
	}

	@Override
	public String getName() {
		return "create";
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
		return new String[] { "§b/pp create §dname §b创建一个名为§dname§b的传送门" };
	}

	@Override
	public String getDescription() {
		return "创建一个粒子传送门";
	}

	@Override
	public boolean canBeConsole() {
		return false;
	}

	@Override
	public boolean canBeCommandBlock() {
		return false;
	}

	@Override
	public boolean onCommand(CommandSender sender, String label, String[] args) {
		int lenth = args.length;
		if (lenth != 1) {
			return false;
		} else {
			PortalCacheManager pcmanager = plugin.getPortalCacheManager();
			Player player = (Player) sender;
			String portalname = args[0];
			boolean creating = pcmanager.containCache(player.getUniqueId());
			if (creating) {
				player.sendMessage("你已经在创建传送门了");
			} else if (plugin.getPortalManager().isExist(portalname)) {
				player.sendMessage("传送门已存在");
			} else {
				pcmanager.addCache(player.getUniqueId(), portalname);
				player.sendMessage("输入/pp set为传送门添加一个传送点");
			}
			return true;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		return null;
	}

}
