package moonlyte.moonlyte;

import moonlyte.moonlyte.commands.*;
import moonlyte.moonlyte.listeners.PlayerJoin;
import moonlyte.moonlyte.listeners.PlayerLeave;
import moonlyte.moonlyte.listeners.ToggleGlideEvent;
import moonlyte.moonlyte.listeners.compassInteract;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Moonlyte extends JavaPlugin {

    private static Moonlyte plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Logger logger = getLogger();
        logger.info("Lift-off!");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new ToggleGlideEvent(), this);
        pm.registerEvents(new compassInteract(), this);
        getCommand("glide").setExecutor(new Glider());
        getCommand("nightvision").setExecutor(new Nightvision());
        getCommand("feed").setExecutor(new Feed());
        getCommand("heal").setExecutor(new Heal());
        getCommand("swim").setExecutor(new Swim());
        getCommand("fly").setExecutor(new Fly());
        getCommand("top").setExecutor(new Top());
        getCommand("walk").setExecutor(new Walk());
        getCommand("serverSelector").setExecutor(new ServerSelector());
    }

    public static Moonlyte getPlugin() {
        return plugin;
    }
}
