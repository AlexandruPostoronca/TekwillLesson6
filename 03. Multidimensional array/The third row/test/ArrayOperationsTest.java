import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void test1() {
        simpleTest(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}}, "3 4 5");
    }

    @Test
    public void test2() {
        simpleTest(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, "3 3 3");
    }

    @Test
    public void test3() {
        simpleTest(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, "3 3 3");
    }

    @Test
    public void test4() {
        simpleTest(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, "7 8 9");
    }

    @Test
    public void test5() {
        simpleTest(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}, "7 8 9");
    }

    @Test
    public void test6() {
        simpleTest(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}, "7 8 9");
    }

    @Test
    public void test7() {
        simpleTest(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, "7 8 9");
    }

    @Test
    public void test8() {
        simpleTest(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, "5 6");
    }

    public void simpleTest(int[][] input, String expectedOutput) {
        // Convert the input to a string
        StringBuilder in = new StringBuilder();
        for (int[] ints : input) {
            for (int anInt : ints) {
                in.append(anInt).append(" ");
            }
            in.setLength(in.length() - 1);
            in.append("\n");
        }
        String inputStr = in.toString();

        ArrayOperations.printTheThirdRow(input);

        // Get the result
        String result = outputStreamCaptor.toString().trim();

        // Check the result
        String message = "For input:\n" + inputStr + "\nThe output must be:\n" + expectedOutput + "\nActual output:\n" + result + "\n";
        assertEquals(message, expectedOutput, result);
    }
}





