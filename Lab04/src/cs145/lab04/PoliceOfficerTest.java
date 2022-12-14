package cs145.lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoliceOfficerTest {

	PoliceOfficer officer1;
	PoliceOfficer officer2;
	PoliceOfficer officer3;
	PoliceOfficer officer4;
	
	ParkedCar car1;
	ParkedCar car2;
	ParkedCar car3;
	ParkedCar car4;
	
	ParkingMeter meter1;
	ParkingMeter meter2;
	ParkingMeter meter3;
	

	@BeforeEach
	void setUp() throws Exception {
		officer1 = new PoliceOfficer("Joe Swanson", 10847);
		officer2 = new PoliceOfficer("Max Payne", 20013);
		officer3 = new PoliceOfficer("Dave Toschi", 19689);
		officer4 = new PoliceOfficer(officer1);
		
		car1 = new ParkedCar(2001, "Chrysler", "T&C", "Blue", "77BAQ3");
		car2 = new ParkedCar(2022, "Tesla", "Model 3", "Red", "ELON1");
		car3 = new ParkedCar(1970, "Chevy", "Camaro", "Black", "AS0562");
		car4 = new ParkedCar(car1);
		
		meter1 = new ParkingMeter(0);
		meter2 = new ParkingMeter(-40);
		meter3 = new ParkingMeter(1);

	}

	@Test
	void testPoliceOfficerStringInt() {
		assertEquals("Joe Swanson, 10847", officer1.toString());
		assertEquals("Max Payne, 20013", officer2.toString());
		assertEquals("Dave Toschi, 19689", officer3.toString());
	}

	@Test
	void testPoliceOfficerPoliceOfficer() {
		assertEquals(officer1.toString(),officer4.toString());
	}

	@Test
	void testParkingTicket() {
		assertEquals("2001 Chrysler T&C Blue 77BAQ3 has been issued a ticket for 25 by Joe Swanson, 10847 for illegal parking.", officer1.patrol(meter1, car1).toString());
		assertEquals("2022 Tesla Model 3 Red ELON1 has been issued a ticket for 25 by Dave Toschi, 19689 for illegal parking.", officer3.patrol(meter1, car2).toString());
		assertEquals("1970 Chevy Camaro Black AS0562 has been issued a ticket for 25 by Max Payne, 20013 for illegal parking.", officer2.patrol(meter1, car3).toString());
		assertEquals(null, officer1.patrol(meter3, car1));
	}
	
	@Test
	void testToString() {
		assertEquals("Joe Swanson, 10847", officer1.toString());
		assertEquals("Max Payne, 20013", officer2.toString());
		assertEquals("Dave Toschi, 19689", officer3.toString());
	}
	
	@Test
	void testPatrolMeterCar(){
		assertEquals(null,officer1.patrol(meter3, car1));
		assertEquals("2001 Chrysler T&C Blue 77BAQ3 has been issued a ticket for 25 by Joe Swanson, 10847 for illegal parking.",officer1.patrol(meter1, car1).toString());
	}

}
