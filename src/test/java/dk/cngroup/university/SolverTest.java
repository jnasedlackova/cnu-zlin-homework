package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest {

    @Test
    void solveAssignmentPositiveResult() {
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
        boolean expected = true;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be true");
    }

    @Test
    void solveAssignmentNegativeResult() {
        String input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "2,0;1,3;2,3;4,3\n" +
                "\n" +
                "4,0\n" +
                "\n" +
                "RRFLFRFF";
        boolean expected = false;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be false");
    }

    @Test
    void solveComplicatedNegativeResult() {
        String input = "2,2\n" +
                "\n" +
                "E\n" +
                "\n" +
                "5\n" +
                "\n" +
                "0,3;1,1;1,4;2,3;3,0;3,5;4,2\n" +
                "\n" +
                "0,0\n" +
                "\n" +
                "FLFRFFLFBLFLBRF";
        boolean expected = false;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be false");
    }

    @Test
    void solveComplicatedPositiveResult() {
        String input = "2,2\n" +
                "\n" +
                "E\n" +
                "\n" +
                "5\n" +
                "\n" +
                "0,3;1,1;1,4;2,3;3,0;3,5;4,2\n" +
                "\n" +
                "0,0\n" +
                "\n" +
                "FLFRFFLFBLFLBRFF";
        boolean expected = true;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be false");
    }

    @Test
    void solveOutOfBoundsBothPositiveResult() {
        String input = "5,5\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "0,3;1,1;1,4;2,3;3,0;3,5;4,2\n" +
                "\n" +
                "-1,-1\n" +
                "\n" +
                "FLFFFFLBBRFRFF";
        boolean expected = true;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be false");
    }
}