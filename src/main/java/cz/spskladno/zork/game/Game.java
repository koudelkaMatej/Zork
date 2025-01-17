package cz.spskladno.zork.game;

public interface Game {
    String getWelcomeMessage();

    String getEndMessage();

    boolean isFinished();

    String processTextCommand(String line);
}
