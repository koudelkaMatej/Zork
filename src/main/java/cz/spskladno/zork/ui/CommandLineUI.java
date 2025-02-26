package cz.spskladno.zork.ui;

import cz.spskladno.zork.game.Game;
import cz.spskladno.zork.game.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CommandLineUI {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUI.class);
    private static CommandLineUI INSTANCE = new CommandLineUI();
    private Game game = new GameImpl();

    public CommandLineUI() {
    }

    public void start() {
        log.info("Application started.");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(this.game.getWelcomeMessage());
            while (!this.game.isFinished()) {
                System.out.print("> ");
                System.out.println(this.game.processTextCommand(scanner.nextLine()));
            }
            System.out.println(this.game.getEndMessage());
        }
    }

    public static CommandLineUI getInstance() {
        return INSTANCE;
    }
}
