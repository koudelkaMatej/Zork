package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;
import cz.spskladno.zork.game.Items.Item;

import java.util.Arrays;
import static cz.spskladno.zork.game.AnsiChars.*;

public class DistributeAPCommand implements Command {
    @Override
    public String getName() {
        return "zvys";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (gameData.getHero().getSkillPoints() <= 0) {
            return "Nemáš dostatek skill/ability pointů!";
        }

        if (arguments.length < 2) {
            return "Musíš zadat atribut, do kterého chceš přidat skill point! " + reportColor + "Můžeš zadat: str, vit, sta, int, dex, cha, agi, lck, spd" + resetColor;
        }

        String atributeName = String.join(" ", Arrays.copyOfRange(arguments, 1, arguments.length)).toLowerCase();

        switch (atributeName) {
            case "str", "s" -> gameData.getHero().setBonusStrength(gameData.getHero().getBonusStrength() + 1);
            case "vit", "v" -> gameData.getHero().setBonusVitality(gameData.getHero().getBonusVitality() + 1);
            case "sta", "st" -> gameData.getHero().setBonusStamina(gameData.getHero().getBonusStamina() + 1);
            case "int", "i" -> gameData.getHero().setBonusIntelligence(gameData.getHero().getBonusIntelligence() + 1);
            case "dex", "d" -> gameData.getHero().setBonusDexterity(gameData.getHero().getBonusDexterity() + 1);
            case "cha", "c" -> gameData.getHero().setBonusCharisma(gameData.getHero().getBonusCharisma() + 1);
            case "agi", "a" -> gameData.getHero().setBonusAgility(gameData.getHero().getBonusAgility() + 1);
            case "lck", "l" -> gameData.getHero().setBonusLuck(gameData.getHero().getBonusLuck() + 1);
            case "spd", "speed" -> gameData.getHero().setBonusSpeed(gameData.getHero().getBonusSpeed() + 1);
            default -> {
                return "Neznámý atribut!";
            }
        }

        gameData.getHero().setSkillPoints(gameData.getHero().getSkillPoints() - 1);
        gameData.getHero().updateStats();
        return "Skill point přidán do: " + atributeName;
    }
}

