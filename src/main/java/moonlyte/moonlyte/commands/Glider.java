package moonlyte.moonlyte.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Glider implements CommandExecutor {
    public static final ArrayList<Player> gliderList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack pInv = p.getInventory().getChestplate();
            if (p.hasPermission("moonlyte.glide")) {
                if ((pInv == null) || !(pInv.getType() == Material.ELYTRA)) {
                    if (!gliderList.contains(p)) {
                        gliderList.add(p);
                        p.setGliding(true);
                        p.sendMessage("Glider onn");
                    } else {
                        gliderList.remove(p);
                        p.setGliding(false);
                        p.sendMessage("Glider off");
                    }
                } else {
                    p.sendMessage("You can not wear an elytra and glide at the same time.");
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
