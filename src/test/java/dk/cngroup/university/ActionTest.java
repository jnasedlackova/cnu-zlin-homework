package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionTest {

	@Test
	void performForwardToAccessibleField() {
		Action forward = Action.FORWARD;
		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = forward.perform(rover, landscape);
		Rover expected = new Rover(Direction.SOUTH, new Position(1,0));
		assertEquals(expected, result, "Rover should be equal");
	}

    @Test
        //nutno implementovat isAccessible
	void performForwardToInAccessibleField() {
        Action forward = Action.FORWARD;
        Rover rover = new Rover(Direction.SOUTH, new Position(0, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = forward.perform(rover, landscape);
        Rover expected = new Rover(Direction.SOUTH, new Position(0, 0));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void performBackwardToAccessibleField() {
        Action backward = Action.BACKWARD;
        Rover rover = new Rover(Direction.NORTH, new Position(0, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = backward.perform(rover, landscape);
        Rover expected = new Rover(Direction.NORTH, new Position(1, 0));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void performRight() {
        Action right = Action.RIGHT;
        Rover rover = new Rover(Direction.NORTH, new Position(0, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = right.perform(rover, landscape);
        Rover expected = new Rover(Direction.EAST, new Position(0, 0));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void performLeft() {
        Action right = Action.LEFT;
        Rover rover = new Rover(Direction.NORTH, new Position(0, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = right.perform(rover, landscape);
        Rover expected = new Rover(Direction.WEST, new Position(0, 0));
        assertEquals(expected, result, "Rover should be equal");
    }
}