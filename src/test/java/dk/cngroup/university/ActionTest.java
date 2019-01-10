package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
	void performForwardToInAccessibleField() {
        Action forward = Action.FORWARD;
        Rover rover = new Rover(Direction.SOUTH, new Position(0, 0));
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(1, 0));
        Landscape landscape = new Landscape(2, stones);

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
    void performBackwardToInAccessibleField() {
        Action backward = Action.BACKWARD;
        Rover rover = new Rover(Direction.NORTH, new Position(0, 0));
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(1, 0));
        Landscape landscape = new Landscape(2, stones);

        Rover result = backward.perform(rover, landscape);
        Rover expected = new Rover(Direction.NORTH, new Position(0, 0));
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
        Action left = Action.LEFT;
        Rover rover = new Rover(Direction.NORTH, new Position(0, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = left.perform(rover, landscape);
        Rover expected = new Rover(Direction.WEST, new Position(0, 0));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void performForwardOutOfBoundary() {
        Action forward = Action.FORWARD;
        Rover rover = new Rover(Direction.SOUTH, new Position(1, 0));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = forward.perform(rover, landscape);
        Rover expected = new Rover(Direction.SOUTH, new Position(1, 0));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void performBackwardOutOfBoundary() {
        Action backward = Action.BACKWARD;
        Rover rover = new Rover(Direction.WEST, new Position(0, 1));
        Landscape landscape = new Landscape(2, new ArrayList<>());

        Rover result = backward.perform(rover, landscape);
        Rover expected = new Rover(Direction.WEST, new Position(0, 1));
        assertEquals(expected, result, "Rover should be equal");
    }

    @Test
    void getDetectedStonePositionWhenPerformForwardToInAccessibleField() {
        Action forward = Action.FORWARD;
        Rover rover = new Rover(Direction.SOUTH, new Position(0, 0));
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(1, 0));
        Landscape landscape = new Landscape(2, stones);
        forward.perform(rover, landscape);
        List<Position> result = Action.getListOfDetectedStones();
        List<Position> expected = new ArrayList<Position>();
        expected.add(new Position(1, 0));
        assertEquals(expected, result, "Stones should be at the same position");
    }
}