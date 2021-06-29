package Classes.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.Bukkit;

public class CommandsAdmins implements CommandExecutor {
	private Core plugin;
	public CommandsAdmins(Core plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("roleplay.admins")) {
			ArrayList<Player> people = new ArrayList<Player>();
			for ( Player p : Bukkit.getOnlinePlayers() ) {
				if (p.hasPermission("roleplay.admin")) people.add(p);
			}
			if (!people.isEmpty()) {
				sender.sendMessage("\u00a77Админов онлайн: ");
				for ( Player p : people ) {
					String gotovo = " "+PrefixManager.getPrefix(p).replace("&", "\u00a7") +p.getName();
					sender.sendMessage(gotovo);
				}
				return true;
			}
			else {
				sender.sendMessage("\u00a77Админов нет онлайн!");
				return true;
			}
		}
		return false; 
	}

}
