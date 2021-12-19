package moonlyte.moonlyte;

import moonlyte.moonlyte.commands.Feed;
import moonlyte.moonlyte.commands.Glider;
import moonlyte.moonlyte.commands.Heal;
import moonlyte.moonlyte.commands.Nightvision;
import moonlyte.moonlyte.listeners.PlayerJoin;
import moonlyte.moonlyte.listeners.PlayerLeave;
import moonlyte.moonlyte.listeners.ToggleGlideEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Moonlyte extends JavaPlugin {

    private static Moonlyte plugin;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Lift-off!");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new ToggleGlideEvent(), this);
        getCommand("glide").setExecutor(new Glider());
        getCommand("nightvision").setExecutor(new Nightvision());
        getCommand("feed").setExecutor(new Feed());
        getCommand("heal").setExecutor(new Heal());
    }

    public static Moonlyte getPlugin() {
        return plugin;
    }
}
