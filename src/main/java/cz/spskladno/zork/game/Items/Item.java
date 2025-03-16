package cz.spskladno.zork.game.Items;

import static cz.spskladno.zork.game.AnsiChars.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Item {
    private final String name;
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
    private int level;
    private final ItemFlyweight itemFlyweight;
    private final int weight;
    private List<String> classRestrictions = new ArrayList<>();

    public Item(ItemBuilder itemBuilder) {
        this.itemFlyweight = itemBuilder.getItemFlyweight();
        this.name = itemBuilder.getName();
        this.vitality = itemBuilder.getVitality();
        this.strength = itemBuilder.getStrength();
        this.stamina = itemBuilder.getStamina();
        this.intelligence = itemBuilder.getIntelligence();
        this.dexterity = itemBuilder.getDexterity();
        this.level = itemBuilder.getLevel();
        this.charisma = itemBuilder.getCharisma();
        this.agility = itemBuilder.getAgility();
        this.luck = itemBuilder.getLuck();

        this.minAttack = itemBuilder.getMinAttack();
        this.maxAttack = itemBuilder.getMaxAttack();
        this.defense = itemBuilder.getDefense();
        this.health = itemBuilder.getHealth();
        this.criticalChance = itemBuilder.getCriticalChance();
        this.speed = itemBuilder.getSpeed();
        this.weight = itemBuilder.getWeight();
        this.classRestrictions = itemBuilder.getClassRestrictions();
    }

    public String classRestrictionsToString(){
        StringBuilder sb = new StringBuilder();
        for (String classRestriction : classRestrictions) {
            sb.append(classRestriction).append(" ");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Item Header
        sb.append(resetColor).append("\n==================================================================\n")
                .append("                        ** Předmět **\n")
                .append("------------------------------------------------------------------\n");

        // Item Basic Info
        sb.append(statsCategoryColor).append("============================ Obecné ==============================\n ").append(reset).append(statsColor)
                .append(nameANSI).append(":").append(name).append("\t")
                .append("  ").append(typeANSI).append(": ").append(itemFlyweight.getItemType()).append("\t")
                .append("  ").append(levelANSI).append(" ").append(level).append("\t")
                .append("  ").append("Omezení: ").append(this.classRestrictionsToString()).append("\t");
        if (weight > 0) sb.append("  ").append(weightANSI).append(" ").append(weight).append(" Kg");

        // Item Attributes
        sb.append(statsCategoryColor).append("\n======================= Základní atributy ========================\n").append(reset).append(statsColor);
        if (vitality != 0) sb.append(" ").append(vitalityANSI).append(" ").append(vitality).append("\t");
        if (strength != 0) sb.append(" ").append(strengthANSI).append(" ").append(strength).append("\t");
        if (stamina != 0) sb.append(" ").append(staminaANSI).append(" ").append(stamina).append("\t");
        if (intelligence != 0) sb.append(" ").append(intelligenceANSI).append(" ").append(intelligence).append("\t");
        if (dexterity != 0) sb.append(" ").append(dexterityANSI).append(" ").append(dexterity).append("\t");
        if (charisma != 0) sb.append(" ").append(charismaANSI).append(" ").append(charisma).append("\t");
        if (agility != 0) sb.append(" ").append(agilityANSI).append(" ").append(agility).append("\t");
        if (luck != 0) sb.append(" ").append(luckANSI).append(" ").append(luck);

        // Item Combat Stats
        sb.append(statsCategoryColor).append("\n========================== Staty v boji ==========================\n").append(reset).append(statsColor);
        if (minAttack != 0) sb.append(" ").append(attackOneSwordANSI).append(" ").append(minAttack).append("-").append(maxAttack).append(" DMG\t");
        if (defense != 0) sb.append(" ").append(defenseANSI).append(" ").append(defense).append(" \t");
        if (health != 0) sb.append(" ").append(healthANSI).append(" ").append(health).append("\t");
        if (criticalChance != 0) sb.append(" ").append(criticalChanceANSI).append(" ").append(criticalChance).append(" %");

        // Item Footer
                sb.append(resetColor).append("\n==================================================================\n");

        return sb.toString();
    }
}