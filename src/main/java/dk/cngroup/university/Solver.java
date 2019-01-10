package dk.cngroup.university;

import java.util.List;

public class Solver {

    public static boolean solve(String input) {

        Boolean result = false;
        List<String> rows = InputParser.parseInputString(input);
        Rover rover = InputParser.parseRover(rows);
        Landscape landscape = InputParser.parseLandscape(rows);
        Position finalDestination = InputParser.parseFinalDestination(rows);
        List<Action> commands = InputParser.parseCommands(rows);

        finalDestination = checkPosition(landscape, finalDestination, "final destination");
        Position roverPosition = checkPosition(landscape, rover.getPosition(), "initial position of rover");
        rover = new Rover(rover.getDirection(), roverPosition);


        for (int i = 0; i < commands.size(); i++) {
            Action action = commands.get(i);
            rover = action.perform(rover, landscape);
        }

        if (rover.getPosition().equals(finalDestination)) {
            result = true;
        }

        return result;
    }

    public static List<Position> detectedStones() {
        return Action.getListOfDetectedStones();
    }

    public static Position checkPosition(Landscape landscape, Position position, String string) {
        if (Position.isOutOfBounds(landscape, position)) {
            position = Position.changeOutOfBoundsPosition(position, landscape.getFields().length, string);
        }
        if (!landscape.isAccessible(position)) {
            System.out.println("WARNING: " + string + " is at inaccessible Field");
        }
        return position;
    }
}
