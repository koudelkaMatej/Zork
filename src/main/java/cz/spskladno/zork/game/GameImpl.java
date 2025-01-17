package cz.spskladno.zork.game;

import cz.spskladno.zork.command.Command;
import cz.spskladno.zork.command.GoCommand;
import cz.spskladno.zork.command.HelpCommand;
import cz.spskladno.zork.command.ResetCommand;

import java.util.HashMap;
import java.util.Map;

/**
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
        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
    }

    /**
     * Returns a welcome message printed after the game's start
     */
    @Override
    public String getWelcomeMessage() {
        return "Hra zacala. Pokus nevis co mas delat, \n" +
                "pouzij prikaz 'napoveda' \n"
                + gameData.getCurrentRoom().getDescription();
    }

    /**
     * Returns an end message printed after the game's over
     */
    @Override
    public String getEndMessage() {
        return "Konec hry";
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
            result = command.execute(null, gameData);
        } else {
            result = "Neznamy prikaz, zkus jiny nebo pouzij prikaz 'napoveda'";
        }
        return result;
    }

    /**
     * Delegates its call to the mutable GameData instance, which holds the current game state. This
     * state should be checked after each command evaluation a possibly terminate the whole app if
     * true is returned
     */
    @Override
    public boolean isFinished() {
        return gameData.isFinished();
    }
}
