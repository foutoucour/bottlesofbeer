package coveo.qatest;

import java.util.stream.IntStream;

public class BottlesOfBeer {

    private int numberOfBottles;

    public BottlesOfBeer(int numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }

    public String sing() {
        int[] reversedNumberOfBottles = new int[this.numberOfBottles];
        String song = "";
        for (int i = this.numberOfBottles; i >= 0; i--) {
            song += getSentence(i);
        }
        return song;
    }

    public String getSentence(int i) {
        switch (i) {
            case 0:
                return String.format(
                        "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                "Go to the store and buy some more, %s of beer on the wall.",
                        getBottle(this.numberOfBottles)
                );
            case 1:
                return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take one down and pass it around, no more bottles of beer on the wall.\n";
            default:
                return String.format(
                        "%s of beer on the wall, %s of beer.\n" +
                                "Take one down and pass it around, %s of beer on the wall.\n",
                        getBottle(i), getBottle(i), getBottle(i - 1)
                );
        }
    }

    private String getBottle(int bottle) {
        switch (bottle) {
            case 1:
                return "1 bottle";
            default:
                return String.format("%d bottles", bottle);
        }
    }
}
