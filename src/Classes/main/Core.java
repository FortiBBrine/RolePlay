package Classes.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;


public class Core extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		
		File config = new File(getDataFolder()+File.separator+"config.yml");
		if (!config.exists()) {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		getCommand("me").setExecutor(new CommandsMe(this));
		getCommand("do").setExecutor(new CommandsDo(this));
		getCommand("try").setExecutor(new CommandsTry(this));
		getCommand("b").setExecutor(new CommandsB(this));
		getCommand("sethp").setExecutor(new CommandsSethp(this));
		getCommand("changename").setExecutor(new CommandsChangename(this));
		getCommand("admins").setExecutor(new CommandsAdmins(this));
		
		getLogger().info("Plugin created by FortiBrine!");
		EconomyManager.init();
		PrefixManager.init();
	}
	
	public void onDisable() {
		getLogger().info("Stopped sucessfully!");
	}
}
