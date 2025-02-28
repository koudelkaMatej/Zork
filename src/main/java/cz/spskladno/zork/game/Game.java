package cz.spskladno.zork.game;

public interface Game {
    String getWelcomeMessage();

    //String deathEndMessage(Enemy enemy);

    String getEndMessage();

    boolean isFinished();

    String processTextCommand(String line);
}
