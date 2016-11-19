package pierce.evan.galg;

public class GeneticAlgMain {

	public static final String TARGET = "Genetic Algorithms Are Cool";
	public static final int TARGET_LENGTH = TARGET.length();

	public static final int POPULATION_SIZE = 2000;
	public static final double MUTATION_RATE = 0.005;

	//Lower population means lower initial gene pool
	//Lower population requires higher mutation rate to introduce new genes

	//higher population means larger initial gene pool
	//therefore less mutation is required to introduce new genes

	public static void main(String[] args) {

		
		//Create initial random population
		Population pop = new Population(POPULATION_SIZE);

		//Print out all DNAs from population generation #1 (initial generation)
		for(int i = 0; i < pop.population.length; i++){

			System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());

		}
		
		//Only print out the best of a generation
		System.out.println("BEST OF EACH GENERATION: ");

		System.out.println("GEN: " + pop.getGeneration() 
		+ " DATA: " + pop.getHighestFitnessDNA().getData()
		+ " FITNESS: " + pop.getHighestFitnessDNA().getFitness());

		//Continue to reproduce until perfect DNA is found ("perfect is when fitness = 1")
		while(pop.getHighestFitnessDNA().getFitness() < 1.0){
			//Combine best DNA together
			pop.crossover();

			//Mutate population
			pop.mutate(MUTATION_RATE);

			//Is now a new generation of DNA, so increment it
			pop.incrementGeneration();

			/* Uncomment for visual of all DNA

			for(int i = 0; i < pop.population.length; i++){

				System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());


			}
			 */

			//print out the best of a generation
			System.out.println("GEN: " + pop.getGeneration() 
			+ " DATA: " + pop.getHighestFitnessDNA().getData()
			+ " FITNESS: " + pop.getHighestFitnessDNA().getFitness());

		}
		
		//Final verdict
		System.out.println(pop.getGeneration() + " Generations to get to target: " + TARGET);


	}


}
