package dk.cngroup.university;

import java.util.List;

public class Main {

    public static void main(String[] args) {

    /*    String input = "2,2\n" +
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
    */

        String input = FileInput.readFromFile("input.txt");
        boolean result = Solver.solve(input);
        List<Position> detectedStones = Solver.detectedStones();
        List<Position> overcomedStones = Solver.overcomeddStones();
        if (result) {
            System.out.println("SUCCESS - The Rover did reach the final destination");
        } else {
            System.out.println("FAILURE - The Rover did not reach the final destination");
        }
        System.out.println("detected stones:" + detectedStones);
        System.out.println("overcomed stones:" + overcomedStones);
        System.out.println("");

        GraficField[][] graficFields = Solver.getGraficFields();
        int size = graficFields.length;
        System.out.println("The Landscape after the Rover trip looks like this:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(graficFields[i][j].toString());
            }
            System.out.println();
        }

    }
}
