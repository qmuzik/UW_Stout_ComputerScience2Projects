package cs145.lab04;

public class ParkedCar {

	private int year;
	private String make;
	private String model;
	private String color;
	private String license;

	/**
	 * Constructor for ParkedCar
	 *
	 * @param year    Cars manufactured year
	 * @param make    Make/Name of the car
	 * @param model   Name of the cars model
	 * @param color   Color of the car
	 * @param license License plate number on the car
	 * 
	 */

	public ParkedCar(int year, String make, String model, String color, String license) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.license = license;
	}

	/**
	 * Copy Constructor
	 *
	 * @param car The car being copied
	 */

	public ParkedCar(ParkedCar car) {
		this.year = car.year;
		this.make = car.make;
		this.model = car.model;
		this.color = car.color;
		this.license = car.license;
	}

	/**
	 * Used to print out car object 
	 * 
	 * @return cars year, make, model, color and license plate number 
	 */
	
	public String toString() {
		return year + " " + make + " " + model + " " + color + " " + license;
	}
}
