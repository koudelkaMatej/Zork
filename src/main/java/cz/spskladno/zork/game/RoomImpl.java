package cz.spskladno.zork.game;
import cz.spskladno.zork.game.Items.Item;
import static cz.spskladno.zork.game.AnsiChars.*;

import java.util.*;

/**
 * Represents a Room (e.g. space in our game). Contains exits and can form a map of Rooms.
 */
public class RoomImpl implements Room {

    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private boolean isLocked = false;


    public RoomImpl(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RoomImpl(String name, String description, Item item) {
        this.name = name;
        this.description = description;
        this.items.add(item);
    }
    public RoomImpl(String name, String description, Item item, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.items.add(item);
        this.isLocked = isLocked;
    }
    /**
     * Adds a new exit to the map
     */
    @Override
    public void registerExit(Room room) {
        exits.put(room.getName(), room);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Method returns a description of this room (from the #getDescription call)
     * and should add possible exit names
     */
    @Override
    public String getDescriptionWithExits() {
        return "Vychody: "+ roomColor + String.join(", ", this.exits.keySet()) + resetColor;
    }

    /**
     * Returns a description of this room
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns an unmodifiable view of our map
     */
    @Override
    public Collection<Room> getExits() {
        return Collections.unmodifiableCollection(exits.values());
    }

    /**
     * Returns a room based on the entered room (exit) name
     */
    @Override
    public Room getExitByName(String name) {
        return exits.getOrDefault(name, null);
    }

    public String getExitsName() {
        StringBuilder sb = new StringBuilder();
        sb.append(roomNameColor);
        for (Room room : exits.values()) {
            sb.append(room.getName()).append(", ");
        }
        sb.append(resetColor);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomImpl room = (RoomImpl) o;
        return Objects.equals(name, room.name);
    }

    public String getItemsName() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getItemFlyweight().getItemType()).append(item.getItemFlyweight().getName()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getItemFlyweight().getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getItemFlyweight().getName().equals(itemName));
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getItemFlyweight().getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nNacházíš se v místnosti: ")
                .append(roomNameColor).append(getName()).append(resetColor).append("\n")
                .append(descriptionColor).append(getDescription()).append(resetColor).append("\n");

        if (getItemsName() != null && !getItemsName().isEmpty()) {
            sb.append("V místnosti se nachází: ")
                    .append(itemColor).append(getItemsName()).append(resetColor).append("\n");
        }

        sb.append(descriptionColor).append(getDescriptionWithExits()).append(resetColor);

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}


