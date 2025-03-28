package cz.spskladno.zork.game;

import cz.spskladno.zork.command.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

/**
 * Represents a running game instance
 */
@Getter @Setter
public class GameImpl implements Game {

    private Map<String, Command> commands = new HashMap<>();
    private GameData gameData;
    private boolean giveUp = false;

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
        EndCommand end = new EndCommand();
        ExploreRoomCommand exploreRoom = new ExploreRoomCommand();
        MapCommand map = new MapCommand();
        PickUpCommand pickUp = new PickUpCommand();
        DropCommand drop = new DropCommand();
        EquipCommand equip = new EquipCommand();
        DistributeAPCommand distribute = new DistributeAPCommand();
        AttackCommand attack = new AttackCommand();
        commands.put(attack.getName(), attack);
        commands.put(distribute.getName(), distribute);
        commands.put(equip.getName(), equip);
        commands.put(drop.getName(), drop);
        commands.put(pickUp.getName(), pickUp);
        commands.put(exploreRoom.getName(), exploreRoom);
        commands.put(map.getName(), map);
        commands.put(end.getName(), end);
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

    @Override
    public String deathEndMessage() {
        return reportColor + bold + "Konec hry!" + reset + "\n" +
                "\n" + italic+ // + enemyColor + this.gameData.getCurrentRoom().getEnemies().getLast().getName()+ italic
                "Bohužel, tvé dobrodružství skončilo. Zabil tě " + enemyColor +  italic + ".\n" +
                "Princezna " + friendColor + "Elara" + italic + " byla opuštěna v temných horách, bez tebe není nikdo, kdo by ji zachránil.\n" +
                "Tvá smrt se stala varováním pro ostatní. Tvé jméno bude vzpomínáno v příbězích o odvážných, kteří selhali.\n" +
                "\n" +
                "Tvá legenda bude žít dál jako varování pro všechny budoucí hrdiny.\n" +
                reset;
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

    public String getGiveUpMessage() {
        return "Záchranu princezny jsi vzdal! Jsi ostudou všech hrdinů.";
    }

    /**
     * Parses input line and should divide its parts to command name
     * and an array of input arguments (0-N). Based on the parsed command's name,
     * a specific command should be looked up and executed. If none is found, a
     * default message should be returned.
     */
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
    public void settingUpHeroName(String s) {
        this.gameData.getHero().setName(s);
    }

    @Override
    public String settingUpHeroNameText() {
        return "Zvol si jméno hrdiny: ";
    }

    @Override
    public void settingUpHeroClass(String s) {
        String selectedClass = getlistOfClasses(s);

        String classANSI = switch (selectedClass) {
            case "Warrior" -> warriorANSI;
            case "Mage" -> mageANSI;
            case "Rogue" -> rogueANSI;
            case "Priest" -> priestANSI;
            case "Paladin" -> paladinANSI;
            case "Hunter" -> hunterANSI;
            case "Warlock" -> warlockANSI;
            case "Druid" -> druidANSI;
            default -> clownANSI;
        };

        // Set the class in the game data
        this.gameData.getHero().setClassSymbol(classANSI);
        this.gameData.getHero().setClassName(selectedClass);

    }

    private static String getlistOfClasses(String s) {
        s = s.toLowerCase();
        Map<String, String> heroClasses = Map.ofEntries(
                Map.entry("1", "Warrior"),
                Map.entry("2", "Mage"),
                Map.entry("3", "Rogue"),
                Map.entry("4", "Priest"),
                Map.entry("5", "Paladin"),
                Map.entry("6", "Hunter"),
                Map.entry("7", "Warlock"),
                Map.entry("8", "Druid"),
                Map.entry("warrior", "Warrior"),
                Map.entry("mage", "Mage"),
                Map.entry("rogue", "Rogue"),
                Map.entry("priest", "Priest"),
                Map.entry("paladin", "Paladin"),
                Map.entry("hunter", "Hunter"),
                Map.entry("warlock", "Warlock"),
                Map.entry("druid", "Druid")
        );

        // Convert the input to lowercase and get the corresponding class or default to "Clown"
        return heroClasses.getOrDefault(s.toLowerCase(), "Clown");
    }

    @Override
    public String settingUpHeroClassText() {
        return "Zvol si třídu hrdiny: \n" +
                "1. " + bold + reportColor + "Warrior" + reset + " - bojovník, který se specializuje na boj s mečem a štítem.\n" +
                "2. " + bold + reportColor + "Mage" + reset + " - kouzelník, který ovládá magii a kouzla.\n" +
                "3. " + bold + reportColor + "Rogue" + reset + " - zloděj, který se specializuje na lstivost a rychlost.\n" +
                "4. " + bold + reportColor + "Priest" + reset + " - kněz, který léčí a ochraňuje své společníky.\n" +
                "5. " + bold + reportColor + "Paladin" + reset + " - paladin, který bojuje za spravedlnost a světlo.\n" +
                "6. " + bold + reportColor + "Hunter" + reset + " - lovec, který se specializuje na střelbu z luku a přírodní magii.\n" +
                "7. " + bold + reportColor + "Warlock" + reset + " - černokněžník, který ovládá démony a temnou magii.\n" +
                "8. " + bold + reportColor + "Druid" + reset + " - druid, který ovládá přírodu a mění se v zvířata.\n";
    }
    @Override
    public String getHeroJobText() {

        return "Tvé jméno je: " + friendColor + this.gameData.getHero().getName() + reset +"\nTvá třída je: "+ napovedaColor + this.gameData.getHero().getClassSymbol() + " " + this.gameData.getHero().getClassName() + reset;
    }

    @Override
    public void setHeroStartingStats(){
        this.gameData.getHero().updateStats();
        this.gameData.getHero().setHealth(this.gameData.getHero().getMaxHealth());
    }

    /**
     * Delegates its call to the mutable GameData instance, which holds the current game state. This
     * state should be checked after each command evaluation a possibly terminate the whole app if
     * true is returned
     */
    @Override
    public boolean isFinished() {
        if (!gameData.getHero().isAlive()) {
            this.gameData.setFinished(true);
        }
        return gameData.isFinished();
    }
    public boolean heroIsAlive() {
        return gameData.getHero().isAlive();
    }

    @Override
    public boolean hasGiveUp() {
        return this.gameData.hasGivenUp();
    }
}
