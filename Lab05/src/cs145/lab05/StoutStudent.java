/**
 * 
 */
package cs145.lab05;

/**
 * @author MuzikQuincy
 *
 */
public class StoutStudent extends StoutPerson {

	enum Level {
		freshman, sophmore, junior, senior
	}

	private Level year;
	private String major;

	/**
	 * @return the year
	 */
	public Level getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Level year) {
		this.year = year;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 */
	public StoutStudent(int id, String lastName, String firstName) {
		super(id, lastName, firstName);
		year = Level.freshman;
		major = "Undeclared";
	}

	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param year
	 * @param major
	 */
	public StoutStudent(int id, String lastName, String firstName, Level year, String major) {
		super(id, lastName, firstName);
		this.year = year;
		this.major = major;
	}

	@Override
	public String role() {
		// TODO Auto-generated method stub
		return "takes classes";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n"+ this.major + " " +  this.year + " " + role() + "\n";
	}

}
