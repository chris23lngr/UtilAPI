// package
package de.z1up.utilapi.location;

// imports
import de.z1up.utilapi.file.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 *  creates a custom Location and
 *  writes it into a config, where it's
 *  beeing saved.
 */
public class CustomLocation {

    // variables
    private Config config;
    private String name;
    private Location location;

    // constructor

    /**
     * @param config
     * @param name
     * @param location
     */
    public CustomLocation(Config config, String name, Location location) {
        this.config = config;
        this.name = name;
        this.location = location;
    }

    // methods

    /**
     * create a new CustomLocation and write it
     * into the config
     */
    public void create() {
        config.write(name + ".world", location.getWorld().getName());
        config.write(name + ".X", location.getX());
        config.write(name + ".Y", location.getY());
        config.write(name + ".Z", location.getZ());
        config.write(name + ".Yaw", location.getYaw());
        config.write(name + ".Pitch", location.getPitch());
        config.save();
    }

    /**
     * get a Location by the name from the
     * config
     * @return
     */
    public Location get() {

        final String world = (String) config.get(name + ".world");
        final double x = (double) config.get(name + ".X");
        final double y = (double) config.get(name + ".Y");
        final double z = (double) config.get(name + ".Z");

        final float yaw = (float) config.get(name + ".Yaw");
        final float pitch = (float) config.get(name + ".Pitch");

        location = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        return location;
    }

}
