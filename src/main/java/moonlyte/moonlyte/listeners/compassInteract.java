package moonlyte.moonlyte.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class compassInteract implements Listener {
    @EventHandler
    public void playerCompassInteract(PlayerInteractEvent e) {
        Player player = (Player) e.getPlayer();
        if (Objects.requireNonNull(e.getItem()).getType() == Material.COMPASS){
            player.performCommand("serverSelector");
        }
    }
}
