package cezarCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String incomingText = Files.readString(Path.of(args[1], ""));

        if ("encode".equals(args[0])){
            int key = Integer.parseInt(args[2]);
            Path outFilePath = Path.of(args[1] + "_encoded", "");
            String encoded = Coder.encoding(incomingText, key);
            Files.writeString(outFilePath, encoded);
        } else if ("decode".equals(args[0])) {
            int key = Integer.parseInt(args[2]);
            Path outFilePath = Path.of(args[1] + "_decoded", "");
            String decoded = Coder.decoding(incomingText, key);
            Files.writeString(outFilePath, decoded);
        } else if("bruteForce".equals(args[0])){
            String incomingSecondText = Files.readString(Path.of(args[2], ""));
            BruteForce.searchTheKey(incomingText, incomingSecondText);
            System.out.println("Your key is " + BruteForce.searchKey /*+ " or " + BruteForce.possibleKey*/);
            Path outFilePath = Path.of(args[1] + "_decoded_With_BruteForce", "");
            String decoded = Coder.decoding(incomingText, BruteForce.searchKey );
            Files.writeString(outFilePath, decoded);
        }
    }
}
