/**
 * 
 */
package cs145.lab07;

/**
 * @author MuzikQuincy
 *
 */
public class SocSecException extends Exception {

	/**
	 * Default Constructor
	 */
	
	public SocSecException() {
		super("Invalid social security number");
	}
	
	/**
	 * Constructor for SocSecException
	 * 
	 * @param errorMessage
	 */
	public SocSecException(String errorMessage) {
		super("Invalid social security number " + errorMessage);
	}

}
