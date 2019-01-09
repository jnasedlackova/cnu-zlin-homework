package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<String> parseInputString(String inputString) {
        List<String> parameters = parseStringToList(inputString, "\n");
        return parameters;
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
        int x = Integer.valueOf(stringPosition.substring(0, 1));
        int y = Integer.valueOf(stringPosition.substring(2, 3));
        return new Position(x, y);
    }


    private static List<String> parseStringToList(String inputString, String regex) {
        List<String> outputList = new ArrayList<>();
        String[] rows = inputString.split(regex);
        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() > 0) {
                outputList.add(rows[i]);
            }
        }
        return outputList;
    }

}
