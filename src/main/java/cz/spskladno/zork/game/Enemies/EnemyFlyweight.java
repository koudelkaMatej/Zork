package cz.spskladno.zork.game.Enemies;

import cz.spskladno.zork.game.Items.Item;

public class EnemyFlyweight {
    private String type;



    public EnemyFlyweight(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "EnemyFlyweight{" +
                "type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
