package moonlyte.moonlyte.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class CompassInteract implements Listener {
    @EventHandler
    public void playerCompassInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (Objects.requireNonNull(e.getItem()).getType() == Material.COMPASS) {
                player.performCommand("serverSelector");
            }
        }
    }
}
