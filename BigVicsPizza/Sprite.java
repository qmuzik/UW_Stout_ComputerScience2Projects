package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The Sprite class represents a sprite that will be shown on the PizzaMakerPane.
 * 
 * The Sprite class represents a sprite that will be either a still image or an animated image
 * that will be shown on the PizzaMakerPane. A sprite's location can be assigned and if the sprite is
 * to be animated, its velocity can be adjusted as well.
 * 
 * @author MondragonVictor
 * @version 2022.05.04
 */
public class Sprite {

	private Image image;
	private double xPos;
	private double yPos;
	private double xVelocity;
	private double width;
	private double height;
	
	/**
	 * Creates a sprite and assigns its initial position and velocity
	 */
	public Sprite() {
		xPos = 0;
		yPos = 0;
		xVelocity = 0;
	}
	
	/**
	 * Sets the image that will be attached to the sprite by using an Image item
	 * 
	 * @param image The image that will be attached to the sprite
	 */
	public void setImage(Image image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	/**
	 * Sets the image that will be attached to the sprite by using a file name
	 * 
	 * @param filename The name of the image file that will be attached to the sprite
	 */
	public void setImage(String filename) {
		Image image = new Image(filename);
		setImage(image);
	}
	
	/**
	 * Sets the position of a sprite
	 * 
	 * @param x The x-position of the sprite
	 * @param y The y-position of the sprite
	 */
	public void setPosition(double x, double y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Gets the x-position of the sprite
	 * 
	 * @return The x-position of the sprite
	 */
	public double getXPos() {
		return xPos;
	}
	
	/**
	 * Gets the y-position of the sprite
	 * 
	 * @return The y-position of the sprite
	 */
	public double getYPos() {
		return yPos;
	}
	
	/**
	 * Sets the x-velocity of the sprite
	 * 
	 * @param x The desired velocity to set as the x-velocity
	 */
	public void setVelocity(double x) {
		xVelocity = x;
	}
	
	/**
	 * Gets the x-velocity of the sprite
	 * 
	 * @return The x-velocity of the sprite
	 */
	public double getVelocity() {
		return xVelocity;
	}
	
	/**
	 * Takes a set amount off the x-velocity
	 * 
	 * @param x The desired amount to decrease the x-velocity by
	 */
	public void subtractVelocity(double x) {
		xVelocity -= x;
		if (xVelocity < 0) {
			xVelocity = 0;
		}
	}
	
	/**
	 * Adjusts the position of the sprite according to the velocity and time passed. Also decreases
	 * the velocity, giving the sprite a decelerating effect
	 * 
	 * @param time The amount of time passed to move the sprite the correct amount over said time
	 */
	public void update(double time) {
		xPos += xVelocity * time;
		subtractVelocity(10);
	}
	
	/**
	 * Renders the sprite
	 * 
	 * @param gc The graphics context object that allows the images to be drawn/rendered
	 */
	public void render(GraphicsContext gc) {
		gc.drawImage(image, xPos, yPos);
	}
	
	/**
	 * Returns a new 2D rectangle
	 * 
	 * @return New 2D rectangle
	 */
	public Rectangle2D getBoundary()
	{
		return new Rectangle2D(xPos, yPos, width, height);
	}
}
