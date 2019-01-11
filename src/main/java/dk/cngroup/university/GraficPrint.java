package dk.cngroup.university;

import java.util.List;

public class GraficPrint {

    public static GraficField[][] fields;

    public GraficPrint(int size, Landscape landscape, Position finalDestination, Position initialDestination, List<Position> roverMovement) {
        initLandscapeFields(landscape);
        insertRoverPath(roverMovement);
        insertDetectedStones();
        insertFinalAndInitialDestination(initialDestination, finalDestination);
        insertVictory(roverMovement.get(roverMovement.size() - 1), finalDestination);
    }

    public void initLandscapeFields(Landscape landscape) {
        Field[][] landscapeFields = landscape.getFields();
        int size = landscapeFields.length;
        this.fields = new GraficField[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (landscapeFields[i][j] == Field.ACCESSIBLE) {
                    fields[i][j] = GraficField.NEUTRAL;
                } else {
                    fields[i][j] = GraficField.STONE;
                }
            }
        }
    }

    private void insertRoverPath(List<Position> roverMovement) {
        for (int i = 0; i < roverMovement.size(); i++) {
            int x = roverMovement.get(i).x;
            int y = roverMovement.get(i).y;
            if (fields[x][y] == GraficField.STONE) {
                fields[x][y] = GraficField.ROVERSTONE;
            } else {
                fields[x][y] = GraficField.ROVER;
            }
        }

    }

    private void insertDetectedStones() {
        List<Position> detectedStones = Action.getListOfDetectedStones();
        for (int i = 0; i < detectedStones.size(); i++) {
            int x = detectedStones.get(i).x;
            int y = detectedStones.get(i).y;
            fields[x][y] = GraficField.DETECTEDSTONE;
        }
    }

    private void insertFinalAndInitialDestination(Position initialDestination, Position finalDestination) {
        fields[initialDestination.x][initialDestination.y] = GraficField.INITIAL;
        fields[finalDestination.x][finalDestination.y] = GraficField.FINAL;
    }

    private void insertVictory(Position roverPosition, Position finalDestination) {
        if (roverPosition.equals(finalDestination)) {
            fields[finalDestination.x][finalDestination.y] = GraficField.VICTORY;
        }
    }

    public GraficField[][] getFields() {
        return fields;
    }
}



