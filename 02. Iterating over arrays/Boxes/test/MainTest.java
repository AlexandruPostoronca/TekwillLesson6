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

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void fromProblem2() {
        //minimum values
        simpleTest("1 3 7\n2 8 3", "Incompatible");
    }

    @Test
    public void shouldReturnBox1IsSmallerWhenBox1HasMinimumValues() {
        //minimum values
        simpleTest("1 2 3\n5 6 4", "Box 1 < Box 2");
    }

    @Test
    public void shouldReturnBox1IsLargerWhenBox1IsMuchLargerThanBox2() {
        //the first box is much larger than the second box
        simpleTest("10 20 30\n5 6 4", "Box 1 > Box 2");
    }

    @Test
    public void shouldReturnBox1IsSmallerWhenBox2IsMuchLargerThanBox1() {
        //the second box is much larger than the first box
        simpleTest("5 6 4\n10 20 30", "Box 1 < Box 2");
    }

    @Test
    public void shouldReturnIncompatibleWhenBoxesHaveSameDimensions() {
        //boxes have the same dimensions
        simpleTest("10 20 30\n10 20 30", "Incompatible");
    }

    @Test
    public void shouldReturnIncompatibleWhenBoxesHaveMinimumValuesAndSameDimensions() {
        //minimum values, boxes have the same dimensions
        simpleTest("1 1 1\n1 1 1", "Incompatible");
    }

    @Test
    public void shouldReturnBox1IsLargerWhenBox1IsSmallerThanBox2ButCannotBePlacedInside() {
        //the first box is smaller than the second one, but it can't be placed inside the second box
        simpleTest("5 5 5\n3 3 3", "Box 1 > Box 2");
    }

    @Test
    public void shouldReturnBox1IsSmallerWhenBox1IsSmallerThanBox2AndCanBePlacedInside() {
        //the first box is smaller than the second one and can be placed inside the second box
        simpleTest("5 5 5\n7 7 7", "Box 1 < Box 2");
    }

    @Test
    public void shouldReturnIncompatibleWhenBoxesHaveSameDimensionsAndMinimumValues() {
        //boxes have the same dimensions
        simpleTest("5 5 5\n5 5 5", "Incompatible");
    }

    @Test
    public void shouldReturnBox1IsLargerWhenBox1IsLargerInOneDimensionAndSmallerInTwoDimensions() {
        //the second box is smaller in two dimensions, but larger in one, the boxes are incompatible
        simpleTest("10 10 10\n20 5 10", "Incompatible");
    }

    @Test
    public void shouldReturnBox1IsLargerWhenBox1IsLargerInOneDimensionAndSmallerInTwoDimensions2() {
        //the second box is smaller in two dimensions, but larger in one, the boxes are incompatible
        simpleTest("10 10 10\n5 20 10", "Incompatible");
    }

    @Test
    public void shouldReturnBox1IsLargerWhenBox1IsLargerInOneDimensionAndSmallerInTwoDimensions3() {
        //the second box is smaller in two dimensions, but larger in one, the boxes are incompatible
        simpleTest("10 10 10\n5 10 20", "Incompatible");
    }

    @Test
    public void test1() {
        //the second box is smaller than the first one and can be placed inside the first box
        simpleTest("10 10 10\n5 5 5", "Box 1 > Box 2");
    }


    @Test
    public void test2() {
        //the first box is smaller than the second one and can be placed inside the second box
        simpleTest("10 5 20\n10 10 10", "Incompatible");
    }

    @Test
    public void test3() {
        //the first box is smaller than the second one and can be placed inside the second box
        simpleTest("5 10 20\n10 10 10", "Incompatible");
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});
        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}