package moonlyte.moonlyte.listeners;

import moonlyte.moonlyte.Moonlyte;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Moonlyte plugin = Moonlyte.getPlugin();
        if (!(e.getPlayer().hasPlayedBefore())) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("playerJoinedFirstTimeMessage").replace("[player]", e.getPlayer().getDisplayName())));
        } else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("playerJoinMessage").replace("[player]", e.getPlayer().getDisplayName())));
        }
    }
}
