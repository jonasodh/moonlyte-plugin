package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
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
                if (args.length == 0) {
                    if ((pInv == null) || !(pInv.getType() == Material.ELYTRA)) {
                        if (!gliderList.contains(p)) {
                            gliderList.add(p);
                            p.setGliding(true);
                            p.sendMessage("Glider on");
                        } else {
                            gliderList.remove(p);
                            p.setGliding(false);
                            p.sendMessage("Glider off");
                        }
                    } else {
                        p.sendMessage("You can not wear an elytra and glide at the same time.");
                    }
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }

            if (p.hasPermission("moonlyte.glide.others")) {
                if (args.length > 0) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    ItemStack tInv = target.getInventory().getChestplate();
                    if ((tInv == null) || !(tInv.getType() == Material.ELYTRA)) {
                        if (!gliderList.contains(target)) {
                            gliderList.add(target);
                            target.setGliding(true);
                            target.sendMessage("Glider on");
                            p.sendMessage("Turned " + target.getDisplayName() + " into a glider.");
                        } else {
                            gliderList.remove(target);
                            target.setGliding(false);
                            target.sendMessage("Glider off");
                            p.sendMessage("Turned off gliding for " + target.getDisplayName());
                        }
                    } else {
                        p.sendMessage(target.getDisplayName() + " is wearing an elytra so gliding was not enabled.");
                    }
                }
            }
        }
        return true;
    }
}
