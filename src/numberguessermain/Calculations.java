package numberguessermain;
import numberguessermain.RemainderObject;
import numberguessermain.CalcObject;

public class Calculations {

	int mult70;
	int mult21;
	int mult15;
	
	int guessedNumber;
	
	public Calculations(int modThreeInput, int modFiveInput, int modSevenInput) {
		
		super();
		
		findNumber(modThreeInput,modFiveInput,modSevenInput);
		
	}
	
	public void findNumber(int modThreeInput, int modFiveInput, int modSevenInput) {
		
		RemainderObject r = new RemainderObject(modThreeInput, modFiveInput, modSevenInput);
		CalcObject c = new CalcObject(
				r.getRO3(),
				r.getRO5(),
				r.getRO7()
				);
		
		int addMults = c.getMult70() + c.getMult21() + c.getMult15();
		
		while (addMults > 100) {
			addMults = addMults - 105;
		}
		
		this.guessedNumber = addMults;
		
	}
	
	public int getGuessedNumber() { return this.guessedNumber; }
}
