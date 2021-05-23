
public class Bulk extends Container {
	
	private int weight;
	
	public Bulk(String text1, String text2, int num) {
		code = text1;
		destination = text2;
		weight = num;
	}
	
	public double calculateCharge() {
		return 10 * weight;
	}

}
