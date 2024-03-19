import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOperationsTest {

    @Test
    public void testCreateCube() {
        int[][][] cube = ArrayOperations.createCube();

        assertEquals(3, cube.length);
        assertEquals(3, cube[0].length);
        assertEquals(3, cube[0][0].length);
        int[][][] expectedCube = new int[3][3][3];

        expectedCube[0] = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        expectedCube[1] = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        expectedCube[2] = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        // Test that the values are correct
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    assertEquals(expectedCube[i][j][k], cube[i][j][k]);
                }
            }
        }
    }
}