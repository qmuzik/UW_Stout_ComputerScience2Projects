package application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ColorFactoryPane extends BorderPane {
	private Button redButton, orangeButton, yellowButton;
	private RadioButton greenButton, blueButton, cyanButton;
	private ToggleGroup rbGroup;
	private TextField input;
	private Label instructions;
	private Text output;
	private FlowPane centerPane, topPane;
	private CheckBox boldCheckBox, italicCheckBox, fontCheckBox;
	private Font font;

	public ColorFactoryPane() {
		setupCenterPane();
		setupTopPane();
		setupBottomPane();
		setupRightPane();
		setupLeftPane();
	}

	private void setupCenterPane() {
		font = new Font("Helvetica", 15);
		output = new Text(
				"Buttons change panel color,\n radio buttons change text color,\n check boxes formats text input");
		output.setFont(font);
		output.setFill(Color.PURPLE);
		centerPane = new FlowPane();
		centerPane.getChildren().add(output);
		centerPane.setAlignment(Pos.CENTER);
		setCenter(centerPane);
	}

	private void setupTopPane() {
		instructions = new Label("Type something in and hit enter");
		input = new TextField();
		input.setOnAction(this::processAction);
		topPane = new FlowPane();
		topPane.getChildren().addAll(instructions, input);
		topPane.setAlignment(Pos.CENTER);
		topPane.setHgap(10);
		setTop(topPane);
	}

	private void setupBottomPane() {
		boldCheckBox = new CheckBox("Bold");
		boldCheckBox.setOnAction(this::processAction);

		italicCheckBox = new CheckBox("Italic");
		italicCheckBox.setOnAction(this::processAction);

		fontCheckBox = new CheckBox("Change Font Size");
		fontCheckBox.setOnAction(this::processAction);

		FlowPane bottomPane = new FlowPane(boldCheckBox, italicCheckBox, fontCheckBox);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setHgap(10);
		setBottom(bottomPane);
	}

	private void setupRightPane() {
		rbGroup = new ToggleGroup();
		Insets rbInsets = new Insets(20, 20, 10, 10);

		greenButton = new RadioButton("Green");
		greenButton.setStyle("-fx-text-fill: green");
		greenButton.setToggleGroup(rbGroup);
		greenButton.setOnAction(this::processAction);

		blueButton = new RadioButton("Blue");
		blueButton.setStyle("-fx-text-fill: blue");
		blueButton.setToggleGroup(rbGroup);
		blueButton.setOnAction(this::processAction);

		cyanButton = new RadioButton("Cyan");
		cyanButton.setStyle("-fx-text-fill: cyan");
		cyanButton.setToggleGroup(rbGroup);
		cyanButton.setOnAction(this::processAction);

		VBox rightPane = new VBox(greenButton, blueButton, cyanButton);
		rightPane.setSpacing(20);
		rightPane.setPadding(rbInsets);

		setRight(rightPane);
	}

	private void setupLeftPane() {
		Insets bInsets = new Insets(20, 20, 10, 10);

		redButton = new Button("Red");
		redButton.setStyle("-fx-background-color: red");
		redButton.setOnAction(this::processAction);

		orangeButton = new Button("Orange");
		orangeButton.setStyle("-fx-background-color: orange");
		orangeButton.setOnAction(this::processAction);

		yellowButton = new Button("Yellow");
		yellowButton.setStyle("-fx-background-color: yellow");
		yellowButton.setOnAction(this::processAction);

		VBox leftPane = new VBox(redButton, orangeButton, yellowButton);
		leftPane.setSpacing(20);
		leftPane.setPadding(bInsets);

		setLeft(leftPane);
	}

	private void processAction(ActionEvent event) {
		FontWeight weight = FontWeight.NORMAL;
		FontPosture posture = FontPosture.REGULAR;
		String fontFamily = "Helvetica";
		int fontSize = 25;

		if (boldCheckBox.isSelected()) {
			weight = FontWeight.BOLD;
		}

		if (italicCheckBox.isSelected()) {
			posture = FontPosture.ITALIC;
		}

		if (fontCheckBox.isSelected()) {
			fontSize = 30;
		}

		if (greenButton.isSelected()) {
			output.setFill(Color.GREEN);
		}

		else if (blueButton.isSelected()) {
			output.setFill(Color.BLUE);
		}

		else if (cyanButton.isSelected()) {
			output.setFill(Color.CYAN);
		}

		if (event.getSource() == redButton) {
			centerPane.setStyle("-fx-background-color: red");
		}

		else if (event.getSource() == orangeButton) {
			centerPane.setStyle("-fx-background-color: orange");
		}

		else if (event.getSource() == yellowButton) {
			centerPane.setStyle("-fx-background-color: yellow");
		}

		output.setFont(Font.font(fontFamily, weight, posture, fontSize));
		output.setText(input.getText());

	}
}
