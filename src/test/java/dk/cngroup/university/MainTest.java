package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

	@Test
	void main() {
        String input = "1,0\n" +
                "\n" +
                "N\n" +
                "\n" +
                "5\n" +
                "\n" +
                "2,0;1,3;2,3;4,3\n" +
                "\n" +
                "4,0\n" +
                "\n" +
                "RRFLFRFF";
        boolean expected = false;
        boolean result = Solver.solve(input);
        assertEquals(expected, result, "Result should be false");

	}
}