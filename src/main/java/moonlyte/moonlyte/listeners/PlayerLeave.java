package moonlyte.moonlyte.listeners;

import moonlyte.moonlyte.Moonlyte;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    Moonlyte plugin = Moonlyte.getPlugin();
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("playerLeaveMessage").replace("[player]", e.getPlayer().getDisplayName())));
    }
}
