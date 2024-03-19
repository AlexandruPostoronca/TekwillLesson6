import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final String N = System.lineSeparator();

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
        //simpleTest("0 0 9 9\n1 2 3 4\n5 6 7 8", "9 9 0 0\n4 3 2 1\n8 7 6 5"); // from the problem
        simpleTest(new int[][]{{0, 0, 9, 9}, {1, 2, 3, 4}, {5, 6, 7, 8}},
                "9 9 0 0" + N + "4 3 2 1" + N + "8 7 6 5"); // edge case with one row
    }

    @Test
    public void test2() {
        simpleTest(new int[][]{{1}}, "1"); // edge case with one row
    }

    @Test
    public void test3() {
        simpleTest(new int[][]{{1, 2, 3}, {4, 5, 6}}, "3 2 1" + N + "6 5 4"); // edge case with multiple rows and columns
    }

    @Test
    public void test4() {
        simpleTest(new int[][]{{0, 0, 0}}, "0 0 0"); // edge case with all elements in the array are the same
    }

    @Test
    public void test5() {
        simpleTest(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, "7 8 9" + N + "4 5 6" + N + "1 2 3"); // random test case 1
    }

    @Test
    public void test6() {
        simpleTest(new int[][]{{10, 20}, {30, 40}, {50, 60}, {70, 80}, {90, 100}},
                "20 10" + N + "40 30" + N + "60 50" + N + "80 70" + N + "100 90"); // random test case 2
    }

    private void simpleTest(int[][] twoDimArray, String expected) {
        //Set input stream
        String in = toArrString(twoDimArray);
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        ArrayOperations.reverseElements(twoDimArray);

        //output towDimArray
        for (int[] ints : twoDimArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        //Get the result
        String result = outputStreamCaptor.toString().trim().replaceAll("\\s(\\r\\n|\\r|\\n)", N);

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

    private String toArrString(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        return sb.toString();
    }

}