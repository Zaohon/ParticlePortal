package cn.blockmc.Zao_hon.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.listener.Portal;
import cn.blockmc.Zao_hon.listener.PortalManager;

public class ParticleCommand implements ICommand {
	private ParticlePortal plugin;

	public ParticleCommand(ParticlePortal plugin) {
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "particle";
	}

	@Override
	public String[] getAliases() {
		return new String[] { "p" };
	}

	@Override
	public String getPermission() {
		return "ParticlePortal.Admin";
	}

	@Override
	public String[] getUsageString(String label, CommandSender sender) {
		return new String[] { "§b/pp portal §dstart§9/§dstop name" };
	}

	@Override
	public String getDescription() {
		return "开启或关闭传送门的粒子特效";
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
		int lenth = args.length;
		if (lenth < 1) {
			return false;
		}
		String subcmd = args[0];
		PortalManager pmanager = plugin.getPortalManager();
		if (subcmd.equalsIgnoreCase("start") && subcmd.equalsIgnoreCase("stop")) {
			sender.sendMessage("参数错误:" + subcmd);
			sender.sendMessage("正确用法:/pp portal start 或/pp portal stop");
			return true;
		}
		if (lenth < 2) {
			sender.sendMessage("缺少参数:§dname");
			sender.sendMessage("正确用法:/pp portal " + subcmd + " §dname");
			return true;
		}
		String portalname = args[1];
		boolean start = subcmd.equalsIgnoreCase("start");
		if (portalname.equalsIgnoreCase("ALL")) {
			if (start) {
				pmanager.getPortals().values().forEach(portal -> {
					portal.startParticle();
				});
				sender.sendMessage("开启所有传送门的粒子特效");
			} else {
				pmanager.getPortals().values().forEach(portal -> {
					portal.stopParticle();
				});
				sender.sendMessage("关闭所有传送门的粒子特效");
			}
			return true;
		}

		Portal portal = pmanager.getPortals().get(portalname);
		if (portal == null) {
			sender.sendMessage(portalname + "不存在");
			return true;
		} else {
			if (start) {
				portal.startParticle();
				sender.sendMessage("开启" + portalname + "粒子特效");
			} else {
				portal.stopParticle();
				sender.sendMessage("关闭" + portalname + "粒子特效");
			}
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		int lenth = args.length;
		if (lenth == 0) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("start");
			list.add("stop");
			return list;
		}
		if (lenth == 1) {
			ArrayList<String> list = new ArrayList<String>();
			for (Portal portal : plugin.getPortalManager().getPortals().values()) {
				list.add(portal.getName());
			}
			return list;
		}
		return null;
	}

}
