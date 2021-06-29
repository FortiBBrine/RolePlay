package Classes.main;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class CommandsSethp implements CommandExecutor {
	private Core plugin;
	public CommandsSethp(Core plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("roleplay.sethp") && args.length == 2) {
			Player p = (Player) sender;
			
			int hp = Integer.parseInt(args[1]);
			Player p2 = Bukkit.getPlayer(args[0]);
			p2.setHealth(hp);
			p.sendMessage("Было установлено "+hp+"hp игроку "+args[0]);
			return true;
		}
		return false;
	}

}
