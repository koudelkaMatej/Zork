package cz.spskladno.zork.game.Items;

public class ItemBuilder {
    private final ItemFlyweight itemFlyweight;
    private String name; // Přidaný název
    private int minAttack;
    private int maxAttack;
    private int armor;
    private int hp;
    private int criticalChance;
    private int weight;


    public ItemBuilder(ItemFlyweight itemFlyweight) {
        this.itemFlyweight = itemFlyweight;
    }

    public ItemBuilder name(String name) { // Metoda pro nastavení jména
        this.name = name;
        return this;
    }
    public ItemBuilder criticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
        return this;
    }

    public ItemBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }
    public ItemBuilder attack(int minAttack) {
        this.minAttack = minAttack;
        return this;
    }

    public ItemBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public ItemBuilder attack(int minAttack, int maxAttack) {
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        return this;
    }

    public ItemBuilder armor(int armor) {
        this.armor = armor;
        return this;
    }

    public Item build() {
        itemFlyweight.setName(name); // Uloží název do Flyweight
        return new Item(this);
    }

    public int getCriticalChance() {
        return criticalChance;
    }
    public int getMinAttack() {
        return minAttack;
    }

    public int getWeight() {
        return weight;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getArmor() {
        return armor;
    }

    public String getName() {
        return name;
    }
    public ItemFlyweight getItemFlyweight() {
        return itemFlyweight;
    }
}
