package cz.spskladno.zork.game.Items;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ItemBuilder {
    private String name; // Název
    private int vitality; //
    private int strength; //
    private int stamina;
    private int intelligence; //
    private int dexterity; //
    private int charisma; //
    private int agility;
    private int luck;//
    private int health;
    private int minAttack;
    private int maxAttack;//
    private int defense;//
    private int criticalChance; //
    private int speed;
    private int level; //Item {
    private final ItemFlyweight itemFlyweight;
    private int weight;
    private List<String> classRestrictions = new ArrayList<>();


    public ItemBuilder(ItemFlyweight itemFlyweight) {
        this.itemFlyweight = itemFlyweight;
    }

    public ItemBuilder classRestriction(String className) {
        this.classRestrictions.add(className);
        return this;
    }


    public ItemBuilder name(String name) { // Metoda pro nastavení jména
        this.name = name;
        return this;
    }

    public ItemBuilder speed(int speed) {
        this.speed = speed;
        return this;
    }

    public ItemBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }
    public ItemBuilder criticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
        return this;
    }

    public ItemBuilder attack(int minAttack) {
        this.minAttack = minAttack;
        return this;
    }

    public ItemBuilder health(int health) {
        this.health = health;
        return this;
    }

    public ItemBuilder attack(int minAttack, int maxAttack) {
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        return this;
    }

    public ItemBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    public ItemBuilder level(int level) {
        this.level = level;
        return this;
    }

    public ItemBuilder vitality(int vitality) {
        this.vitality = vitality;
        return this;
    }

    public ItemBuilder strength(int strength) {
        this.strength = strength;
        return this;
    }

    public ItemBuilder stamina(int stamina) {
        this.stamina = stamina;
        return this;
    }

    public ItemBuilder intelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public ItemBuilder dexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public ItemBuilder charisma(int charisma) {
        this.charisma = charisma;
        return this;
    }

    public ItemBuilder agility(int agility) {
        this.agility = agility;
        return this;
    }

    public ItemBuilder luck(int luck) {
        this.luck = luck;
        return this;
    }

    public Item build() {
        return new Item(this);
    }
}