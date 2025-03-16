package cz.spskladno.zork.game.Items;

import lombok.Getter;
import lombok.Setter;

import static cz.spskladno.zork.game.AnsiChars.*;

@Setter @Getter
public class ItemFlyweight {
    private ItemTypes type;
    public ItemFlyweight(ItemTypes type) {
        this.type = type;
    }

    public String getItemType() {
        return switch (type) {
            case POTION -> potionANSI;
            case RING -> ringANSI;
            case AMULET -> amuletANSI;
            case SHIELD -> shieldANSI;
            case CHEST_PIECE -> chestPieceANSI;
            case BELT -> beltANSI;
            case BOOTS -> bootsANSI;
            case GLOVES -> glovesANSI;
            case HELMET -> helmetANSI;
            case GREAVES -> greavesANSI;
            case TWO_HANDED_WEAPON -> attackTwoSwordANSI;
            case WEAPON -> attackOneSwordANSI;
            case KEY -> keyANSI;
            case QUEST -> questANSI;
            default -> miscANSI;
        };
    }
}
