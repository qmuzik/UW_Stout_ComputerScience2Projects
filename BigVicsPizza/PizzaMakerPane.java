package application;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * The PizzaMakerPane class is an extension of BorderPane that makes up the pizza making portion of
 * our program.
 * 
 * The PizzaMakerPane class is an extension of BorderPane that allows people to create a pizza of their
 * own. When the user enters the page, a blank pizza will slide into frame and instructions found 
 * at the top tells them to select a checkbox that will add the corresponding topping to their pizza.
 * They are also prompted to press the 'F' key when they finish topping their pizza, as that will allow
 * them to move onto the next screen, which is where they'll enter their address info. The user is paying
 * with cash, so they don't need to worry about card info.
 * 
 * @author MondragonVictor
 * @version 2022.05.04
 */
public class PizzaMakerPane extends BorderPane {
	private int numToppings = 0;
	private CheckBox pepperoniBox, sausageBox, mushroomBox, oliveBox;
	private Text instructions;
	private Sprite crust;
	private Canvas pizzaPane;
	private GraphicsContext gc;
	private long lastNanoTime;
	private Sprite[][]  pepperoni, sausage, mushroom, olive;
	
	
	/**
	 * Creates a PizzaMakerPane, which is made up of 3 different panes
	 */
	public PizzaMakerPane() {
		setupTopPane();
		setupCenterPane();
		setupBottomPane();
	}
	
	/**
	 * Sets up the top pane of the PizzaMakerPane
	 */
	private void setupTopPane() {
		instructions = new Text("Select a checkbox to add that topping to your pizza!\nPress the 'F' key to move onto the payment screen");
		
		FlowPane topPane = new FlowPane(instructions);
		topPane.setAlignment(Pos.CENTER);
		setTop(topPane);
	}
	
	/**
	 * Sets up the center pane of the PizzaMakerPane, creating the canvas that the pizza will 
	 * appear on
	 */
	private void setupCenterPane() {
		
		pizzaPane = new Canvas(500, 500);
		gc = pizzaPane.getGraphicsContext2D();
		gc.setFill(Color.ANTIQUEWHITE);
		
		lastNanoTime = System.nanoTime();
		
		createSprites("pizzasprite.png");
		createSprites("pepperoni.png");
		createSprites("sausage.png");
		createSprites("mushroom.png");
		createSprites("blackolive.png");

		
		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				double elapsedTime = (currentNanoTime - lastNanoTime) / 1000000000.0;
				lastNanoTime = currentNanoTime;
				
				crust.update(elapsedTime);
				
				gc.clearRect(0, 0, 500, 500);
				crust.render(gc);
				
				if(pepperoniBox.isSelected()) {
					for(int i = 0; i < 4; i++) {
						for (int t = 0; t < 4; t++) {
							pepperoni[i][t].render(gc);
						}
					}
				}
				
				if(mushroomBox.isSelected()) {
					for(int i = 0; i < 3; i++) {
						for (int t = 0; t < 4; t++) {
							mushroom[i][t].render(gc);
						}
					}
				}
				
				if(sausageBox.isSelected()) {
					for(int i = 0; i < 5; i++) {
						for (int t = 0; t < 3; t++) {
							sausage[i][t].render(gc);
						}
					}
				}
				
				if(oliveBox.isSelected()) {
					for (int i = 0; i < 4; i++) {
						for (int t = 0; t < 5; t++) {
							olive[i][t].render(gc);
						}
					}
				}
				
			}
			
		}.start();
		
		FlowPane centerPane = new FlowPane(pizzaPane);
		centerPane.setAlignment(Pos.CENTER);
		setCenter(centerPane);
		
	}
	
	/**
	 * Sets up the bottom pane of the PizzaMakerPane, adding the four checkboxes that allow the user
	 * to add toppings to their pizza
	 */
	private void setupBottomPane() {
		pepperoniBox = new CheckBox("Pepperoni");
		pepperoniBox.setOnAction(this::processPepperoni);
		
		sausageBox = new CheckBox("Sausage");
		sausageBox.setOnAction(this::processSausage);
		
		mushroomBox = new CheckBox("Mushroom");
		mushroomBox.setOnAction(this::processMushroom);
		
		oliveBox = new CheckBox("Black Olives");
		oliveBox.setOnAction(this::processOlive);
				
		FlowPane bottomPane = new FlowPane(pepperoniBox, sausageBox, mushroomBox, oliveBox);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setHgap(10);
		setBottom(bottomPane);
	}
	
	/**
	 * Checks if the pepperoni checkbox is checked. If it is, then the number of toppings is increased.
	 * If it is not, then the number of toppings is decreased, unless it's already 0. If it's already
	 * 0, then it stays at 0.
	 * 
	 * @param event The event of the pepperoni checkbox being checked/unchecked
	 */
	private void processPepperoni(ActionEvent event) {
		if(pepperoniBox.isSelected()) {
			numToppings++;
		}
		else {
			numToppings--;
			if (numToppings < 0) {
				numToppings = 0;
			}
		}
	}
	
	/**
	 * Checks if the sausage checkbox is checked. If it is, then the number of toppings is increased.
	 * If it is not, then the number of toppings is decreased, unless it's already 0. If it's already
	 * 0, then it stays at 0.
	 * 
	 * @param event The event of the sausage checkbox being checked/unchecked
	 */
	private void processSausage(ActionEvent event) {
		if(sausageBox.isSelected()) {
			numToppings++;
		}
		else {
			numToppings--;
			if (numToppings < 0) {
				numToppings = 0;
			}
		}
	}
	
	/**
	 * Checks if the mushroom checkbox is checked. If it is, then the number of toppings is increased.
	 * If it is not, then the number of toppings is decreased, unless it's already 0. If it's already
	 * 0, then it stays at 0.
	 * 
	 * @param event The event of the mushroom checkbox being checked/unchecked
	 */
	private void processMushroom(ActionEvent event) {
		if(mushroomBox.isSelected()) {
			numToppings++;
		}
		else {
			numToppings--;
			if (numToppings < 0) {
				numToppings = 0;
			}
		}
	}

	/**
	 * Checks if the olive checkbox is checked. If it is, then the number of toppings is increased.
	 * If it is not, then the number of toppings is decreased, unless it's already 0. If it's already
	 * 0, then it stays at 0.
	 * 
	 * @param event The event of the olive checkbox being checked/unchecked
	 */
	private void processOlive(ActionEvent event) {
		if(oliveBox.isSelected()) {
			numToppings++;
		}
		else {
			numToppings--;
			if (numToppings < 0) {
				numToppings = 0;
			}
		}
	}

	/**
	 * Sets the number of pizza toppings
	 * 
	 * @param num The number of pizza toppings that the user would like to set numToppings to
	 * @return The new number of pizza toppings
	 */
	public int setNumToppings(int num) {
		numToppings = num;
		return numToppings;
	}
	
	/**
	 * Gets the number of pizza toppings
	 * 
	 * @return The number of pizza toppings
	 */
	public int getNumToppings() {
		return numToppings;
	}
	
	/**
	 * Creates a new sprite(s) depending on the image being used. If the image used is that of the
	 * pizza itself, then only one is made, along with info to animate it. The the image used is that
	 * of one of the pizza toppings, then a specific number of said topping will be made in a specific
	 * order.
	 * 
	 * @param imgName The image being used to create a sprite(s)
	 */
	public void createSprites(String imgName) {
		if (imgName == "pizzasprite.png") {
			crust = new Sprite();
			crust.setImage(imgName);
			crust.setPosition(-410, 15);
			crust.setVelocity(500);
		}
		else if (imgName == "pepperoni.png") {
			pepperoni = new Sprite[4][4];
			for (int i = 0; i < 4; i++) {
				for (int t = 0; t < 4; t++) {
					pepperoni[i][t] = new Sprite();
					pepperoni[i][t].setImage(imgName);
					pepperoni[i][t].setPosition((110+(i*80)), (100+(t*70)));
				}
			}
		}
		else if (imgName == "mushroom.png") {
			mushroom = new Sprite[3][4];
			for (int i = 0; i < 3; i++) {
				for (int t = 0; t < 4; t++) {
					mushroom[i][t] = new Sprite();
					mushroom[i][t].setImage(imgName);
					mushroom[i][t].setPosition((150+(i*80)), (110+(t*70)));
				}
			}
		}
		else if (imgName == "sausage.png") {
			sausage = new Sprite[5][3];
			for (int i = 0; i < 5; i++) {
				for (int t = 0; t < 3; t++) {
					sausage[i][t] = new Sprite();
					sausage[i][t].setImage(imgName);
					sausage[i][t].setPosition((80+(i*80)), (150+(t*70)));
				}
			}
		}
		else if (imgName == "blackolive.png") {
			olive = new Sprite[4][5];
			for (int i = 0; i < 4; i++) {
				for (int t = 0; t < 5; t++) {
					olive[i][t] = new Sprite();
					olive[i][t].setImage(imgName);
					olive[i][t].setPosition((130+(i*80)), (90+(t*70)));
				}
			}
		}
	}
}


