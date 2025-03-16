package cz.spskladno.zork.command;

import cz.spskladno.zork.game.Enemies.Enemy;
import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;

import static cz.spskladno.zork.game.AnsiChars.itemColor;
import static cz.spskladno.zork.game.AnsiChars.resetColor;

public class AttackCommand implements Command {
    @Override
    public String getName() {
        return "utok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String enemyName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length));
        if (gameData.getCurrentRoom().getEnemies() == null || !gameData.getCurrentRoom().containLiveEnemies()) {
            gameData.getHero().selfBurn();
        }
        else{
            if (arguments.length == 1 && gameData.getCurrentRoom().containLiveEnemies()) {
                for (Enemy enemy : gameData.getCurrentRoom().getEnemies()) {
                    gameData.getHero().attack(enemy);
                    if (enemy.isAlive()) {
                        enemy.attack(gameData.getHero());
                    }
                    else {
                        for (Item item : enemy.getLoot()) {
                            gameData.getCurrentRoom().addItem(item);
                        }
                        gameData.getCurrentRoom().removeEnemy(enemy);
                    }
                }
            }
            if (arguments.length > 1 && gameData.getCurrentRoom().containLiveEnemies()) {
                Enemy utokNaEnemy = gameData.getCurrentRoom().getEnemyByName(enemyName);
                if (utokNaEnemy != null && utokNaEnemy.isAlive()) {
                    gameData.getHero().attack(gameData.getCurrentRoom().getEnemyByName(enemyName));
                    if (gameData.getCurrentRoom().getEnemyByName(enemyName).isAlive()) {
                        gameData.getCurrentRoom().getEnemyByName(enemyName).attack(gameData.getHero());
                    }
                    else{
                        for (Item item : gameData.getCurrentRoom().getEnemyByName(enemyName).getLoot()) {
                            gameData.getCurrentRoom().addItem(item);
                            System.out.println("V místnosti se objevil předmět: " + itemColor + item.getName() + resetColor) ;
                        }
                        gameData.getCurrentRoom().removeEnemy(gameData.getCurrentRoom().getEnemyByName(enemyName));
                    }
                }
                else {
                    System.out.println("Tento nepřítel tu není nebo je mrtvý.");
                }
            }
            else{
                gameData.getHero().selfBurn();
            }
        }


        return "";
    }
}

