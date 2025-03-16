package cz.spskladno.zork.ui;

import cz.spskladno.zork.game.Game;
import cz.spskladno.zork.game.GameImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CommandLineUI {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUI.class);
    private static CommandLineUI INSTANCE;
    private Game game = new GameImpl();

    private CommandLineUI() {
        this.game = new GameImpl();
    }
    // Singleton
    public static synchronized CommandLineUI getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandLineUI();
        }
        return INSTANCE;
    }

    public void start() {
        log.info("Application started.");
        String command = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf(game.settingUpHeroNameText());
            command = scanner.nextLine();
            this.game.settingUpHeroName(command);
            System.out.println(this.game.settingUpHeroClassText());
            command = scanner.nextLine();
            this.game.settingUpHeroClass(command);
            System.out.println(this.game.getHeroJobText());
            this.game.setHeroStartingStats();
            System.out.println(this.game.getWelcomeMessage());
            while (!this.game.isFinished()) {
                System.out.print("> ");
                System.out.println(this.game.processTextCommand(scanner.nextLine()));
                if (this.game.isFinished()) {
                    break;
                }
            }
            if (!this.game.heroIsAlive()) {
                System.out.println(this.game.deathEndMessage());
            } else if (this.game.hasGiveUp()) {
                System.out.println(this.game.getGiveUpMessage());
            } else {
                System.out.println(this.game.getEndMessage());
            }
        }
    }

}
