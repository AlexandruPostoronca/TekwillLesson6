import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayOperationsTest {
    private static final String N = System.lineSeparator();

    @Test
    public void testPrintCorners_singleElementArray() {
        int[][] arr = {{5}};
        assertConsoleOutput("5 5" + N + "5 5" + N, () -> ArrayOperations.printCorners(arr));
    }

    @Test
    public void testPrintCorners_twoByTwoArray() {
        int[][] arr = {{1, 2}, {3, 4}};
        assertConsoleOutput("1 2" + N + "3 4" + N, () -> ArrayOperations.printCorners(arr));
    }

    @Test
    public void testPrintCorners_twoByThreeArray() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        assertConsoleOutput("1 3" + N + "4 6" + N, () -> ArrayOperations.printCorners(arr));
    }

    @Test
    public void testPrintCorners_oneRowArray() {
        int[][] arr = {{1, 2, 3, 4}};
        assertConsoleOutput("1 4" + N + "1 4" + N, () -> ArrayOperations.printCorners(arr));
    }

    @Test
    public void testPrintCorners_oneColumnArray() {
        int[][] arr = {{1}, {2}, {3}, {4}};
        assertConsoleOutput("1 1" + N + "4 4" + N, () -> ArrayOperations.printCorners(arr));
    }

    @Test
    public void testPrintCorners_largeArray() {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        assertConsoleOutput("1 5" + N + "11 15" + N, () -> ArrayOperations.printCorners(arr));
    }

    private void assertConsoleOutput(String expectedOutput, Runnable action) {
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
            action.run();
            Assert.assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}