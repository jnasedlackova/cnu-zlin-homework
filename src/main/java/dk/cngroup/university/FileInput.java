package dk.cngroup.university;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {


    public static String readFromFile(String fileName) {
        String input = "";
        String row;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            while ((row = bfr.readLine()) != null) {
                input += row;
                input += "\n";
            }
        } catch (IOException e) {
            System.out.println("The file doesn't exist");
            System.exit(1);
        }
        return input;
    }
}
