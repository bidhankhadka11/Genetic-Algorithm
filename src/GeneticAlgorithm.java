//Simple Genetic Algorithm to evolve the string to match the target phrase

//Core Algorithm
import java.util.Random; //Random class for generating random values

public class GeneticAlgorithm {

    public static final String TARGET = "HELLO WORLD";
    //private - variable cannot be accessed or modified outside the class (Encapsulation)
    //static - Shared accrosss all instances of class
    //final - value cannot be changed after initialization
    public static final String CHARACTERS = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int POPULATION_SIZE = 100;
    public static final double MUTATION_RATE = 0.01;
    public static final int MAX_GENERATIONS = 1000;

    //Random object for generating random numbers
    public static final Random random = new Random();


    //Generates a random character using allowed length and characters
    public static String randomString(int length) {
        //String in java are immutable so we use stringBuilder
        StringBuilder sb = new StringBuilder(length);

        for(int i = 0; i<length; i++) {  //Loop through each character position
            //Append a random character from CHARACTERS string at that position
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        //Convert SB to string and return
        return sb.toString();
    }


    public static int calculateFitness(String candidate) {
        int score = 0;

        for (int i = 0 ; i<TARGET.length(); i++) {
            if(candidate.charAt(i) == TARGET.charAt(i)) {
                score++;
            }
        }

        return score;
    }

}