/**
 * 
 */
package cs145.lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author MuzikQuincy
 *
 */
class ComplexNumberTest {
	ComplexNumber empty;
	ComplexNumber test1;
	ComplexNumber test2;
	ComplexNumber test3;
	ComplexNumber arithmeticTests1;
	ComplexNumber arithmeticTests2;
	ComplexNumber arithmeticTests3;
	ComplexNumber arithmeticTests4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		empty = new ComplexNumber();
		test1 = new ComplexNumber(1, 2);
		test2 = new ComplexNumber(1);
		test3 = new ComplexNumber(test1);
		arithmeticTests1 = new ComplexNumber(5, 2);
		arithmeticTests2 = new ComplexNumber(5, -2);
		arithmeticTests3 = new ComplexNumber(-5, 2);
		arithmeticTests4 = new ComplexNumber(-5, -2);

	}

	@Test
	void testComplexNumber() {
		assertEquals(0, empty.getRealPart());
		assertEquals(0, empty.getImaginaryPart());
	}

	@Test
	void testComplexNumberDoubleDouble() {
		assertEquals(1, test1.getRealPart());
		assertEquals(2, test1.getImaginaryPart());
	}

	@Test
	void testComplexNumberDouble() {
		assertEquals(1, test2.getRealPart());
		assertEquals(0, test2.getImaginaryPart());
	}

	@Test
	void testComplexNumberComplexNumber() {
		assertEquals(test1.getRealPart(), test3.getRealPart());
		assertEquals(test1.getImaginaryPart(), test3.getImaginaryPart());
	}

	@Test
	void testGetRealPart() {
		assertEquals(0, empty.getRealPart());
	}

	@Test
	void testSetRealPart() {
		empty.setRealPart(1);
		assertEquals(1, empty.getRealPart());
	}

	@Test
	void testGetImaginaryPart() {
		assertEquals(0, empty.getImaginaryPart());
	}

	@Test
	void testSetImaginaryPart() {
		empty.setImaginaryPart(2);
		assertEquals(2, empty.getImaginaryPart());
	}

	@Test
	void testConjugate() {
		empty = test1.conjugate();
		assertEquals(test1.getRealPart(), empty.getRealPart());
		assertEquals(test1.getImaginaryPart() * -1, empty.getImaginaryPart());
	}

	@Test 
	void testAdd() {
		assertEquals(2,test1.add(test2).getRealPart());
		assertEquals(2,test1.add(test2).getImaginaryPart());
		
		assertEquals(6,test1.add(arithmeticTests1).getRealPart(),0.001);
		assertEquals(4,test1.add(arithmeticTests1).getImaginaryPart(),0.001);
		
		assertEquals(6,test1.add(arithmeticTests2).getRealPart(),0.001);
		assertEquals(0,test1.add(arithmeticTests2).getImaginaryPart(),0.001);
		
		assertEquals(-4,test1.add(arithmeticTests3).getRealPart(),0.001);
		assertEquals(4,test1.add(arithmeticTests3).getImaginaryPart(),0.001);
		
		assertEquals(-4,test1.add(arithmeticTests4).getRealPart(),0.001);
		assertEquals(0,test1.add(arithmeticTests4).getImaginaryPart(),0.001);
	}

	@Test
	void testSubtract() {
		assertEquals(0,test1.subtract(test2).getRealPart());
		assertEquals(2,test1.subtract(test2).getImaginaryPart());
		
		assertEquals(-4,test1.subtract(arithmeticTests1).getRealPart(),0.001);
		assertEquals(0,test1.subtract(arithmeticTests1).getImaginaryPart(),0.001);
		
		assertEquals(-4, test1.subtract(arithmeticTests2).getRealPart(),0.001);
		assertEquals(4, test1.subtract(arithmeticTests2).getImaginaryPart(),0.001);
		
		assertEquals(6, test1.subtract(arithmeticTests3).getRealPart(),0.001);
		assertEquals(0, test1.subtract(arithmeticTests3).getImaginaryPart(),0.001);
		
		assertEquals(6, test1.subtract(arithmeticTests4).getRealPart(),0.001);
		assertEquals(4, test1.subtract(arithmeticTests4).getImaginaryPart(),0.001);
	}


	@Test
	void testMultiply() {
		assertEquals(1,test1.multiply(test2).getRealPart());
		assertEquals(2,test1.multiply(test2).getImaginaryPart());
		
		assertEquals(1,test1.multiply(arithmeticTests1).getRealPart(),0.001);
		assertEquals(12,test1.multiply(arithmeticTests1).getImaginaryPart(),0.001);
		
		assertEquals(9,test1.multiply(arithmeticTests2).getRealPart(),0.001);
		assertEquals(8,test1.multiply(arithmeticTests2).getImaginaryPart(),0.001);
		
		assertEquals(-9,test1.multiply(arithmeticTests3).getRealPart(),0.001);
		assertEquals(-8,test1.multiply(arithmeticTests3).getImaginaryPart(),0.001);
		
		assertEquals(-1,test1.multiply(arithmeticTests4).getRealPart(),0.001);
		assertEquals(-12,test1.multiply(arithmeticTests4).getImaginaryPart(),0.001);
		
	}

	

	// test1 = 1, 2i
	// arithmeticTests1 = 5, 2i
	// arithmeticTests2 = 5, -2i
	// arithmeticTests3 = -5, 2i
	// arithmeticTests4 = -5, -2i
	@Test
	void testDivide() {
		assertEquals(1,test1.divide(test2).getRealPart());
		assertEquals(2,test1.divide(test2).getImaginaryPart());
		
		assertEquals(0.310,test1.divide(arithmeticTests1).getRealPart(), 0.001);
		assertEquals(0.275,test1.divide(arithmeticTests1).getImaginaryPart(),0.01);
		
		assertEquals(0.034,test1.divide(arithmeticTests2).getRealPart(),0.001);
		assertEquals(0.413,test1.divide(arithmeticTests2).getImaginaryPart(),0.001);
		
		assertEquals(-0.034,test1.divide(arithmeticTests3).getRealPart(),0.001);
		assertEquals(-0.413,test1.divide(arithmeticTests3).getImaginaryPart(),0.001);
		
		assertEquals(-0.310,test1.divide(arithmeticTests4).getRealPart(),0.001);
		assertEquals(-0.275,test1.divide(arithmeticTests4).getImaginaryPart(),0.001);
	}
}
