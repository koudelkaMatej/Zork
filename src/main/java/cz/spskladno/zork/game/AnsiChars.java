package cz.spskladno.zork.game;

public class AnsiChars {
    // Definice barev
    public static String bold = "\u001B[1m"; // bold
    public static String italic = "\u001B[38;5;218m\u001B[3m"; // italic
    public static String reset = "\u001B[0m"; // reset styling
    public static String resetColor = "\u001B[39m"; // Reset to default text color


    public static String enemyColor = "\u001B[31m";  // Red text
    public static String friendColor = "\u001B[32m"; // Green text
    public static String statsCategoryColor = "\u001B[33m"; // Yellow text
    public static String statsColor = "\u001B[34m"; // Blue text
    public static String roomNameColor = "\033[93m";
    public static String exitColor = "\u001B[38;5;94m"; // Yellow text
    public static String descriptionColor = "\u001B[34m";   // Blue text
    public static String reportColor = "\u001B[35m"; // Magenta text
    public static String itemColor = "\u001B[36m";   // Cyan text
    public static String napovedaColor = "\u001B[38;5;214m"; // oranžová barva
    public static String whiteColor = "\u001B[37m";  // White text


    //basic stats of heroes ANSI
    public static String nameANSI = "\uD83E\uDEB6"; // 📜🪶 (svitek)
    public static String vitalityANSI = "\uD83D\uDC96"; // 💖 (srdíčko)
    public static String staminaANSI = "\uD83D\uDD0B"; //  ⚡\u26A1 🛌💛🔋 (hvězdička)
    public static String strengthANSI = "\uD83D\uDCAA"; // 💪
    public static String luckANSI = "\uD83C\uDF40"; // 🍀
    public static String intelligenceANSI = "\uD83E\uDDE0"; // 📖🧠
    public static String agilityANSI = "\uD83C\uDFC3"; //🐌 🏃🕊️ bird
    public static String charismaANSI = "\uD83D\uDE0E"; // 😎
    public static String dexterityANSI = "\uD83D\uDD28";// ⚒️ //
    public static String skillPointsANSI = "\uD83C\uDFB2"; //🎲🏅🔬

    //stats of heroes ANSI
    public static final String healthRedANSI = "\033[91m";   // Low HP
    public static final String healthYellowANSI = "\033[93m"; // Medium HP
    public static final String healthGreenANSI = "\033[92m"; // High HP
    public static String healthANSI = "\u2764\uFE0F"; // ❤️ (hezké srdíčko)
    public static String attackANSI = "\uD83D\uDDE1\uFE0F"; // 👊 (meč)
    public static String defenseANSI = "\uD83D\uDEE1\uFE0F"; // 🛡️ (štít)
    public static String levelANSI = "\uD83D\uDD3C";  // 🔼 (nahoru)
    public static String experienceANSI = "\u2B50"; // 🌟 (hvězda)
    public static String backpackANSI = "\uD83D\uDCBC"; // 🎒💼 (batoh)
    public static String equipmentANSI = "⚙️"; // ⚙️(výbava)
    public static String criticalChanceANSI = "\uD83D\uDCA5"; // 💥
    public static String speedANSI = "\uD83D\uDC0C"; // 🐌

    //items ANSI
    public static String attackTwoSwordANSI = "\u2694\uFE0F"; // ⚔️ (jeden meč)
    public static String attackOneSwordANSI = "\uD83D\uDDE1\uFE0F"; // 🗡️ (dva meče)
    public static String helmetANSI = "\uD83E\uDE96"; // 🪖
    public static String chestPieceANSI = "\uD83D\uDC55"; // 🛡👕 (brnění)
    public static String shieldANSI = "\uD83D\uDEE1\uFE0F"; // 🛡🛡️ (štít)
    public static String glovesANSI = "\uD83E\uDDE4"; //🧤
    public static String beltANSI = "\uD83C\uDFC1"; // 🏁 (opasek)
    public static String greavesANSI = "\uD83D\uDC56"; // 👖
    public static String bootsANSI = "\uD83E\uDD7E"; // 🥾 (boty)
    public static String ringANSI = "\uD83D\uDC8D"; // 💍 (prsten)
    public static String ringANSI2 = "\033[48;5;34m\uD83D\uDC8D\033[0m"; // 💍 (prsten)
    public static String potionANSI = "\uD83C\uDF77"; // 🍷 (lektvar)
    public static String keyANSI = "\uD83D\uDD11"; // 🔑 (klíč)
    public static String questANSI = "\uD83D\uDCDC"; // 📜 (svitek)
    public static String miscANSI = "\uD83C\uDF81"; // 🎁 (diamant)
    public static String typeANSI = "\uD83D\uDCDA"; // 📚
    public static String amuletANSI = "\uD83C\uDFC5"; // 💎🏅💠💐🪞 (náhrdelník)



    public static String weightANSI = "\uD83D\uDCAA"; //💪
    public static String lootANSI = "\uD83D\uDCB0"; // 🏆💰🎁

    //classes of heroes ANSI

    public static String warriorANSI = "\uD83E\uDE93"; // 🪓 (Shield)
    public static String mageANSI = "\uD83E\uDDD9"; // 🧙 (Mage)
    public static String rogueANSI = "\uD83E\uDD77"; //  🥷️ (Dagger)
    public static String paladinANSI = "\uD83D\uDD06"; // 🔆 (Crossed Swords)
    public static String priestANSI = "\uD83D\uDE4F"; // 🙏👼⛪️ (Praying Hands)
    public static String hunterANSI = "\uD83C\uDFAF"; // 🎯 (Bow and Arrow)
    public static String warlockANSI = "\u2620"; // ☠️ (Skull)
    public static String druidANSI = "\uD83C\uDF31"; // 🌿🌳 (Herb)
    public static String clownANSI = "\uD83E\uDD21"; // 🤡 (Clown Face)

    //enemies categories ANSI
    public static String minionANSI = "\u001B[32m\uD83E\uDD8B"; // 🦋 (Green Skull)
    public static String eliteANSI = "\033[95m\uD83E\uDDCC"; // 🧌 (Orange Imp)
    public static String bossANSI = "\u001B[31m\uD83D\uDC09"; // 🐉 (Red Dragon)
    public static String normalANSI = "\033[33m\uD83D\uDC3A"; // 🐺 (Yellow Crown)
    public static String bossColorANSI = "\u001B[31m";  //🔴  Red text
    public static String eliteColorANSI = "\033[95m"; // Orange text
    public static String normalColorANSI = "\033[33m"; // Blue text
    public static String minionColorANSI = "\033[32m";   // Green text

    //map ANSI
    //🐺💎
}
