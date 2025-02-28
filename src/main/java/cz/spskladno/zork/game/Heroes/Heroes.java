package cz.spskladno.zork.game.Heroes;

public interface Heroes {
    boolean isAlive();
//    void attack(Enemy enemy);
//    void defend(Enemy enemy);
//    void heal(Item item);
    void levelUp();
    void addExperience(int experience);
    void addInventory(String item);
    void removeInventory(String item);
}
