package za.co.marks.util;

import java.util.Set;

public class Utility {

    public static String removeSpecialCharactrers(String word) {
        return word.replaceAll("[-+.^:,]", "");
    }

    public static void displayData(Set<Character> vowels, int wordLength, float average, String data) {
        System.out.println("Word: " + data);
        System.out.println("Unique chars: " + vowels);
        System.out.println("String length: " + wordLength);
        System.out.println("Average: " + average);
        System.out.println("===================================");
    }
}
