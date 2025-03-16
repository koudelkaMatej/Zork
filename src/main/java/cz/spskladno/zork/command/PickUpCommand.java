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
        if (gameData.getCurrentRoom().getEnemies().isEmpty()) {
            gameData.getHero().addToInventory(item);
            gameData.getCurrentRoom().removeItem(item);
        } else if (!gameData.getCurrentRoom().getEnemies().isEmpty() && gameData.getCurrentRoom().getEnemies().size() > 1) {
            System.out.println("Snažil jsi se sebrat předmět, ale než se ti to podařilo, tak tě všichni v místnosti zranili.");
            gameData.getCurrentRoom().allEnemiesAttack(gameData.getHero());
        } else if (!gameData.getCurrentRoom().getEnemies().isEmpty() && gameData.getCurrentRoom().getEnemies().size() == 1) {
            System.out.println("Snažil jsi se sebrat předmět, ale než se ti to podařilo, tak tě nepřítel zranil.");
            gameData.getCurrentRoom().allEnemiesAttack(gameData.getHero());
            return "";
        }
        return "";
    }
}

