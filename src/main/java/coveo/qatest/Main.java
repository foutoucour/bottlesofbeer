package coveo.qatest;

public class Main {

    public static void main(String[] args) {
        // Check how many arguments were passed in
        if(args.length == 0)
        {
            System.out.println("A number of bottles should be provided. Aborted.");
            System.exit(1);
        }

        int numberOfBottles = Integer.parseInt(args[0]);
        BottlesOfBeer bottles = new BottlesOfBeer(numberOfBottles);
        System.out.println(bottles.sing());
    }
}
