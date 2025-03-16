package cz.spskladno.zork.game.Items;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

@Setter @Getter
public class Equipment {
    private final Map<String, Item> itemsMap;  // Changed from ArrayList to HashMap



    public Equipment() {
        this.itemsMap = new LinkedHashMap<>();  // Initializing the map
        itemsMap.put(ringANSI, null);
        itemsMap.put(helmetANSI, null);
        itemsMap.put(ringANSI2, null);

        itemsMap.put(shieldANSI, null);
        itemsMap.put(chestPieceANSI, null);
        itemsMap.put(attackOneSwordANSI, null);
        itemsMap.put(attackTwoSwordANSI, null);

        itemsMap.put(glovesANSI, null);
        itemsMap.put(beltANSI, null);
        itemsMap.put(greavesANSI, null);

        itemsMap.put(bootsANSI, null);
        itemsMap.put(amuletANSI, null);



    }



      // Method to add an item
public void equipItem(Item item) {
    String slot = item.getItemFlyweight().getItemType();
    if (Objects.equals(slot, ringANSI) && itemsMap.get(ringANSI) != null) {
        if (itemsMap.get(ringANSI) != null){
            slot = ringANSI2;
            System.out.println("Předmět " + itemColor + item.getName() + resetColor + " byl úspěšně obléknut.");
        }
    }
    if (itemsMap.containsKey(slot)) {
        itemsMap.put(slot, item);
        System.out.println("Předmět " + itemColor + item.getName() + resetColor + " byl úspěšně obléknut.");
    } else {
        System.out.println("Tento typ předmětu si nemůžeš obléct: ");
    }
}

// Method to remove an item (set to null)
public void unEquipItem(Item item) {
    String slot = item.getItemFlyweight().getItemType();
    if (Objects.equals(slot, ringANSI) && Objects.equals(item.getName(), itemsMap.get(ringANSI2).getName())) {
        slot = ringANSI2;
        System.out.println("Předmět " + itemColor + item.getName() + resetColor + " byl úspěšně sundán.");
    }
    if (itemsMap.containsKey(slot)) {
        itemsMap.put(slot, null);
        System.out.println("Předmět " + itemColor + item.getName() + resetColor + " byl úspěšně sundán.");
    } else {
        System.out.println("Tento Předmět si nemůžeš sundat, jelikož ho nemáš na sobě.");
    }
}

    public Map<String, Item> getItems() {
        return itemsMap;  // Returns the map of items
    }

    public String getItemsName() {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsMap.values()) {
            if (item != null) {
                sb.append(item.getItemFlyweight().getItemType()).append(item.getName()).append(" ");
            }
        }
        return sb.toString();
    }

    public Item getItemByName(String name) {
        for (Item item : itemsMap.values()) {
            if (item != null && item.getName().equals(name)) {
                return item;
            }
        }
        return itemsMap.get(name);  // Direct lookup in the map
    }

    public void clear() {
        itemsMap.replaceAll((s, v) -> null);
    }
}
