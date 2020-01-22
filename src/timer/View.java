package timer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View extends Application {

    private double buttonWidth = 80.0f;
    private double timerWidth = 120.0f;
    private double boarderPadding = 50.0f;
    private double topPadding = 25.0f;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set Timer Label
        Label entryL = new Label();
        entryL.setLayoutX(40.0f);
        entryL.setLayoutY(topPadding);
        entryL.setText("Set timer: ");

        // Entry Field
        TextField entryF = new TextField();
        entryF.setLayoutX(110.0f);
        entryF.setLayoutY(topPadding);
        entryF.setPrefWidth(buttonWidth);

        // start Button
        Button startB = new Button();
        startB.setLayoutX(200);
        startB.setLayoutY(topPadding);
        startB.setPrefWidth(buttonWidth);
        startB.setText("Start");
        startB.setFont(Font.font("Helvetica Neue", 12));

        // Circle
        Circle circle = new Circle();
        circle.setCenterX(150.0f);
        circle.setCenterY(200.0f);
        circle.setRadius(130.0f);
        circle.setFill(null);
        circle.setStroke(Color.LIGHTBLUE);
        circle.setStrokeWidth(3.0f);

        // CountDown Label
        Label cDLabel = new Label();
        cDLabel.setText("00:00:00");
        cDLabel.setLayoutX(130.0f);
        cDLabel.setLayoutY(180.0f);
//        cDLabel.setFont(Font.font("Helvetica Neue", 24.0f));
        cDLabel.setMinWidth(timerWidth);


        // Pause Button
        Button pauseB = new Button();
        pauseB.setLayoutX(boarderPadding);
        pauseB.setLayoutY(350);
        pauseB.setPrefWidth(buttonWidth);
        pauseB.setText("Pause");
        cDLabel.setFont(Font.font("Helvetica Neue", 12));


        // Reset Button
        Button resetB = new Button();
        resetB.setLayoutX(170);
        resetB.setLayoutY(350);
        resetB.setPrefWidth(buttonWidth);
        resetB.setText("Reset");
        cDLabel.setFont(Font.font("Helvetica Neue", 12));


        // ROOT and ADD
        Group root = new Group();
        root.getChildren().add(entryL);
        root.getChildren().add(entryF);
        root.getChildren().add(startB);
        root.getChildren().add(circle);
        root.getChildren().add(cDLabel);
        root.getChildren().add(pauseB);
        root.getChildren().add(resetB);

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }


}
