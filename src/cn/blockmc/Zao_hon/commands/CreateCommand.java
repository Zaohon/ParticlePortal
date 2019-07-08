package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.creator.PortalCacheManager;

public class CreateCommand implements ICommand {
	private ParticlePortal plugin;

	public CreateCommand() {
		this.plugin = ParticlePortal.getInstance();
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
		return new String[] { "��bcreate ��dname ��8--����һ�����Ӵ�����" };
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "����һ�����Ӵ�����";
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
				player.sendMessage("���Ѿ��ڴ�����������");
			} else if (plugin.getPortalManagerr().isExist(portalname)) {
				player.sendMessage("�������Ѵ���");
			} else {
				pcmanager.addCache(player.getUniqueId(), portalname);
				player.sendMessage("����/pp setΪ����������һ�����͵�");
			}
			return true;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		return null;
	}

}