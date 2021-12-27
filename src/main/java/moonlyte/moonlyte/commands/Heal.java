package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("moonlyte.heal")) {
                if (args.length == 0) {
                    p.setFoodLevel(20);
                    p.setHealth(20);
                    p.setRemainingAir(300);
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    assert target != null;
                    target.setFoodLevel(20);
                    target.setHealth(20);
                    target.setRemainingAir(300);
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
