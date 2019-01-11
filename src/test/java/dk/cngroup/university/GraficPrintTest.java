package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraficPrintTest {

    @Test
    void initSmallLandscapeFieldWithOneStone() {
        List<Position> stones = new ArrayList<>();
        stones.add(new Position(0, 0));
        Landscape landscape = new Landscape(2, stones);
        String expected = "0.\n..\n";
        GraficField[][] fields = new GraficField[2][2];

        assertEquals(expected, landscape.toString(),
                "Small landscape with one stone on position 0,0 should be like this.");
    }

}