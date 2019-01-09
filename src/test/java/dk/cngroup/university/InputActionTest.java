package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputActionTest {

    @Test
    void testAtionFromLetterRight() {
        testActionFromLetter(InputAction.R, Action.RIGHT, "Letter W means RIGHT");
    }

    @Test
    void testAtionFromLetterLeft() {
        testActionFromLetter(InputAction.L, Action.LEFT, "Letter L means LEFT");
    }

    @Test
    void testAtionFromLetterForward() {
        testActionFromLetter(InputAction.F, Action.FORWARD, "Letter F means FORWARD");
    }

    @Test
    void testAtionFromLetterBackward() {
        testActionFromLetter(InputAction.B, Action.BACKWARD, "Letter B means BACKWARD");
    }


    private void testActionFromLetter(InputAction letter, Action expected, String message) {
        Action result = letter.getActionFromLetter();
        assertEquals(expected, result, message);
    }


}