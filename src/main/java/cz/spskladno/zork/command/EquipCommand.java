package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;

public class EquipCommand implements Command {
    @Override
    public String getName() {
        return "oblec";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));
        Item item = gameData.getCurrentRoom().getItemByName(itemName);
        if (item != null) {
            if (gameData.getCurrentRoom().getEnemies().isEmpty()) {
                if (item.getClassRestrictions().contains(gameData.getHero().getClassSymbol())) { //checks if the item can be equipped by the hero
                    if (gameData.getHero().getLevel() < item.getLevel()) { //checks if the hero has the required level
                        return "Tento předmět je příliš silný pro tvou úroveň.";
                    }
                    gameData.getHero().equipItem(item);
                    if (gameData.getHero().getEquipment().getItemsMap().containsValue(item)) {
                        gameData.getCurrentRoom().removeItem(item);
                    }
                } else {
                    return "Tento předmět je určený pro jinou třídu hrdiny.";
                }
            }
            else{
                System.out.println("Snažil jsi se obléct předmět, ale než se ti to podařilo, tak tě všichni v místnosti zranili.");
                gameData.getCurrentRoom().allEnemiesAttack(gameData.getHero());
            }
        }
            else {
                item = gameData.getHero().getInventory().getItemByName(itemName);
                if (item != null) {
                    if (gameData.getCurrentRoom().getEnemies().isEmpty()) {
                        if (item.getClassRestrictions().contains(gameData.getHero().getClassSymbol())) { //checks if the item can be equipped by the hero
                            if (gameData.getHero().getLevel() < item.getLevel()) { //checks if the hero has the required level
                                return "Tento předmět je příliš silný pro tvou úroveň.";
                            }
                            gameData.getHero().equipItem(item);
                            if (gameData.getHero().getEquipment().getItemsMap().containsValue(item)) {
                                gameData.getHero().getInventory().removeItem(item);
                            }
                        } else {
                            return "Tento předmět je určený pro jinou třídu hrdiny.";
                        }
                    }
                    else{
                        System.out.println("Snažil jsi se obléct předmět, ale než se ti to podařilo, tak tě všichni v místnosti zranili.");
                        gameData.getCurrentRoom().allEnemiesAttack(gameData.getHero());
                    }
                }
            }
            return "";
        }
}

