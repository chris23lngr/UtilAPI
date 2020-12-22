// package
package de.z1up.utilapi;

// imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class, runs methods onEnable an onDisable
 * @author
 * @version 2.0
 */
public class UtilAPI extends JavaPlugin {

    /**
     * The main instance to access the UtilAPI.
     */
    private static UtilAPI instance;

    @Override
    public void onEnable() {
        init();
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY
                + "["
                + ChatColor.WHITE
                + "!"
                + ChatColor.DARK_GRAY
                + "]"
                + ChatColor.GRAY
                + "Enabling Util API by chris23lngr...");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY
                + "["
                + ChatColor.WHITE
                + "!"
                + ChatColor.DARK_GRAY
                + "]"
                + ChatColor.GRAY
                + "Disabling Util API by chris23lngr...");
    }

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY
                + "["
                + ChatColor.WHITE
                + "!"
                + ChatColor.DARK_GRAY
                + "]"
                + ChatColor.GRAY
                + "Loading Util API by chris23lngr...");
    }

    // methods

    /**
     * Initialises the instance of the main class.
     */
    private void init() {
        instance = this;
    }

    /**
     * The instance to access the UtilAPI.
     * @return The instance of the main class.
     */
    public static UtilAPI getInstance() {
        return instance;
    }
}
