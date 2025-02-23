import java.util.Arrays; //Handle array sorting
import java.util.Comparator; //Sort the population based on fitness


public class Main {

    public static void main(String[] args) {
        Population population = new Population(GeneticAlgorithm.POPULATION_SIZE);
        int generation = 0;

        while (generation < GeneticAlgorithm.MAX_GENERATIONS) {
            // Sort by fitness
            Arrays.sort(population.individuals, Comparator.comparingInt(i -> -i.fitness));

            // Print the best candidate
            Individual best = population.individuals[0];
            System.out.println("Generation " + generation + ": " + best.genes + " (Fitness: " + best.fitness + ")");

            // Check if we've found the target
            if (best.fitness == GeneticAlgorithm.TARGET.length()) {
                System.out.println("Target reached in " + generation + " generations!");
                break;
            }

             // Selection
            Individual[] parents = population.selectParents();

            // Generate new population using crossover and mutation
            Individual[] newIndividuals = new Individual[GeneticAlgorithm.POPULATION_SIZE];
            for (int i = 0; i < GeneticAlgorithm.POPULATION_SIZE; i++) {
                newIndividuals[i] = Population.crossover(parents[0], parents[1]);
                Population.mutate(newIndividuals[i]);
            }
            population.individuals = newIndividuals;

            generation++;
        }

    }
}