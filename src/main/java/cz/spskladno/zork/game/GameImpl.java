package cz.spskladno.zork.game;

import cz.spskladno.zork.command.*;
import cz.spskladno.zork.game.Enemies.Enemy;

import java.util.HashMap;
import java.util.Map;

import static cz.spskladno.zork.game.AnsiChars.*;


/*
 * Represents a running game instance
 */
public class GameImpl implements Game {

    private Map<String, Command> commands = new HashMap<>();
    private GameData gameData;

    public GameImpl() {
        this.registerCommands();
        this.gameData = new GameDataImpl();
    }

    /**
     * Registers immutable Command instances
     */
    private void registerCommands() {
        Command help = new HelpCommand(commands);
        Command reset = new ResetCommand();
        GoCommand go = new GoCommand();
        StatsCommand stats = new StatsCommand();
        MapCommand map = new MapCommand();
        EndCommand end = new EndCommand();
        ExploreRoomCommand exploreRoom = new ExploreRoomCommand();
        PickUpCommand pickUp = new PickUpCommand();
        DropCommand drop = new DropCommand();
        commands.put(drop.getName(), drop);
        commands.put(pickUp.getName(), pickUp);
        commands.put(exploreRoom.getName(), exploreRoom);
        commands.put(end.getName(), end);
        commands.put(map.getName(), map);
        commands.put(stats.getName(), stats);
        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
    }

    /**
     * Returns a welcome message printed after the game's start
     */
    @Override
    public String getWelcomeMessage() {

        return reportColor + bold + "Vítej ve hře Zork!" + reset + "\n" +
                "\n" + italic+
                "V mlhavém úsvitu, kdy slunce sotva líbalo vrcholky hor, se před branami královského hradu objevil posel v královských barvách. Zadýchaný a rozrušený předal vzkaz – samotný král tě žádá o okamžitou audienci.\n" +
                "Vstoupil jsi do velkého sálu, kde na trůnu seděl stárnoucí, ale stále důstojný král " + friendColor + "Aldemar" + italic + ". Jeho oči byly plné zoufalství. Když jsi poklekl, pronesl:\n" +
                "\n" +
                italic + "Statečný hrdino, přišla hodina největší zkoušky.\n" +
                "Moje dcera, " + friendColor + " princezna Elara " + resetColor + italic + ", byla unesena strašlivým " + enemyColor + " Vorthraxem" + resetColor + italic +". Odnesl ji do svého doupěte v Hlubokých horách, odkud se dosud nikdo nevrátil živý. Moji rytíři se bojí, má armáda je bezradná," +
                "\nale ty, ty jsi jiný. Tvá sláva se rozšířila daleko a široko. Jsi poslední nadějí mého království." + enemyColor + " Vorthrax " + reset + italic + "musí zemřít a princezna se musí vrátit. Nevrátíš-li se, bude to má věčná hanba.\n" +
                reset + "\n" +
                bold + italic+ "Věděl jsi, že právě teď začíná tvé největší dobrodružství!" + reset + "\n" +
                "\n" +
                reset + bold + "Tvá hra začíná:" + reset + gameData.getCurrentRoom().toString();
    }




    /**
     * Returns an end message printed after the game's over
     */
    @Override
    public String getEndMessage() {
        return reportColor + bold + "Gratulujeme!" + reset + "\n" +
                "\n" +
                "Po dlouhé a nebezpečné cestě jsi nakonec porazil " + enemyColor + "Vorthrax" + reset + " a zachránil princeznu " + friendColor + "Elaru" + reset + ".\n" +
                "Když jsi přivedl princeznu zpět do bezpečí, " + friendColor + "král Aldemar" + reset + " tě přijal jako svého hrdinu a díky tobě se jeho království opět vrátilo do klidu.\n" +
                "\n" +
                "Vítězství nad " + enemyColor + "Vorthraxem" + reset + " se stalo legendou, kterou budou vyprávět generace. Tvá odvaha a síla zachránily království a zůstaneš navždy v paměti všech.\n" +
                "\n" +
                "Tvá hra skončila, ale tvá legenda pokračuje.\n" +
                reset;
    }


    @Override
    public String deathEndMessage() {
        return reportColor + bold + "Konec hry!" + reset + "\n" +
                "\n" + italic+
                "Bohužel, tvé dobrodružství skončilo. Zabil tě " + enemyColor + this.gameData.getCurrentRoom().getEnemy().getName() + italic + ".\n" +
                "Princezna " + friendColor + "Elara" + italic + " byla opuštěna v temných horách, bez tebe není nikdo, kdo by ji zachránil.\n" +
                "Tvá smrt se stala varováním pro ostatní. Tvé jméno bude vzpomínáno v příbězích o odvážných, kteří selhali.\n" +
                "\n" +
                "Tvá legenda bude žít dál jako varování pro všechny budoucí hrdiny.\n" +
                reset;
    }


    @Override
    public String processTextCommand(String line) {
        //TODO Process the command and arguments and fill where needed.
        String result;
        String[] args = line.split(" ");
        Command command = commands.getOrDefault(args[0], null);
        if (command != null) {
            result = command.execute(args, gameData);
        } else {
            result = "Neznamy prikaz, zkus jiny nebo pouzij prikaz 'napoveda'";
        }
        return result;
    }

    @Override
    public String settingUpHero() {
        return  reportColor +"Zvol si jméno hrdiny: " + reset;
    }

    /**
     * Delegates its call to the mutable GameData instance, which holds the current game state. This
     * state should be checked after each command evaluation a possibly terminate the whole app if
     * true is returned
     */
    @Override
    public boolean isFinished() {
        if (gameData.getHero().isAlive()) {
            this.gameData.setFinished(false);
        }
        return gameData.isFinished();
    }

    public boolean heroIsAlive() {
        return gameData.getHero().isAlive();
    }

    public void setName(String name) {
        gameData.getHero().setName(name);
    }

}
