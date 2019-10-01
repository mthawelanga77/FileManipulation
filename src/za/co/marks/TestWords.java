package za.co.marks;

import java.io.IOException;
import static za.co.marks.util.Utility.*;

public class TestWords {

    public static void main(String[] args) {
        Words wordObject = new Words();
        String outputStr = "";
        try {
            String data = wordObject.readFile();
            for (String dataStr : wordObject.getWordsIntoArray(data, " ")) {
                char[] vowelsArray = dataStr.toCharArray();
                String cleanData = removeSpecialCharactrers(dataStr);
                int wordLength = cleanData.length();

                int number = wordObject.getUniqueCharacters(vowelsArray).size();
                if (number > 0) {
                    outputStr += "{" + wordObject.getUniqueCharacters(vowelsArray) + "}, " + wordLength + ") -> " + wordObject.computeAverageForVowels(wordLength, number) + "\n";
                    displayData(wordObject.getUniqueCharacters(vowelsArray), wordLength, wordObject.computeAverageForVowels(wordLength, number), cleanData);
                }
            }
            wordObject.writeToFile(outputStr, "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
