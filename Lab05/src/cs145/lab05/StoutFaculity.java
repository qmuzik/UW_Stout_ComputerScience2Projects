/**
 * 
 */
package cs145.lab05;

/**
 * @author MuzikQuincy
 *
 */
public class StoutFaculity extends StoutPerson {

	private String position;

	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 */
	public StoutFaculity(int id, String lastName, String firstName) {
		super(id, lastName, firstName);
		position = "Instructor";
	}

	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param position
	 */
	public StoutFaculity(int id, String lastName, String firstName, String position) {
		super(id, lastName, firstName);
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String role() {
		// TODO Auto-generated method stub
		return "teaches students";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + this.position + " " + role() + "\n";
	}

}
