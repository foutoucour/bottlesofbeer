package coveo.qatest;

/**
 * Represents the song of X Bottles Of Beer. The song can be 99 bottles long but the size can change.
 */
public class Lyrics {

    private int numberOfBottles;

    /**
     * Constructor
     *
     * @param numberOfBottles number of bottle to drink
     */
    public Lyrics(int numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }

    /**
     * Return the lyrics of the song according to the number of bottles provided in the constructor.
     *
     * @return the lyrics of the song
     */
    public String get() {
        int[] reversedNumberOfBottles = new int[this.numberOfBottles];
        StringBuilder song = new StringBuilder();
        for (int i = this.numberOfBottles; i >= 0; i--) {
            song.append(buildLyricsFor(i));
        }
        return song.toString();
    }

    /**
     * Build the sentence for the lyrics according to the number of bottles provided.
     *
     * @param numberBottles the number of bottles
     * @return the lyrics related to the number of bottles
     */
    public String buildLyricsFor(int numberBottles) {
        switch (numberBottles) {
            case 0:
                return String.format(
                        "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                "Go to the store and buy some more, %s of beer on the wall.",
                        makeBottleAgreeWith(this.numberOfBottles)
                );
            case 1:
                return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take one down and pass it around, no more bottles of beer on the wall.\n";
            default:
                return String.format(
                        "%1$s of beer on the wall, %1$s of beer.\n" +
                                "Take one down and pass it around, %2$s of beer on the wall.\n",
                        makeBottleAgreeWith(numberBottles),
                        makeBottleAgreeWith(numberBottles - 1)
                );
        }
    }

    /**
     * Simple function to determite if the word "bottle" should be plural or singular
     *
     * @param numberBottles the number of bottles to consider to make the word "bottle" agree with.
     * @return the number of bottle and the word bottle
     */
    private String makeBottleAgreeWith(int numberBottles) {
        switch (numberBottles) {
            case 1:
                return "1 bottle";
            default:
                return String.format("%d bottles", numberBottles);
        }
    }
}
