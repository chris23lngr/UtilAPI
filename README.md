# UtilAPI
A Util and more Spigot/Bukkit API to make developing minecraft plugins a lot easier.

## Getting started
To use the UtilAPI just implement the .jar -file as a library and you are ready to go.
Remember, that the .jar -file also has to be in the plugins folder when running the server. 
Otherwise your plugin won't work.

## Usage
A few simple examples of how to use each module.

### UUID Fetcher
Get a UUID by the username.
```
UUID uuid = UUIDFetcher.getUUID("z1up");
```

### Item- and Inventory- builder
Create a custom iron sword with the displayname and a lore.
```
ItemStack item = new ItemBuilder(Material.IRON_SWORD, (short) 0).setDisplayName("§eIron Sowrd").setLore("§7This is the lore.").build();
```

### Log
Write a Log into the console. Message will be marked as a INFO and shown as color red ('c').
```
new Log(LogType.INFO, "This is a test message", "c");
```

### Config
Create a new Config and write into it.
```
Config cfg = new Config("path//to//the", "file.name");
cfg.write("is.chris.cool", true);
```

### Custom Location (-Manager)
Use the CustomLocationManager to create a new Location and than teleport a player to
the location.

First create the Manager.
```
CustomLocationManager manager = new CustomLocationManager("path", "file.name");
```

Then get you Location from the config.
```
Location location = manager.getLocation("locationName");
```

And now you just have to teleport the player to the Location.
```
player.teleport(location);
```

### MySQL 
Create a MySQL connection and execute a Update.

First create the SQLConfig to save the login data.
```
SQLConfig cfg = new SQLConfig("plugins//yourProject", "mysql.yml");
```

Then just create a new SQL using the above created Config.
```
SQL sql = new SQL(cfg.readData());
```

Now you only have to run you Statement using
```
sql.executeUpdate("INSERT INTO yourtable (ValueOne, ValueTwo) VALUES (?, ?)", Arrays.asList("One", "Two"));
```


## Author
* **chris23lngr** - *Initial project and idea*
