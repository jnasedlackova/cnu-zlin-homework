package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

	@Test
	void getNeighbourSouth() {
		Position position = new Position(0, 0);
		Position result = position.getNeighbour(Direction.SOUTH);
		assertEquals(new Position(1,0), result, "New position should be 1,0");
	}

    @Test
    void getNeighbourWest() {
        Position position = new Position(0, 1);
        Position result = position.getNeighbour(Direction.WEST);
        assertEquals(new Position(0, 0), result, "New position should be 0,0");
    }

    @Test
    void getNeighbourNorth() {
        Position position = new Position(1, 0);
        Position result = position.getNeighbour(Direction.NORTH);
        assertEquals(new Position(0, 0), result, "New position should be 0,0");
    }

    @Test
    void getNeighbourEast() {
        Position position = new Position(0, 0);
        Position result = position.getNeighbour(Direction.EAST);
        assertEquals(new Position(0, 1), result, "New position should be 0,1");
    }

    @Test
    void isOutOfBoundsXminus() {
        Position position = new Position(-1, 1);
        Landscape landscape = new Landscape(2, new ArrayList<>());
        boolean result = Position.isOutOfBounds(landscape, position);
        boolean expected = true;
        assertEquals(expected, result, "Position is out of Boundary");
    }

    @Test
    void isOutOfBoundsXplus() {
        Position position = new Position(5, 1);
        Landscape landscape = new Landscape(2, new ArrayList<>());
        boolean result = Position.isOutOfBounds(landscape, position);
        boolean expected = true;
        assertEquals(expected, result, "Position is out of Boundary");
    }

    @Test
    void isOutOfBoundsYminus() {
        Position position = new Position(1, -2);
        Landscape landscape = new Landscape(2, new ArrayList<>());
        boolean result = Position.isOutOfBounds(landscape, position);
        boolean expected = true;
        assertEquals(expected, result, "Position is out of Boundary");
    }

    @Test
    void isOutOfBoundsYplus() {
        Position position = new Position(1, 10);
        Landscape landscape = new Landscape(2, new ArrayList<>());
        boolean result = Position.isOutOfBounds(landscape, position);
        boolean expected = true;
        assertEquals(expected, result, "Position is out of Boundary");
    }

    @Test
    void changeOutOfBoundsPositionXminusYplus() {
        Position position = new Position(-2, 10);
        Position result = Position.changeOutOfBoundsPosition(position, 5, "");
        Position expected = new Position(0, 4);
        assertEquals(expected, result, "Positions should be equal");
    }

    @Test
    void changeOutOfBoundsPositionXplusYminus() {
        Position position = new Position(20, -5);
        Position result = Position.changeOutOfBoundsPosition(position, 10, "");
        Position expected = new Position(9, 0);
        assertEquals(expected, result, "Positions should be equal");
    }

}