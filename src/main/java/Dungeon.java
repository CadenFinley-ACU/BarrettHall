
import java.util.ArrayList;
import java.util.List;

/**
 * Dungeon Class
 *
 * Text Adventure Game SE374 F24 Final Project Caden Finley Albert Tucker
 * Grijesh Shrestha
 */
public class Dungeon extends Room {

    public static String currentDungeon;
    public static int completedDungeons = 0;

    public static int[][] meadowDungeon;
    public static int[][] darkForestDungeon;
    public static int[][] mountainCaveDungeon;
    public static int[][] mountainTopDungeon;
    public static int[][] desertOasisDungeon;
    public static int[][] desertPlainsDungeon;
    public static int[][] desertPyramidDungeon;
    public static int[][] oceanKingdomDungeon;

    public static int[] currentPlayerPosition;
    public static boolean previousAutoSettings;

    public static List<String> items = new ArrayList<>();

    public static void generateDungeons() { //generates all 8 dungeons and stores them in their respective variables
        meadowDungeon = DungeonGenerator.generateAndReturnMatrix(5);
        darkForestDungeon = DungeonGenerator.generateAndReturnMatrix(6);
        mountainCaveDungeon = DungeonGenerator.generateAndReturnMatrix(7);
        mountainTopDungeon = DungeonGenerator.generateAndReturnMatrix(7);
        desertOasisDungeon = DungeonGenerator.generateAndReturnMatrix(8);
        desertPlainsDungeon = DungeonGenerator.generateAndReturnMatrix(8);
        desertPyramidDungeon = DungeonGenerator.generateAndReturnMatrix(9);
        oceanKingdomDungeon = DungeonGenerator.generateAndReturnMatrix(10);
    }

    public static void defaultDungeonArgs(String data) throws InterruptedException { //default dungeon arguments
        switch (data) {
            case "leave" -> {
                TextEngine.printWithDelays("Im sorry. You cannot leave right now.", true);
            }
            case "map" -> {
                if (Player.getName().equals("Debug!")) {
                    switch (currentDungeon) {
                        case "Meadow" -> {
                            DungeonGenerator.printMap(meadowDungeon);
                        }
                        case "Dark Forest" -> {
                            DungeonGenerator.printMap(darkForestDungeon);
                        }
                        case "Mountain Cave" -> {
                            DungeonGenerator.printMap(mountainCaveDungeon);
                        }
                        case "Mountain Top" -> {
                            DungeonGenerator.printMap(mountainCaveDungeon);
                        }
                        case "Desert Oasis" -> {
                            DungeonGenerator.printMap(desertOasisDungeon);
                        }
                        case "Desert Plains" -> {
                            DungeonGenerator.printMap(desertPlainsDungeon);
                        }
                        case "Desert Pyramid" -> {
                            DungeonGenerator.printMap(desertPyramidDungeon);
                        }
                        case "Ocean Kingdom" -> {
                            DungeonGenerator.printMap(oceanKingdomDungeon);
                        }
                        //add more dungeons here if needed
                    }
                } else {
                    Main.inGameDefaultTextHandling(data);
                }
            }
            default -> {
                Main.inGameDefaultTextHandling(data);
            }
        }
    }

    public static void resetAll() { //reset all dungeons
        generateDungeons();
        MeadowDungeon.fresh();
        DarkForestDungeon.fresh();
        MountainCaveDungeon.fresh();
        MountainTopDungeon.fresh();
        DesertOasisDungeon.fresh();
        DesertPlainsDungeon.fresh();
        DesertPyramidDungeon.fresh();
        OceanKingdomDungeon.fresh();
    }

    public static void autoCheck() {
        previousAutoSettings = Player.autoFight;
        if (Player.autoFight) {
            Player.autoFight = false;
        }
    }

    public static void addItemsToMiniDungeons(List<String> items) {
        for (String item : items) {
            items.add(item);
        }
    }
}
