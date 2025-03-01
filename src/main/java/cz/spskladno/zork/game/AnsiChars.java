package cz.spskladno.zork.game;

public class AnsiChars {
    // Definice barev
    public static String bold = "\u001B[1m"; // bold
    public static String italic = "\u001B[38;5;218m\u001B[3m"; // italic
    public static String reset = "\u001B[0m"; // reset styling
    public static String enemyColor = "\u001B[31m";  // Red text
    public static String friendColor = "\u001B[32m"; // Green text
    public static String roomNameColor = "\033[93m";
    public static String roomColor = "\u001B[33m"; // Yellow text
    public static String descriptionColor = "\u001B[34m";   // Blue text
    public static String reportColor = "\u001B[35m"; // Magenta text
    public static String itemColor = "\u001B[36m";   // Cyan text
    public static String napovedaColor = "\u001B[38;5;214m"; // oranžová barva
    public static String whiteColor = "\u001B[37m";  // White text
    public static String resetColor = "\u001B[39m"; // Reset to default text color
    public static String heartANSI = "\u2764\uFE0F"; // ❤️ (hezké srdíčko)
    public static String attackTwoSwordANSI = "\u2694\uFE0F"; // ⚔️ (jeden meč)
    public static String attackOneSwordANSI = "\uD83D\uDDE1\uFE0F"; // 🗡️ (dva meče)
    public static String defenseANSI = "\uD83D\uDEE1\uFE0F"; // 🛡️ (štít)
    public static String levelANSI = "\uD83D\uDD3C";  // 🔼 (nahoru)
    public static String experienceANSI = "\u2B50"; // 🌟 (hvězda)
    public static String backpackANSI = "\uD83D\uDCBC"; // 🎒💼 (batoh)
    public static String ringANSI = "\uD83D\uDC8D"; // 💍 (prsten)
    public static String potionANSI = "\uD83C\uDF77"; // 🍷 (lektvar)
    public static String utokANSI = "\uD83C\uDFF9"; // 🏹 (luk a šípy)
    public static String hammerANSI = "\uD83D\uDD28"; // ⚒️ (kladivo)
    public static String chestPieceANSI = "\uD83D\uDC55"; // 🛡👕 (štít)
    public static String shieldANSI = "\uD83D\uDEE1\uFE0F"; // 🛡👕 (štít)
    public static String keyANSI = "\uD83D\uDD11"; // 🔑 (klíč)
    public static String questANSI = "\uD83D\uDCDC"; // 📜 (svitek)
    public static String miscANSI = "\uD83C\uDF81"; // 🎁 (diamant)
    public static String typeANSI = "\uD83D\uDCDA"; // 📚
    public static String criticalANSI = "\uD83D\uDCA5"; // 💥
    public static String weightANSI = "\uD83D\uDCAA"; //
    public static String helmetANSI = "\uD83E\uDE96"; // 🪖
    public static String legsANSI = "\uD83D\uDC56"; // 👖
}