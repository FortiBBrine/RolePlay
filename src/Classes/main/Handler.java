package Classes.main;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntitySpawnEvent;

import net.milkbowl.vault.chat.Chat;

public class Handler implements Listener {

	private Core plugin;
	public Handler(Core plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin( PlayerJoinEvent e ) {
		Player p = e.getPlayer();
		
		String display = plugin.getConfig().getString("nicks."+p.getName());
		if (display!=null) {
			p.setDisplayName(display);
			p.setPlayerListName(display);
			
		}
		Bukkit.broadcastMessage(PrefixManager.getPrefix(p).replace("&", "\u00a7") +p.getDisplayName()+" зашел на сервер!");
		
	}
	
	@EventHandler
	public void onSpawn( EntitySpawnEvent e ) {
		e.setCancelled(true);
	}
}
