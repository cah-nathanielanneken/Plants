import java.util.*;
/**
 * User interface for interactions in the farm.  The user selects 
 * from 6 different choices whether to print a picture of the garden,
 * add a plant to the garden, add time to the plant, harvest the plants,
 * check the harvested plants, or to leave the garden.
 * @author Nathan Anneken
 * @version 1.0
 */
 
public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Garden p = new Garden();
		int userInput;
		do {
			System.out.println("Welcome to the wonderful world of Plants!");
			System.out.println("1: Print Garden");
			System.out.println("2: Add Plant");
			System.out.println("3: Add Time");
			System.out.println("4: Harvest Plant");
			System.out.println("5: Check Harvested Plants");
			System.out.println("6: Leave the Farm");
			System.out.print("Please enter your choice: ");
			for (userInput = input.nextInt(); userInput < 0 || userInput > 6; userInput = input
					.nextInt())
				System.out.println("Please enter a valid choice: ");
			if (userInput == 1)
				p.printGarden();
			if (userInput == 2)
				p.addPlant();
			if (userInput == 3)
				p.addTime();
			if (userInput == 4)
				p.harvestPlant();
			if (userInput == 5)
				p.printHarvestedPlants();
		} while (userInput != 6);
		System.out.println("Thanks for stopping by!");
	}
}
