package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;

public class PickUpCommand implements Command {
    @Override
    public String getName() {
        return "seber";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));
        Item item = gameData.getCurrentRoom().getItemByName(itemName);
        if (item == null) {
            return "Tento predmet tu neni.";
        }
        gameData.getHero().addToInventory(item);
        gameData.getCurrentRoom().removeItem(itemName);


        return gameData.getCurrentRoom().toString();
    }
}

