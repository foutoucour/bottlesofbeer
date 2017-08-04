package coveo.qatest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    /**
     * When we launch the application
     * Then we sing all the 99 bottles of beer song
     */
    @Test
    public void output() {
        Main.main(new String[]{});
        String workingDirectory = System.getProperty("user.dir");
        Path path = Paths.get(workingDirectory, "src", "test", "song.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expected = String.join("\n", lines);
        expected += "\n"; // println finish with an extra \n
        assertEquals(expected, outContent.toString());
    }
}