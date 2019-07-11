package cn.blockmc.Zao_hon.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import cn.blockmc.Zao_hon.ParticlePortal;
import cn.blockmc.Zao_hon.listener.Portal;
import cn.blockmc.Zao_hon.listener.PortalManager;

public class StartParticleCommand implements ICommand{
	private ParticlePortal plugin;
	public StartParticleCommand(ParticlePortal plugin){
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "startparticle";
	}

	@Override
	public String[] getAliases() {
		return new String[]{"sp"};
	}

	@Override
	public String getPermission() {
		return "ParticlePortal.Admin";
	}

	@Override
	public String[] getUsageString(String label, CommandSender sender) {
		return new String[]{" start particle"};
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
		return true;
	}

	@Override
	public boolean onCommand(CommandSender sender, String label, String[] args) {
		if(args.length<1){
			return false;
		}
		String portalname = args[0];
		PortalManager pmanager = plugin.getPortalManager();
		if(portalname.equalsIgnoreCase("ALL")){
			pmanager.getPortals().values().forEach(portal->{
				portal.startParticle();
			});
			return true;
		}
		
		Portal portal = pmanager.getPortals().get(portalname);
		if(portal==null){
			sender.sendMessage(portalname+"不存在");
		}else{
			portal.stopParticle();
			sender.sendMessage("关闭"+portalname+"粒子特效");
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

}
