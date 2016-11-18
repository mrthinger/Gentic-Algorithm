package pierce.evan.galg;

public class GeneticAlgMain {

	public static final String TARGET = "LOSE";
	public static final int TARGET_LENGTH = TARGET.length();

	public static void main(String[] args) {

		Population pop = new Population(20);

		for(int i = 0; i < pop.population.length; i++){

			System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());

		}
		
		for(int c = 0; c < 5; c++){
			pop.crossover();
			System.out.println("crossed over");

			pop.mutate(0.01F);
			System.out.println("mutated");

			for(int i = 0; i < pop.population.length; i++){

				System.out.println("DATA: " + pop.population[i].getData() + " FITNESS: " + pop.population[i].getFitness());

			}

		}
	}

}
