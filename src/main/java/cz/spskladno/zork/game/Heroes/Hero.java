package cz.spskladno.zork.game.heroes;
import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Items.Equipment;
import cz.spskladno.zork.game.Items.Inventory;
import cz.spskladno.zork.game.Items.Item;
import lombok.Getter;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

@Getter @Setter
public class Hero {
    //basic stats
    private String name;
    private String classSymbol;
    private ClassTypes classType;
    private String className;
    private int vitality; //
    private int strength; //
    private int stamina;
    private int intelligence; //
    private int dexterity; //
    private int charisma; //
    private int agility;
    private int luck;//
    private int skillPoints;//

    //combat stats
    private int health;
    private int maxHealth;//
    private int minAttack;
    private int maxAttack;//
    private int defense;//
    private int criticalChance; //
    private int speed;
    private int experience;
    private int experienceToNextLevel; //
    private int level; //


    private int baseStrength;
    private int baseVitality;
    private int baseStamina;
    private int baseIntelligence;
    private int baseDexterity;
    private int baseCharisma;
    private int baseAgility;
    private int baseLuck;
    private int baseSpeed;

    private int bonusStrength = 0;
    private int bonusVitality = 0;
    private int bonusStamina = 0;
    private int bonusIntelligence = 0;
    private int bonusDexterity = 0;
    private int bonusCharisma = 0;
    private int bonusAgility = 0;
    private int bonusLuck = 0;
    private int bonusSpeed = 0;


    //inventory
    private Inventory inventory = new Inventory(10);
    private Equipment equipment = new Equipment();

    public Hero(){
        this.restart();
    }

    public void restart(){
        this.name = "Joker";
        this.className = "Clown";
        this.classSymbol = clownANSI;
        this.classType = ClassTypes.CLOWN;
        this.vitality = baseVitality;
        this.strength = baseStrength;
        this.stamina = baseStamina;
        this.intelligence = baseIntelligence;
        this.dexterity = baseDexterity;
        this.charisma = baseCharisma;
        this.agility = baseAgility;
        this.speed = baseSpeed;
        this.luck = baseLuck;
        this.health = vitality * 2;

        //combat stats
        this.updateStats();
        this.skillPoints = 2;
        this.experience = 0;
        this.experienceToNextLevel = 10;
        this.level = 1;
        this.inventory.clear();
        this.equipment.clear();
    }

    public void baseStats() {
        if (classSymbol.equals(warriorANSI)) {
            baseStrength = 5+5;
            baseVitality = 5+3;
            baseStamina = 5+2;
            baseIntelligence = 5-2;
            baseDexterity = 5+2;
            baseCharisma = 5-2;
            baseAgility = 5+1;
            baseLuck = 5;
            baseSpeed = -2;
        } else if (classSymbol.equals(mageANSI)) {
            baseStrength = 5-1;
            baseVitality = 5;
            baseStamina = 5+2;
            baseIntelligence = 5+5;
            baseDexterity = 5;
            baseCharisma = 5+1;
            baseAgility = 5-1;
            baseLuck = 5+2;
            baseSpeed = 5-1;
        } else if (classSymbol.equals(rogueANSI)) {
            baseStrength = 5;
            baseVitality = 5;
            baseStamina = 5+1;
            baseIntelligence = 5;
            baseDexterity = 5+1;
            baseCharisma = 5-3;
            baseAgility = 5+3;
            baseLuck = 5+2;
            baseSpeed = 5+3;
        } else if (classSymbol.equals(paladinANSI)) {
            baseStrength = 5+3;
            baseVitality = 5+4;
            baseStamina = 5+3;
            baseIntelligence = 5;
            baseDexterity = 5;
            baseCharisma = 5+2;
            baseAgility = 5-3;
            baseLuck = 5;
            baseSpeed = 5-2;
        } else if (classSymbol.equals(priestANSI)) {
            baseStrength = 5;
            baseVitality = 5+3;
            baseStamina = 5;
            baseIntelligence = 5+2;
            baseDexterity = 5;
            baseCharisma = 5+4;
            baseAgility = 5-1;
            baseLuck = 5;
            baseSpeed = 5-1;
        } else if (classSymbol.equals(hunterANSI)) {
            baseStrength = 5-1;
            baseVitality = 5-1;
            baseStamina = 5+1;
            baseIntelligence = 5-2;
            baseDexterity = 5+3;
            baseCharisma = 5+1;
            baseAgility = 5+4;
            baseLuck = 5;
            baseSpeed = 5+1;
        } else if (classSymbol.equals(warlockANSI)) {
            baseStrength = 5;
            baseVitality = 5+3;
            baseStamina = 5;
            baseIntelligence = 5+4;
            baseDexterity = 5;
            baseCharisma = 5+1;
            baseAgility = 5;
            baseLuck = 5;
            baseSpeed = 5-1;
        } else if (classSymbol.equals(druidANSI)) {
            baseStrength = 5;
            baseVitality = 5;
            baseStamina = 5+1;
            baseIntelligence = 5+2;
            baseDexterity = 5+1;
            baseCharisma = 5;
            baseAgility = 5+2;
            baseLuck = 5;
            baseSpeed = 5+1;
        } else {
            baseStrength = 5;
            baseVitality = 5;
            baseStamina = 5;
            baseIntelligence = 5;
            baseDexterity = 5;
            baseCharisma = 5;
            baseAgility = 5;
            baseLuck = 5;
            baseSpeed = 5;
        }
    }


    public void updateStats() {
        this.baseStats();
        this.strength = baseStrength + bonusStrength;
        this.vitality = baseVitality + bonusVitality;
        this.stamina = baseStamina + bonusStamina;
        this.intelligence = baseIntelligence + bonusIntelligence;
        this.dexterity = baseDexterity + bonusDexterity;
        this.charisma = baseCharisma + bonusCharisma;
        this.agility = baseAgility + bonusAgility;
        this.luck = baseLuck + bonusLuck;
        this.speed = baseSpeed + bonusSpeed;
        // First, add stats from equipment
        for (Item item : equipment.getItems().values()) {
            if (item == null) {
                continue;
            }
            this.strength += item.getStrength();
            this.vitality += item.getVitality();
            this.stamina += item.getStamina();
            this.intelligence += item.getIntelligence();
            this.dexterity += item.getDexterity();
            this.charisma += item.getCharisma();
            this.agility += item.getAgility();
            this.luck += item.getLuck();
            this.strength = Math.max(1, this.strength);
            this.vitality = Math.max(1, this.vitality);
            this.stamina = Math.max(1, this.stamina);
            this.intelligence = Math.max(1, this.intelligence);
            this.dexterity = Math.max(1, this.dexterity);
            this.charisma = Math.max(1, this.charisma);
            this.agility = Math.max(1, this.agility);
            this.luck = Math.max(1, this.luck);

        }
        this.maxHealth = vitality * 2;
        this.minAttack = strength / 2;
        this.maxAttack = strength + (dexterity) / 2;
        this.defense = (vitality / 4) + level;
        this.criticalChance = agility + (luck + intelligence) / 3 + level;
        this.speed = agility + (stamina / 2) + level;

        for (Item item : equipment.getItems().values()) {
            if (item == null) {
                continue;
            }
            this.maxHealth += item.getHealth();
            this.minAttack += item.getMinAttack();
            this.maxAttack += item.getMaxAttack();
            this.defense += item.getDefense();
            this.criticalChance += item.getCriticalChance();
            this.speed += item.getSpeed();
        }

        this.maxHealth = Math.max(1, this.maxHealth);
        this.minAttack = Math.max(1, this.minAttack);
        this.maxAttack = Math.max(1, this.maxAttack);
        this.defense = Math.max(0, this.defense);
        this.criticalChance = Math.max(0, this.criticalChance);
        this.speed = Math.max(1, this.speed);
    }





    public void addSkillPoint(String stat) {
        if (this.skillPoints <= 0) {
            System.out.println("Nemáš žádné body k dispozici.");
            return;
        }
        stat = stat.toLowerCase();
        boolean validStat = true;
        switch (stat) {
            case "vitality":
            case "vit":
            case "1":
                this.vitality++;
                break;
            case "strength":
            case "str":
            case "2":
                this.strength++;
                break;
            case "stamina":
            case "sta":
            case "3":
                this.stamina++;
                break;
            case "intelligence":
            case "int":
            case "4":
                this.intelligence++;
                break;
            case "dexterity":
            case "dex":
            case "5":
                this.dexterity++;
                break;
            case "6":
            case "charisma":
            case "cha":
                this.charisma++;
                break;
            case "agility":
            case "agi":
            case "7":
                this.agility++;
                break;
            case "luck":
            case "lck":
            case "8":
                this.luck++;
                break;
            default:
                validStat = false;
                System.out.println("Takový název statu neexistuje.");
        }

        if (validStat) {
            this.skillPoints--;
            this.updateStats();
            System.out.println(stat + " increased! Remaining skill points: " + skillPoints);
        }

    }

    public boolean isAlive() {
        return health > 0;
    }

    public void levelUp(){
        this.skillPoints += 3;
        this.experience -= experienceToNextLevel;
        experienceToNextLevel += 5;
        this.level++;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        while(this.experience >= experienceToNextLevel) {
            System.out.println("Level up!");
            levelUp();
            System.out.println("Gratuluji, postoupil jsi na úroveň " + level);
        }
    }


    public void addToInventory(Item item) {
        inventory.addItem(item);
        System.out.println(item.getName() + " byl přidán do inventáře.");
    }

    public void removeFromInventory(Item item) {
        inventory.removeItem(item);
        System.out.println(item.getName() + " byl odebrán z inventáře.");
    }

    public void equipItem(Item item) {
        equipment.equipItem(item);
        this.updateStats();

    }

    public void unEquipItem(Item item) {
        equipment.unEquipItem(item);
        this.updateStats();
        System.out.println(item.getName() + " byl sundán.");
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(statsColor).append("Staty Hrdiny: ").append(nameANSI).append(friendColor).append(name).append("\n").append(reset)
        // Základní staty
        .append(statsCategoryColor).append("======================== Obecné ========================\n").append(reset).append(statsColor)
        .append(classSymbol).append(" ").append(className).append(" \t\t")
        .append(levelANSI).append(" ").append(level).append(" LVL\t\t")
        .append(experienceANSI).append(" ").append(experience).append("/").append(experienceToNextLevel).append(" EXP\t\t")
        .append(skillPointsANSI).append(" ").append(skillPoints).append(" AP\n")
        .append(statsCategoryColor).append("__________________ Základní atributy ___________________\n").append(reset).append(statsColor)
        .append(vitalityANSI).append(" VIT ").append(vitality).append("\t\t")
        .append(strengthANSI).append(" STR ").append(strength).append("\t\t")
        .append(staminaANSI).append(" STA ").append(stamina).append("\t\t")
        .append(intelligenceANSI).append(" INT ").append(intelligence).append("\n")
        .append(dexterityANSI).append(" DEX ").append(dexterity).append("\t\t")
        .append(charismaANSI).append(" CHA ").append(charisma).append("\t\t")
        .append(agilityANSI).append(" AGI ").append(agility).append("\t\t")
        .append(luckANSI).append(" LCK ").append(luck).append("\n")

        // Combat staty
        .append(statsCategoryColor).append("_____________________ Staty v boji ______________________\n").append(reset).append(statsColor)
        .append(healthANSI).append(" ").append(health).append("/").append(maxHealth).append(" \t\t")
        .append(defenseANSI).append(" ").append(defense).append("\t\t\t")
        .append(speedANSI).append(" ").append(speed).append("\n")
        .append(attackOneSwordANSI).append(" ").append(minAttack).append("-").append(maxAttack).append(" DMG  \t")
        .append(criticalChanceANSI).append(" ").append(criticalChance).append(" %\n")


        // Inventář
        .append(statsCategoryColor).append("_______________________ Inventář ________________________\n").append(reset).append(statsColor)
        .append(backpackANSI).append("Inventář: ").append(inventory.getItemsName()).append("\n");

        // Equipment (only add if equipment is not empty)
        if (equipment.getItemsName() == null || !equipment.getItemsName().isEmpty()) {
            sb.append(statsCategoryColor).append("_________________________________________________________\n").append(reset).append(statsColor);
            sb.append(equipmentANSI).append("Výbava: ").append(equipment.getItemsName()).append("\n");
        }

        sb.append(reset);

        return sb.toString();
    }

    public void selfBurn(){
        setHealth(getHealth()-2);
        System.out.println("Promáchl jsi a zranil se za " + enemyColor + "2 " + resetColor + "body zdraví. Jsi fakt super hrdina");
    }

    public void attack(Enemy enemy) {
        if (enemy == null) {
            System.out.println("Nemáš žádného nepřítele k útoku.");
            return;
        }
        int damage = (int) (Math.random() * (maxAttack - minAttack + 1) + minAttack);
        if (Math.random() * 100 < criticalChance) {
            damage *= 2;
            System.out.println("Zasáhl jsi kriticky!");
        }
        damage -= enemy.getDefense();
        if (damage < 0) {
            damage = 1;
        }
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println("Zasáhl jsi nepřítele za " + enemyColor + damage + resetColor + " bodů zdraví.");
        System.out.println("Nepřítel má nyní " + enemyColor + enemy.getHealth() + resetColor + " bodů zdraví.");
        if (enemy.getHealth() <= 0) {
            enemy.setHealth(0);
            enemy.setAlive(false);
            System.out.println("Porazil jsi nepřítele " + enemy.getName());
            addExperience(enemy.getExperience());
        }
    }
    public void raiseHP(int hp){
        if (maxHealth > health + hp){
            health += hp;
        }
        else{
            health = maxHealth;
        }
    }
    public void heal(Item item) {
        if (inventory.getItems().containsValue(item)){
            if (item.getItemFlyweight().getItemType().equals(potionANSI)) {
                this.raiseHP(item.getHealth());
                System.out.println("Lektvar ti přidal " + itemColor + item.getHealth() +resetColor +  " životů.");
                System.out.println("Tvoje životy jsou nyní: " + itemColor +health + "/" + maxHealth+ resetColor );
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
}
