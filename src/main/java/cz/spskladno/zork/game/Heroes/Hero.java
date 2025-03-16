package cz.spskladno.zork.game.Heroes;
import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Items.Inventory;
import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Room;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

public class Hero implements Heroes {
    private String name;
    private int maxHP;
    @Setter
    private int HP;
    @Setter
    private int minAttack;
    @Setter
    private int maxAttack;
    @Setter
    private int defense;
    @Setter
    private int level;
    @Setter
    private int experience;
    @Setter
    private int experienceToNextLevel;
    private int criticalChance;
    private final Inventory inventory = new Inventory(10);
    @Setter
    private int strength;

    public Hero() {
        this.restart();
    }

    public void restart() {
        this.name = "Hero";
        this.maxHP = 20;
        this.HP = 20;
        this.minAttack = 20;
        this.maxAttack = 50;
        this.defense = 1;
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 10;
        this.criticalChance = 0;
        this.strength = 20;
        this.inventory.clear();
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHP() {
        return HP;
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

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return itemColor + "Staty hrdiny " + name + "\n" +
                levelANSI + " " + level + "\t"+ experienceANSI + " " + experience + "/" + experienceToNextLevel + "\t\t"+ heartANSI + " " + HP +"/" + maxHP + "\n" +
                defenseANSI + " " + defense + "\t"+  utokANSI + " " + minAttack + "-" + maxAttack + "\t\t"+ criticalANSI  + " " + criticalChance + " %\n" +
        backpackANSI + ": " + inventory.getItemsName()+ "\n" + reset;
    }

    @Override
    public boolean isAlive() {
        return HP > 0;
    }

    @Override
    public void levelUp() {
        level++;
        HP += 5;
        maxHP += 5;
        minAttack += 2;
        maxAttack += 2;
        defense += 2;
        strength += 5;

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
    public void addToInventory(Item item) {
        inventory.addItem(item);
    }


    @Override
    public void removeItemFromInventory(Item item) {
        inventory.removeItem(item);
    }

    public void raiseHP(int hp){
        if (maxHP > HP + hp){
            HP += hp;
        }
        else{
            HP = maxHP;
        }
    }

    @Override
    public void attack(Enemy enemy) {
        int damage = (int) (Math.random() * (maxAttack - minAttack + 1) + minAttack);
        if (Math.random() * 100 < criticalChance) {
            damage *= 2;
            System.out.println("Zasáhl jsi kriticky!");
        }
        damage -= enemy.getDefense();
        if (damage < 0) {
            damage = 1;
        }
        enemy.setHp(enemy.getHp() - damage);
        System.out.println("Zasáhl jsi nepřítele za " + enemyColor + damage + resetColor + " bodů zdraví.");
        System.out.println("Nepřítel má nyní " + enemyColor + enemy.getHp() + resetColor + " bodů zdraví.");
        if (enemy.getHp() <= 0) {
            enemy.setHp(0);
            enemy.setAlive(false);
            System.out.println("Porazil jsi nepřítele " + enemy.getName());
            addExperience(enemy.getExperience());
            if (enemy.getLoot() != null) {
                System.out.println("Získal jsi " + itemColor + enemy.getLoot().getItemFlyweight().getItemType() + enemy.getLoot().getItemFlyweight().getName() + resetColor);
                addToInventory(enemy.getLoot());
            }
        }
    }

    @Override
    public void heal(Item item) {
        if (inventory.getItems().containsValue(item)){
            if (item.getItemFlyweight().getItemType().equals(potionANSI)) {
                this.raiseHP(item.getHp());
                System.out.println("Lektvar ti přidal " + itemColor + item.getHp() +resetColor +  " životů.");
                System.out.println("Tvoje životy jsou nyní: " + itemColor +HP + "/" + maxHP+ resetColor );
                inventory.removeItem(item);
            }
            else{
                System.out.println("Tento předmět není typu lektvar.");
            }
        }
        else{
            System.out.println("Nemáš tento předmět v inventáři.");
        }

    }

    public void selfBurn(){
        setHP(getHP()-2);
        System.out.println("Promáchl jsi a zranil se za " + enemyColor + "2 " + resetColor + "body zdraví. Jsi fakt super hrdina");
    }

    public boolean setName(String name) {
        if (name.length() > 3) {
            this.name = name;
            return true;
        }
        return false;
    }

    public int getHp() {
        return HP;
    }
}
