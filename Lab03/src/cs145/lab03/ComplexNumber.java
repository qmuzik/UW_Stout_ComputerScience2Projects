package cs145.lab03;

/**
 * The ComplexNumber Class represents a number that has two parts.
 * 
 * The ComplexNumber Class represents a number in num(x) form. For example, 5i
 * has both an real part (5) and imaginary part (i).
 * 
 * @author Quincy Muzik
 * @version 2022.02.12
 */

public class ComplexNumber {

	private double realPart;
	private double imaginaryPart;

	/**
	 * Creates a ComplexNumber equal to 0
	 */

	public ComplexNumber() {
		realPart = 0;
		imaginaryPart = 0;
	}

	/**
	 * Creates a ComplexNumber with a real and imaginary part
	 * 
	 * @param realPart      The double numeric value of the number
	 * @param imaginaryPart The imaginary value of the number
	 */

	public ComplexNumber(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	/**
	 * Creates a ComplexNumber without an imaginary part
	 * 
	 * @param realPart The double numeric value of the number
	 */

	public ComplexNumber(double realPart) {
		this.realPart = realPart;
		imaginaryPart = 0;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other ComplexNumber that will be used to copy
	 */

	public ComplexNumber(ComplexNumber other) {
		this.realPart = other.realPart;
		this.imaginaryPart = other.imaginaryPart;
	}

	/**
	 * Gets the real part
	 * 
	 * @return the realPart
	 */
	public double getRealPart() {
		return realPart;
	}

	/**
	 * Sets the real part
	 * 
	 * @param realPart the realPart to set
	 */
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	/**
	 * Gets the imaginary part
	 * 
	 * @return the imaginaryPart
	 */
	public double getImaginaryPart() {
		return imaginaryPart;
	}

	/**
	 * Sets the imaginary part
	 * 
	 * @param imaginaryPart the imaginaryPart to set
	 */
	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	/**
	 * Creates the conjugate
	 * 
	 * @return conjugatedNumber The imaginary and real parts in conjugate form
	 **/

	public ComplexNumber conjugate() {
		ComplexNumber conjugatedNumber = new ComplexNumber(this);

		conjugatedNumber.setImaginaryPart(this.imaginaryPart * -1);

		return conjugatedNumber;
	}

	/**
	 * Displays mathematics and final answer
	 * 
	 * @return the final output
	 **/

	public String toString() {

		return realPart + " + " + imaginaryPart + "i";

	}

	/**
	 * Performs addition on the complex numbers
	 * 
	 * @param ComplexNumber input numbers that are being calculated
	 * 
	 * @return addittionAnswer result after performing additon
	 **/

	public ComplexNumber add(ComplexNumber input) {

		// Use the default constructor for effiecency
		ComplexNumber addittionAnswer = new ComplexNumber();

		addittionAnswer.setRealPart(input.getRealPart() + this.getRealPart());
		addittionAnswer.setImaginaryPart(input.getImaginaryPart() + this.getImaginaryPart());

		return addittionAnswer;

	}

	/**
	 * Performs subtraction on the complex numbers
	 * 
	 * @param ComplexNumber input numbers that are being calculated
	 * 
	 * @return subtractAnswer result after performing subtraction
	 **/

	public ComplexNumber subtract(ComplexNumber input) {

		ComplexNumber subtractAnswer = new ComplexNumber();

		subtractAnswer.setRealPart(this.getRealPart() - input.getRealPart());
		subtractAnswer.setImaginaryPart(this.getImaginaryPart() - input.getImaginaryPart());

		return subtractAnswer;
	}

	/**
	 * Performs multiplication on the complex numbers
	 * 
	 * @param ComplexNumber input numbers that are being calculated
	 * 
	 * @return multiplicationAnswer result after performing multiplication
	 **/

	public ComplexNumber multiply(ComplexNumber input) {

		ComplexNumber multiplicationAnswer = new ComplexNumber();

		multiplicationAnswer.setRealPart(
				this.getRealPart() * input.getRealPart() - this.getImaginaryPart() * input.getImaginaryPart());
		multiplicationAnswer.setImaginaryPart(
				this.getRealPart() * input.getImaginaryPart() + this.getImaginaryPart() * input.getRealPart());

		return multiplicationAnswer;
	}

	/**
	 * Performs division on the complex numbers
	 * 
	 * @param ComplexNumber input numbers that are being calculated
	 * 
	 * @return divisionAnswer result after performing division
	 **/

	public ComplexNumber divide(ComplexNumber input) {

		ComplexNumber divisionAnswer = new ComplexNumber();

		divisionAnswer.setRealPart(
				(this.getRealPart() * input.getRealPart() + this.getImaginaryPart() * input.getImaginaryPart())
						/ ((input.getRealPart() * input.getRealPart())
								+ (input.getImaginaryPart() * input.getImaginaryPart())));
		divisionAnswer.setImaginaryPart(((this.getImaginaryPart() * input.getRealPart())
				- (this.getRealPart() * input.getImaginaryPart())) / (Math.pow(input.getRealPart(), 2) + Math.pow(input.getImaginaryPart(), 2)));

		return divisionAnswer;
	}
}
