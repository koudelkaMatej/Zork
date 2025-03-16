package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Heroes.Hero;

import java.util.Collection;
import java.util.List;

public interface Room {
    String getName();

    String getDescription();

    Item getItemByName(String itemName);

    String getDescriptionWithExits();

    Collection<Room> getExits();

    Room getExitByName(String name);
    void removeItem(Item item);
    void addItem(Item item);
    void registerExit(Room room);

    List<Enemy> getEnemies();
    Enemy getEnemyByName(String enemyName);
    void allEnemiesAttack(Hero hero);

    boolean isAlive(String enemyName);
    boolean isLocked();
    boolean containLiveEnemies();
    void addEnemy(Enemy enemy);
    void removeEnemy(Enemy enemy);
}
