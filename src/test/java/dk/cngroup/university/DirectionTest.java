package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

	@Test
	void testTurnRightFromEast() {
		testTurnRight(Direction.EAST, Direction.SOUTH, "South should be right of east");
	}

	@Test
	void testTurnRightFromSouth() {
		testTurnRight(Direction.SOUTH, Direction.WEST, "West should be right of south");
	}

	@Test
	void testTurnRightFromWest() {
		testTurnRight(Direction.WEST, Direction.NORTH, "North should be right of west");
	}

	@Test
	void testTurnRightFromNorth() {
		testTurnRight(Direction.NORTH, Direction.EAST, "East should be right of north");
	}

    @Test
    void testTurnLeftFromEast() {
        testTurnLeft(Direction.EAST, Direction.NORTH, "North should be left of east");
    }

    @Test
    void testTurnLeftFromSouth() {
        testTurnLeft(Direction.SOUTH, Direction.EAST, "East should be left of south");
    }

    @Test
    void testTurnLeftFromWest() {
        testTurnLeft(Direction.WEST, Direction.SOUTH, "South should be left of west");
    }

    @Test
    void testTurnLeftFromNorth() {
        testTurnLeft(Direction.NORTH, Direction.WEST, "West should be left of north");
    }

    @Test
    void testOpositeDirectionEast() {
        testOpositeDirection(Direction.EAST, Direction.WEST, "West is oposite to East");
    }

    @Test
    void testOpositeDirectionSouth() {
        testOpositeDirection(Direction.SOUTH, Direction.NORTH, "North is oposite to South");
    }

    @Test
    void testOpositeDirectionWest() {
        testOpositeDirection(Direction.WEST, Direction.EAST, "East is oposite to West");
    }

    @Test
    void testOpositeDirectionNorth() {
        testOpositeDirection(Direction.NORTH, Direction.SOUTH, "South is oposite to North");
    }

	private void testTurnRight(Direction input, Direction expected, String message) {
		Direction result = input.getDirectionOnRight();
		assertEquals(expected, result, message);
	}

    private void testTurnLeft(Direction input, Direction expected, String message) {
        Direction result = input.getDirectionOnLeft();
        assertEquals(expected, result, message);
    }

    private void testOpositeDirection(Direction input, Direction expected, String message) {
        Direction result = input.getOpositeDirection();
        assertEquals(expected, result, message);
    }
}