package cz.spskladno.zork.game.Enemies;

import cz.spskladno.zork.game.Heroes.Hero;
import cz.spskladno.zork.game.Items.Item;

import static cz.spskladno.zork.game.AnsiChars.*;

public class Enemy {

    private EnemyFlyweight enemyFlyweight;
    private EnemyBuilder enemyBuilder;
    private String name;
    private int hp;
    private int minAttack;
    private int maxAttack;
    private int defense;
    private int criticalChance;
    private int experience;
    private boolean alive = true;
    private Item loot  ;

    public Enemy(EnemyBuilder enemyBuilder) {
       this.enemyBuilder = enemyBuilder;
        this.enemyFlyweight = enemyBuilder.getEnemyFlyweight();
        this.name = enemyBuilder.getName();
        this.hp = enemyBuilder.getHp();
        this.defense = enemyBuilder.getDefense();
        this.criticalChance = enemyBuilder.getCriticalChance();
        this.experience = enemyBuilder.getExperience();
        this.minAttack = enemyBuilder.getMinAttack();
        this.maxAttack = enemyBuilder.getMaxAttack();
        this.alive = true;
        this.loot = enemyBuilder.getLoot();
    }


    public void registerItem(Item item){
        loot = item;
   }
   public void unregisterItem(){
        loot = null;
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
        hero.setHP(hero.getHp() - damage);
        System.out.println(enemyColor +name + resetColor + " útočí na " + friendColor + hero.getName() + resetColor +" a způsobuje " + enemyColor + damage + resetColor+" poškození.");
        if (hero.getHp() <= 0) {
            hero.setHP(0);
            System.out.println(hero.getName() + " byl poražen.");

        }
    }

    @Override
    public String toString() {
        return enemyColor + "Staty nepřítele: " + name + "\n" +
                heartANSI + " " + hp + "\t\t" + experienceANSI + " EXP: " + experience + "\n" +
                defenseANSI + " " + defense + "\t\t" + utokANSI + " " + minAttack + "-" + maxAttack + "\t\t" +
                criticalANSI + " " + criticalChance + " %\n" +
                lootANSI + ": " + (loot != null ? loot.getItemFlyweight().getItemType() + loot.getItemFlyweight().getName() : "Žádný") + "\n" + reset;
    }

    public EnemyFlyweight getEnemyFlyweight() {
        return enemyFlyweight;
    }

    public void setEnemyFlyweight(EnemyFlyweight enemyFlyweight) {
        this.enemyFlyweight = enemyFlyweight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Item getLoot(){
        return  loot;
    }
    public void setLoot(Item loot){
        this.loot = loot;
    }

    public EnemyBuilder getEnemyBuilder() {
        return enemyBuilder;
    }

    public void setEnemyBuilder(EnemyBuilder enemyBuilder) {
        this.enemyBuilder = enemyBuilder;
    }
}
