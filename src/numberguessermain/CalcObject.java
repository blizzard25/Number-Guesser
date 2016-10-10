package numberguessermain;

public class CalcObject {

	int mult70;
	int mult21;
	int mult15;
	
	public CalcObject(int ro3, int ro5, int ro7) {
		
		super();
		
		setMult70(ro3);
		setMult21(ro5);
		setMult15(ro7);
		
	}
	
	public int getMult70() { return this.mult70; }
	public void setMult70(int ro3) {
		this.mult70 = ro3 * 70;
	}
	
	public int getMult21() { return this.mult21; }
	public void setMult21(int ro5) {
		this.mult21 = ro5 * 21;
	}
	
	public int getMult15() { return this.mult15; }
	public void setMult15(int ro7) {
		this.mult15 = ro7 * 15;
	}
	
	
}
