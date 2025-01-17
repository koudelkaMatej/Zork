package cz.spskladno.zork.game;

import java.util.ArrayList;
import java.util.List;

/**
 * All the mutable game data should exist within this class
 * (e.g. room map, game state, inventory, weapons..)
 */
public class GameDataImpl implements GameData {

    private Room currentRoom;
    private boolean finished;
    private List<Room> rooms;

    /**
     * Room map registration in constructor
     */
    public GameDataImpl() {
        this.init();
    }

    public void init() {
        this.rooms = new ArrayList<>();
        Room baseRoom = new RoomImpl("Jeskyne", "temna jeskyne plna nepratel");
        baseRoom.registerExit(baseRoom);
        rooms.add(baseRoom);

        this.currentRoom = baseRoom;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets a room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the finished flag, indicating the game is done/finished
     */
    @Override
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * Retrieves the finished flag -> the parent components decides whether to end the game
     * based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }
}

