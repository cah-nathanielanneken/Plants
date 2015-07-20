import java.util.ArrayList;
import java.util.*;

/**
 * This class provides methods to print the garden, add time to the plants, add
 * plants to the garden, harvest fully grown plants, and print a list of
 * previously harvested plants
 * 
 * @author Nathan Anneken
 * @version 1.2
 */
public class Garden {
	private String[][] plantedPlants = new String[10][5];
	private ArrayList<Plant> harvestPlants = new ArrayList<Plant>();

	/**
	 * Constructs the garden space
	 */
	public Garden() {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++)
				plantedPlants[x][y] = "--";
		}
	}

	/**
	 * Prints a view of the garden
	 */
	public void printGarden() {
		for (int y = 0; y < 5; y++) {
			if (y > 0)
				System.out.print("\n");
			for (int x = 0; x < 10; x++)
				System.out.print(plantedPlants[x][y].substring(0, 1)
						+ plantedPlants[x][y].substring(plantedPlants[x][y]
								.length() - 1) + " ");
		}
		System.out.println();
	}

	/**
	 * Adds time to the plants in the garden
	 */
	public void addTime() {
		Scanner input = new Scanner(System.in);
		System.out.print("How much time would you like to pass?");
		int time = input.nextInt(); // user inputed value for the time
		for (int x = 0; x < harvestPlants.size(); x++) {
			harvestPlants.get(x).addingTime(time); // Call to add time to the
													// Plant object
			if (!harvestPlants.get(x).isHarvested())
				plantedPlants[harvestPlants.get(x).getXcord()][harvestPlants
						.get(x).getYcord()] = plantedPlants[harvestPlants
						.get(x).getXcord()][harvestPlants.get(x).getYcord()]
						.substring(0, plantedPlants[harvestPlants.get(x)
								.getXcord()][harvestPlants.get(x).getYcord()]
								.length() - 1)
						+ harvestPlants.get(x).getPlantCurrentHeight(); 
			// Updates the view of the plants in the garden, specifically
			// the height
		}
	}

	/**
	 * Adds a plant to the garden
	 */
	public void addPlant() {
		Scanner input = new Scanner(System.in);
		String plant;
		System.out.print("What kind of plant would you like to plant? ");
		plant = input.nextLine(); // User inputed name for the plant
		plant = plant.trim(); // Trims the excess of the string
		System.out.print("What is the max height of this plant(<10)? ");
		int maxHeight = input.nextInt(); // User inputed max height for the
											// plant
		System.out.print("What is the current height of this plant(<10)? ");
		int currentHeight = input.nextInt();// User inputed current height for
											// the plant
		System.out.print("How many do you want to plant? ");
		int numberOfPlants = input.nextInt(); // Number of plants
		int xcordinate = 0; // X-Cord. of the plant location
		int ycordinate = 0; // Y-Cord. of the plant location

		for (int temp = 0; temp < numberOfPlants; temp++) {
			if (numberOfPlants == 1) {
				System.out.print("Where would you like to plant this plant? ");
				xcordinate = input.nextInt();
				ycordinate = input.nextInt();
				if (xcordinate > 10 || ycordinate > 5 || xcordinate < 0
						|| ycordinate < 0)
					throw new IllegalArgumentException("Invalid cordinates");
			} else {
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 10; x++) {
						if (plantedPlants[x][y].startsWith("-")) {
							xcordinate = x;
							ycordinate = y;
							x = 10;
							y = 5;
						}

					}
				}
			}

			Plant p = new Plant(plant, currentHeight, maxHeight, xcordinate,
					ycordinate);
			harvestPlants.add(p);
			plantedPlants[xcordinate][ycordinate] = p.getPlantName() + " "
					+ p.getPlantCurrentHeight(); // Inserts plant into garden
		}
	}

	/**
	 * Harvests the plant from the garden, removing the plant string from the
	 * garden and including the plant in the list of harvested plants
	 */

	public void harvestPlant() {
		Scanner input = new Scanner(System.in);
		System.out.print("Which plant would you like to harvest? ");
		String harvest = input.nextLine(); // Name of plant wanting to be
											// harvested
		harvest = harvest.trim();
		int temp = 0;
		for (int x = 0; x < harvestPlants.size(); x++) {
			if (harvest.equals(harvestPlants.get(x).getPlantName())
					&& harvestPlants.get(x).readyToBeHarvested()) {
				harvestPlants.get(x).harvestPlant(); // Checking to find matches
														// with the user inputed
														// string
				temp++; // Used to determine if a match was found or not
				for (int y = 0; y < 5; y++) {
					for (int z = 0; z < 10; z++) {
						if (plantedPlants[z][y].equals(harvestPlants.get(x)
								.getPlantName()
								+ " "
								+ harvestPlants.get(x).getPlantCurrentHeight()))
							plantedPlants[z][y] = "--"; // Removes plant string
														// from the garden
					}
				}
			} else if (harvest.equals(harvestPlants.get(x).getPlantName())) {
				System.out.println("Plant not available for harvest"); // If
																		// match
																		// is
																		// found
																		// but
																		// not
																		// ready
																		// for
																		// harvesting
				temp++;
			} else if (x == harvestPlants.size() - 1 && temp == 0)
				System.out.println("No plants found matching that name");
		}

	}

	/**
	 * Prints all the plants that have been harvested on the farm
	 */
	public void printHarvestedPlants() {
		int y = 0;
		for (int x = 0; x < harvestPlants.size(); x++) {
			if (harvestPlants.get(x).isHarvested()) {
				System.out.println(harvestPlants.get(x).toString());
				y++;
			}
		}
		if (y == 0)
			System.out.println("No plants harvested");
	}
}
