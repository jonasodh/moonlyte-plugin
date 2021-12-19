package moonlyte.moonlyte.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ToggleGlideEvent implements Listener {
    @EventHandler
    public void toggleGlideEvent(EntityToggleGlideEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            PlayerInventory inv = ((Player) e.getEntity()).getInventory();
            ItemStack chestPlate = inv.getChestplate();
            if (chestPlate != null && chestPlate.getType() == Material.ELYTRA) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        }
    }
}
