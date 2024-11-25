package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filepath = "C:/Users/Vo/Desktop/large_input.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filepath));
        startTime = System.currentTimeMillis();
        String outputString = "";

        for (byte b : inputBytes) {
            outputString += (char)b;
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
