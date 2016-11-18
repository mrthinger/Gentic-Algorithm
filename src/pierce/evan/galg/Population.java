package pierce.evan.galg;

import java.util.ArrayList;

public class Population {

	public DNA[] population;
	private int popSize;
	private int gen;
	
	public Population(int popSize){
		
		gen = 1;
		this.popSize = popSize;
		this.population = genRandPopulation(popSize);
		
		
	}
	
	public void incrementGeneration(){
		gen++;
	}
	
	public int getGeneration(){
		return gen;
	}
	
	public float getHighestFitness(){
		float highestFit = population[0].getFitness();
		
		
		for (int i = 0; i < population.length; i++){
			if(highestFit < population[i].getFitness()){
				highestFit = population[i].getFitness();
			}
		}
		
		
		return highestFit;
	}
	
	
	public DNA[] genRandPopulation(int size){
		DNA[] pop = new DNA[size];
		
		for (int i = 0; i < pop.length; i++){
			
			pop[i] = new DNA(DNA.genRandomData(GeneticAlgMain.TARGET_LENGTH));
			
		}
		
		System.out.println(pop[2].getData());
		return pop;
	}
	
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
