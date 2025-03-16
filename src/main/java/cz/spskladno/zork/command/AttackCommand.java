package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;

public class AttackCommand implements Command {
    @Override
    public String getName() {
        return "utok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (gameData.getCurrentRoom().getEnemy() == null || !gameData.getCurrentRoom().getEnemy().isAlive()) {
            gameData.getHero().selfBurn();

        }
        else{
            gameData.getHero().attack(gameData.getCurrentRoom().getEnemy());
            if (gameData.getCurrentRoom().getEnemy().isAlive()) {
                gameData.getCurrentRoom().getEnemy().attack(gameData.getHero());
            }
            else {
                gameData.getCurrentRoom().removeEnemy(gameData.getCurrentRoom().getEnemy().getName());
            }
        }


        return "";
    }
}

