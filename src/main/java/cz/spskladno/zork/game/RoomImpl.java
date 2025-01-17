package cz.spskladno.zork.game;

import java.util.*;

/**
 * Represents a Room (e.g. space in our game). Contains exits and can form a map of Rooms.
 */
public class RoomImpl implements Room {

    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();


    public RoomImpl(String name, String description) {
        this.name = name;
        this.description = description;
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
        return "Vychody: " + String.join(", ", this.exits.keySet());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomImpl room = (RoomImpl) o;
        return Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
