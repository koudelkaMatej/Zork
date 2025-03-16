package cz.spskladno.zork.game.Enemies;

import static cz.spskladno.zork.game.AnsiChars.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnemyFlyweight {
    private String type;
    private String difficulty;



    public EnemyFlyweight(String type, EnemyDifficultyCategories difficulty) {
        this.type = type;
        switch (difficulty){
            case MINION:
                this.difficulty = minionANSI;
                break;
            case ELITE:
                this.difficulty = eliteANSI;
                break;
            case BOSS:
                this.difficulty = bossANSI;
                break;
            default:
                this.difficulty = normalANSI;
        }
    }


    @Override
    public String toString() {
        return "EnemyFlyweight{" +
                "type='" + type + '\'' +
                '}';
    }


}
