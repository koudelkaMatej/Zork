package cz.spskladno.zork.game.Items;
import static cz.spskladno.zork.game.AnsiChars.*;

public class Item {
    private final ItemFlyweight itemFlyweight;
    private final int minAttack;
    private final int maxAttack;
    private final int armor;
    private final int hp;
    private final int criticalChance;
    private final int weight;

    public Item(ItemBuilder itemBuilder) {
        this.itemFlyweight = itemBuilder.getItemFlyweight();
        this.minAttack = itemBuilder.getMinAttack();
        this.maxAttack = itemBuilder.getMaxAttack();
        this.armor = itemBuilder.getArmor();
        this.hp = itemBuilder.getHp();
        this.criticalChance = itemBuilder.getCriticalChance();
        this.weight = itemBuilder.getWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n=========================================\n");
        sb.append("             ** Předmět **\n");
        sb.append("-----------------------------------------\n");
        sb.append(" Název:     ").append(itemFlyweight.getName()).append("\n");
        sb.append("  ").append(typeANSI).append(":       ").append(itemFlyweight.getItemType()).append("\n");
        if (minAttack > 0) {
            sb.append("  ").append(attackOneSwordANSI).append(":       ").append(minAttack).append("-").append(maxAttack).append(" DMG\n");
        }
        if (armor > 0) {
            sb.append("  ").append(defenseANSI).append(":       ").append(armor).append("\n");
        }
        if (hp > 0) {
            sb.append("  ").append(heartANSI).append(":       ").append(hp).append("\n");
        }
        if (criticalChance > 0) {
            sb.append("  ").append(criticalANSI).append(":       ").append(criticalChance).append(" %\n");
        }
        if (weight > 0) {
            sb.append("  ").append(weightANSI).append(":       ").append(weight).append(" Kg\n");
        }
        sb.append("-----------------------------------------\n");
        sb.append("=========================================\n");
        return sb.toString();
    }

    public ItemFlyweight getItemFlyweight() {
        return itemFlyweight;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getHp() {
        return hp;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getArmor() {
        return armor;
    }
}
