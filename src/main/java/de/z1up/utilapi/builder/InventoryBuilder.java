package de.z1up.utilapi.builder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {

    private Player holder;
    private String title;
    private int rows;
    private Inventory inventory;
    private InventoryType type;

    public InventoryBuilder(Player holder, String title, int rows) {
        this.holder = holder;
        this.title = title;
        this.rows = rows;
    }

    public void setType(InventoryType type) {
        if(type != null) {
            this.type = type;
        }
        return;
    }

    public Inventory build() {

        if(type != null) {
            inventory = Bukkit.createInventory(holder, type, title);
            return inventory;
        }

        inventory = Bukkit.createInventory(holder, rows * 9, title);

        return inventory;
    }

}
