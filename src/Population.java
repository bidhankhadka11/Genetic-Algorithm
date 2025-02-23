import java.util.Arrays; //Handle array sorting
import java.util.Comparator; //Sort the population based on fitness

class Population {
    Individual[] individuals;

    public Population(int size) {
        //Create an array of individuals of a size
        individuals = new Individual[size];

        //Create and store a random individual in the array of individuals
        for (int i = 0; i<size; i++) {
            individuals[i] = Individual.randomIndividual();
        }
    }

    //Select the top two fittest individuals from the population for parents
    public Individual[] selectParents() {
        Arrays.sort(individuals, Comparator.comparingInt(i -> -i.fitness)); //Sort by fitness

        return new Individual[] {individuals[0], individuals[1]};
    }

    //Crossover : Combine genes from individuals to parent to create a child
    public static Individual crossover(Individual parent1, Individual parent2) {

        StringBuilder childGenes = new StringBuilder(); 

        for(int i = 0; i< parent1.genes.length(); i++) {
            //Append genes from parent randomly
            if(Math.random() > 0.5 ) {
                childGenes.append(parent1.genes.charAt(i));
            } else {
                childGenes.append(parent2.genes.charAt(i));
            }
        }

        return new Individual(childGenes.toString());
    }


    public static void mutate(Individual individual) {
        char[] genes = individual.genes.toCharArray();

        for(int i = 0; i<genes.length; i++) {
            if(Math.random() < GeneticAlgorithm.MUTATION_RATE) {
                genes[i] = GeneticAlgorithm.CHARACTERS.charAt(GeneticAlgorithm.random.nextInt(GeneticAlgorithm.CHARACTERS.length()));
            }
        }

        individual.genes = new String(genes);
        individual.fitness = GeneticAlgorithm.calculateFitness(individual.genes);
    }
}