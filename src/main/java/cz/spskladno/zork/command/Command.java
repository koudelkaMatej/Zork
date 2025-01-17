package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;

public interface Command {
    String getName();

    String execute(String[] arguments, GameData gameData);
}
