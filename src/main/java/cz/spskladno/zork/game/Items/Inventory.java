package cz.spskladno.zork.game.Items;

import static cz.spskladno.zork.game.AnsiChars.*;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> itemsMap;  // Changed from ArrayList to HashMap
    private final int maxSize;
    private int size;

    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.itemsMap = new HashMap<>();  // Initializing the map
    }

    public void addItem(Item item) {
        if ((size + item.getWeight()) <= maxSize) {
            itemsMap.put(item.getItemFlyweight().getName(), item);  // Using item name as the key
            size += item.getWeight();
            System.out.println("Předmět " + itemColor + item.getItemFlyweight().getName() + reset +  " byl přidán do inventáře.");
        } else {
            System.out.println("Inventář je plný nebo předmět je příliš těžký.");
        }
    }

    public void removeItem(Item item) {
        if (itemsMap.containsKey(item.getItemFlyweight().getName())) {
            System.out.println("Předmět "+ itemColor + item.getItemFlyweight().getName() + resetColor + " byl odebrán z inventáře.");
            itemsMap.remove(item.getItemFlyweight().getName());
            size -= item.getWeight();
        } else {
            System.out.println("Předmět " + itemColor + item.getItemFlyweight().getName() + resetColor + " není v inventáři.");
        }
    }

    public Map<String, Item> getItems() {
        return itemsMap;  // Returns the map of items
    }

    public String getItemsName() {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsMap.values()) {
            sb.append(item.getItemFlyweight().getItemType()).append(item.getItemFlyweight().getName()).append(", ");
        }
        return sb.toString();
    }

    public Item getItemByName(String name) {
        return itemsMap.get(name);  // Direct lookup in the map
    }

    public void clear() {
        itemsMap.clear();  // This clears the map
        size = 0;  // Make sure the size is also reset to 0
    }
}
