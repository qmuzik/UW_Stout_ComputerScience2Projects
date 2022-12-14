/**
 * 
 */
package cs145.lab05;

/**
 * @author MuzikQuincy
 *
 */
public class StoutSI extends StoutStudent {

	private String course;
	
	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 */
	public StoutSI(int id, String lastName, String firstName) {
		super(id, lastName, firstName);
	}

	/**
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param year
	 * @param major
	 */
	public StoutSI(int id, String lastName, String firstName, Level year, String major,String course) {
		super(id, lastName, firstName, year, major);
		this.course = course;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String role() {
		return super.role() + " and teaches students";
	}
	
	@Override
	public String toString() {
		return super.toString() + this.course;
	}

}
