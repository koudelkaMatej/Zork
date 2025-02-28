package cz.spskladno.zork.command;
import static cz.spskladno.zork.game.AnsiChars.*;
import cz.spskladno.zork.game.GameData;

import java.util.Map;

public class HelpCommand implements Command {

    private Map<String, Command> commands;
    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "napoveda";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return "Napsal jsi prikaz pro napovedu. Seznam prikazu: " + napovedaColor + commands.keySet() + "\u001B[0m";
    }
}

