package de.z1up.utilapi.player.holo;

// imports
import de.z1up.utilapi.netty.Reflections;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


/**
 * creates a new Hologram for a specific player using packets. The hologram can use a flying item,
 * a text or even both.
 */
public class Hologram {

    // variables

    private Player player;
    private Location location;
    private ItemStack itemStack;
    private String text;
    private int ID;

    private EntityItem entityItem;
    private WorldServer worldServer;
    private EntityArmorStand linesArmorStand;
    private EntityArmorStand itemArmorStand;

    // constructors

    /**
     *
     * @param player
     * @param location
     */
    public Hologram(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    /**
     *
     * @param player
     * @param location
     * @param text
     */
    public Hologram(Player player, Location location, String text) {
        this.player = player;
        this.location = location;
        this.text = text;
    }

    /**
     *
     * @param player
     * @param location
     * @param itemStack
     */
    public Hologram(Player player, Location location, org.bukkit.inventory.ItemStack itemStack) {
        this.player = player;
        this.location = location;
        this.itemStack = itemStack;
    }

    /**
     *
     * @param player
     * @param location
     * @param itemStack
     * @param text
     */
    public Hologram(Player player, Location location, org.bukkit.inventory.ItemStack itemStack, String text) {
        this.player = player;
        this.location = location;
        this.itemStack = itemStack;
        this.text = text;
    }

    // methods

    /**
     * builds the holograms / armorstands
     */
    public void buildHologram() {

        worldServer = ((CraftWorld) location.getWorld()).getHandle();

        if(text != null) {
            createArmorStand(this.location, this.text, true);
        }

        if(itemStack != null) {
            createArmorStand(location, text, false);
            EntityItem item = createEntityItem(itemStack, location);
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new PacketPlayOutAttachEntity(0, item, itemArmorStand));
        }

        ID = linesArmorStand.getId();
    }


    /**
     * destroys the created armorstands / holograms
     */
    public void destroy() {

        int[] i = {};

        if(linesArmorStand != null) {
            i = new int[]{linesArmorStand.getId()};

            if(itemArmorStand != null) {
                i = new int[] {linesArmorStand.getId(), itemArmorStand.getId(), entityItem.getId()};
            }
        } else if(itemArmorStand != null) {
            i = new int[] {itemArmorStand.getId(), entityItem.getId()};
        }

        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy =
                new PacketPlayOutEntityDestroy(i);
        Reflections.sendPacket(packetPlayOutEntityDestroy, player);

    }

    /**
     * sets the new text for the armorstand wich is displaying a text
     * @param text which will be set
     */
    public void setText(String text) {
        this.text = text;
        this.linesArmorStand.setCustomName(text);
    }

    /**
     *
     * @return ID of the entity armor
     */
    public int getID() {
        return ID;
    }

    /**
     * create a armorstand which will later hold the entity item, see {@code createEnityItem}
     * @param armorLoc location of the armor stand
     * @param armorText the custom text for the armorstand
     * @param textVisible if the text is visible, if true text will be shown, else it wont
     * @return {@link PacketPlayOutSpawnEntityLiving}
     */
    private Object createArmorStand(Location armorLoc, String armorText, boolean textVisible) {

        EntityArmorStand armorStand = new EntityArmorStand(worldServer);

        if(textVisible) {
            this.linesArmorStand = armorStand;
        } else {
            this.itemArmorStand = armorStand;
            armorLoc = armorLoc.add(0, 1, 0);
        }

        armorStand.setLocation(armorLoc.getX(), armorLoc.getY(), armorLoc.getZ(), 0, 0);
        armorStand.setGravity(false);
        armorStand.setInvisible(true);
        armorStand.setCustomName(armorText);
        armorStand.setCustomNameVisible(textVisible);
        Bukkit.getConsoleSender().sendMessage("§eID for §c" + text + " §e is " + armorStand.getId());

        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armorStand);

        ((CraftPlayer) this.player).getHandle().playerConnection.sendPacket(packet);

        return packet;
    }

    /**
     * creates the entity item which later will be added
     * @param item itemstack wich will be passed
     * @param itemLoc location of item
     * @return entity item
     */
    private EntityItem createEntityItem(ItemStack item, Location itemLoc) {

        EntityItem entityItem = new EntityItem(((CraftWorld)player.getWorld()).getHandle());
        entityItem.setItemStack(CraftItemStack.asNMSCopy(itemStack));
        entityItem.setPosition(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

        this.entityItem = entityItem;

        PacketPlayOutSpawnEntity itemPacket = new PacketPlayOutSpawnEntity(entityItem, 2, 1);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(itemPacket);

        PacketPlayOutEntityMetadata meta = new PacketPlayOutEntityMetadata(entityItem.getId(), entityItem.getDataWatcher(), true);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(meta);

        return entityItem;
    }

}
