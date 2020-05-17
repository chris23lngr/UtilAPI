// package
package de.z1up.utilapi.location;

// imports
import de.z1up.utilapi.file.Config;
import org.bukkit.Location;

/**
 * Manages the Custom Locations.
 * @dependencies Config
 */
public class CustomLocationManager {

    // variabels
    private Config config;

    /**
     * @param path
     * @param fileName
     */
    public CustomLocationManager(String path, String fileName) {
        config = new Config(path, fileName);
    }

    /**
     * save a location by the name
     * @param name
     * @param location
     */
    public void saveLocation(String name, Location location) {
        CustomLocation customLocation = new CustomLocation(config, name, location);
        customLocation.create();
    }

    /**
     * get a location from config by name
     * @param name
     * @return
     */
    public Location getLocation(String name) {
        CustomLocation customLocation = new CustomLocation(config, name, null);
        Location location = customLocation.get();
        return location;
    }

}
