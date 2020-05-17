// package
package de.z1up.utilapi;

// imports
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class, runs methods onEnable and
 * onDisable
 * @author z1up, chris23lngr
 */
public class UtilAPI extends JavaPlugin {

    // instance
    private static UtilAPI instance;

    // override
    @Override
    public void onEnable() {
        init();
        Bukkit.getConsoleSender().sendMessage("§aUtilAPI was loaded");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cUtilAPI was unloaded");
    }

    // methods

    /**
     * initalize instances and variables
     */
    private void init() {
        instance = this;
    }

    /**
     * get instance of UtilAPI
     * @return UtilAPI
     */
    public static UtilAPI getInstance() {
        return instance;
    }
}
