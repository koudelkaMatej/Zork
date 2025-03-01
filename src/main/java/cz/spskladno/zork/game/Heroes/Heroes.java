package cz.spskladno.zork.game.Heroes;
import cz.spskladno.zork.game.Items.Item;

public interface Heroes {
    boolean isAlive();
//    void attack(Enemy enemy);
//    void defend(Enemy enemy);
    void heal(Item item);
    void levelUp();
    void addExperience(int experience);
    void addToInventory(Item item);
    void removeItemFromInventory(Item item);
}
