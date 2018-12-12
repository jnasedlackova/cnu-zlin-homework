package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LandscapeTest {

	@Test
	void testCreateSmallAccessibleLandscape() {
		Landscape landscape = new Landscape(2, new ArrayList<>());
		String expected = "..\n..\n";
		assertEquals(expected, landscape.toString(),
				"Small accessible landscape should be like this.");
	}

	@Test
	void testCreateSmallLandscapeWithOneStone() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		String expected = "0.\n..\n";
		assertEquals(expected, landscape.toString(),
				"Small landscape with one stone on position 0,0 should be like this.");
	}

	@Test
	void isAccessible() {
	}
}