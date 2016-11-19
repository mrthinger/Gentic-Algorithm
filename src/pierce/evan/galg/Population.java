package pierce.evan.galg;

import java.util.ArrayList;

public class Population {

	public DNA[] population;
	private int popSize;
	private int gen;
	
	//Generates new population of popSize amount of DNA.
	public Population(int popSize){
		
		gen = 1;
		this.popSize = popSize;
		this.population = genRandPopulation(popSize);
		
	}
	
	//Adds 1 to generation counter.
	public void incrementGeneration(){
		gen++;
	}
	
	//Returns current generation.
	public int getGeneration(){
		return gen;
	}
	
	//Returns the DNA with the highest fitness in the population.
	public DNA getHighestFitnessDNA(){
		float highestFit = population[0].getFitness();
		int mostFitDNA = 0;
		
		
		for (int i = 0; i < population.length; i++){
			if(highestFit < population[i].getFitness()){
				highestFit = population[i].getFitness();
				mostFitDNA = i;
			}
		}
		
		
		return population[mostFitDNA];
	}
	
	/*
	 * Returns a population with random DNA.
	 * Size refers to the size of the population and not the DNA.
	 */
	public DNA[] genRandPopulation(int size){
		DNA[] pop = new DNA[size];
		
		for (int i = 0; i < pop.length; i++){
			
			pop[i] = new DNA();
			
		}
		return pop;
	}
	
	/*
	 * Assigns probability to each fitness by
	 * adding the same DNA to an ArrayList (fitness * 100) times (a number between 0-100).
	 * 
	 * It then picks 2 random numbers that are used as indexes to retrieve an element from
	 * that ArrayList. DNA that was added more times (because they had higher fitness) 
	 * have a higher probability of being selected.
	 * 
	 * Finally it takes those two DNA objects and uses the shuffle method to cross them over
	 * and create a new child DNA.
	 * 
	 * It does this popSize amount of times creating a whole new generation of the population.
	 * 
	 * Returns new population.
	 */
	public DNA[] crossover(){
		
		DNA[] newPop = new DNA[popSize];
		
		ArrayList<DNA> prob = new ArrayList<DNA>();
		
		for(int i = 0; i < population.length; i++){
			for	(int c = 0; c < population[i].getFitness() * 100; c++){
				prob.add(population[i]);
			}
			
		}
		
		DNA[] probA =  prob.toArray(new DNA[prob.size()]);
		
		for(int i = 0; i < population.length; i++){
			int n1 = (int) (Math.random() * (float)probA.length);
			int n2 = (int) (Math.random() * (float)probA.length);
			DNA d1 = probA[n1];
			DNA d2 = probA[n2];
			
			DNA d3 = shuffle(d1, d2);
			newPop[i] = d3;
		}
		
		population = newPop;
		return population;
	}

	/*
	 * Takes 50%(on avg) of d1 and 50%(on avg) of d2 and creates a new string of data.
	 * This is the actual crossing over of DNA.
	 */
	private DNA shuffle(DNA d1, DNA d2) {
		
		int dLength = d1.getData().length();
		String newData = "";
		
		for (int i = 0; i < dLength; i++){
			char c1 = d1.getData().charAt(i);
			char c2 = d2.getData().charAt(i);
			
			if(Math.random() > .5){
				newData += c1;
			}else{
				newData += c2;
			}
			
		}
		
		DNA shuffledDNA = new DNA(newData);
		
		return shuffledDNA;
	}
	

	/*
	 * Roll chance for each character in dna's data.
	 * If true, generate a new character for that spot.
	 * 
	 * Returns mutated population.
	 */
	public DNA[] mutate(double chance){
		for(int i = 0; i < population.length; i++){
			DNA d = population[i];
			
			String data = d.getData();
			
			for(int c = 0; c < data.length(); c++){
				if(Math.random() <= chance){
				StringBuilder sb = new StringBuilder(data);
				sb.setCharAt(c, Helpers.genChar());
				data = sb.toString();
				}
			}
			
			population[i] = new DNA(data);
			
		}
		return population;
	}
	
}
