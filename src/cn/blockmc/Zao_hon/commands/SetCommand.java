package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.Listener.Portal;
import cn.blockmc.Zao_hon.Listener.PortalManager;
import cn.blockmc.Zao_hon.creator.PortalCache;
import cn.blockmc.Zao_hon.creator.PortalCacheManager;

public class SetCommand implements ICommand {
	private ParticlePortal plugin;

	public SetCommand() {
		this.plugin = ParticlePortal.getInstance();
	}

	@Override
	public String getName() {
		return "set";
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
		return null;
	}

	@Override
	public String getDescription() {
		return "��bset ��8--�������Ӵ����ŵ������";
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
		Player player = (Player) sender;
		PortalCacheManager pcmanager = plugin.getPortalCacheManager();
		if (!pcmanager.containCache(player.getUniqueId())) {
			player.sendMessage("��û���ڴ��������ţ�������/pp create ��ʼ����һ��������");
		} else {
			PortalCache pc = pcmanager.getCache(player.getUniqueId());
			Location loc = player.getLocation();
			String portalname = pc.getName();
			pc.addLocation(loc);
			if (!pc.isFull()) {
				player.sendMessage("��һ�����͵�������ϣ��ٴ�����/pp set���õڶ������͵�");
			} else {
				PortalManager pmanager = plugin.getPortalManagerr();
				if (pmanager.isExist(portalname)) {
					player.sendMessage("����ʧ�ܣ�");
				} else {
					pmanager.addPortal(portalname, new Portal(portalname, pc.getLocations()));
					player.sendMessage(portalname+"�����Ŵ�����ɣ����Զ�����������Ч");
				}
			}
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		return null;
	}

}