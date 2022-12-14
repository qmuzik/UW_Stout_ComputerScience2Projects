package application;

import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Big Vic's Pizza is a Pizza Ordering App.
 * 
 * This program allows users to place an pizza order and choose between 4 types
 * of toppings. After completing the order, a receipt is printed with the
 * customer information and final cost of the order.
 * 
 * @author Quincy Muzik
 * @version 2022.05.04
 */

public class BigVicsPizza extends Application {

	private final double TOPPING_COST = 1.99;
	private final double PIZZA_COST = 11.99;
	private double finalCost = 0;
	private Stage window;
	private Text intro, receiptMessage;
	private Font font;
	private AudioClip italianMusic;
	private BorderPane pane1;
	private File audioFile;
	private Scene scene1, scene2;
	private PizzaMakerPane root;
	private PaymentScreenPane payment;

	/**
	 * Creates the main menu of Big Vic's Pizza
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		audioFile = new File("Seaside Piazza - Aaron Kenny.mp3");

		// https://studio.youtube.com/channel/UCrie5tC_dMM4UW2btNcLIrg/music
		italianMusic = new AudioClip(audioFile.toURI().toString());
		window = primaryStage;
		font = new Font("Comic Sans MS", 20);
		intro = new Text(
				"Welcome to Big Vic's Pizzeria! \n Press Enter to make create your order \n Press Esc to exit");
		intro.setFont(font);

		pane1 = new BorderPane();
		pane1.setCenter(intro);

		scene1 = new Scene(pane1, 600, 600);

		scene1.setOnKeyPressed(this::processKeyPress);
		intro.setTextAlignment(TextAlignment.CENTER);

		primaryStage.setTitle("BigVicsPizza");
		primaryStage.setScene(scene1);
		primaryStage.show();
		italianMusic.setCycleCount(AudioClip.INDEFINITE);
		italianMusic.play();
	}

	/**
	 * Launches the app
	 */

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Allows user to use keyboard keys to navigate through program when it opens
	 * 
	 * @param KeyEvent Key that is pressed
	 */

	public void processKeyPress(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			root = new PizzaMakerPane();
			scene2 = new Scene(root, 600, 600);
			scene2.setOnKeyPressed(this::changeToPayment);
			window.setScene(scene2);
		}

		else if (event.getCode() == KeyCode.ESCAPE) {
			window.close();
		}

	}

	/**
	 * Changes the pizza making pane to the payment pane
	 * 
	 * @param event F key used to navigate through the program
	 */

	public void changeToPayment(KeyEvent event) {
		if (event.getCode() == KeyCode.F) {
			payment = new PaymentScreenPane(root.getNumToppings());
			Scene scene3 = new Scene(payment, 600, 600);
			scene3.setOnKeyPressed(this::changeToReceipt);
			window.setScene(scene3);
		}
	}

	/**
	 * Changes the payment pane to the printed reciept scene
	 * 
	 * @param event F key used to navigate through the program
	 */

	public void changeToReceipt(KeyEvent event) {
		if (event.getCode() == KeyCode.ALT) {
			finalCost = PIZZA_COST + (TOPPING_COST * root.getNumToppings());
			Font font1 = new Font("Comic Sans MS", 15);
			Font font2 = new Font("Comic Sans MS", 20);
			receiptMessage = new Text(
					"Thank for placing your order at Big Vick's Pizza, \n here is your reciept: \n\n");
			receiptMessage.setFont(font1);
			Text receiptText = new Text(
					"\t" + payment.getFirstName() + " " + payment.getLastName() + "\n\t" + payment.getAddress() + ", "
							+ payment.getState() + "\n\t" + payment.getZip() + "\n\n\t Final Cost: " + finalCost);
			receiptText.setFont(font2);
			VBox receipt = new VBox(receiptMessage, receiptText);
			Scene scene4 = new Scene(receipt, 350, 250);
			window.setScene(scene4);
		}
	}

}
