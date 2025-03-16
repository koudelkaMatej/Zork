package cz.spskladno.zork.game.Enemies;

import cz.spskladno.zork.game.Items.Equipment;
import cz.spskladno.zork.game.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnemyBuilder {
    private int health;
    private int maxHealth;//
    private int minAttack;
    private int maxAttack;//
    private int defense;//
    private int criticalChance; //
    private int experience;
    private int speed;
    private int level; //
    private ArrayList<Item> loot = new ArrayList<>();

    private EnemyFlyweight enemyFlyweight;
    private EnemyBuilder enemyBuilder;
    private String name;
    private boolean alive = true;
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

    public EnemyBuilder health(int health) {
        this.health = health;
        return this;
    }

    public EnemyBuilder loot(List<Item> lootOptions){
        if (lootOptions != null && !lootOptions.isEmpty()) {
            int chance = 25;
            while (chance > 0) {
                int randomNumber = RANDOM.nextInt(100) + 1;
                if (randomNumber < chance) {
                    Item lootItem = lootOptions.get(RANDOM.nextInt(lootOptions.size()));
                    this.loot.add(lootItem); // Randomly select an item from the list
                }
                chance -= 10;
            }
        }
        return this;
    }

    public Enemy build()
    {
        return new Enemy(       this);

    }


}
