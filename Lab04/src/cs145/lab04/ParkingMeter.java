package cs145.lab04;

public class ParkingMeter {

	private int time;

	/**
	 * Constructor for parking meter
	 * 
	 * @param time time that is being tracked in minutes
	 */
	public ParkingMeter(int time) {
		this.time = time;
	}
	
	/**
	 * Getter for time
	 * 
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Setter for time
	 * 
	 * @param time minutes on the meter 
	 */
	public void setTime(int time) {
		this.time = time;
	}
}
