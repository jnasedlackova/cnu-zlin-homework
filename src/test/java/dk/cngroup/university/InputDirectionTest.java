package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputDirectionTest {

    @Test
    void testDirrectionFromLetterWest() {
        testDirectionFromLetter(InputDirection.W, Direction.WEST, "Letter W means WEST");
    }

    @Test
    void testDirrectionFromLetterNorth() {
        testDirectionFromLetter(InputDirection.N, Direction.NORTH, "Letter N means NORTH");
    }

    @Test
    void testDirrectionFromLetterEast() {
        testDirectionFromLetter(InputDirection.E, Direction.EAST, "Letter E means EAST");
    }

    @Test
    void testDirrectionFromLetterSouth() {
        testDirectionFromLetter(InputDirection.S, Direction.SOUTH, "Letter S means SOUTH");
    }

    private void testDirectionFromLetter(InputDirection letter, Direction expected, String message) {
        Direction result = letter.getDirectionFromLetter();
        assertEquals(expected, result, message);
    }

}