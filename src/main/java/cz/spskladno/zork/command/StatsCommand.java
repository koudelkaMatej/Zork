package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Room;
public class StatsCommand implements Command{
    public String getName() {
        return "staty";
    }
    public String execute(String[] arguments, GameData gameData) {
        return gameData.getHero().toString();
    }
}
