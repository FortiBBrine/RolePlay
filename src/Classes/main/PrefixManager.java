package Classes.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.chat.Chat;

public class PrefixManager {
	
	private static Chat c;
	
	public static void init() {
		RegisteredServiceProvider<Chat> reg = Bukkit.getServicesManager().getRegistration(Chat.class);
		if(reg != null) c = reg.getProvider();
	}
	
	public static String getPrefix(Player p) {
		String prefix = c.getPlayerPrefix(p);
		return prefix;
	}

}
