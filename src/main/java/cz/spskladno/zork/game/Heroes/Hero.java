package cz.spskladno.zork.game.Heroes;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

import java.util.ArrayList;

public class Hero implements Heroes {
    @Setter
    private String name;
    @Setter
    private int health;
    @Setter
    private int minAttack;
    @Setter
    private int maxAttack;
    @Setter
    private int defense;
    private int level;
    private int experience;
    private int experienceToNextLevel;
    private final ArrayList <String> inventory;

    public Hero(String name, int health, int minAttack, int maxAttack, int defense) {
        this.name = name;
        this.health = health;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.defense = defense;
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 10;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return itemColor + "Staty hrdiny " + name + "\n" +
                levelANSI + " " + level + "\t"+ experienceANSI + " " + experience + "/" + experienceToNextLevel + "\n" +
                heartANSI + " " + health + "\t"+ defenseANSI + " " + defense + "\t"+  attackTwoSwordANSI + " " + minAttack + "-" + maxAttack + "\n" +
        backpackANSI + " " + inventory + "\n" + reset;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public void addExperience(int experience) {
        this.experience += experience;
        while(this.experience >= experienceToNextLevel) {
            System.out.println("Level up!");
            levelUp();
            this.experience -= experienceToNextLevel;
            experienceToNextLevel += 5;
            System.out.println("Gratuluji, postoupil jsi na úroveň " + level);
        }
    }

    @Override
    public void addInventory(String item) {
        inventory.add(item);
        System.out.println("Přidal jsi do inventáře " + item);
    }

    @Override
    public void removeInventory(String item) {
        inventory.remove(item);
        System.out.println("Odebral jsi z inventáře " + item);
    }

//
//    @Override
//    public void attack(Enemy enemy) {
//
//    }
//
//    @Override
//    public void defend(Enemy enemy) {
//
//    }
//
//    @Override
//    public void heal(Item item) {
//
//    }

}
