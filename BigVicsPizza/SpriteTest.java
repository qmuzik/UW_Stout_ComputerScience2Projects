package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author MondragonVictor
 *
 */
class SpriteTest {
	Sprite sprite;

	@BeforeEach
	void setUp() throws Exception {
		sprite = new Sprite();
	}

	/**
	 * This tests the getXPos() method
	 */
	@Test
	void testGetXPos() {
		sprite.setPosition(5, 7);
		assertEquals(5.0, sprite.getXPos());
	}

	/**
	 * This tests the getYPos() method
	 */
	@Test
	void testGetYPos() {
		sprite.setPosition(5, 7);
		assertEquals(7.0, sprite.getYPos());	}

	/**
	 * This tests the getVelocity() method
	 */
	@Test
	void testGetVelocity() {
		sprite.setVelocity(50);
		assertEquals(50, sprite.getVelocity());
	}

	/**
	 * This tests the subtractVelocity() method
	 */
	@Test
	void testSubtractVelocity() {
		sprite.setVelocity(30);
		assertEquals(30, sprite.getVelocity());
		sprite.subtractVelocity(15.5);
		assertEquals(14.5, sprite.getVelocity());
	}

}
