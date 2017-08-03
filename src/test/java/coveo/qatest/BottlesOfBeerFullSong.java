package coveo.qatest;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

// Test against the song.
public class BottlesOfBeerFullSong {
    @Test
    public void allTheSong() throws Exception {
        String workingDirectory = System.getProperty("user.dir");
        Path path = Paths.get(workingDirectory, "song.txt");
        List<String> lines = Files.readAllLines(path);
        String expected = String.join("\n", lines);
        BottlesOfBeer bottlesOfBeer = new BottlesOfBeer(99);
        assertEquals(expected, bottlesOfBeer.sing());
    }

}
