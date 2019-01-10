package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testCreateSmallLandscapeWithOneStoneOutOfBoundaryInY() {
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(0, 2));
        Landscape landscape = new Landscape(2, stones);
        String expected = "..\n..\n";
        assertEquals(expected, landscape.toString(),
                "Small landscape with one stone on out of boundary position 0,2 should be like this.");
    }

    @Test
    void testCreateSmallLandscapeWithOneStoneOutOfBoundaryInX() {
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(-1, 0));
        Landscape landscape = new Landscape(2, stones);
        String expected = "..\n..\n";
        assertEquals(expected, landscape.toString(),
                "Small landscape with one stone on out of boundary position 5,0 should be like this.");
    }

	@Test
	void testIsAccessible() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		Position position = new Position(1, 0);
		boolean result = landscape.isAccessible(position);
		boolean expected = true;
		assertEquals(expected, result, "The result should be true, stone is not at this position");
	}

	@Test
	void testIsNotAccessible() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		boolean result = landscape.isAccessible(new Position(0, 0));
		boolean expected = false;
		assertEquals(expected, result, "The result should be false, stone is at this position");
	}


}