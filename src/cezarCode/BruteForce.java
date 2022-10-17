package cezarCode;

import java.util.*;


public class BruteForce extends Coder {
    static int searchKey;
    static int possibleKey;
    static List<Integer> sortedValues = new ArrayList<>();
    static List<Character> sortedLetters = new ArrayList<>();
    static List<Integer> sortedValuesEncoded = new ArrayList<>();
    static List<Character> sortedLettersEncoded = new ArrayList<>();


    public static void searchTheKey(String codedText, String compareText) {
        Map<Character, Integer> decodedLetters = countLetters(codedText);
        Map<Character, Integer> comparedLetter = countLetters(compareText);
        sort(decodedLetters, sortedLettersEncoded, sortedValuesEncoded);
        sort(comparedLetter, sortedLetters, sortedValues);
        searchKey = Math.abs(alphabetLowerCase.indexOf(sortedLetters.get(0))
                     - alphabetLowerCase.indexOf(sortedLettersEncoded.get(0)));
        possibleKey = Math.abs(alphabetLowerCase.indexOf(sortedLettersEncoded.get(0))
                     - alphabetLowerCase.indexOf(sortedLetters.get(1)));
    }

    public static Map<Character, Integer> countLetters(String incomingText) {
        char[] textFromFile = incomingText.toCharArray();
        int counterAllLetters = 0;
        Map<Character, Integer> mapWithCountedLetters = new HashMap<>();

        for (Character c : textFromFile) {
            if (Character.isAlphabetic(c)) {
                counterAllLetters++;
            }
        }

        for (int i = 0; i < alphabetLowerCase.size(); i++) {
            int counter = 0;
            for (char c : textFromFile) {
                if (alphabetLowerCase.get(i).equals(c) ||
                        alphabetUpperCase.get(i).equals(c)) {
                    counter++;
                }
            }
            int meetingStatistic = (counter * 100) / counterAllLetters;
            mapWithCountedLetters.put((alphabetLowerCase.get(i)), meetingStatistic);
        }
        return mapWithCountedLetters;
    }

    public static void sort(Map<Character, Integer> map, List<Character> sortedLetters,
                            List<Integer> sortedValues) {

        for (int i = 100; i >= 0; i--) {
            for (Character character : alphabetLowerCase) {
                if (map.get(character) == i) {
                    sortedLetters.add(character);
                    sortedValues.add(i);
                }
            }
        }
    }
}