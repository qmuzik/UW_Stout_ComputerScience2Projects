/**
 * 
 */
package cs145.lab05;

/**
 * @author MuzikQuincy
 *
 */

public abstract class StoutPerson implements Comparable<StoutPerson>{

	private int id;
	private String lastName;
	private String firstName;

	/**
	 * Constructor for Stout Person
	 * 
	 * @param id
	 * @param lastName
	 * @param firstName
	 */

	public StoutPerson(int id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Abstract method for the class
	 */

	public abstract String role();

	/**
	 * Override toString method
	 * 
	 * @ return id
	 */

	@Override
	public String toString() {
		return this.lastName + ", " + this.firstName + "\n" + "ID: " + this.id;
	}

	public int compareTo(StoutPerson person) {
		return this.lastName.compareTo(person.getLastName());
	}
}
