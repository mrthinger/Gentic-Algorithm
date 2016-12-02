package pierce.evan.galg;
/*
 * DNA has data and a fitness score that tells it how "fit" it is.
 * The more fit the DNA is the higher probability it will be bred into the next generation.
 */
public class DNA {

	private float fitness;
	private String data;
	private int length;
	
	//Generates random DNA.
	public DNA(){
		
		this.data = genRandomData(GeneticAlgMain.TARGET_LENGTH);
		this.length = this.data.length();
		this.fitness = calcFitness(GeneticAlgMain.TARGET);
		
	}
	
	//Generates DNA based off entered data.
	public DNA(String data){
		
		this.data = data;
		this.length = this.data.length();
		this.fitness = calcFitness(GeneticAlgMain.TARGET);
		
	}
	
	//Generates a random String of int length.
	public static String genRandomData(int length){
		
		String d = "";
		
		for(int i = 0; i < length; i++){
			d += Helpers.genChar();
		}
		return d;
		
	}
	
	//Fitness = #correct characters / total length.
	public float calcFitness(String target){
		int numCharCorrect = 0;
		for(int i = 0; i < length; i++){
			char targetChar = target.charAt(i);
			char dataChar = data.charAt(i);
			if(targetChar == dataChar){
				numCharCorrect++;
				
			}
		}
		
		this.fitness = ((float)numCharCorrect / (float)length);
		this.fitness = (float) Math.pow(fitness, 3);
		
		return fitness;
	}
	
	//return String data.
	public String getData(){
		return data;
	}
	
	//set String data.
	public void setData(String data){
		this.data = data;
	}
	
	//return fitness score.
	public float getFitness(){
		return fitness;
	}
	
	
}
