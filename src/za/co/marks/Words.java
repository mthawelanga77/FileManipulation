package za.co.marks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Set;
import java.util.TreeSet;
import za.co.marks.constants.*;
import static java.lang.Character.toLowerCase;

public class Words {

    public String readFile() throws IOException {
        String data;
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(Constants.FILENAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (reader == null) {
                throw new IOException("There was an error opening an input.txt file.");
            }
            while ((data = reader.readLine()) != null) {
                strBuilder.append(data);
            }
        }
        return strBuilder.toString();
    }

    public String[] getWordsIntoArray(String str, String delimiter) {
        return str.split(delimiter);
    }

    public float computeAverageForVowels(int wordLength, int numberOfUniqueVowels) {
        Constants.FORMAT_NUMBER.setRoundingMode(RoundingMode.UP);
        return (wordLength / Float.parseFloat(Constants.FORMAT_NUMBER.format(numberOfUniqueVowels)));
    }

    public Set<Character> getUniqueCharacters(char[] uniqueChars) {
        Set<Character> uniqueSet = new TreeSet<>();
        for (char c : uniqueChars) {
            if (toLowerCase(c) == 'a' || toLowerCase(c) == 'e' || toLowerCase(c) == 'i' || toLowerCase(c) == 'o' || toLowerCase(c) == 'u') {
                uniqueSet.add(c);
            }
        }
        return uniqueSet;
    }

    public void writeToFile(String output, String delimeter) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILENAME_OUT))) {
            if (writer == null) {
                throw new IOException("There was an opening an output.txt file.");
            }
            for (String str : getWordsIntoArray(output, delimeter)) {
                writer.write(str);
                writer.newLine();
            }
        }
    }
}
