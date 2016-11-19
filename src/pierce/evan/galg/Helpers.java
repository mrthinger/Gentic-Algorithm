package pierce.evan.galg;

public class Helpers {

	/*
	 * @return random upper/lower case char or a ' '. 
	 */
	public static char genChar(){
		//65-90 Uppercase letters
		char upper = (char) ((int)(Math.random() * 25) + 65);
		//97-122 lowercase letters
		char lower = (char) ((int)(Math.random() * 25) + 97);
		
		
		//pick if lower or upper 50/50 chance
		char c = (Math.random() > .5)? upper : lower;
		
		
		return (Math.random() >= 0.002)? c : ' ';
	}
	
}
