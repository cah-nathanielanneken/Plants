/**
 * Creates a plant that can be planted and harvested in the garden
 * (See garden class)
 * @author Nathan Anneken
 * @version 1.0
 */
public class Plant {
	private final String PLANT_NAME;
	private int plantCurrentHeight;
	private final int PLANT_MAX_HEIGHT;
	private boolean harvested;
	private int xcord; //X cord. of the plant in the garden
	private int ycord; //Y cord. of the plant in the garden

	/**
	 * Constructs a plant with a given name, height, max height, and x and y
	 * coordinates in the garden.  
	 * @param plantName The name of this plant
	 * @param plantCurrentHeight The current height of this plant
	 * @param plantMaxHeight The max height of this plant
	 * @param xcord The x coordinate of this plant in the garden
	 * @param ycord The y coordinate of this plant in the garden
	 */
	public Plant(String plantName, int plantCurrentHeight, int plantMaxHeight,
			int xcord, int ycord) {
		this.PLANT_NAME = plantName;
		this.plantCurrentHeight = plantCurrentHeight;
		this.PLANT_MAX_HEIGHT = plantMaxHeight;
		this.harvested = false;
		this.xcord = xcord;
		this.ycord = ycord;
	}

	/**
	 * Determines whether this plant is ready to be harvested yet
	 * @return True if the plant is grown to full height, otherwise
	 * it returns false
	 */
	public boolean readyToBeHarvested() {
		if(plantCurrentHeight==PLANT_MAX_HEIGHT)
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the x coordinate of this plant in the garden
	 * @return the x coordinate of this plant in the garden
	 */
	public int getXcord() {
		return xcord;
	}

	/**
	 * Gets the y coordinate of this plant in the garden
	 * @return The y coordinate of this plant in the garden
	 */
	public int getYcord() {
		return ycord;
	}

	/**
	 * Converts this plant object into a string 
	 * @return The string representation of this plant
	 */
	public String toString() {
		return PLANT_NAME + ", Height " + plantCurrentHeight;
	}
	
	/**
	 * Returns whether or not this plant was harvested
	 * @return A boolean statement answering if the plant was harvested
	 */
	public boolean isHarvested() {
		return this.harvested;
	}

	/**
	 * Gets the name of this plant
	 * @return The name of this plant
	 */
	public String getPlantName() {
		return this.PLANT_NAME;
	}

	/**
	 * Gets the current height of this plant
	 * @return The current height of this plant
	 */
	public int getPlantCurrentHeight() {
		return this.plantCurrentHeight;
	}

	/**
	 * Gets the maximum height of this plant
	 * @return The maximum height of this plant
	 */
	public int getPlantMaxHeight() {
		return this.PLANT_MAX_HEIGHT;
	}

	/**
	 * Adds a given number of time to the height of the plants
	 * @param time The time added to the plants
	 */
	public void addingTime(int time) {
		this.plantCurrentHeight = this.plantCurrentHeight + time;
		if (this.PLANT_MAX_HEIGHT < this.plantCurrentHeight)
			this.plantCurrentHeight = this.PLANT_MAX_HEIGHT;
	}

	/**
	 * Sets the plant to harvested
	 */
	public void harvestPlant() {
		this.harvested = true;
	}

}
