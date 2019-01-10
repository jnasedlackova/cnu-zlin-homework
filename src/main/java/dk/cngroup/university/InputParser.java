package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<String> parseInputString(String inputString) {
        List<String> rows = parseStringToList(inputString, "\n");
        return rows;
    }


    public static Rover parseRover(List<String> rows) {
        String stringPosition = rows.get(0);
        Position position = getPosition(stringPosition);
        String letter = rows.get(1);
        InputDirection directionLetter = InputDirection.valueOf(letter);
        Direction direction = directionLetter.getDirectionFromLetter();

        Rover rover = new Rover(direction, position);
        return rover;
    }

    public static Landscape parseLandscape(List<String> rows) {
        int size = Integer.valueOf(rows.get(2));
        List<Position> stones = new ArrayList<>();
        String stringOfStones = rows.get(3);
        List<String> stonesListOfString = parseStringToList(stringOfStones, ";");
        for (int i = 0; i < stonesListOfString.size(); i++) {
            Position position = getPosition(stonesListOfString.get(i));
            stones.add(position);
        }

        Landscape landscape = new Landscape(size, stones);
        return landscape;
    }

    public static Position parseFinalDestination(List<String> rows) {
        String stringPosition = rows.get(4);
        Position position = getPosition(stringPosition);
        return position;
    }

    public static List<Action> parseCommands(List<String> rows) {
        List<Action> commands = new ArrayList<>();
        String stringOfCommands = rows.get(5);
        for (int i = 0; i < stringOfCommands.length(); i++) {
            InputAction actioinLetter = InputAction.valueOf(stringOfCommands.substring(i, i + 1));
            Action action = actioinLetter.getActionFromLetter();
            commands.add(action);
        }
        return commands;
    }

    private static Position getPosition(String stringPosition) {
        List<String> coordinates = parseStringToList(stringPosition, ",");
        int x = Integer.valueOf(coordinates.get(0));
        int y = Integer.valueOf(coordinates.get(1));
        return new Position(x, y);
    }

    private static List<String> parseStringToList(String inputString, String regex) {
        List<String> outputList = new ArrayList<>();
        String[] rows = inputString.split(regex);
        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() > 0) {
                outputList.add(rows[i].trim());
            }
        }
        return outputList;
    }

    public static Position changeOutOfBoundsPosition(Position position, int landscapeSize) {
        int x = position.x;
        int y = position.y;
        if (position.x < 0) {
            x = 0;
        }
        if (position.x >= landscapeSize) {
            x = landscapeSize - 1;
        }
        if (position.y < 0) {
            y = 0;
        }
        if (position.y >= landscapeSize) {
            y = landscapeSize - 1;
        }
        System.out.println("Input Coordinates out of Landscape Boundary - changed to the closest Field");
        return new Position(x, y);
    }

}
