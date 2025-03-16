package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Items.Item;

import java.util.*;

import cz.spskladno.zork.game.heroes.Hero;
import lombok.Getter;
import lombok.Setter;
import static cz.spskladno.zork.game.AnsiChars.*;
import static cz.spskladno.zork.game.AnsiChars.resetColor;


/**
 * Represents a Room (e.g. space in our game). Contains exits and can form a map of Rooms.
 */
@Getter @Setter
public class RoomImpl implements Room {
    private String name;
    private String description;
    private boolean isLocked = false;
    private Map<String, Room> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private static final Random RANDOM = new Random();





    public RoomImpl(String name, String description, List<Item> items, List<Enemy> enemies, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        addRandomFromList(items, true);
        addRandomFromList(enemies, false);
    }

    /**
     * Adds a new exit to the map
     */

    private void addRandomFromList(List<?> list, boolean isItems) {
        if (list == null || list.isEmpty()) {
            return; // No need to modify the list
        }

        int randomNumber = RANDOM.nextInt(25) + 1;
        if (randomNumber < 25) {
            int randomIndex = RANDOM.nextInt(list.size());

            if (isItems) {
                addItem((Item) list.get(randomIndex));
            } else {
                addEnemy((Enemy) list.get(randomIndex));
            }
            list.remove(randomIndex);
        } else {
            list.clear();
        }
    }

    @Override
    public void registerExit(Room room) {
        exits.put(room.getName(), room);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Item getItemByName(String itemName){
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Enemy getEnemyByName(String enemyName){
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    /**
     * Method returns a description of this room (from the #getDescription call)
     * and should add possible exit names
     */
    @Override
    public String getDescriptionWithExits() {
        return "Můžeš se vydat do: "+ exitColor + String.join(", ", this.exits.keySet()) + resetColor;
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
    public void addItem(Item item) {
        items.add(item);
    }
    @Override
    public void removeItem(Item item) {
        items.remove(item);
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

    public String getItemsName() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getItemFlyweight().getItemType()).append(item.getName()).append(" ");
        }
        return sb.toString();
    }

    public void allEnemiesAttack(Hero hero){
        for (Enemy enemy : enemies) {
            enemy.attack(hero);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nNacházíš se v místnosti: ")
                .append(roomNameColor).append(getName()).append(resetColor).append("\n")
                .append(descriptionColor).append(getDescription()).append(resetColor).append("\n");

        if (getItemsName() != null && !getItemsName().isEmpty()) {
            sb.append("Ve tvém okolí se nachází: ").append(itemColor).append(getItemsName()).append(resetColor).append("\n");
        }
        if (enemies != null) {
            if (enemies.isEmpty()) {
                sb.append("V místnosti se nenachází žádný nepřítel.").append("\n");
            }
            else if (enemies.size() == 1) {
                sb.append("V místnosti se nachází nepřítel: ").append(getEnemiesNameAndDificulty()).append(resetColor).append("\n");
            } else {
                sb.append("V místnosti se nachází nepřátelé: ").append(enemyColor).append(getEnemiesNameAndDificulty()).append(resetColor).append("\n");
            }
        }

        sb.append(getDescriptionWithExits());

        return sb.toString();
    }


    public String getEnemiesNameAndDificulty() {
        StringBuilder sb = new StringBuilder();
        for (Enemy enemy : enemies) {
            sb.append(enemy.getEnemyFlyweight().getDifficulty()).append(enemy.getName()).append(", ");
        }
        return sb.toString();
    }

    public boolean containLiveEnemies(){
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                return true;
            }
        }
        return false;
    }
    public boolean isAlive(String enemyName){
        if (getEnemyByName(enemyName) != null) {
            return getEnemyByName(enemyName).isAlive();
        }
        return false;
    }

    public void isLocked(boolean locked) {
        isLocked = locked;
    }

}
