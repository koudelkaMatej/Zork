package cz.spskladno.zork.game;

public interface Game {
    String getWelcomeMessage();

    String getEndMessage();

    boolean isFinished();

    String deathEndMessage();

    String processTextCommand(String line);

    String settingUpHeroNameText();

    void settingUpHeroName(String command);

    String settingUpHeroClassText();

    void settingUpHeroClass(String command);

    String getHeroJobText();
    void setHeroStartingStats();
    boolean heroIsAlive();
    boolean hasGiveUp();

    String getGiveUpMessage();
}
