package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;

public class EndCommand implements Command {
    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true);
        gameData.setGivenUp(true);
        return "";
    }
}

