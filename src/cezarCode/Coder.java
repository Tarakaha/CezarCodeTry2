package cezarCode;

import java.util.Arrays;
import java.util.List;

public class Coder {
    public static final List<Character> alphabetLowerCase = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public static final List<Character> alphabetUpperCase = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    public static String encoding(String incomingText, int key) {
        StringBuilder strBox = new StringBuilder(incomingText.length());
        char temp;
        for (int i = 0; i < incomingText.length(); i++) {
            temp = incomingText.charAt(i);
            if (alphabetLowerCase.contains(temp)) {
                int currentIndex = alphabetLowerCase.indexOf(temp);
                int encodedIndex = (currentIndex + key) % alphabetLowerCase.size();
                strBox.append(alphabetLowerCase.get(encodedIndex));
            } else if (alphabetUpperCase.contains(temp)) {
                int currentIndex = alphabetUpperCase.indexOf(temp);
                int encodedIndex = (currentIndex + key) % alphabetUpperCase.size();
                strBox.append(alphabetUpperCase.get(encodedIndex));
            } else {
                strBox.append(temp);
            }
        }
        return strBox.toString();
    }

    public static String decoding(String incomingText, int key) {

        StringBuilder strBox = new StringBuilder(incomingText.length());
        char temp;
        for (int i = 0; i < incomingText.length(); i++) {
            temp = incomingText.charAt(i);
            if (alphabetLowerCase.contains(temp)) {

                int currentIndex = alphabetLowerCase.indexOf(temp);
                int decodedIndex = (currentIndex - key) % alphabetLowerCase.size();
                if (decodedIndex < 0) {
                    decodedIndex = alphabetLowerCase.size() + decodedIndex;
                }
                strBox.append(alphabetLowerCase.get(decodedIndex));

            } else if (alphabetUpperCase.contains(temp)) {
                int currentIndex = alphabetUpperCase.indexOf(temp);
                int decodedIndex = (currentIndex - key) % alphabetUpperCase.size();

                if (decodedIndex < 0) {
                    decodedIndex = alphabetUpperCase.size() + decodedIndex;

                }
                strBox.append(alphabetUpperCase.get(decodedIndex));
            } else {
                strBox.append(temp);
            }
        }

        return strBox.toString();
    }
}
