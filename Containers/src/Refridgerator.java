
public class Refridgerator extends Container {

	private double power;
	
	public Refridgerator(String text1, String text2, double num) {
		code = text1;
		destination = text2;
		power = num;
	}
	
	public double calculateCharge() {
		return 2000 * power;
	}
}
