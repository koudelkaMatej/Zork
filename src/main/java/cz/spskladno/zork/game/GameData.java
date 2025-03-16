package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Heroes.Hero;

import java.util.List;

public interface GameData {
    boolean isFinished();

    void setFinished(boolean finished);

    Room getCurrentRoom();

    List<Room> getRooms();

    void setCurrentRoom(Room currentRoom);

    void init();

    void reset();

    Hero getHero();

    boolean hasGivenUp();

    void setGivenUp(boolean b);
}
