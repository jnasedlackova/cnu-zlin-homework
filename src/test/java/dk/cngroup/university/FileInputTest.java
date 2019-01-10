package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileInputTest {

    @Test
    void getInputStringFromFile() {
        String expected = "2,2\n" +
                "\n" +
                "E\n" +
                "\n" +
                "5\n" +
                "\n" +
                "0,3;1,1;1,4;2,3;3,0;3,5;4,2\n" +
                "\n" +
                "0,0\n" +
                "\n" +
                "FLFRFFLFBLBFLBRFF\n" +
                "\n" +
                "1\n";

        String result = FileInput.readFromFile("input.txt");
        assertEquals(expected, result, "Strings should be the same");
    }
}