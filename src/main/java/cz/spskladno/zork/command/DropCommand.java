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
            return "Tento predmet hrdina nemá.";
        }
        gameData.getHero().removeItemFromInventory(item);
        gameData.getCurrentRoom().addItem(item);


        return gameData.getCurrentRoom().toString();
    }
}

