package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;

import java.util.Map;

import static cz.spskladno.zork.game.AnsiChars.*;

public class HelpCommand implements Command {

    private Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "napoveda";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return "Napsal jsi prikaz pro napovedu. Seznam prikazu: " + napovedaColor + commands.keySet() + resetColor + "\n" +
                napovedaColor + "mapa" + resetColor + " - Zobrazí mapu\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "mapa\n" + resetColor +
                napovedaColor + "konec" + resetColor + " - Ukončí hru\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "konec\n" + resetColor +
                napovedaColor + "reset" + resetColor + " - Resetuje hru\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "reset\n" + resetColor +
                napovedaColor + "zvys" + resetColor + " - Zvýší základní hodnoty hráče\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "zvys str   |    zvys s    |   zvys STR\n" + resetColor +
                napovedaColor + "utok" + resetColor + " - Zautocis na všechny nebo vybraného nepřítele\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "utok   |    utok vlk samotář\n" + resetColor +
                napovedaColor + "prozkoumej" + resetColor + " - Prozkoumá aktuální místnost\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "prozkoumej\n" + resetColor +
                napovedaColor + "staty" + resetColor + " - Vypíše vše o nějakém nepřítely hrdinovy či předmětu \t\t\t\t\t\t\tPříklad:" + italic + " staty nepratele   |   staty Přilba osudu   |   staty   |   staty hrdina   |   staty vlk samotář\n" + resetColor +
                napovedaColor + "seber" + resetColor + " - Sebere předmět z aktuální lokace\t\t\t\t\t\t\t\t\t\t\t\tPříklad:" + italic + " seber Přilba osudu\n" + resetColor +
                napovedaColor + "oblec" + resetColor + " - Obleče předmět z aktuální lokace nebo inventáře\t\t\t\t\t\t\t\t\t\t\t\tPříklad:" + italic + " oblec Přilba osudu\n" + resetColor +
                napovedaColor + "poloz" + resetColor + " - Položí předmět z batohu i co má hrdina na sobě do aktuální místnosti'\t\t\tPříklad:" + italic + " poloz Přilba osudu\n" + resetColor +
                napovedaColor + "jdi" + resetColor + " - Přemístí hrdinu do jiné místnosti'\t\t\t\t\t\t\t\t\t\t\t\tPříklad: " + italic + "jdi Vstup do jeskyne\n" + resetColor;
    }
}

