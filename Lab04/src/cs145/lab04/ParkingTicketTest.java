package cs145.lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingTicketTest {

	ParkingTicket ticket1;
	ParkingTicket ticket2;
	ParkingTicket ticket3;

	ParkedCar car1;
	ParkedCar car2;
	ParkedCar car3;

	PoliceOfficer officer1;
	PoliceOfficer officer2;
	PoliceOfficer officer3;

	ParkingMeter meter1;
	ParkingMeter meter2;
	ParkingMeter meter3;

	@BeforeEach
	void setUp() throws Exception {
		car1 = new ParkedCar(2001, "Chrysler", "T&C", "Blue", "77BAQ3");
		car2 = new ParkedCar(2022, "Tesla", "Model 3", "Red", "ELON1");
		car3 = new ParkedCar(1970, "Chevy", "Camaro", "Black", "AS0562");

		officer1 = new PoliceOfficer("Joe Swanson", 10847);
		officer2 = new PoliceOfficer("Max Payne", 20013);
		officer3 = new PoliceOfficer("Dave Toschi", 19689);

		meter1 = new ParkingMeter(0);
		meter2 = new ParkingMeter(-40);
		meter3 = new ParkingMeter(1);
	}

	@Test
	void testParkingTicketParkedCarPoliceOfficer() {
		assertEquals("2001 Chrysler T&C Blue 77BAQ3",car1.toString());
		assertEquals("Joe Swanson, 10847",officer1.toString());
		assertEquals("2022 Tesla Model 3 Red ELON1",car2.toString());
		assertEquals("Max Payne, 20013",officer2.toString());
		assertEquals("1970 Chevy Camaro Black AS0562",car3.toString());
		assertEquals("Dave Toschi, 19689",officer3.toString());
	}

	@Test
	void StringToString() {
		assertEquals("2001 Chrysler T&C Blue 77BAQ3 has been issued a ticket for 25 by Joe Swanson, 10847 for illegal parking.",officer1.patrol(meter1, car1).toString());
		assertEquals(null,officer2.patrol(meter3, car1));
	}

}
