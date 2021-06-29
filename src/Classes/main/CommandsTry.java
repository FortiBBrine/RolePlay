package Classes.main;

import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class CommandsTry implements CommandExecutor {
	private Core plugin;
	public CommandsTry(Core plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("roleplay.try")) {
			Player p = (Player) sender;
			double kof = plugin.getConfig().getDouble("radius");
			double x1 = (int) p.getLocation().getX()-kof;
			double x2 = (int) p.getLocation().getX()+kof;
			double y1 = (int) p.getLocation().getY()-kof;
			double y2 = (int) p.getLocation().getY()+kof;
			double z1 = (int) p.getLocation().getZ()-kof;
			double z2 = (int) p.getLocation().getZ()+kof;
			String msg = "";
			for ( String msgtxt : args ) {
				msg += msgtxt + " ";
			}
			
			List<String> randomList = plugin.getConfig().getStringList("tryes");
			int index = new Random().nextInt(randomList.size());
			
			String rand = randomList.get(index);
			
			for (Player pz : Bukkit.getOnlinePlayers()) {
				double x = (int) pz.getLocation().getX();
				double y = (int) pz.getLocation().getY();
				double z = (int) pz.getLocation().getZ();
				if (x1 < x && x < x2 && y1 < y && y < y2 && z1 < z && z < z2) {
					pz.sendMessage(plugin.getConfig().getString("try").replace("{player}", p.getDisplayName()).replace("{message}", msg).replace("&", "\u00a7")+rand.replace("&", "\u00a7"));
				}
			}
			return true;
		}
		return false;
	}

}
