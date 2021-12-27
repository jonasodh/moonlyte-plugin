package moonlyte.moonlyte.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Objects;

public class Top implements CommandExecutor {
    private final ArrayList<Player> flyList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            //set p as Player
            Player p = (Player) sender;

            //check permission
            if (p.hasPermission("moonlyte.top")) {
                if (args.length == 0) {
                    double x = p.getLocation().getX();
                    double z = p.getLocation().getZ();
                    double y = Objects.requireNonNull(p.getLocation().getWorld()).getHighestBlockYAt((int) x, (int) z);
                    p.teleport(new Location(p.getWorld(), x, y + 1, z));
                } else if (p.hasPermission("moonlyte.top.others")) {
                    if (args.length == 1) {
                        Player t = Bukkit.getPlayerExact(args[0]);
                        assert t != null;

                        double x = t.getLocation().getX();
                        double z = t.getLocation().getZ();
                        double y = Objects.requireNonNull(t.getLocation().getWorld()).getHighestBlockYAt((int) x, (int) z);
                        t.teleport(new Location(t.getWorld(), x, y + 1, z));

                    } else {
                        p.sendMessage("Invalid arguments ");
                    }
                } else {
                    p.sendMessage("You do not have permission ");
                }
            } else {
                p.sendMessage("You don't have permission for this command.");
            }
        }
        return true;
    }
}
