package cz.spskladno.zork.command;

import cz.spskladno.zork.game.GameData;

public class MapCommand implements Command {
    @Override
    public String getName() {
        return "mapa";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.init();
        return """
                                              _________
                                             /         \\
                                            /           \\
                                           |   CAVE 1    |
                                           |     |       |       ________________
                                           |_____|       |      |                |
                                                 |       |______|    CAVE 3      |
                                                 |        _______________________|
                                              ___|__   __|___
                                             |               |
                                             |    CAVE 2     |
                                             |_____     _____|
                                                 |       |
                               __________________|__   __|____________________
                              |                                               |______
                              |                   CAVE 4                       ___   |
                              |_______    ____________    ___________     ____|   |  |
                                      |  |            |  |           |   |        |  |
                                      |  |            |  |           |   |        |  |
                    ________       ___|  |_____    ___|  |____     __|   |____    |  |
                   |        |_____|           |   |           |   |           |   |  |
                   | CAVE 5  _____  CAVE 6    |   |  CAVE 7   |   |  CAVE 8   |   |  |
                   |________|     |___     ___|   |____    ___|   |___    ____|   |  |
                                      |   |            |  |           |  |        |  |
                                   ___|   |____    ____|  |___________|  |____    |  |
                                  |           |   |                           |   |  |
                                  |  CAVE 9   |   |      LARGE CAVE 10        |   |  |
                                  |___________|   |____    ___________    ____|   |  |
                                                       |  |           |  |        |  |
                          _________            ________|  |___    ____|  |____    |  |
                         |         |__________|               |   |           |___|  |
                         | CAVE 11  __________   CAVE 12      |   |  CAVE 13   ______|
                         |_________|          |_______________|   |___________|
                
                """;
    }
}

