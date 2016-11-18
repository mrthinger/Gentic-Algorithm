package pierce.evan.galg;

public class GeneticAlgMain {

	public static final String TARGET = "SUPER LONG";
	public static final int TARGET_LENGTH = TARGET.length();
	
	public static final int POPULATION_SIZE = 200;
	public static final double MUTATION_RATE = 0.02;

	//Lower population means lower initial gene pool
	//Lower population requires higher mutation rate to introduce new genes
	
	//higher population means larger initial gene pool
	//therefore less mutation is required to introduce new genes
	
	public static void main(String[] args) {

		Population pop = new Population(POPULATION_SIZE);

		for(int i = 0; i < pop.population.length; i++){

			System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());

		}
		
		while(pop.getHighestFitness() < 1.0){
			pop.crossover();
			System.out.println("crossed over");

			pop.mutate(MUTATION_RATE);
			System.out.println("mutated");
			
			pop.incrementGeneration();

			for(int i = 0; i < pop.population.length; i++){

				System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());
				
				
			}
			
		}
		
		System.out.println(pop.getGeneration() + " Generations to get to target: " + TARGET);
		
	
	}

}
