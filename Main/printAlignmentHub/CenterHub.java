package Main.printAlignmentHub;

public class CenterHub {

    public CenterHub() { }

    public static int consoleWidth = 150;

    // User-defined function to print any text centered
    public static void printCenteredText(String text) {
        String[] lines = text.split("\n"); // split text into lines
        for (String line : lines) {
            printCentered(line, consoleWidth);      // call the centering helper for each line
        }
    }

    public static void printRightText(String text) {
        String[] lines = text.split("\n"); // split text into lines
        for (String line : lines) {
            printRightAligned(line, consoleWidth);      // call the right-aligning helper for each line
        }
    }

    // Helper function to center a single line
    public static void printCentered(String text, int width) {
        if (text.length() >= width) {
            System.out.println(text);
            return;
        }
        int leftPadding = (width - text.length()) / 2;
        String padding = " ".repeat(leftPadding);
        System.out.println(padding + text);
    }

    public static void printRightAligned(String text, int width) {
    if (text.length() >= width) {
        System.out.println(text); // too long, just print normally
        return;
    }
    int leftPadding = width - text.length(); // spaces to push text to the right
    String padding = " ".repeat(leftPadding);
    System.out.println(padding + text);
    }   
}