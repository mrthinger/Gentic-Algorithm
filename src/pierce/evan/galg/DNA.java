package pierce.evan.galg;

public class DNA {

	private float fitness;
	private String data;
	private int length;
	
	public DNA(){
		
		this.length = GeneticAlgMain.TARGET_LENGTH;
		
	}
	
	public DNA(String data){
		
		this.length = GeneticAlgMain.TARGET_LENGTH;
		this.data = data;
		this.fitness = calcFitness(GeneticAlgMain.TARGET);
		
	}
	
	
	public static String genRandomData(int length){
		
		String d = "";
		
		for(int i = 0; i < length; i++){
			d += Helpers.genChar();
			
		}
		return d;
		
	}
	
	//Fitness = #correct / total length;
	public float calcFitness(String target){
		int numCharCorrect = 0;
		for(int i = 0; i < length; i++){
			char targetChar = target.charAt(i);
			char dataChar = data.charAt(i);
			if(targetChar == dataChar){
				numCharCorrect++;
				
			}
		}
		
		this.fitness = ((float)numCharCorrect / (float)length) + 0.01F;
		
		return fitness;
	}
	
	public String getData(){
		return data;
	}
	public void setData(String data){
		this.data = data;
	}
	
	public float getFitness(){
		return fitness;
	}
	
	
}
