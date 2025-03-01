package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Room;
import static cz.spskladno.zork.game.AnsiChars.*;
import java.util.Arrays;

public class GoCommand implements Command {
    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String roomName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));

        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);
        if (exitByName == null) {
            return "Neexistujici vychod";
        }
        if (exitByName.isLocked()) {
            return "Vychod je zamcen. Najdi klíč";
        }
        gameData.setCurrentRoom(exitByName);
        return gameData.getCurrentRoom().toString();
    }
}

