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
        List<String> result = InputParser.parseInputString(input);

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
        Rover expected = new Rover(Direction.SOUTH, new Position(1, 0));

        assertEquals(expected, result,
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
        Rover expected = new Rover(Direction.WEST, new Position(4, 2));

        assertEquals(expected, result,
                "Rovers should be the same");
    }

    @Test
    void testParseLandscapeSize2WithOneStone() {
        List<String> input = new ArrayList<>();
        input.add("0,1");
        input.add("W");
        input.add("2");
        input.add("0,0");
        input.add("1,1");
        input.add("RRFLFRFF");

        String result = InputParser.parseLandscape(input).toString();
        String expected = "0.\n..\n";

        assertEquals(expected, result,
                "Landscapes should be the same");
    }

    @Test
    void testParseLandscapeSize5WithFourStones() {
        List<String> input = new ArrayList<>();
        input.add("4,2");
        input.add("W");
        input.add("5");
        input.add("3,0;1,3;4,3;1,0");
        input.add("4,1");
        input.add("RRFLFRFF");

        String result = InputParser.parseLandscape(input).toString();
        String expected = ".....\n0..0.\n.....\n0....\n...0.\n";

        assertEquals(expected, result,
                "Landscapes should be the same");
    }

    @Test
    void testParseLandscapeSize5WithFourStonesOneOutOfBoundary() {
        List<String> input = new ArrayList<>();
        input.add("4,2");
        input.add("W");
        input.add("5");
        input.add("3,0;1,3;5,3;1,0");
        input.add("4,1");
        input.add("RRFLFRFF");

        String result = InputParser.parseLandscape(input).toString();
        String expected = ".....\n0..0.\n.....\n0....\n.....\n";

        assertEquals(expected, result,
                "Landscapes should be the same");
    }

    @Test
    void testParseFinalDestination() {
        List<String> input = new ArrayList<>();
        input.add("0,1");
        input.add("W");
        input.add("2");
        input.add("0,0");
        input.add("1,1");
        input.add("RRFLFRFF");

        Position expected = new Position(1, 1);
        Position result = InputParser.parseFinalDestination(input);

        assertEquals(expected, result,
                "Positions should be the same");
    }

    @Test
    void testParseCommands() {
        List<String> input = new ArrayList<>();
        input.add("0,1");
        input.add("W");
        input.add("2");
        input.add("0,0");
        input.add("1,1");
        input.add("RLFRB");

        List<Action> expected = new ArrayList<>();
        expected.add(Action.RIGHT);
        expected.add(Action.LEFT);
        expected.add(Action.FORWARD);
        expected.add(Action.RIGHT);
        expected.add(Action.BACKWARD);

        List<Action> result = InputParser.parseCommands(input);

        assertEquals(expected, result,
                "Actions should be the same");
    }




}