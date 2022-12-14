package cs145.lab04;

public class PoliceOfficer {

	private String name;
	private int badgeNumber;

	/**
	 * Constructor for the police officer
	 * 
	 * @param name  Police Officers name
	 * @param badge Police Officers badge number
	 */

	public PoliceOfficer(String name, int badge) {
		this.name = name;
		this.badgeNumber = badge;
	}

	/**
	 * Copy constructor for Police Officer
	 * 
	 * @param officer New Police Officer
	 */

	public PoliceOfficer(PoliceOfficer officer) {
		this.name = officer.name;
		this.badgeNumber = officer.badgeNumber;
	}

	/**
	 * Generates Police officer object information as string
	 * 
	 * @return name Police officers name
	 * @return badgeNumber Police officers badgeNumber
	 * 
	 */

	public String toString() {
		return this.name + ", " + this.badgeNumber;
	}

	/**
	 * Generates parking ticket during patrol 
	 * 
	 * @param meter The time on the meter 
	 * @param car The car in the parking spot 
	 * 
	 * @return ParkingTicket Ticket for $25 if the meter time is zero
	 * @return null Default value if there is no parking ticket issued 
	 * 
	 */

	public ParkingTicket patrol(ParkingMeter meter, ParkedCar car) {
		if (meter.getTime() <= 0) {
			return new ParkingTicket(car, this);
		}
		return null;
	}

}
