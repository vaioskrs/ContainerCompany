import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ship ship1 = new Ship("Olympia", 450);
		Ship ship2 = new Ship("Titan", 250);
		Ship ship3 = new Ship("Copacabana", 300);
		
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		
		MyFrame mf = new MyFrame(ships);		
	}

}







