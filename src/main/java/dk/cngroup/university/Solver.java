package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    static List<Position> roverMovement = new ArrayList<>();
    static GraficField[][] graficFields; // = new GraficField[][];

    public static List<Position> getRoverMovement() {
        return roverMovement;
    }

    public static GraficField[][] getGraficFields() {
        return graficFields;
    }

    public static boolean solve(String input) {

        Boolean result = false;
        List<String> rows = InputParser.parseInputString(input);
        Rover rover = InputParser.parseRover(rows);
        Landscape landscape = InputParser.parseLandscape(rows);
        Position finalDestination = InputParser.parseFinalDestination(rows);
        List<Action> commands = InputParser.parseCommands(rows);
        int numberOfOvercomingFields = InputParser.parseNumberOfOvercomingFields(rows);

        finalDestination = checkPosition(landscape, finalDestination, "final destination");
        Position roverPosition = checkPosition(landscape, rover.getPosition(), "initial position of rover");
        rover = new Rover(rover.getDirection(), roverPosition);
        Position initialPosition = roverPosition;

        for (int i = 0; i < commands.size(); i++) {
            Action action = commands.get(i);
            rover = action.perform(rover, landscape, numberOfOvercomingFields);
            roverMovement.add(rover.getPosition());
        }

        if (rover.getPosition().equals(finalDestination)) {
            result = true;
        }

        GraficPrint graficPrint = new GraficPrint(landscape.getFields().length, landscape, finalDestination, initialPosition, roverMovement);
        graficFields = graficPrint.getFields();

        return result;
    }

    public static List<Position> detectedStones() {
        return Action.getListOfDetectedStones();
    }

    public static List<Position> overcomeddStones() {
        return Action.getListOfOvecomedStones();
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
