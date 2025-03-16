package cz.spskladno.zork.game.Enemies;

import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.heroes.Hero;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import static cz.spskladno.zork.game.AnsiChars.*;


@Getter @Setter
public class Enemy {
    private int health;
    private int maxHealth;//
    private int minAttack;
    private int maxAttack;//
    private int defense;//
    private int criticalChance; //
    private int experience;
    private int speed;
    private int level; //
    private boolean alive = true;
    private ArrayList<Item> loot = new ArrayList<>();
    private EnemyFlyweight enemyFlyweight;
    private EnemyBuilder enemyBuilder;
    private String name;


    public Enemy(EnemyBuilder enemyBuilder) {
       this.enemyBuilder = enemyBuilder;
        this.enemyFlyweight = enemyBuilder.getEnemyFlyweight();
        this.name = enemyBuilder.getName();
        this.health = enemyBuilder.getHealth();
        this.defense = enemyBuilder.getDefense();
        this.criticalChance = enemyBuilder.getCriticalChance();
        this.minAttack = enemyBuilder.getMinAttack();
        this.maxAttack = enemyBuilder.getMaxAttack();
        this.experience = enemyBuilder.getExperience();
        this.speed = enemyBuilder.getSpeed();
        this.level = enemyBuilder.getLevel();
        this.maxHealth = health;
        this.alive = true;
        this.loot = enemyBuilder.getLoot();
    }

    public void attack(Hero hero){
        int attack = minAttack + (int) (Math.random() * (maxAttack - minAttack + 1));
        double criticalChanceRoll = Math.random();  // A random number between 0 and 1
        if (criticalChanceRoll <= criticalChance / 100.0) {  // If the roll is within critical chance
            // Apply critical damage multiplier (for example, 2x damage)
            attack = (int) (attack * 1.5);
        }
        int damage = attack - hero.getDefense();
        if (damage <= 0) {
            damage = 1;
        }
        hero.setHealth(hero.getHealth() - damage);
        System.out.println(enemyColor +name + resetColor + " útočí na " + friendColor + hero.getName() + resetColor +" a způsobuje " + enemyColor + damage + resetColor+" poškození.");
        if (hero.getHealth() <= 0) {
            hero.setHealth(0);
            System.out.println(hero.getName() + " byl poražen.");

        }
    }
    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public String toString() {
        return  "Staty nepřítele: " + enemyFlyweight.getDifficulty() + name + "\n" +
                levelANSI + " " + level + " LVL\t" +  healthANSI + " " + health + "/" + maxHealth + "\t\t" + experienceANSI + " " + experience + " EXP"+ "\n" +
                defenseANSI + " " + defense + "\t\t" + attackANSI + " " + minAttack + "-" + maxAttack + "  \t\t" + criticalChanceANSI + " " + criticalChance + " %\t\t" + speedANSI + " " + speed + "\n" +
                lootANSI + ": " + (loot != null ? this.getItemsName() : "Žádný") + "\n" + reset;
    }

    public String getItemsName(){
        StringBuilder sb = new StringBuilder();
        for (Item item : loot) {
            sb.append(item.getItemFlyweight().getItemType()).append(item.getName()).append(" ");
        }
        return sb.toString();
    }

    public void updateStats(){
        for (Item item : loot) {
            if (item != null) {
                level += item.getLevel();
                health += item.getHealth();
                maxHealth += item.getHealth();
                minAttack += item.getMinAttack();
                maxAttack += item.getMaxAttack();
                defense += item.getDefense();
                criticalChance += item.getCriticalChance();
                speed += item.getSpeed();
            }
        }
    }

    public void equipItem(Item item) {
        loot.add(item);
    }

}
