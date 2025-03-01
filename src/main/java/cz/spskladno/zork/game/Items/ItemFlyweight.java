package cz.spskladno.zork.game.Items;
import static cz.spskladno.zork.game.AnsiChars.*;

public class ItemFlyweight {
    private ItemTypes type;
    private String name;

    public ItemFlyweight(ItemTypes type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Nová metoda pro přiřazení vzhledu podle typu předmětu
    public String getItemType() {
        switch (type) {
            case POTION:
                return potionANSI;
            case HELMET:
                return helmetANSI;
            case LEGS:
                return legsANSI;
            case TwoHANDED_WEAPON:
                return attackTwoSwordANSI;
            case WEAPON:
                return attackOneSwordANSI;
            case ARMOR:
                return shieldANSI;
            case KEY:
                return keyANSI;
            case QUEST:
                return questANSI;
            default:
                return miscANSI;
        }
    }
}
