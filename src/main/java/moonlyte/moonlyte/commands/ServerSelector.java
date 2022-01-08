package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ServerSelector implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            Inventory serverSelector = Bukkit.createInventory(p, 9, ChatColor.RED + "Server selector");

            ItemStack lobby = new ItemStack(Material.COMPASS);
            ItemMeta lobbyMeta = lobby.getItemMeta();
            ArrayList<String> lobbyLore = new ArrayList<>();
            lobbyLore.add("Teleport to the lobby");
            if (lobbyMeta != null) {
                lobbyMeta.setDisplayName("Lobby");
                lobbyMeta.setLore(lobbyLore);
            }
            lobby.setItemMeta(lobbyMeta);

            ItemStack survival = new ItemStack(Material.OAK_SAPLING);
            ItemStack[] serverOptions = {lobby, survival};
            serverSelector.setContents(serverOptions);
            p.openInventory(serverSelector);
        }
        return true;
    }
}
