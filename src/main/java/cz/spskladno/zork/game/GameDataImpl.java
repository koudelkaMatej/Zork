package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.Enemies.EnemyBuilder;
import cz.spskladno.zork.game.Enemies.EnemyFlyweight;
import cz.spskladno.zork.game.Heroes.Hero;
import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Items.ItemBuilder;
import cz.spskladno.zork.game.Items.ItemFlyweight;
import cz.spskladno.zork.game.Items.ItemTypes;
import lombok.Getter;

import static cz.spskladno.zork.game.AnsiChars.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All the mutable game data should exist within this class
 * (e.g. room map, game state, inventory, weapons..)
 */
public class GameDataImpl implements GameData {

    private Room currentRoom;
    private boolean finished;
    private List<Room> rooms = new ArrayList<>();
    @Getter
    private Hero hero = new Hero();
    private ArrayList<Item> gameItems = new ArrayList<>();
    private ArrayList<Enemy> gameEnemies = new ArrayList<>();

    /**
     * Room map registration in constructor
     */
    public GameDataImpl() {
        this.init();
    }

    public void init() {
        this.CreateUniverse();
        resetHero();
    }

    public void CreateUniverse(){
        ItemFlyweight zbran = new ItemFlyweight(ItemTypes.WEAPON);
        ItemFlyweight twoZbran = new ItemFlyweight(ItemTypes.TwoHANDED_WEAPON);
        ItemFlyweight brneni = new ItemFlyweight(ItemTypes.ARMOR);
        ItemFlyweight kalhoty = new ItemFlyweight(ItemTypes.LEGS);
        ItemFlyweight helma = new ItemFlyweight(ItemTypes.HELMET);
        ItemFlyweight lektvar = new ItemFlyweight(ItemTypes.POTION);
        ItemFlyweight klic = new ItemFlyweight(ItemTypes.KEY);
        ItemFlyweight quest = new ItemFlyweight(ItemTypes.QUEST);
        ItemFlyweight misc = new ItemFlyweight(ItemTypes.MISC);

        Item excalibur = new ItemBuilder(twoZbran).name("Excalibur").attack(10,20).criticalChance(10).weight(15).build();
        Item mec = new ItemBuilder(zbran).name("Dlouhý meč").attack(5,10).criticalChance(5).weight(5).build();
        Item luk = new ItemBuilder(zbran).name("Luk přesnosti").attack(4,8).criticalChance(20).weight(5).build();
        Item brneni1 = new ItemBuilder(brneni).name("Hrudní plát").armor(5).hp(5).weight(10).build();
        Item brneni2 = new ItemBuilder(brneni).name("Brnění rytíře").armor(10).hp(10).weight(15).build();
        Item kalhoty1 = new ItemBuilder(kalhoty).name("Kožené kalhoty").armor(2).hp(2).weight(2).build();
        Item kalhoty2 = new ItemBuilder(kalhoty).name("Železné kalhoty").armor(5).hp(5).weight(5).build();
        Item prilba1 = new ItemBuilder(helma).name("Kovová přilba").armor(2).hp(2).weight(2).build();
        Item prilba2 = new ItemBuilder(helma).name("Železná přilba").armor(5).hp(5).weight(5).build();
        Item klicBoss = new ItemBuilder(klic).name("Klíč od Vorthraxe").weight(1).build();
        Item mince = new ItemBuilder(misc).name("Zlaté mince").weight(0).build();
        Item kniha = new ItemBuilder(misc).name("Kniha proroctví").weight(0).build();
        Item prilbaOsudu = new ItemBuilder(helma).name("Přilba osudu").armor(5).hp(2).build();
        Item malýLektvarZdraví = new ItemBuilder(lektvar).name("Malý lektvar zdraví").hp(10).build();
        Item velkýLektvarZdraví = new ItemBuilder(lektvar).name("Velký lektvar zdraví").hp(20).build();
        gameItems.addAll(Arrays.asList(excalibur, mec, luk, brneni1, brneni2, kalhoty1, kalhoty2, prilba1, prilba2, klicBoss, mince, kniha, prilbaOsudu, malýLektvarZdraví, velkýLektvarZdraví));


        EnemyFlyweight goblin = new EnemyFlyweight("Goblin");
        EnemyFlyweight pavouk = new EnemyFlyweight("Pavouk");
        EnemyFlyweight troll = new EnemyFlyweight("Troll");
        EnemyFlyweight bestie = new EnemyFlyweight("Bestie");
        EnemyFlyweight temnyRytir = new EnemyFlyweight("Temný rytíř");
        EnemyFlyweight drak = new EnemyFlyweight("Drak");
        EnemyFlyweight kostlivec = new EnemyFlyweight("Kostlivec");

        Enemy kostilivec1 = new EnemyBuilder(kostlivec,"Kostlivec").hp(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy goblin1 = new EnemyBuilder(goblin,"Goblin s nožem").hp(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy goblin2 = new EnemyBuilder(goblin,"Goblin s mečem").hp(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy goblin3 = new EnemyBuilder(goblin,"Goblin s lukem").hp(20).minAttack(3).maxAttack(7).defense(3).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy pavouk1 = new EnemyBuilder(pavouk,"Pavouk").hp(10).minAttack(1).maxAttack(5).defense(1).criticalChance(5).experience(5).loot(gameItems).build();
        Enemy pavouk2 = new EnemyBuilder(pavouk,"Velký pavouk").hp(15).minAttack(2).maxAttack(6).defense(2).criticalChance(5).experience(10).loot(gameItems).build();
        Enemy troll1 = new EnemyBuilder(troll,"Troll").hp(20).minAttack(3).maxAttack(7).defense(3).criticalChance(5).experience(15).loot(gameItems).build();
        Enemy troll2 = new EnemyBuilder(troll,"Troll s kyjem").hp(25).minAttack(4).maxAttack(8).defense(4).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy bestie1 = new EnemyBuilder(bestie,"Bestie").hp(25).minAttack(4).maxAttack(8).defense(4).criticalChance(5).experience(20).loot(gameItems).build();
        Enemy temnyRytir1 = new EnemyBuilder(temnyRytir,"Temný rytíř").hp(30).minAttack(5).maxAttack(9).defense(5).criticalChance(5).experience(25).build();
        temnyRytir1.setLoot(klicBoss);
        Enemy drak1 = new EnemyBuilder(drak,"Drak Vorthrax").hp(50).minAttack(10).maxAttack(20).defense(10).criticalChance(10).experience(50).loot(gameItems).build();

        gameEnemies.addAll(Arrays.asList(goblin2, goblin3 , pavouk2,troll2, kostilivec1));

        Room baseRoom = new RoomImpl("Vstup do jeskyne", "Jsi u vstupu do jeskyne. Vevnitř je jen tma. A nebo ne?",gameItems,gameEnemies,false);

        Room cave1 = new RoomImpl("Vstupní místnost", "Vstupuješ do místnosti, kde se nachází několik cest. Kam se vydáš?",gameItems,gameEnemies,false);
        Room cave3 = new RoomImpl("Místnost s vodopádem", "Vstupuješ do místnosti, kde se nachází vodopád. Můžeš se napít nebo pokračovat dál.",gameItems,gameEnemies,false);
        Room cave4 = new RoomImpl("Temná síň", "Vstupuješ do temné síně. Je tu tma a cítíš zde zvláštní chlad.",gameItems,gameEnemies,false);
        Room cave5 = new RoomImpl("Místnost s pokladem", "Vstupuješ do místnosti, kde se nachází" + itemColor + " poklad" + resetColor + ", ale může to být past.",gameItems,gameEnemies,false);
        Room cave8 = new RoomImpl("Jezírko odpočinku", "Vstupuješ do místnosti, kde se nachází jezírko. Můžeš se zde odpočinout a nabrat síly.",gameItems,gameEnemies,false);
        Room cave12 = new RoomImpl("Obřadní místnost", "Vstupuješ do místnosti, kde se nachází obřadní místnost. Zde se konají obřady a rituály. ve jménu " + enemyColor + "Vorthraxe" + resetColor + ". Všude je cítit pach krve a smrti.",gameItems,gameEnemies,false);
        Room cave13 = new RoomImpl("Místnost s trůnem", "",gameItems,gameEnemies,false);


        //předem určená monstra
        Room cave2 = new RoomImpl("Místnost s gobliny", "Vstupuješ do místnosti, kde se nachází " + enemyColor + goblin1.getName() + resetColor + ". Můžeš se s nimi prát nebo radši utečeš?",gameItems,null,false);
        cave2.addEnemy(goblin1);
        Room cave6 = new RoomImpl("Jeskyně s pavouky", "Vstupuješ do jeskyne, kde se nachází " + enemyColor + pavouk1.getName() + resetColor+" . Můžeš se pokusit je zabít Nebo radši utečeš?",gameItems,null,false);
        cave6.addEnemy(pavouk1);
        Room cave7 = new RoomImpl("Místnost s obřím pavoukem", "Vstupuješ do místnosti, kde se nachází " + enemyColor + troll1.getName() + resetColor,gameItems,gameEnemies,false);
        cave7.addEnemy(troll1);
        Room cave9 = new RoomImpl("Doupě bestie", "Vstupuješ do místnosti, kde se nachází " + enemyColor + bestie1.getName() + resetColor + "Po stěnách jsou stopy škrábanců a všude je krev.",gameItems,null,false);
        cave9.addEnemy(bestie1);
        // Jeskyně s ručně přiřazenými nepřáteli kvůli klíči
        Room cave10 = new RoomImpl("Hlavní síň", "Vstupuješ do hlavní síně, kde se nachází " + enemyColor + temnyRytir1.getName() + resetColor + " . Oddaný služebník " + enemyColor + "draka Vorthraxe." + resetColor,null,null,false);
        cave10.addEnemy(temnyRytir1);
        Room cave11 = new RoomImpl("Jeskyně s drakem", "Vstupuješ do jeskyne, kde se nachází drak" + enemyColor + drak1.getName() + resetColor + " . Tvá největší zkouška začíná.",gameItems,null,true);
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
    }
    @Override
    public List<Room> getRooms() {
        return rooms;
    }

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

    public void addItem(Item item){
        currentRoom.addItem(item);
    }
    /**
     * Sets finished flag, indicating game is done/finished
     */
    /**
     * Retrieves the finished flag -> the parent components decides whether to end the game
     * based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }

    public void resetHero(){
        hero.getInventory().clear();
    }


}

