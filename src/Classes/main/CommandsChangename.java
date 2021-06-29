package Classes.main;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.Bukkit;

public class CommandsChangename implements CommandExecutor {
	private Core plugin;
	public CommandsChangename(Core plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("roleplay.changename") && args.length == 2) {
			Player p = (Player) sender;
			double amount = plugin.getConfig().getDouble("changename_cost");
			boolean sucess = (boolean) EconomyManager.takeMoney(p, amount);
			if (sucess == true) { 
				p.setDisplayName(args[0]+" "+args[1]);
				p.setPlayerListName(args[0]+" "+args[1]);
				
				Bukkit.broadcastMessage(p.getName()+" сменил имя на "+p.getDisplayName());
				
				plugin.getConfig().set("nicks."+p.getName(), p.getDisplayName());
				
				plugin.saveConfig();
				plugin.reloadConfig();
				
				return true;

			}
		}
		return false; 
	}

}
