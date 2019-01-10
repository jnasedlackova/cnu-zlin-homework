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

        if (Action.isOutOfBounds(landscape, finalDestination)) {
            finalDestination = InputParser.changeOutOfBoundsPosition(finalDestination, landscape.getFields().length);
        }

        if (Action.isOutOfBounds(landscape, rover.getPosition())) {
            Position position = InputParser.changeOutOfBoundsPosition(finalDestination, landscape.getFields().length);
            Direction direction = rover.getDirection();
            rover = new Rover(direction, position);
        }

        for (int i = 0; i < commands.size(); i++) {
            Action action = commands.get(i);
            rover = action.perform(rover, landscape);
        }

        if (rover.getPosition().equals(finalDestination)) {
            result = true;
        }

        return result;
    }
}
