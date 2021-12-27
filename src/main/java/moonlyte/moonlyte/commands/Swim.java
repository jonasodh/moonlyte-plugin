package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Swim implements CommandExecutor {
    private final ArrayList<Player> dolphinsGrace = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //set p as Player
            Player p = (Player) sender;

            //check permission
            if (p.hasPermission("moonlyte.swim")) {
                if (args.length == 0) {
                    p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
                    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
                    if (!dolphinsGrace.contains(p)) {
                        dolphinsGrace.add(p);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                        p.setRemainingAir(300);
                    } else {
                        dolphinsGrace.remove(p);
                        p.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
                        p.removePotionEffect(PotionEffectType.WATER_BREATHING);
                        p.setRemainingAir(0);
                    }
                } else if (p.hasPermission("moonlyte.swim.others")) {
                    if (args.length == 1) {

                        Player t = Bukkit.getPlayerExact(args[0]);
                        assert t != null;
                        t.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
                        t.removePotionEffect(PotionEffectType.WATER_BREATHING);
                        if (!dolphinsGrace.contains(t)) {
                            dolphinsGrace.add(t);
                            t.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 1));
                            t.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                            t.setRemainingAir(300);
                        } else {
                            dolphinsGrace.remove(t);
                            t.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
                            t.removePotionEffect(PotionEffectType.WATER_BREATHING);
                            t.setRemainingAir(0);
                        }

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
