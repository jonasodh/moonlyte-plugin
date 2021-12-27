package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Fly implements CommandExecutor {
    private final ArrayList<Player> flyList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //set p as Player
            Player p = (Player) sender;

            //check permission
            if (p.hasPermission("moonlyte.fly")) {
                if (args.length == 0) {
                    if (!flyList.contains(p)) {
                        flyList.add(p);
                        p.setAllowFlight(true);
                    } else {
                        flyList.remove(p);
                        p.setAllowFlight(false);
                    }
                } else if (p.hasPermission("moonlyte.fly.others")) {
                    if (args.length == 1) {
                        Player t = Bukkit.getPlayerExact(args[0]);
                        assert t != null;

                        if (!flyList.contains(t)) {
                            flyList.add(t);
                            t.setAllowFlight(true);
                        } else {
                            flyList.remove(t);
                            t.setAllowFlight(false);
                        }
                    } else {
                        p.sendMessage("Invalid arguments");
                    }
                } else {
                    p.sendMessage("You do not have permission for flight.others");
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
