package de.z1up.utilapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class UtilAPI extends JavaPlugin {

    private static UtilAPI instance;

    @Override
    public void onEnable() {
        init();
        Bukkit.getConsoleSender().sendMessage("§aUtilAPI was loaded");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cUtilAPI was unloaded");
    }

    private void init() {
        instance = this;
    }

    public static UtilAPI getInstance() {
        return instance;
    }
}
