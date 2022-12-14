package cs145.lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkedCarTest {

	ParkedCar car1;
	ParkedCar car2;
	ParkedCar car3;
	ParkedCar car4;

	@BeforeEach
	void setUp() throws Exception {
		car1 = new ParkedCar(2001, "Chrysler", "T&C", "Blue", "77BAQ3");
		car2 = new ParkedCar(2022, "Tesla", "Model 3", "Red", "ELON1");
		car3 = new ParkedCar(1970, "Chevy", "Camaro", "Black", "AS0562");
		car4 = new ParkedCar(car1);
	}

	@Test
	void testParkedCarIntStringStringStringString() {
		assertEquals("2001 Chrysler T&C Blue 77BAQ3" ,car1.toString());
		assertEquals("2022 Tesla Model 3 Red ELON1",car2.toString());
		assertEquals("1970 Chevy Camaro Black AS0562",car3.toString());
	}
	
	@Test
	void testParkedCarParkedCar() {
		assertEquals(car1.toString(), car4.toString());
	}
	
	@Test
	void testToString() {
		assertEquals("2001 Chrysler T&C Blue 77BAQ3", car1.toString());
		assertEquals("2022 Tesla Model 3 Red ELON1", car2.toString());
		assertEquals("1970 Chevy Camaro Black AS0562", car3.toString());
	}
	
	

}
