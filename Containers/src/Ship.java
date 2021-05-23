import java.util.*;

public class Ship {
	
	private String name;
	private int maxNoOfContainers;
	private ArrayList<Container> containers;
	
	public String getName() {
		return name;
	}
	
	public Ship(String text, int number) {
		name = text;
		containers = new ArrayList<Container>();
		maxNoOfContainers = number;
	}
	
	public void addContainer(Container c) {
		if(containers.size() < maxNoOfContainers)
		   containers.add(c);
		else
			System.out.println("The ship is Full !!");
	}
	
	public double getTotalCharge() {
		double sum = 0;
		for(Container c : containers)
			sum += c.calculateCharge();
		
		return sum;
	}

}





