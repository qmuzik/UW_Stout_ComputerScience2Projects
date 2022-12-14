package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Payment screen for Big Vic's Pizza
 * 
 * This pane allows a user to input their information such as their name,
 * address,etc.
 * 
 * @author Quincy Muzik
 * @version 2022.05.04
 */

public class PaymentScreenPane extends HBox {

	private TextField firstName, lastName, address, city, state, zip;
	private Label firstNameInstructions, lastNameInstructions, addressInstructions, cityInstructions, stateInstructions,
			zipInstructions;
	private String firstNameString, lastNameString, addressString, cityString, stateString, zipString;

	/**
	 * Creates the payment pane
	 */

	public PaymentScreenPane(int numToppings) {

		firstNameInstructions = new Label("First Name");
		firstName = new TextField();

		lastNameInstructions = new Label("Last Name");
		lastName = new TextField();

		addressInstructions = new Label("Address");
		address = new TextField();

		cityInstructions = new Label("City");
		city = new TextField();

		stateInstructions = new Label("State");
		state = new TextField();

		zipInstructions = new Label("Zip code");
		zip = new TextField();

		Text finalInstructions = new Text("Press ALT to complete your order");

		VBox customerInformation = new VBox(firstNameInstructions, firstName, lastNameInstructions, lastName,
				addressInstructions, address, cityInstructions, city, stateInstructions, state, zipInstructions, zip,
				finalInstructions);
		customerInformation.setPrefSize(500, 430);
		customerInformation.setSpacing(10);
		customerInformation.setAlignment(Pos.TOP_CENTER);

		getChildren().addAll(customerInformation);
	}

	/**
	 * Get's the users first name from a text box
	 */

	public String getFirstName() {
		firstNameString = firstName.getText();
		return firstNameString;
	}

	/**
	 * Get's the users last name from a text box
	 */

	public String getLastName() {
		lastNameString = lastName.getText();
		return lastNameString;
	}

	/**
	 * Get's the users street address from a text box
	 */

	public String getAddress() {
		addressString = address.getText();
		return addressString;
	}

	/**
	 * Get's the users city of residence from a text box
	 */

	public String getCity() {
		cityString = city.getText();
		return cityString;
	}

	/**
	 * Get's the users state from a text box
	 */

	public String getState() {
		stateString = state.getText();
		return stateString;
	}

	/**
	 * Get's the users zip code from a text box
	 */

	public String getZip() {
		zipString = zip.getText();
		return zipString;
	}

}
