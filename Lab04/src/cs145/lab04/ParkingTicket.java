package cs145.lab04;

public class ParkingTicket {

	private PoliceOfficer officer;
	private ParkedCar car;
	private final int FINE = 25;

	/**
	 * Constructor for the parking ticket
	 * 
	 * @param car     The car object being issued a ticket
	 * @param officer The officer object issuing a ticket
	 * 
	 */

	public ParkingTicket(ParkedCar car, PoliceOfficer officer) {
		this.car = car;
		this.officer = officer;
	}

	/**
	 * Generates ParkingTicket object information as a string
	 * 
	 * @return name Police officers name
	 * @return badgeNumber Police officers badgeNumber
	 * 
	 */

	public String toString() {
		return car + " has been issued a ticket for " + FINE + " by " + officer + " for illegal parking.";
	}

}
