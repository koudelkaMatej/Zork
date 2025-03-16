package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;

public class DropCommand implements Command {
    @Override
    public String getName() {
        return "poloz";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));
        Item item = gameData.getHero().getInventory().getItemByName(itemName);
        if (item == null) {
            item = gameData.getHero().getEquipment().getItemByName(itemName);
            if (item == null) {
                return "Tento předmět hrdina nemá v batohu ani na sobě.";
            }
            gameData.getHero().unEquipItem(item);
            gameData.getCurrentRoom().addItem(item);
        }
        else{
            gameData.getHero().removeFromInventory(item);
            gameData.getCurrentRoom().addItem(item);
        }


        return gameData.getCurrentRoom().toString();
    }
}

