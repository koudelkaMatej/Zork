package cz.spskladno.zork.game;

public interface Game {
    String getWelcomeMessage();

    String deathEndMessage();

    String getEndMessage();

    boolean isFinished();

    String processTextCommand(String line);

    String settingUpHero();

    void setName(String s);

    boolean heroIsAlive();
}
