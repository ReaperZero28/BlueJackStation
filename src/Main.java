import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<String> id = new ArrayList<String>();
	static ArrayList<String> destination = new ArrayList<String>();
	static ArrayList<Integer> distance = new ArrayList<Integer>();
	static ArrayList<Float> price = new ArrayList<Float>();
	
	static void enterMenu() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	static void insertRoute( ){
		String inputID = new String();
		String inputDestination = new String();
		int inputDistance;
	
		do {
			inputID = "B";
			inputID = inputID + "J" + rand.nextInt(10);
		}while(id.contains(inputID));
		
		id.add(inputID);
		
		boolean flag;
		do {
			flag = false;
			inputDestination = scan.nextLine();
			System.out.println("Input route destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): " );
			
			if(inputDestination.equals("Jakarta") || inputDestination.equals("Bogor") || inputDestination.equals("Depok") || inputDestination.equals("Tangerang") || inputDestination.equals("Bekasi")) {
				flag = true;
			}
		}while(!flag);
		
		destination.add(inputDestination);
		
		do {
			inputDistance = scan.nextInt();
			System.out.println("Input route distance [1...1000]: ");
		}while(inputDistance<1 && inputDistance>1000);
		
		distance.add(inputDistance);
	
		float inputPrice = (inputDistance/2)*1000;
		inputPrice = inputPrice + 10000;
		price.add(inputPrice);
		
		System.out.println("Successfully added new route!");
		enterMenu();
	}
	
	static void viewRoute() {
		
		if(id.isEmpty()) {
			System.out.println("There are no routes available.");
		}
		else {
			System.out.println("ID\t" + "To\t" + "Distance\t" + "Price\t");
			for(int i=0; i<id.size(); i++) {
				System.out.println(id.get(i) + "\t" + destination.get(i) + "\t" + distance.get(i) + "\t" + price.get(i) + "\t");
			}
		}
	}
	
	static void updateRoute() {
		if(id.isEmpty()) {
			System.out.println("There are no routes available.");
		}
		else {
			viewRoute();
			//Input RouteID
			if(!id.isEmpty()) {
				System.out.println("Input Route ID to update: ");
				String newRouteID = scan.nextLine();
				if(id.contains(newRouteID)) {
					//Input Destination
					String newDestRoute = new String();
					do {
						newDestRoute = scan.nextLine();
						System.out.println("Input new destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive): " );
					}while(newDestRoute!="Jakarta" || newDestRoute!="Bogor" || newDestRoute!="Depok" || newDestRoute!="Tangerang" || newDestRoute!="Bekasi");
				
					destination.set(id.indexOf(newRouteID), newDestRoute);
				
					//Input Distance
					int newDistRoute;
					do {
						newDistRoute = scan.nextInt();
						System.out.println("Input new distance [1...1000]: ");
					}while(newDistRoute<1 && newDistRoute>1000);
				
					distance.set(id.indexOf(newRouteID), newDistRoute);
				
					//Calculate New Price
					float newPrice = (newDistRoute/2)*1000;
					newPrice = newPrice + 10000;
					price.set(id.indexOf(newRouteID), newPrice);
				
					System.out.println("Successfully updated Route " + newRouteID + "!");
				}
				else {
					System.out.println("Route ID is invalid!");
				}
			}
		}
		
		enterMenu();
	}
	
	public static void main(String[] args) {
		
		int input;
		do {
		System.out.println("BlueJack Station");
		System.out.println("=================");
		System.out.println("1. Insert route");
		System.out.println("2. View routes");
		System.out.println("3. Update route");
		System.out.println("4. Exit");
		System.out.print(">>");
		
		input = scan.nextInt();
		scan.nextLine();
		
		if(input==1) {
			insertRoute();
		}
		
		else if(input==2) {
			viewRoute();
		}
		else if(input==3) {
			updateRoute();
		}
	}
	while(input!=4);	
	}
}
