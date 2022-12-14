package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author MuzikQuincy
 *
 */

public class Logos extends Application {

	/**
	 * Scene/Logo Display Settings 
	 * 
	 * @param primaryStage Window for display
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Scene Setup
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.ANTIQUEWHITE);

		// MasterCard Logo
		Circle circle1 = new Circle(85, 75, 50);
		circle1.setFill(Color.RED);
		
		Circle circle2 = new Circle(145,75,50);
		circle2.setFill(Color.ORANGE);
		
		Text masterCard = new Text(45,85,"MasterCard");
		Font masterCardFont = Font.font("Times",FontPosture.ITALIC,28);
		
		masterCard.setFont(masterCardFont);
		masterCard.setFill(Color.WHITE);
		
		Group masterCardGroup = new Group(circle1,circle2,masterCard);
		masterCardGroup.setTranslateY(200);
	
		root.getChildren().add(masterCardGroup);
		
		// VISA Logo 
		Rectangle rectBackground = new Rectangle(0,0,150,100);
		rectBackground.setFill(Color.WHITE);
		
		Rectangle rectTop = new Rectangle(0,0,150,30);
		rectTop.setFill(Color.BLUE);
		
		Rectangle rectBottom = new Rectangle(0,70,150,30);
		rectBottom.setFill(Color.ORANGE);
		
		Text visa = new Text(33,65,"VISA");
		Font visaFont = Font.font("Times",FontWeight.BOLD,FontPosture.ITALIC,40);
		
		visa.setFont(visaFont);
		visa.setFill(Color.BLUE);
		
		Group visaGroup = new Group(rectBackground,rectTop,rectBottom,visa);
		visaGroup.setTranslateX(300);
		visaGroup.setTranslateY(350);
	
		root.getChildren().add(visaGroup);
		
		// Walmart Logo 
		Text walmart = new Text(0,54,"Walmart");
		Font walmartFont = new Font("Courier",50);
		
		walmart.setFont(walmartFont);
		walmart.setFill(Color.CORNFLOWERBLUE);
		
		Text walmartSlogan = new Text(0,75,"Save Money. Live Better");
		Font walmartSloganFont = new Font("Courier",18);
		
		walmartSlogan.setFont(walmartSloganFont);
		walmartSlogan.setFill(Color.CORNFLOWERBLUE);
		
		Line line1 = new Line(250,5,250,20);
		line1.setStrokeWidth(6);
		line1.setStroke(Color.ORANGE);
		
		Line line2 = new Line(250,50,250,65);
		line2.setStrokeWidth(6);
		line2.setStroke(Color.ORANGE);
		
		Line line3 = new Line(250,20,250,35);
		line3.setStrokeWidth(6);
		line3.setStroke(Color.ORANGE);
		line3.setRotate(60);
		line3.setTranslateX(20);
		line3.setTranslateY(-3);
		
		Line line4 = new Line(250,50,250,65);
		line4.setStrokeWidth(6);
		line4.setStroke(Color.ORANGE);
		line4.setRotate(120);
		line4.setTranslateX(20);
		line4.setTranslateY(-10);
		
		Line line5 = new Line(250,20,250,35);
		line5.setStrokeWidth(6);
		line5.setStroke(Color.ORANGE);
		line5.setRotate(-60);
		line5.setTranslateX(-20);
		line5.setTranslateY(-3);
		
		Line line6 = new Line(250,50,250,65);
		line6.setStrokeWidth(6);
		line6.setStroke(Color.ORANGE);
		line6.setRotate(-120);
		line6.setTranslateX(-20);
		line6.setTranslateY(-10);
		
		Group flowerLinesGroup = new Group(line1,line2,line3,line4,line5,line6);
		flowerLinesGroup.setTranslateX(-25);
		
		Group walmartGroup = new Group(walmart,walmartSlogan,flowerLinesGroup);
		walmartGroup.setTranslateX(240);
		walmartGroup.setTranslateY(100);
		
		root.getChildren().add(walmartGroup);
		
		// Amazon Logo 
		Text amazon = new Text(0,54,"amazon");
		Font amazonFont = Font.font("Courier",FontWeight.BOLD,46);
		amazon.setFont(amazonFont);
		
		Arc arc1 = new Arc(70,10,80,60,240,50);
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.ORANGE);
		arc1.setFill(null);
		arc1.setStrokeWidth(4);
		
		Arc arc2 = new Arc(100,65,20,6,60,65);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.ORANGE);
		arc2.setFill(null);
		arc2.setStrokeWidth(4);
		
		Arc arc3 = new Arc(90,60,20,25,320,40);
		arc3.setType(ArcType.OPEN);
		arc3.setStroke(Color.ORANGE);
		arc3.setFill(null);
		arc3.setStrokeWidth(4);
		
		Group smile = new Group(arc1,arc2,arc3);
		
		Group amazonGroup = new Group(amazon,smile);
		amazonGroup.setTranslateX(20);
		amazonGroup.setTranslateY(20);
		
		root.getChildren().add(amazonGroup);
		
		primaryStage.setTitle("Logos");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Launches the scene
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
