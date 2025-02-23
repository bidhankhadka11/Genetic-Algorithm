//Individual class - Represents an individual solution

public class Individual {
    //Instance Variables
    public String genes;   //Genetic squence: In this case a string representing solution
    public int fitness;
    //Constructor function
    public Individual(String genes) {
        this.genes = genes;
        this.fitness = GeneticAlgorithm.calculateFitness(genes);
    }

    //Generates and returns a new individual
    public static Individual randomIndividual() {
        return new Individual(GeneticAlgorithm.randomString(GeneticAlgorithm.TARGET.length()));
    }
} 