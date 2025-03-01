package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.GameImpl;

public class EndCommand implements Command {
    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true);
        return "Záchranu princezny jsi vzdal! Jsi ostudou všech hrdinů.";
    }
}

