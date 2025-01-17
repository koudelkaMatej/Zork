package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Room;

public class GoCommand implements Command {
    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {

        String roomName = arguments[1];

        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);
        if (exitByName == null) {
            return "Neexistujici vychod";
        }
        gameData.setCurrentRoom(exitByName);
        return "Presunut do mistnosti " + gameData.getCurrentRoom().getDescriptionWithExits();
    }
}

