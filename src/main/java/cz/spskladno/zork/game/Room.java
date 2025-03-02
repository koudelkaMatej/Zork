package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Items.Item;

import java.util.Collection;

public interface Room {
    String getName();

    String getDescription();

    String getDescriptionWithExits();

    Collection<Room> getExits();

    Room getExitByName(String name);

    void registerExit(Room room);

    String getExitsName();

    String getItemsName();

    boolean isLocked();
    Item getItemByName(String name);

    void removeItem(String itemName);

    Object getItem(String itemName);

    void addItem(Item item);

    Enemy getEnemy();

    void addEnemy(Enemy enemy);

    void setDescription(String s);
}
