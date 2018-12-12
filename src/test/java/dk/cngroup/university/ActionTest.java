package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

	@Test
	void performForwardToAccessibleField() {
		Action forward = Action.FORWARD;

		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = forward.perform(rover, landscape);
		Rover expected = new Rover(Direction.SOUTH, new Position(1,0));
		assertEquals(expected, result, "Rover is equal");
	}

	@Test
	void performForwardToInAccessibleField() {
		// TODO implement
	}
}