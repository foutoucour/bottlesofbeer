package coveo.qatest;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class LyricsTest {

    private Lyrics lyrics;
    private int initialNumberOfBottles;

    @Before
    public void setUp() {
        this.initialNumberOfBottles = 14;
        this.lyrics = new Lyrics(this.initialNumberOfBottles);
    }


    /**
     * When the number of bottles is 14
     * Then the number of bottles on the wall is 14 and "bottle" is plural
     * And 13 bottles remind and "bottle" is plural
     */
    @Test
    public void whenBottleIsFourteen_thenWeDrink() throws Exception {
        String expected = "14 bottles of beer on the wall, 14 bottles of beer.\n" +
                "Take one down and pass it around, 13 bottles of beer on the wall.\n";

        assertEquals(expected, this.lyrics.buildLyricsFor(14));
    }

    /**
     * When the number of bottles is 2
     * Then the number of bottles on the wall is 2 and "bottle" is plural
     * And 1 bottle stay and "bottle" is now singular
     */
    @Test
    public void whenBottleIsTwo_thenWeDrinkButOnlyOneLeft() throws Exception {
        String expected = "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.\n";

        assertEquals(expected, this.lyrics.buildLyricsFor(2));
    }

    /**
     * When the number of bottles is 1
     * Then the number of bottles on the wal is 1 and "bottle" is singular
     * And no more bottles on the wall.
     */
    @Test
    public void whenBottleIsOne_thenWeDrinkButNoMore() throws Exception {
        String expected = "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.\n";

        assertEquals(expected, this.lyrics.buildLyricsFor(1));
    }

    /**
     * When the number of bottles is 0
     * Then no more bottles on the wall
     * And we buy the same number of bottles we started with
     */
    @Test
    public void whenBottleIsZero_thenWeBuy() throws Exception {
        String expected = String.format(
                "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, %d bottles of beer on the wall.",
                this.initialNumberOfBottles
        );
        assertEquals(expected, this.lyrics.buildLyricsFor(0));
    }

    /**
     * When we drink 99 beers
     * Then we have the lyrics of the original song.
     *
     * The song is stored in song.txt file, at the root level of tests
     */
    @Test
    public void allTheSong() throws Exception {
        String workingDirectory = System.getProperty("user.dir");
        Path path = Paths.get(workingDirectory, "src", "test", "song.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expected = String.join("\n", lines);
        Lyrics lyrics = new Lyrics(99);
        assertEquals(expected, lyrics.get());
    }

}

