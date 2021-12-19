package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //if command comes form user
        if (sender instanceof Player) {

            Player p = (Player) sender;


            if (p.hasPermission("moonlyte.feed")) {
                if (args.length == 0) {
                    p.setFoodLevel(20);
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    target.setFoodLevel(20);
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
