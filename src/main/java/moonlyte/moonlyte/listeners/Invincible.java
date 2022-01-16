package moonlyte.moonlyte.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Invincible implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = ((Player) e.getEntity()).getPlayer();
            if (player != null){
                player.setInvulnerable(true);
                player.sendMessage("God mode on");
            }
        }
    }
}
