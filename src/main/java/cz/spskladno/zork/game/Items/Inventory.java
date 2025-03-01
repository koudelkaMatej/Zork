package cz.spskladno.zork.game.Items;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> items;
    private final int maxSize;
    private int size;

    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if ((size+item.getWeight()) < maxSize) {
            items.add(item);
            size+=item.getWeight();
            System.out.println("Předmět " + item.getItemFlyweight().getName() + " byl přidán do inventáře.");
        }
    }

    public void removeItem(Item item) {
        if (items.contains(item)){
            System.out.println("Předmět " + item.getItemFlyweight().getName() + " byl odebrán z inventáře.");
            items.remove(item);
            size-=item.getWeight();
        }
        else{
            System.out.println("Předmět " + item.getItemFlyweight().getName() + " není v inventáři.");
        }
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public String getItemsName() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getItemFlyweight().getItemType()).append(item.getItemFlyweight().getName()).append(", ");
        }
        return sb.toString();
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getItemFlyweight().getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

}
