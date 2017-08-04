package coveo.qatest;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class BottlesOfBeerTest {

    private BottlesOfBeer bottlesOfBeer;
    private int initialNumberOfBeer;

    @Before
    public void setUp() {
        this.initialNumberOfBeer = 14;
        this.bottlesOfBeer = new BottlesOfBeer(this.initialNumberOfBeer);
    }

    @Test
    public void whenBottleIsForteen_thenWeDrink() throws Exception {
        String expected = "14 bottles of beer on the wall, 14 bottles of beer.\n" +
                "Take one down and pass it around, 13 bottles of beer on the wall.\n";

        assertEquals(expected, this.bottlesOfBeer.getSentence(14));
    }

    @Test
    public void whenBottleIsTwo_thenWeDrinkButOnlyOneLeft() throws Exception {
        String expected = "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.\n";

        assertEquals(expected, this.bottlesOfBeer.getSentence(2));
    }

    @Test
    public void whenBottleIsOne_thenWeDrinkButNoMore() throws Exception {
        String expected = "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.\n";

        assertEquals(expected, this.bottlesOfBeer.getSentence(1));
    }

    @Test
    public void whenBottleIsZero_thenWeBuy() throws Exception {
        String expected = String.format(
                "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, %d bottles of beer on the wall.",
                this.initialNumberOfBeer
        );
        assertEquals(expected, this.bottlesOfBeer.getSentence(0));
    }

    /*
    Test against all the song.
    The song is stored in {root}/song.txt file
     */
    @Test
    public void allTheSong() throws Exception {
        String workingDirectory = System.getProperty("user.dir");
        Path path = Paths.get(workingDirectory, "src", "test", "java", "coveo", "qatest", "song.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expected = String.join("\n", lines);
        BottlesOfBeer bottlesOfBeer = new BottlesOfBeer(99);
        assertEquals(expected, bottlesOfBeer.sing());
    }

}

