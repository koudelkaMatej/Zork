package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;

public class ResetCommand implements Command {
    @Override
    public String getName() {
        return "reset";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.init();
        return "Resetoval jsi hru.";
    }
}

