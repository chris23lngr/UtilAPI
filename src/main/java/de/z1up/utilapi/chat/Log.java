package de.z1up.utilapi.chat;

import de.z1up.utilapi.enums.LogType;
import org.bukkit.Bukkit;

public class Log {

    // constructor
    public Log(LogType type, String message) {
        if(type == null) {
            Bukkit.getConsoleSender().sendMessage("[LOG] " + message);
            return;
        }
        Bukkit.getConsoleSender().sendMessage("[" + type.toString().toUpperCase() + "] " + message);
    }

}
