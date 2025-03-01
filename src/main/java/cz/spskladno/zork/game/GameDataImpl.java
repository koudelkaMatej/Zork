package cz.spskladno.zork.game;

import cz.spskladno.zork.game.Heroes.Hero;
import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Items.ItemBuilder;
import cz.spskladno.zork.game.Items.ItemFlyweight;
import cz.spskladno.zork.game.Items.ItemTypes;
import lombok.Getter;

import static cz.spskladno.zork.game.AnsiChars.*;
import java.util.ArrayList;
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
        ItemFlyweight prilba = new ItemFlyweight(ItemTypes.HELMET);
        ItemFlyweight lektvar = new ItemFlyweight(ItemTypes.POTION);
        ItemFlyweight klic = new ItemFlyweight(ItemTypes.KEY);
        ItemFlyweight quest = new ItemFlyweight(ItemTypes.QUEST);
        ItemFlyweight misc = new ItemFlyweight(ItemTypes.MISC);

        Item excalibur = new ItemBuilder(twoZbran).name("Excalibur").attack(10,20).criticalChance(10).weight(15).build();
        Item prilbaOsudu = new ItemBuilder(prilba).name("Přilba osudu").armor(5).hp(2).build();
        Item malýLektvarZdraví = new ItemBuilder(lektvar).name("Malý lektvar zdraví").hp(10).build();

        Room baseRoom = new RoomImpl("Vstup do jeskyne", "Jsi u vstupu do jeskyne. Vevnitř je jen tma. A nebo ne?",prilbaOsudu);
        Room cave1 = new RoomImpl("Vstupní místnost", "Vstupuješ do místnosti, kde se nachází několik cest. Kam se vydáš?");
        Room cave2 = new RoomImpl("Místnost s gobliny", "Vstupuješ do místnosti, kde se nachází " + enemyColor + "goblini" + resetColor + ". Můžeš se s nimi prát nebo radši utečeš?");
        Room cave3 = new RoomImpl("Místnost s vodopádem", "Vstupuješ do místnosti, kde se nachází vodopád. Můžeš se napít nebo pokračovat dál.");
        Room cave4 = new RoomImpl("Temná síň", "Vstupuješ do temné síně. Je tu tma a cítíš zde zvláštní chlad.");
        Room cave5 = new RoomImpl("Místnost s pokladem", "Vstupuješ do místnosti, kde se nachází" + itemColor + " poklad" + resetColor + ", ale může to být past.");
        Room cave6 = new RoomImpl("Jeskyně s pavouky", "Vstupuješ do jeskyne, kde se nachází " + enemyColor + " pavouci" + resetColor+" . Můžeš se pokusit je zabít Nebo radši utečeš?");
        Room cave7 = new RoomImpl("Místnost s obřím pavoukem", "Vstupuješ do místnosti, kde se nachází " + enemyColor + "Trol" + resetColor);
        Room cave8 = new RoomImpl("Jezírko odpočinku", "Vstupuješ do místnosti, kde se nachází jezírko. Můžeš se zde odpočinout a nabrat síly.");
        Room cave9 = new RoomImpl("Doupě bestie", "Vstupuješ do místnosti, kde se nachází " + enemyColor + "Bestie" + resetColor + "Po stěnách jsou stopy škrábanců a všude je krev.");
        Room cave10 = new RoomImpl("Hlavní síň", "Vstupuješ do hlavní síně, kde se nachází " + enemyColor + "Temný rytíř" + resetColor + " . Oddaný služebník " + enemyColor + "draka Vorthraxe." + resetColor);
        Room cave11 = new RoomImpl("Jeskyně s drakem", "Vstupuješ do jeskyne, kde se nachází drak" + enemyColor + "Vorthrax" + resetColor + " . Tvá největší zkouška začíná.");
        Room cave12 = new RoomImpl("Obřadní místnost", "Vstupuješ do místnosti, kde se nachází obřadní místnost. Zde se konají obřady a rituály. ve jménu " + enemyColor + "Vorthraxe" + resetColor + ". Všude je cítit pach krve a smrti.");
        Room cave13 = new RoomImpl("Místnost s trůnem", "Vstupuješ do místnosti, kde se nachází trůn. Na trůnu sedí " + enemyColor + "Kostlivec" + resetColor + " s velkým mečem a brněním. Čeká tě těžký souboj.");


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

