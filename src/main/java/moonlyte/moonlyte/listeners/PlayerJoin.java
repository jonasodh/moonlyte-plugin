package moonlyte.moonlyte.listeners;

import moonlyte.moonlyte.Moonlyte;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Moonlyte plugin = Moonlyte.getPlugin();
        if (!(e.getPlayer().hasPlayedBefore())) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("playerJoinedFirstTimeMessage").replace("[player]", e.getPlayer().getDisplayName())));
        } else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("playerJoinMessage").replace("[player]", e.getPlayer().getDisplayName())));
        }
        giveServerSelector(e);
    }

    public void giveServerSelector(PlayerJoinEvent e) {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        ArrayList<String> compassLore = new ArrayList<>();
        compassLore.add("Select a server to teleport to");
        assert compassMeta != null;
        compassMeta.setDisplayName("Server selector");
        compassMeta.setLore(compassLore);
        compass.setItemMeta(compassMeta);
        ItemStack[] giveSelectedItems = {compass};
        e.getPlayer().getInventory().setContents(giveSelectedItems);
    }
}
