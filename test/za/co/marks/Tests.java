package za.co.marks;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.*;
import org.junit.Test;
import za.co.marks.util.Utility;
import static za.co.marks.util.Utility.displayData;
import static za.co.marks.util.Utility.removeSpecialCharactrers;

public class Tests {

    Words wordObject = new Words();

    @Test
    public void readFileTest() throws IOException {
        assertEquals("Platon made bamboo boats.", wordObject.readFile());
    }

    @Test
    public void getWordsIntoArrayTest() {
        String[] words = wordObject.getWordsIntoArray("Platon made bamboo boats", " ");
        String result = "";
        for (String word : words) {
            result += word + " ";
        }
        assertEquals("Platon made bamboo boats ", result);
    }

    @Test
    public void removeSpecialCharactrersTest() {
        assertEquals("Platon made bamboo boats", Utility.removeSpecialCharactrers("Platon made bamboo boats."));
    }

    @Test
    public void computeAverageForVowelsTest() {
        assertEquals(3.0f, wordObject.computeAverageForVowels(6, 2), 0.0f);
    }

    @Test
    public void getUniqueCharactersTest() {
        Set<Character> characters = new TreeSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('o');
        assertEquals(characters, wordObject.getUniqueCharacters("Platon made bamboo boats".toCharArray()));
    }

    @Test
    public void writeToFileTest() {
        String outputStr = "";
        for (String dataStr : wordObject.getWordsIntoArray("Platon made bamboo boats.", " ")) {
            char[] vowelsArray = dataStr.toCharArray();
            String cleanData = removeSpecialCharactrers(dataStr);
            int wordLength = cleanData.length();

            int number = wordObject.getUniqueCharacters(vowelsArray).size();
            if (number > 0) {
                outputStr += "{" + wordObject.getUniqueCharacters(vowelsArray) + "}, " + wordLength + ") -> " + wordObject.computeAverageForVowels(wordLength, number) + "\n";
                displayData(wordObject.getUniqueCharacters(vowelsArray), wordLength, wordObject.computeAverageForVowels(wordLength, number), cleanData);
            }
        }
        assertEquals("{[a, o]}, 6) -> 3.0\n"
                + "{[a, e]}, 4) -> 2.0\n"
                + "{[a, o]}, 6) -> 3.0\n"
                + "{[a, o]}, 5) -> 2.5\n", outputStr);
    }
}
