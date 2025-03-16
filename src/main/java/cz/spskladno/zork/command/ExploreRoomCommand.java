package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
public class ExploreRoomCommand implements Command{
    public String getName() {
        return "prozkoumej";
    }
    public String execute(String[] arguments, GameData gameData) {
        return gameData.getCurrentRoom().toString();

    }
}
