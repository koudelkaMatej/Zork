package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Enemies.EnemyBuilder;
import cz.spskladno.zork.game.Enemies.EnemyDifficultyCategories;
import cz.spskladno.zork.game.Enemies.EnemyFlyweight;
import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Items.ItemBuilder;
import cz.spskladno.zork.game.Items.ItemFlyweight;
import cz.spskladno.zork.game.Items.ItemTypes;
import cz.spskladno.zork.game.Heroes.Hero;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cz.spskladno.zork.game.AnsiChars.*;

/**
 * All the mutable game data should exist within this class
 * (e.g. room map, game state, inventory, weapons..)
 */
@Getter @Setter
public class GameDataImpl implements GameData {
    private Room currentRoom;
    private boolean finished;
    private List<Room> rooms = new ArrayList<>();;
    private static Hero hero = new Hero();
    private ArrayList<Item> gameItems = new ArrayList<>();
    private ArrayList<Enemy> gameEnemies = new ArrayList<>();
    private boolean hasGivenUp = false;

    /**
     * Room map registration in constructor
     */
    public GameDataImpl() {
        this.init();
    }

    public void init() {
        this.reset();

    }

    @Override
    public void reset() {
        createUniverse();
        hero.restart();
    }

    public void createUniverse(){

        ItemFlyweight weapon = new ItemFlyweight(ItemTypes.WEAPON);
        ItemFlyweight twoHandedWeapon = new ItemFlyweight(ItemTypes.TWO_HANDED_WEAPON);
        ItemFlyweight helmet = new ItemFlyweight(ItemTypes.HELMET);
        ItemFlyweight greaves = new ItemFlyweight(ItemTypes.GREAVES);
        ItemFlyweight chestPiece = new ItemFlyweight(ItemTypes.CHEST_PIECE);
        ItemFlyweight gloves = new ItemFlyweight(ItemTypes.GLOVES);
        ItemFlyweight belt = new ItemFlyweight(ItemTypes.BELT);
        ItemFlyweight boots = new ItemFlyweight(ItemTypes.BOOTS);
        ItemFlyweight ring = new ItemFlyweight(ItemTypes.RING);
        ItemFlyweight amulet = new ItemFlyweight(ItemTypes.AMULET);
        ItemFlyweight shield = new ItemFlyweight(ItemTypes.SHIELD);
        ItemFlyweight potion = new ItemFlyweight(ItemTypes.POTION);
        ItemFlyweight key = new ItemFlyweight(ItemTypes.KEY);
        ItemFlyweight quest = new ItemFlyweight(ItemTypes.QUEST);
        ItemFlyweight misc = new ItemFlyweight(ItemTypes.MISC);

// WEAPON
        Item shortSword = new ItemBuilder(weapon).name("Krátký meč").weight(2).level(1).attack(4, 8).criticalChance(5).strength(2).classRestriction(warriorANSI).classRestriction(rogueANSI).build();
        Item axe = new ItemBuilder(weapon).name("Sekera").weight(7).level(3).attack(8, 14).criticalChance(10).strength(5).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item magicSword = new ItemBuilder(weapon).name("Magický meč").weight(4).level(3).attack(7, 13).criticalChance(10).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        Item dagger = new ItemBuilder(weapon).name("Dýka").weight(1).level(1).attack(3, 6).criticalChance(25).classRestriction(rogueANSI).build();
        Item bow = new ItemBuilder(weapon).name("Luk").weight(3).level(2).attack(6, 10).criticalChance(15).classRestriction(hunterANSI).classRestriction(rogueANSI).build();
        Item battleSword = new ItemBuilder(weapon).name("Bitevní meč").weight(6).level(4).attack(10, 20).criticalChance(8).strength(6).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item greatAxe = new ItemBuilder(twoHandedWeapon).name("Obouruční sekera").weight(10).level(5).attack(15, 25).criticalChance(12).strength(8).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item greatSword = new ItemBuilder(twoHandedWeapon).name("Obouruční meč").weight(12).level(5).attack(20, 30).criticalChance(10).strength(12).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item fireStaff = new ItemBuilder(twoHandedWeapon).name("Ohnivá hůl").weight(4).level(3).attack(6, 10).criticalChance(10).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        Item crossbow = new ItemBuilder(weapon).name("Křížový luk").weight(5).level(4).attack(10, 15).criticalChance(20).classRestriction(hunterANSI).classRestriction(rogueANSI).build();
        gameItems.addAll(Arrays.asList(shortSword, axe, magicSword, dagger, bow, battleSword, greatAxe, greatSword, fireStaff, crossbow));
// TWO_HANDED_WEAPON
        Item excalibur = new ItemBuilder(twoHandedWeapon).name("Excalibur").weight(5).level(1).attack(5, 10).criticalChance(5).agility(1).strength(5).defense(2).classRestriction(warriorANSI).build();
        Item giantHammer = new ItemBuilder(twoHandedWeapon).name("Obří kladivo").weight(12).level(5).attack(18, 25).criticalChance(10).strength(10).classRestriction(warriorANSI).build();
        Item longBow = new ItemBuilder(twoHandedWeapon).name("Dlouhý luk").weight(6).level(3).attack(8, 14).criticalChance(15).strength(4).classRestriction(hunterANSI).build();
        Item greatAxe2 = new ItemBuilder(twoHandedWeapon).name("Velká sekera").weight(11).level(4).attack(12, 22).criticalChance(12).strength(7).classRestriction(warriorANSI).build();
        Item magicalStaff = new ItemBuilder(twoHandedWeapon).name("Magická hůl").weight(4).level(3).attack(6, 12).criticalChance(8).classRestriction(mageANSI).build();
        Item greatMace = new ItemBuilder(twoHandedWeapon).name("Obouruční palice").weight(9).level(1).attack(15, 25).criticalChance(10).strength(9).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item battleAxe = new ItemBuilder(twoHandedWeapon).name("Bitevní sekera").weight(8).level(4).attack(11, 20).criticalChance(10).strength(6).classRestriction(warriorANSI).build();
        Item flameSpear = new ItemBuilder(twoHandedWeapon).name("Plamenný kopí").weight(5).level(3).attack(7, 15).criticalChance(12).classRestriction(hunterANSI).classRestriction(mageANSI).build();
        Item thunderHammer = new ItemBuilder(twoHandedWeapon).name("Hromová kladivo").weight(13).level(5).attack(20, 30).criticalChance(15).strength(12).classRestriction(warriorANSI).build();
        Item lightBow = new ItemBuilder(twoHandedWeapon).name("Světelný luk").weight(5).level(3).attack(6, 12).criticalChance(10).classRestriction(hunterANSI).build();
        Item warstaff = new ItemBuilder(twoHandedWeapon).name("Válečná hůl").weight(7).level(4).attack(9, 18).criticalChance(15).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(excalibur, giantHammer, longBow, greatAxe2, magicalStaff, greatMace, battleAxe, flameSpear, thunderHammer, lightBow, warstaff));
// HELMET
        Item ironHelmet = new ItemBuilder(helmet).name("Železná helma").weight(4).level(2).defense(5).health(2).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item clothHelmet = new ItemBuilder(helmet).name("Plátěná helma").weight(3).level(1).defense(2).health(1).classRestriction(warriorANSI).build();
        Item mysticalCrown = new ItemBuilder(helmet).name("Mystická koruna").weight(2).level(2).defense(3).intelligence(5).classRestriction(mageANSI).build();
        Item druidicHelmet = new ItemBuilder(helmet).name("Přilba druidů").weight(3).level(3).defense(4).classRestriction(druidANSI).build();
        Item bearHelmet = new ItemBuilder(helmet).name("Přilba medvěda").weight(5).level(4).defense(6).classRestriction(druidANSI).build();
        Item mageHelmet = new ItemBuilder(helmet).name("Přilba mágů").weight(4).level(3).defense(4).classRestriction(mageANSI).build();
        Item goldenHelmet = new ItemBuilder(helmet).name("Zlatá helma").weight(6).level(4).defense(6).strength(3).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item chieftainHelmet = new ItemBuilder(helmet).name("Helma náčelníka").weight(5).level(5).defense(8).health(3).classRestriction(paladinANSI).build();
        Item magicalHelmet = new ItemBuilder(helmet).name("Magická helma").weight(3).level(2).defense(4).intelligence(6).classRestriction(mageANSI).build();
        Item ironCrown = new ItemBuilder(helmet).name("Železná koruna").weight(4).level(3).defense(5).strength(2).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        gameItems.addAll(Arrays.asList(ironHelmet, clothHelmet, mysticalCrown, druidicHelmet, bearHelmet, mageHelmet, goldenHelmet, chieftainHelmet, magicalHelmet, ironCrown));
// GREAVES
        Item leatherGreaves = new ItemBuilder(greaves).name("Kožené kalhoty").weight(3).level(1).defense(2).health(1).classRestriction(warriorANSI).classRestriction(rogueANSI).build();
        Item ironGreaves = new ItemBuilder(greaves).name("Železné kalhoty").weight(6).level(3).defense(5).health(3).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item mysticalGreaves = new ItemBuilder(greaves).name("Mystické kalhoty").weight(3).level(2).defense(3).classRestriction(mageANSI).build();
        Item enchantedGreaves = new ItemBuilder(greaves).name("Kouzelné kalhoty").weight(4).level(3).defense(4).intelligence(6).classRestriction(mageANSI).build();
        Item metalGreaves = new ItemBuilder(greaves).name("Kovové kalhoty").weight(5).level(4).defense(6).strength(3).classRestriction(warriorANSI).build();
        Item druidicGreaves = new ItemBuilder(greaves).name("Zelené kalhoty druidů").weight(4).level(3).defense(5).classRestriction(druidANSI).build();
        Item eliteGreaves = new ItemBuilder(greaves).name("Elitní kalhoty").weight(7).level(5).defense(7).strength(4).classRestriction(paladinANSI).build();
        Item scholarlyGreaves = new ItemBuilder(greaves).name("Vědecké kalhoty").weight(2).level(1).defense(1).intelligence(3).classRestriction(mageANSI).build();
        Item clothGreaves = new ItemBuilder(greaves).name("Plátěné kalhoty").weight(3).level(2).defense(2).strength(2).classRestriction(warriorANSI).build();
        gameItems.addAll(Arrays.asList(leatherGreaves, ironGreaves, mysticalGreaves, enchantedGreaves, metalGreaves, druidicGreaves, eliteGreaves, scholarlyGreaves, clothGreaves));
        // CHEST_PIECE
        Item leatherChest = new ItemBuilder(chestPiece).name("Kožená zbroj").weight(8).level(2).defense(4).health(3).classRestriction(warriorANSI).classRestriction(rogueANSI).build();
        Item ironChest = new ItemBuilder(chestPiece).name("Železná zbroj").weight(12).level(3).defense(7).health(5).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item mageRobe = new ItemBuilder(chestPiece).name("Mágova róba").weight(4).level(2).defense(2).classRestriction(mageANSI).build();
        Item druidicRobe = new ItemBuilder(chestPiece).name("Druidův háv").weight(6).level(3).defense(3).classRestriction(druidANSI).build();
        Item paladinArmor = new ItemBuilder(chestPiece).name("Rytířská zbroj").weight(14).level(4).defense(10).health(7).classRestriction(paladinANSI).build();
        Item warlockRobe = new ItemBuilder(chestPiece).name("Robe Warlocka").weight(5).level(3).defense(2).classRestriction(warlockANSI).build();
        Item plateArmor = new ItemBuilder(chestPiece).name("Plátová zbroj").weight(18).level(5).defense(15).health(10).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item clothVest = new ItemBuilder(chestPiece).name("Plátěná vesta").weight(3).level(1).defense(2).intelligence(2).classRestriction(mageANSI).build();
        Item hunterChest = new ItemBuilder(chestPiece).name("Lovecký plášť").weight(7).level(3).defense(5).agility(3).classRestriction(hunterANSI).build();
        Item goldenArmor = new ItemBuilder(chestPiece).name("Zlatá zbroj").weight(20).level(5).defense(18).strength(6).classRestriction(warriorANSI).build();
        gameItems.addAll(Arrays.asList(leatherChest, ironChest, mageRobe, druidicRobe, paladinArmor, warlockRobe, plateArmor, clothVest, hunterChest, goldenArmor));
// GLOVES
        Item leatherGloves = new ItemBuilder(gloves).name("Kožené rukavice").weight(1).level(1).defense(1).health(1).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item ironGloves = new ItemBuilder(gloves).name("Železné rukavice").weight(2).level(2).defense(3).strength(2).classRestriction(warriorANSI).build();
        Item mageGloves = new ItemBuilder(gloves).name("Rukavice mágů").weight(1).level(2).defense(2).classRestriction(mageANSI).build();
        Item druidicGloves = new ItemBuilder(gloves).name("Druidické rukavice").weight(2).level(3).defense(2).classRestriction(druidANSI).build();
        Item paladinGloves = new ItemBuilder(gloves).name("Rukavice paladina").weight(3).level(3).defense(4).strength(3).classRestriction(paladinANSI).build();
        Item shadowGloves = new ItemBuilder(gloves).name("Stínové rukavice").weight(1).level(1).defense(1).agility(2).classRestriction(rogueANSI).build();
        Item enchantedGloves = new ItemBuilder(gloves).name("Kouzelné rukavice").weight(2).level(2).defense(3).intelligence(4).classRestriction(mageANSI).build();
        Item warriorGloves = new ItemBuilder(gloves).name("Rukavice bojovníka").weight(3).level(2).defense(5).strength(3).classRestriction(warriorANSI).build();
        Item hunterGloves = new ItemBuilder(gloves).name("Lovecké rukavice").weight(1).level(2).defense(2).agility(4).classRestriction(hunterANSI).build();
        Item frostGloves = new ItemBuilder(gloves).name("Mrazivé rukavice").weight(2).level(3).defense(4).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(leatherGloves, ironGloves, mageGloves, druidicGloves, paladinGloves, shadowGloves, enchantedGloves, warriorGloves, hunterGloves, frostGloves));
// BELT
        Item leatherBelt = new ItemBuilder(belt).name("Kožený opasek").weight(1).level(1).defense(1).health(2).classRestriction(warriorANSI).classRestriction(rogueANSI).build();
        Item ironBelt = new ItemBuilder(belt).name("Železný opasek").weight(2).level(2).defense(2).strength(2).classRestriction(warriorANSI).build();
        Item magicBelt = new ItemBuilder(belt).name("Magický opasek").weight(1).level(2).defense(1).classRestriction(mageANSI).build();
        Item druidicBelt = new ItemBuilder(belt).name("Druidický opasek").weight(2).level(3).defense(2).classRestriction(druidANSI).build();
        Item hunterBelt = new ItemBuilder(belt).name("Lovecký opasek").weight(1).level(2).defense(1).agility(3).classRestriction(hunterANSI).build();
        Item paladinBelt = new ItemBuilder(belt).name("Paladinský opasek").weight(3).level(3).defense(3).strength(4).classRestriction(paladinANSI).build();
        Item warriorBelt = new ItemBuilder(belt).name("Bojovnický opasek").weight(3).level(3).defense(4).strength(5).classRestriction(warriorANSI).build();
        Item frostBelt = new ItemBuilder(belt).name("Mrazivý opasek").weight(2).level(2).defense(2).classRestriction(warlockANSI).build();
        Item shadowBelt = new ItemBuilder(belt).name("Stínový opasek").weight(2).level(3).defense(3).agility(4).classRestriction(rogueANSI).build();
        Item enchantedBelt = new ItemBuilder(belt).name("Kouzelný opasek").weight(3).level(4).defense(4).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(leatherBelt, ironBelt, magicBelt, druidicBelt, hunterBelt, paladinBelt, warriorBelt, frostBelt, shadowBelt, enchantedBelt));
// BOOTS
        Item leatherBoots = new ItemBuilder(boots).name("Kožené boty").weight(2).level(1).defense(2).health(1).classRestriction(warriorANSI).classRestriction(rogueANSI).build();
        Item ironBoots = new ItemBuilder(boots).name("Železné boty").weight(3).level(2).defense(3).strength(2).classRestriction(warriorANSI).build();
        Item mageBoots = new ItemBuilder(boots).name("Magické boty").weight(2).level(2).defense(2).classRestriction(mageANSI).build();
        Item druidicBoots = new ItemBuilder(boots).name("Druidické boty").weight(3).level(3).defense(3).classRestriction(druidANSI).build();
        Item paladinBoots = new ItemBuilder(boots).name("Paladinské boty").weight(4).level(3).defense(4).strength(3).classRestriction(paladinANSI).build();
        Item hunterBoots = new ItemBuilder(boots).name("Lovecké boty").weight(2).level(2).defense(2).agility(3).classRestriction(hunterANSI).build();
        Item warriorBoots = new ItemBuilder(boots).name("Bojovnické boty").weight(3).level(3).defense(4).strength(4).classRestriction(warriorANSI).build();
        Item shadowBoots = new ItemBuilder(boots).name("Stínové boty").weight(2).level(2).defense(2).agility(5).classRestriction(rogueANSI).build();
        Item frostBoots = new ItemBuilder(boots).name("Mrazivé boty").weight(3).level(3).defense(3).classRestriction(mageANSI).build();
        Item enchantedBoots = new ItemBuilder(boots).name("Kouzelnické boty").weight(4).level(4).defense(4).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(leatherBoots, ironBoots, mageBoots, druidicBoots, paladinBoots, hunterBoots, warriorBoots, shadowBoots, frostBoots, enchantedBoots));
        // RING
        Item warriorRing = new ItemBuilder(ring).name("Prsten bojovníka").weight(1).level(2).strength(5).defense(2).classRestriction(warriorANSI).build();
        Item mageRing = new ItemBuilder(ring).name("Prsten mága").weight(1).level(2).intelligence(3).classRestriction(mageANSI).build();
        Item rogueRing = new ItemBuilder(ring).name("Prsten zloděje").weight(1).level(1).agility(5).defense(1).classRestriction(rogueANSI).build();
        Item paladinRing = new ItemBuilder(ring).name("Prsten paladina").weight(1).level(3).strength(6).defense(3).classRestriction(paladinANSI).build();
        Item hunterRing = new ItemBuilder(ring).name("Prsten lovce").weight(1).level(2).agility(4).defense(2).classRestriction(hunterANSI).build();
        Item warlockRing = new ItemBuilder(ring).name("Prsten warlocka").weight(1).level(3).intelligence(5).classRestriction(warlockANSI).build();
        Item druidRing = new ItemBuilder(ring).name("Prsten druidův").weight(1).level(2).defense(2).classRestriction(druidANSI).build();
        Item clownRing = new ItemBuilder(ring).name("Prsten klauna").weight(1).level(1).defense(2).strength(1).classRestriction(clownANSI).build();
        Item priestRing = new ItemBuilder(ring).name("Prsten kněze").weight(1).level(2).health(5).classRestriction(priestANSI).build();
        Item enchantedRing = new ItemBuilder(ring).name("Kouzelný prsten").weight(1).level(4).intelligence(6).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(warriorRing, mageRing, rogueRing, paladinRing, hunterRing, warlockRing, druidRing, clownRing, priestRing, enchantedRing));
// AMULET
        Item magicAmulet = new ItemBuilder(amulet).name("Magický amulet").weight(1).level(2).intelligence(3).classRestriction(mageANSI).build();
        Item druidicAmulet = new ItemBuilder(amulet).name("Druidický amulet").weight(1).level(3).defense(3).classRestriction(druidANSI).build();
        Item warriorAmulet = new ItemBuilder(amulet).name("Bojovnický amulet").weight(1).level(2).strength(4).defense(2).classRestriction(warriorANSI).build();
        Item paladinAmulet = new ItemBuilder(amulet).name("Amulet paladina").weight(1).level(3).strength(5).defense(3).classRestriction(paladinANSI).build();
        Item warlockAmulet = new ItemBuilder(amulet).name("Amulet warlocka").weight(1).level(3).intelligence(4).classRestriction(warlockANSI).build();
        Item rogueAmulet = new ItemBuilder(amulet).name("Amulet zloděje").weight(1).level(2).agility(5).defense(2).classRestriction(rogueANSI).build();
        Item hunterAmulet = new ItemBuilder(amulet).name("Amulet lovce").weight(1).level(2).agility(4).strength(3).classRestriction(hunterANSI).build();
        Item clownAmulet = new ItemBuilder(amulet).name("Amulet klauna").weight(1).level(1).defense(3).agility(2).classRestriction(clownANSI).build();
        Item priestAmulet = new ItemBuilder(amulet).name("Amulet kněze").weight(1).level(3).health(7).classRestriction(priestANSI).build();
        Item enchantedAmulet = new ItemBuilder(amulet).name("Kouzelný amulet").weight(1).level(4).intelligence(5).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(magicAmulet, druidicAmulet, warriorAmulet, paladinAmulet, warlockAmulet, rogueAmulet, hunterAmulet, clownAmulet, priestAmulet, enchantedAmulet));
// SHIELD
        Item woodenShield = new ItemBuilder(shield).name("Dřevěný štít").weight(3).level(1).defense(4).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item ironShield = new ItemBuilder(shield).name("Železný štít").weight(5).level(2).defense(7).strength(2).classRestriction(warriorANSI).classRestriction(paladinANSI).build();
        Item magicalShield = new ItemBuilder(shield).name("Magický štít").weight(4).level(3).defense(6).classRestriction(mageANSI).build();
        Item druidicShield = new ItemBuilder(shield).name("Druidický štít").weight(6).level(3).defense(8).classRestriction(druidANSI).build();
        Item paladinShield = new ItemBuilder(shield).name("Paladinský štít").weight(8).level(4).defense(12).strength(3).classRestriction(paladinANSI).build();
        Item warlockShield = new ItemBuilder(shield).name("Warlockův štít").weight(5).level(3).defense(5).classRestriction(warlockANSI).build();
        Item rogueShield = new ItemBuilder(shield).name("Stínový štít").weight(3).level(2).defense(4).agility(3).classRestriction(rogueANSI).build();
        Item hunterShield = new ItemBuilder(shield).name("Lovecký štít").weight(4).level(2).defense(5).agility(2).classRestriction(hunterANSI).build();
        Item clownShield = new ItemBuilder(shield).name("Klaunský štít").weight(4).level(1).defense(3).strength(1).classRestriction(clownANSI).build();
        Item enchantedShield = new ItemBuilder(shield).name("Kouzelný štít").weight(5).level(4).defense(10).classRestriction(mageANSI).classRestriction(warlockANSI).build();
        gameItems.addAll(Arrays.asList(woodenShield, ironShield, magicalShield, druidicShield, paladinShield, warlockShield, rogueShield, hunterShield, clownShield, enchantedShield));
// POTION
        Item healthPotion = new ItemBuilder(potion).name("Lektvar zdraví").weight(1).level(1).health(15).build();
        Item manaPotion = new ItemBuilder(potion).name("Lektvar many").weight(1).level(2).build();
        Item staminaPotion = new ItemBuilder(potion).name("Lektvar výdrže").weight(1).level(2).strength(5).build();
        Item speedPotion = new ItemBuilder(potion).name("Lektvar rychlosti").weight(1).level(2).agility(4).build();
        Item firePotion = new ItemBuilder(potion).name("Lektvar ohně").weight(1).level(3).build();
        Item healingPotion = new ItemBuilder(potion).name("Silný lektvar zdraví").weight(1).level(4).health(30).build();
        Item manaRegenPotion = new ItemBuilder(potion).name("Lektvar regenerace many").weight(1).level(3).build();
        Item defensePotion = new ItemBuilder(potion).name("Lektvar obrany").weight(1).level(2).defense(5).build();
        Item agilityPotion = new ItemBuilder(potion).name("Lektvar obratnosti").weight(1).level(2).agility(3).build();
        Item strengthPotion = new ItemBuilder(potion).name("Lektvar síly").weight(1).level(2).strength(6).build();
        gameItems.addAll(Arrays.asList(healthPotion, manaPotion, staminaPotion, speedPotion, firePotion, healingPotion, manaRegenPotion, defensePotion, agilityPotion, strengthPotion));
// KEY
        Item dungeonKey = new ItemBuilder(key).name("Klíč do dungeonu").weight(1).level(1).build();
        Item bossKey = new ItemBuilder(key).name("Klíč od bossu").weight(1).level(2).build();
        Item treasureKey = new ItemBuilder(key).name("Klíč k pokladu").weight(1).level(3).build();
        Item palaceKey = new ItemBuilder(key).name("Klíč k paláci").weight(1).level(3).build();
        Item prisonKey = new ItemBuilder(key).name("Klíč do vězení").weight(1).level(2).build();
        Item chestKey = new ItemBuilder(key).name("Klíč k truhle").weight(1).level(1).build();
        Item enchantedKey = new ItemBuilder(key).name("Kouzelný klíč").weight(1).level(4).build();
        Item goldenKey = new ItemBuilder(key).name("Zlatý klíč").weight(1).level(3).build();
        Item silverKey = new ItemBuilder(key).name("Stříbrný klíč").weight(1).level(2).build();
        Item keyOfDestiny = new ItemBuilder(key).name("Klíč osudu").weight(1).level(4).build();
        gameItems.addAll(Arrays.asList(dungeonKey, bossKey, treasureKey, palaceKey, prisonKey, chestKey, enchantedKey, goldenKey, silverKey, keyOfDestiny));
// QUEST
        Item fetchQuest = new ItemBuilder(quest).name("Úkol: Přines kouzelný kámen").weight(1).level(1).build();
        Item slayQuest = new ItemBuilder(quest).name("Úkol: Zabij draka").weight(1).level(2).build();
        Item rescueQuest = new ItemBuilder(quest).name("Úkol: Zachraň princeznu").weight(1).level(3).build();
        Item exploreQuest = new ItemBuilder(quest).name("Úkol: Prozkoumej ztracený chrám").weight(1).level(2).build();
        Item collectionQuest = new ItemBuilder(quest).name("Úkol: Seber 10 léčivých bylin").weight(1).level(1).build();
        Item treasureHunt = new ItemBuilder(quest).name("Úkol: Hledání pokladu").weight(1).level(3).build();
        Item assassinationQuest = new ItemBuilder(quest).name("Úkol: Zabij vůdce banditů").weight(1).level(4).build();
        Item deliveryQuest = new ItemBuilder(quest).name("Úkol: Doruč zprávu do sousední vesnice").weight(1).level(1).build();
        Item protectQuest = new ItemBuilder(quest).name("Úkol: Ochraňuj vesnici před útokem").weight(1).level(3).build();
        Item mysteryQuest = new ItemBuilder(quest).name("Úkol: Vyřeš záhadu ztracené knihy").weight(1).level(4).build();
        gameItems.addAll(Arrays.asList(fetchQuest, slayQuest, rescueQuest, exploreQuest, collectionQuest, treasureHunt, assassinationQuest, deliveryQuest, protectQuest, mysteryQuest));
// MISC
        Item map = new ItemBuilder(misc).name("Mapa světa").weight(1).level(1).build();
        Item compass = new ItemBuilder(misc).name("Kompas").weight(1).level(1).build();
        Item torch = new ItemBuilder(misc).name("Pochodně").weight(2).level(1).build();
        Item lockpick = new ItemBuilder(misc).name("Odemykací páčidlo").weight(1).level(1).build();
        Item bookOfSpells = new ItemBuilder(misc).name("Kniha kouzel").weight(1).level(2).build();
        Item fishingRod = new ItemBuilder(misc).name("Rybářský prut").weight(3).level(1).build();
        Item tent = new ItemBuilder(misc).name("Stan").weight(5).level(1).build();
        Item herbs = new ItemBuilder(misc).name("Byliny").weight(1).level(1).build();
        Item crystalBall = new ItemBuilder(misc).name("Křišťálová koule").weight(2).level(3).build();
        Item magicMirror = new ItemBuilder(misc).name("Kouzelný zrcadlo").weight(2).level(4).build();
        gameItems.addAll(Arrays.asList(map, compass, torch, lockpick, bookOfSpells, fishingRod, tent, herbs, crystalBall, magicMirror));


        EnemyFlyweight goblin = new EnemyFlyweight("Goblin", EnemyDifficultyCategories.MINION);
        EnemyFlyweight slime = new EnemyFlyweight("Sliz", EnemyDifficultyCategories.MINION);
        EnemyFlyweight pavouk = new EnemyFlyweight("Pavouk",EnemyDifficultyCategories.NORMAL);
        EnemyFlyweight troll = new EnemyFlyweight("Troll",EnemyDifficultyCategories.ELITE);
        EnemyFlyweight bestie = new EnemyFlyweight("Bestie", EnemyDifficultyCategories.ELITE);
        EnemyFlyweight temnyRytir = new EnemyFlyweight("Temný rytíř", EnemyDifficultyCategories.BOSS);
        EnemyFlyweight drak = new EnemyFlyweight("Drak", EnemyDifficultyCategories.BOSS);
        EnemyFlyweight kostlivec = new EnemyFlyweight("Kostlivec", EnemyDifficultyCategories.NORMAL);
        EnemyFlyweight orc = new EnemyFlyweight("Ork", EnemyDifficultyCategories.MINION);
        EnemyFlyweight wolf = new EnemyFlyweight("Vlk", EnemyDifficultyCategories.NORMAL);
        EnemyFlyweight giant = new EnemyFlyweight("Obr", EnemyDifficultyCategories.ELITE);
        EnemyFlyweight vampire = new EnemyFlyweight("Upír", EnemyDifficultyCategories.BOSS);
        EnemyFlyweight werewolf = new EnemyFlyweight("Vlkodlak", EnemyDifficultyCategories.NORMAL);
        EnemyFlyweight lich = new EnemyFlyweight("Lich", EnemyDifficultyCategories.BOSS);
        EnemyFlyweight banshee = new EnemyFlyweight("Banshee", EnemyDifficultyCategories.ELITE);
        EnemyFlyweight ogre = new EnemyFlyweight("Ogre", EnemyDifficultyCategories.NORMAL);
        EnemyFlyweight dragon = new EnemyFlyweight("Drak", EnemyDifficultyCategories.ELITE);
        EnemyFlyweight demon = new EnemyFlyweight("Démon", EnemyDifficultyCategories.BOSS);

        Enemy kostilivec1 = new EnemyBuilder(kostlivec,"Kostlivec").health(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy goblin1 = new EnemyBuilder(goblin,"Goblin s nožem").health(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy goblin2 = new EnemyBuilder(goblin,"Goblin s mečem").health(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy goblin3 = new EnemyBuilder(goblin,"Goblin s lukem").health(20).minAttack(3).maxAttack(7).defense(3).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy pavouk1 = new EnemyBuilder(pavouk,"Pavouk").health(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy pavouk2 = new EnemyBuilder(pavouk,"Velký pavouk").health(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy troll1 = new EnemyBuilder(troll,"Troll").health(20).minAttack(3).maxAttack(7).defense(3).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy troll2 = new EnemyBuilder(troll,"Troll s kyjem").health(25).minAttack(4).maxAttack(8).defense(4).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy bestie1 = new EnemyBuilder(bestie,"Bestie").health(25).minAttack(4).maxAttack(8).defense(4).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy temnyRytir1 = new EnemyBuilder(temnyRytir,"Temný rytíř").health(30).minAttack(5).maxAttack(9).defense(5).criticalChance(5).experience(25).build();
        temnyRytir1.equipItem(bossKey);
        Enemy drak1 = new EnemyBuilder(drak,"Drak Vorthrax").health(50).minAttack(10).maxAttack(20).defense(10).criticalChance(10).experience(50).loot(gameItems).build();
        gameEnemies.addAll(Arrays.asList(kostilivec1, goblin1, goblin2, goblin3, pavouk1, pavouk2, troll1, troll2, bestie1, temnyRytir1, drak1));

        Enemy orc1 = new EnemyBuilder(orc,"Ork s mečem").health(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy orc2 = new EnemyBuilder(orc,"Ork s kladivem").health(20).minAttack(3).maxAttack(7).defense(3).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy wolf1 = new EnemyBuilder(wolf,"Vlk").health(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy wolf2 = new EnemyBuilder(wolf,"Velký vlk").health(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy giant1 = new EnemyBuilder(giant,"Obr").health(30).minAttack(5).maxAttack(10).defense(5).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy giant2 = new EnemyBuilder(giant,"Obr s kladivem").health(40).minAttack(6).maxAttack(12).defense(6).criticalChance(5).experience(25).loot(gameItems).build();
        Enemy vampire1 = new EnemyBuilder(vampire,"Upír Armand").health(50).minAttack(8).maxAttack(15).defense(7).criticalChance(8).experience(30).loot(gameItems).build();
        vampire1.equipItem(enchantedRing); // Přidání předmětu do inventáře
        Enemy vampire2 = new EnemyBuilder(vampire,"Upír Aleron").health(60).minAttack(10).maxAttack(18).defense(8).criticalChance(10).experience(35).loot(gameItems).build();
        Enemy werewolf1 = new EnemyBuilder(werewolf,"Vlkodlak").health(25).minAttack(4).maxAttack(9).defense(4).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy lich1 = new EnemyBuilder(lich,"Lich Lord").health(40).minAttack(6).maxAttack(12).defense(6).criticalChance(7).experience(40).loot(gameItems).build();
        lich1.equipItem(magicAmulet); // Přidání magického amuletu do inventáře
        Enemy banshee1 = new EnemyBuilder(banshee,"Banshee z temného lesa").health(35).minAttack(6).maxAttack(14).defense(5).criticalChance(6).experience(30).loot(gameItems).build();
        Enemy ogre1 = new EnemyBuilder(ogre,"Ogre z hor").health(40).minAttack(7).maxAttack(15).defense(7).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy dragon1 = new EnemyBuilder(dragon,"Drak Drakthor").health(100).minAttack(20).maxAttack(40).defense(15).criticalChance(15).experience(100).loot(gameItems).build();
        Enemy demon1 = new EnemyBuilder(demon,"Démon Zargon").health(80).minAttack(15).maxAttack(30).defense(10).criticalChance(12).experience(80).loot(gameItems).build();
        demon1.equipItem(enchantedShield); // Přidání kouzelného štítu do inventáře
        gameEnemies.addAll(Arrays.asList(orc1, orc2, wolf1, wolf2, giant1, giant2, vampire1, vampire2, werewolf1, lich1, banshee1, ogre1, dragon1, demon1));


        Room baseRoom = new RoomImpl("Vstup do jeskyne", "Jsi u vstupu do jeskyne. Vevnitř je jen tma. A nebo ne?",gameItems,gameEnemies,false);

        Room cave1 = new RoomImpl("Vstupní místnost", "Vstupuješ do místnosti, kde se nachází několik cest. Kam se vydáš?",gameItems,gameEnemies,false);
        Room cave3 = new RoomImpl("Místnost s vodopádem", "Vstupuješ do místnosti, kde se nachází vodopád. Můžeš se napít nebo pokračovat dál.",gameItems,gameEnemies,false);
        Room cave4 = new RoomImpl("Temná síň", "Vstupuješ do temné síně. Je tu tma a cítíš zde zvláštní chlad.",gameItems,gameEnemies,false);
        Room cave5 = new RoomImpl("Místnost s pokladem", "Vstupuješ do místnosti, kde se nachází" + itemColor + " poklad" + resetColor + ", ale může to být past.",gameItems,gameEnemies,false);
        Room cave8 = new RoomImpl("Jezírko odpočinku", "Vstupuješ do místnosti, kde se nachází jezírko. Můžeš se zde odpočinout a nabrat síly.",gameItems,gameEnemies,false);
        Room cave12 = new RoomImpl("Obřadní místnost", "Vstupuješ do místnosti, kde se nachází obřadní místnost. Zde se konají obřady a rituály. ve jménu " + enemyColor + "Vorthraxe" + resetColor + ". Všude je cítit pach krve a smrti.",gameItems,gameEnemies,false);
        Room cave13 = new RoomImpl("Místnost s trůnem", "",gameItems,gameEnemies,false);


        //předem určená monstra
        RoomImpl cave2 = new RoomImpl("Místnost s gobliny", "Vstupuješ do místnosti, kde se nachází " + enemyColor + goblin1 + resetColor + ". Můžeš se s nimi prát nebo radši utečeš?",gameItems,null,false);
        cave2.addEnemy(goblin1);
        RoomImpl cave6 = new RoomImpl("Jeskyně s pavouky", "Vstupuješ do jeskyne, kde se nachází " + enemyColor + pavouk1.getName() + resetColor+" . Můžeš se pokusit je zabít Nebo radši utečeš?",gameItems,null,false);
        cave6.addEnemy(pavouk1);
        RoomImpl cave7 = new RoomImpl("Místnost s obřím pavoukem", "Vstupuješ do místnosti, kde se nachází " + enemyColor + troll1.getName() + resetColor,gameItems,gameEnemies,false);
        cave7.addEnemy(troll1);
        RoomImpl cave9 = new RoomImpl("Doupě bestie", "Vstupuješ do místnosti, kde se nachází " + enemyColor + bestie1.getName() + resetColor + "Po stěnách jsou stopy škrábanců a všude je krev.",gameItems,null,false);
        cave9.addEnemy(bestie1);
        // Jeskyně s ručně přiřazenými nepřáteli kvůli klíči
        RoomImpl cave10 = new RoomImpl("Hlavní síň", "Vstupuješ do hlavní síně, kde se nachází " + enemyColor + temnyRytir1.getName() + resetColor + " . Oddaný služebník " + enemyColor + "draka Vorthraxe." + resetColor,null,null,false);
        cave10.addEnemy(temnyRytir1);
        RoomImpl cave11 = new RoomImpl("Jeskyně s drakem", "Vstupuješ do jeskyne, kde se nachází drak" + enemyColor + drak1.getName() + resetColor + " . Tvá největší zkouška začíná.",gameItems,null,true);
        cave11.addEnemy(drak1);

        baseRoom.registerExit(cave1);
        cave1.registerExit(baseRoom);
        cave1.registerExit(cave2);
        cave1.registerExit(cave3);

        cave2.registerExit(cave1);
        cave2.registerExit(cave4);

        cave3.registerExit(cave1);

        cave4.registerExit(cave2);
        cave4.registerExit(cave6);
        cave4.registerExit(cave7);
        cave4.registerExit(cave8);
        cave4.registerExit(cave13);

        cave5.registerExit(cave6);

        cave6.registerExit(cave4);
        cave6.registerExit(cave5);
        cave6.registerExit(cave9);

        cave7.registerExit(cave4);
        cave7.registerExit(cave10);

        cave8.registerExit(cave4);
        cave8.registerExit(cave10);

        cave9.registerExit(cave6);

        cave7.registerExit(cave10);
        cave7.registerExit(cave4);

        cave8.registerExit(cave10);
        cave8.registerExit(cave4);

        cave10.registerExit(cave7);
        cave10.registerExit(cave8);
        cave10.registerExit(cave12);
        cave10.registerExit(cave13);

        cave11.registerExit(cave12);

        cave12.registerExit(cave10);
        cave12.registerExit(cave11);

        cave13.registerExit(cave10);
        cave13.registerExit(cave4);
        rooms.add(baseRoom);
        rooms.add(cave1);
        rooms.add(cave2);
        rooms.add(cave3);
        rooms.add(cave4);
        rooms.add(cave5);
        rooms.add(cave6);
        rooms.add(cave7);
        rooms.add(cave8);
        rooms.add(cave9);
        rooms.add(cave10);
        rooms.add(cave11);
        rooms.add(cave12);
        rooms.add(cave13);
        this.currentRoom = baseRoom;
        baseRoom.addEnemy(goblin1);
        baseRoom.addEnemy(temnyRytir1);
        baseRoom.addEnemy(drak1);
        baseRoom.addEnemy(kostilivec1);
        kostilivec1.equipItem(excalibur);
        this.currentRoom.addItem(excalibur);
        this.currentRoom.addItem(greatMace);

    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets a room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the finished flag, indicating the game is done/finished
     */
    @Override
    public void setFinished(boolean finished) {
        this.finished = finished;
    }


    public Hero getHero() {
        return hero;
    }
    /**
     * Retrieves the finished flag -> the parent components decides whether to end the game
     * based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public boolean hasGivenUp() {
        return hasGivenUp;
    }
    public void setGivenUp(boolean givenUp) {
        hasGivenUp = givenUp;
    }
}

