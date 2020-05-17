// package
package de.z1up.utilapi.file;

// imports
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

/**
 *  Creates a ConfigurationFile and let's the user
 *  read it or write into it.
 *  @author z1up
 *  @since JDK8.0_41
 *  @see org.bukkit.configuration.file.YamlConfiguration, java.io.File
 */
public class Config {

    // variables
    private String path;
    private String fileName;
    private File file;
    private YamlConfiguration cfg;

    // constructor
    /**
     * set the path and the fileName, create file
     * and YamlConfiguration
     * @param path
     * @param fileName
     */
    public Config(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
        this.file = new File(this.path + this.fileName);
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
    }

    // methods
    /**
     * write a object into the cfg
     * @param path
     * @param object
     */
    public void write(String path, Object object) {
        this.cfg.set(path, object);
    }

    /**
     * get a object from the cfg
     * @param path
     * @return Object
     */
    public Object get(String path) {
        return this.cfg.get(path);
    }

    /**
     * check ich object exists in cfg
     * @param path
     * @return
     */
    public boolean exists(String path) {
        return get(path) == null;
    }

    /**
     * add a default variable to the cfg
     * @param path
     * @param object
     */
    public void addDefault(String path, Object object) {
        this.cfg.addDefault(path, object);
    }

    /**
     * set the copy defaults option
     * @param enabled
     */
    public void setCopyDefaults(boolean enabled) {
        this.cfg.options().copyDefaults(enabled);
    }

    /**
     * save the YamlConfiguration
     * @return cfg
     */
    public YamlConfiguration save() {
        try {
            this.cfg.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.cfg;
    }

}
