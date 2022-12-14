package cs145.lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingMeterTest {
	
	ParkingMeter empty;
	ParkingMeter test1;
	ParkingMeter test2;
	ParkingMeter test3;
	

	@BeforeEach
	void setUp() throws Exception {
		empty = new ParkingMeter(0);
		test1 = new ParkingMeter(1);
		test2 = new ParkingMeter(10);
		test3 = new ParkingMeter(-1);	
	}

	@Test
	void testParkingMeter() {
		assertEquals(0,empty.getTime());
		assertEquals(1,test1.getTime());
		assertEquals(10,test2.getTime());
		assertEquals(-1,test3.getTime());
	}
	
	@Test 
	void testGetTime() {
		assertEquals(0,empty.getTime());
		assertEquals(1,test1.getTime());
		assertEquals(10,test2.getTime());
		assertEquals(-1,test3.getTime());
	}

	@Test
	void testSetTime() {
		empty.setTime(1);
		assertEquals(1,empty.getTime());
	}
}