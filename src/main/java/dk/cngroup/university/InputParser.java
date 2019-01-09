package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<String> parseString(String inputString) {
        List<String> paremeters = new ArrayList<>();
        String[] rows = inputString.split("\n");
        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() > 0) {
                paremeters.add(rows[i]);
            }
        }
        return paremeters;
    }

    public static Rover parseRover(List<String> rows) {
        int x = Integer.valueOf(rows.get(0).substring(0, 1));
        int y = Integer.valueOf(rows.get(0).substring(2, 3));
        String letter = rows.get(1);
        InputDirection directionLetter = InputDirection.valueOf(letter);
        Direction direction = directionLetter.getDirectionFromLetter();


        Rover rover = new Rover(direction, new Position(x, y));
        return rover;

    }

}
