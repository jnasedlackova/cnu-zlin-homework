package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    void testCreateArrayOfStrings() {
        List<String> expected = new ArrayList<>();
        expected.add("1,0");
        expected.add("N");
        expected.add("5");
        expected.add("3,0;1,3;4,3;1,5");
        expected.add("4,1");
        expected.add("RRFLFRFF");
        String input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "3,0;1,3;4,3;1,5\n" +
                "\n" +
                "4,1\n" +
                "\n" +
                "RRFLFRFF";
        List<String> result = InputParser.parseString(input);

        assertEquals(expected, result,
                "Both Lists should be the same");
    }

    @Test
    void testParseRover1() {
        List<String> input = new ArrayList<>();
        input.add("1,0");
        input.add("S");
        input.add("5");
        input.add("3,0;1,3;4,3;1,5");
        input.add("4,1");
        input.add("RRFLFRFF");

        Rover result = InputParser.parseRover(input);
        Rover expeted = new Rover(Direction.SOUTH, new Position(1, 0));

        assertEquals(expeted, result,
                "Rovers should be the same");
    }

    @Test
    void testParseRover2() {
        List<String> input = new ArrayList<>();
        input.add("4,2");
        input.add("W");
        input.add("5");
        input.add("3,0;1,3;4,3;1,5");
        input.add("4,1");
        input.add("RRFLFRFF");

        Rover result = InputParser.parseRover(input);
        Rover expeted = new Rover(Direction.WEST, new Position(4, 2));

        assertEquals(expeted, result,
                "Rovers should be the same");
    }

}