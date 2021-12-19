package moonlyte.moonlyte.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Nightvision implements CommandExecutor {
    private final ArrayList<Player> nightVisionList = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //set p as Player
            Player p = (Player) sender;

            //check permission
            if (p.hasPermission("moonlyte.nightvision")){
                p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                if (!nightVisionList.contains(p)) {
                    nightVisionList.add(p);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
                } else {
                    nightVisionList.remove(p);
                    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
