package cz.spskladno.zork.game.Enemies;

import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Items.ItemBuilder;

import java.util.ArrayList;
import java.util.Random;

public class EnemyBuilder {
    private String name;
    private int hp;
    private int minAttack;
    private int maxAttack;
    private int defense;
    private int criticalChance;
    private int experience;
    private boolean alive = true;
    private Item loot;
    private EnemyFlyweight enemyFlyweight;
    private static final Random RANDOM = new Random();

    public EnemyBuilder (EnemyFlyweight enemyFlyweight, String name) {
        this.name = name;
        this.enemyFlyweight = enemyFlyweight;
    }
    public EnemyBuilder maxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
        return this;
    }

    public EnemyBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    public EnemyBuilder criticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
        return this;
    }

    public EnemyBuilder experience(int experience) {
        this.experience = experience;
        return this;
    }

    public EnemyBuilder minAttack(int minAttack) {
        this.minAttack = minAttack;
        return this;
    }

    public EnemyBuilder alive(boolean alive) {
        this.alive = alive;
        return this;
    }

    public EnemyBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public EnemyBuilder loot(ArrayList lootOptions){
        if (lootOptions != null && !lootOptions.isEmpty()) {
            int randomNumber = RANDOM.nextInt(100) + 1;
            if (randomNumber < 25) {
                this.loot = null;  // 25% chance of no loot
            }
            else {
                this.loot = (Item) lootOptions.get(RANDOM.nextInt(lootOptions.size()));  // Randomly select an item from the list
            }
        }
        return this;
    }

    public Enemy build()
    {
        return new Enemy(this);
    }

    public String getName() {
        return name;
    }

    public EnemyFlyweight getEnemyFlyweight() {
        return enemyFlyweight;
    }

    public int getDefense() {
        return defense;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getExperience() {
        return experience;
    }

    public int getHp() {
        return hp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Item getLoot() {
        return loot;
    }

}
