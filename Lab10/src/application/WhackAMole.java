package application;

import java.io.File;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class WhackAMole extends Application {

	private Stage window;
	private Text text1;
	private Font font1;
	private FlowPane pane1;
	private Scene scene1, scene2;
	private Image mole;
	private ImageView imageView;
	private Group root;
	private Random numGen;
	private int score = 0;
	private File file;
	private AudioClip popSound;

	@Override
	public void start(Stage primaryStage) throws Exception {
		file = new File("pop.wav");
		popSound = new AudioClip(file.toURI().toString());
		window = primaryStage;
		font1 = new Font("Comic Sans MS", 40);
		text1 = new Text("Whack-a-mole! \n Hit enter to play \n Click on the mole to move it \n Hit escape to quit.");
		text1.setFont(font1);
		pane1 = new FlowPane();
		pane1.getChildren().add(text1);
		scene1 = new Scene(pane1, 600, 300, Color.SALMON);
		window.setTitle("Whack-a-mole");
		window.setScene(scene1);
		window.show();
		scene1.setOnKeyPressed(this::processKeyPress);
	}

	public void processKeyPress(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			numGen = new Random();
			mole = new Image("mole.png");
			imageView = new ImageView(mole);
			root = new Group(imageView);
			scene2 = new Scene(root, 1000, 1000, Color.DARKGREEN);
			window.setScene(scene2);
			moveMole();
			imageView.setOnMouseClicked(this::processMouseClick);
			scene2.setOnKeyPressed(this::processKeyPress);
		}

		else if (event.getCode() == KeyCode.ESCAPE) {
			text1.setText("You whacked " + score + " moles!");
			window.setScene(scene1);
			popSound.stop();
		}
	}

	public void processMouseClick(MouseEvent event) {
		moveMole();
		score++;
		popSound.play();
	}

	public void moveMole() {
		int xCoordinate = numGen.nextInt(400);
		int yCoordinate = numGen.nextInt(400);

		imageView.setX(xCoordinate);
		imageView.setY(yCoordinate);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
