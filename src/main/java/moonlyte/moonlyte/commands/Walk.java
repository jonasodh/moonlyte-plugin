package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Walk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //set p as Player
            Player p = (Player) sender;

            //check permission
            if (p.hasPermission("moonlyte.walk")) {
                if (args.length == 0) {
                    p.setWalkSpeed(.2f);
                }
                else if (args.length == 1) {
                    float walkingSpeed = Float.parseFloat(args[0]) / 10;
                        p.setWalkSpeed(walkingSpeed);
                }
                else if (p.hasPermission("moonlyte.walk.others")) {
                    if (args.length == 2) {
                        float walkingSpeed = Float.parseFloat(args[0]) / 10;
                        Player t = Bukkit.getPlayerExact(args[1]);
                        assert t != null;
                            t.setWalkSpeed(walkingSpeed);
                    } else {
                        p.sendMessage("invalid arguments");
                    }
                } else {
                    p.sendMessage("You do not have permission for swim.others");
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
