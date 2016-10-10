package numberguessermain;

public class RemainderObject {

	int remainderOfThree;
	int remainderOfFive;
	int remainderOfSeven;
	
	public RemainderObject(int remainderOfThree, int remainderOfFive, int remainderOfSeven) {
		
		super();
		
		setRO3(remainderOfThree);
		setRO5(remainderOfFive);
		setRO7(remainderOfSeven);
		
	}
	
	public int getRO3() { return this.remainderOfThree; }
	public void setRO3(int remainderOfThree) {
		this.remainderOfThree = remainderOfThree;
	}
	
	public int getRO5() { return this.remainderOfFive; }
	public void setRO5(int remainderOfFive) {
		this.remainderOfFive = remainderOfFive;
	}
	
	public int getRO7() { return this.remainderOfSeven; }
	public void setRO7(int remainderOfSeven) {
		this.remainderOfSeven = remainderOfSeven;
	}
}
