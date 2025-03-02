package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;
import cz.spskladno.zork.game.Room;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Arrays;

public class StatsCommand implements Command {
    public String getName() {
        return "staty";
    }

    public String execute(String[] arguments, GameData gameData) {
        //if staty obsahuji slovo hrdina
        String itemName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));
        if (arguments.length == 1) {
            return gameData.getHero().toString();
        }
        else if (arguments.length > 0 && arguments[1].equals("hrdina")) {
            return gameData.getHero().toString();
        }
        else if (arguments.length > 0 && arguments[1].equals("nepritel")) {
            return gameData.getCurrentRoom().getEnemy().toString();
        }
        //if staty obsahuji název předmětu
        else if (arguments.length > 0 && gameData.getHero().getInventory().getItemByName(itemName) != null) {
            return String.valueOf(gameData.getHero().getInventory().getItemByName(itemName));
        }
        else if(arguments.length > 0 && gameData.getCurrentRoom().getItemByName(itemName) != null) {
            return String.valueOf(gameData.getCurrentRoom().getItemByName(itemName));
        }
        else{
            return "Takový předmět tu nikde není.";
        }
    }
}
