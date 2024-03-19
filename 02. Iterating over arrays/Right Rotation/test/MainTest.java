import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainTest {
    private final String input;
    private final String expectedOutput;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public MainTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1 2 3 4 5\n1", "5 1 2 3 4"},
                {"1 2 3 4 5\n2", "4 5 1 2 3"},
                {"1 2 3 4 5\n8", "3 4 5 1 2"},
                {"11 21 1 41 51 78 90\n4", "41 51 78 90 11 21 1"},
                {"1 2\n1", "2 1"},
                {"1 2 3\n2", "2 3 1"},
                {"1 1 1 1 1\n1", "1 1 1 1 1"},
                {"1 2 3 4 5\n0", "1 2 3 4 5"},
                {"1 2 3 4 5\n5", "1 2 3 4 5"},
                {"1 2 3 4 5\n6", "5 1 2 3 4"},
                {"3 2 1\n1", "1 3 2"},
                {"4 2 1 3\n2", "1 3 4 2"},
        });
    }

    @Test
    public void test() {
        //Set input stream
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{""});
        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + input + "\r\nThe output must be:\r\n" + expectedOutput + "\r\nActual output:\r\n" + result;
        assertEquals(message, expectedOutput, result);
    }

}