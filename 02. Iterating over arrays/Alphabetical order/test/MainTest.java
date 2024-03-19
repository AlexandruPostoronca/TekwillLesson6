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
    public void testFromProblem1() {
        simpleTest("a b c", "true");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("a aa az aza", "true");
    }

    @Test
    public void test1() {
        simpleTest("a", "true");// with a single element
    }

    @Test
    public void test2() {
        simpleTest("abc abc", "true");// with two identical elements
    }

    @Test
    public void test3() {
        simpleTest("az a", "false");// with two non-identical elements
    }

    @Test
    public void test4() {
        simpleTest("aaa aaa aaa aaa", "true");// with multiple identical elements
    }

    @Test
    public void test5() {
        simpleTest("apple banana cherry date elderberry", "true");
    }

    @Test
    public void test6() {
        simpleTest("cat dog elephant fish giraffe", "true");
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