package Main.styles.printAlignmentHub;

import Main.styles.animationHub.TypeWriter;
import Main.styles.animationHub.LoadingDots;

public class CenterHub {

    public CenterHub() { }

    private static TypeWriter typeWriter = new TypeWriter();
    private static LoadingDots loadingDots = new LoadingDots();
    private static final String ANSI_REGEX = "\u001B\\[[;\\d]*m";

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

    public static void printRightTextWithTypeWriter(String text) {
        String[] lines = text.split("\n"); // split text into lines
        for (String line : lines) {
            printRightAlignedWithTypeWriter(line, consoleWidth);      // call the right-aligning with typewriter helper for each line
        }
    }

    public static void printCenteredTextWithTypeWriter(String text) {
        String[] lines = text.split("\n"); // split text into lines
        for (String line : lines) {
            int leftPadding = (consoleWidth - line.length()) / 2;
            String padding = " ".repeat(leftPadding);
            System.out.print(padding);
            typeWriter.typeWriterFast(line);
        }
    }

    // Helper function to center a single line
    public static void printCentered(String text, int width) {
        String clean = stripAnsi(text);
        if (clean.length() >= width) {
            System.out.println(clean);
            return;
        }
        int leftPadding = (width - clean.length()) / 2;
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

    public static void printRightAlignedWithTypeWriter(String text, int width) {
        String clean = stripAnsi(text);
        if (clean.length() >= width) {
            System.out.println(clean); // too long, just print normally
            return;
        }
        int leftPadding = width - clean.length(); // spaces to push text to the right
        String padding = " ".repeat(leftPadding);
        System.out.print(padding);
        typeWriter.typeWriterFast(text);
    }

    public static void printCenteredAlignedWithTypeWriter(String text, int width) {
        if (text.length() >= width) {
            typeWriter.typeWriterFast(text);
            return;
        }
        int leftPadding = (width - text.length()) / 2;
        String padding = " ".repeat(leftPadding);
        System.out.print(padding);
        typeWriter.typeWriterMedium(text);
    }

    public static String stripAnsi(String text) {
        return text.replaceAll(ANSI_REGEX, "");
}

}