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

    // Style Variables
    private double buttonWidth = 80.0f;
    private double timerWidth = 120.0f;
    private double boarderPadding = 50.0f;
    private double topPadding = 25.0f;

    // Labels and Buttons
    private TextField entryF;
    private Label countDownLabel;
    private Button startB;
    private Button resetB;
    private Button pauseB;

    // Root pane
    private Group root;

    // The presenter needed for the view to know whom to talk to
    private Presenter presenter;

    // View Constructor
    public View(Presenter presenter) {
        this.presenter = presenter;
    }


    // Application obligatory start method
    @Override
    public void start(Stage primaryStage) {

        // Node Variables
        //Set timer label
        Label entryL = new Label();
        entryL.setLayoutX(40.0f);
        entryL.setLayoutY(topPadding);
        entryL.setText("Set timer: ");

        // Entry Field
        entryF = new TextField();
        entryF.setLayoutX(110.0f);
        entryF.setLayoutY(topPadding);
        entryF.setPrefWidth(buttonWidth);

        // start Button
        startB = new Button();
        startB.setLayoutX(200);
        startB.setLayoutY(topPadding);
        startB.setPrefWidth(buttonWidth);
        startB.setText("Start");
        startB.setFont(Font.font("Helvetica Neue", 12));

        // Mit diesem Listener hört die View auf den Button.
        startB.setOnAction(event -> presenter.startButtonPressed(entryF.getText()));

        // Circle
        Circle circle = new Circle();
        circle.setCenterX(150.0f);
        circle.setCenterY(200.0f);
        circle.setRadius(130.0f);
        circle.setFill(null);
        circle.setStroke(Color.LIGHTBLUE);
        circle.setStrokeWidth(3.0f);

        // CountDown Label
        countDownLabel = new Label();
        countDownLabel.setText("00:00:00");
        countDownLabel.setLayoutX(130.0f);
        countDownLabel.setLayoutY(180.0f);
//        cDLabel.setFont(Font.font("Helvetica Neue", 24.0f));
        countDownLabel.setMinWidth(timerWidth);


        // Pause Button
        pauseB = new Button();
        pauseB.setLayoutX(boarderPadding);
        pauseB.setLayoutY(350);
        pauseB.setPrefWidth(buttonWidth);
        pauseB.setText("Pause");
        countDownLabel.setFont(Font.font("Helvetica Neue", 12));
        pauseB_OFF();

        // Mit diesem Listener hört die View auf den Button.
        pauseB.setOnAction(event -> presenter.pauseButtonPressed());

        // Reset Button
        resetB = new Button();
        resetB.setLayoutX(170);
        resetB.setLayoutY(350);
        resetB.setPrefWidth(buttonWidth);
        resetB.setText("Reset");
        countDownLabel.setFont(Font.font("Helvetica Neue", 12));
        resetB_OFF();

        // Mit diesem Listener hört die View auf den Button.
        resetB.setOnAction(event -> presenter.resetButtonPressed());

        // ADD CHILDREN
        root = new Group();
        root.getChildren().add(entryL);
        root.getChildren().add(entryF);
        root.getChildren().add(startB);
        root.getChildren().add(circle);
        root.getChildren().add(countDownLabel);
        root.getChildren().add(pauseB);
        root.getChildren().add(resetB);

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void startB_OFF() {
        startB.setDisable(true);
    }

    public void startB_ON() {
        startB.setDisable(false);
    }

    public void pauseB_OFF() {
        pauseB.setDisable(true);
    }

    public void pauseB_ON() {
        pauseB.setDisable(false);
    }

    public void resetB_OFF() {
        resetB.setDisable(true);
    }

    public void resetB_ON() {
        resetB.setDisable(false);
    }

    public void updateCountDownLabel() {
        countDownLabel.setText(String.valueOf(presenter.getTime()));
    }

    public Group getRoot() {
        return root;
    }


    public static void main(String[] args) {

        launch(args);
    }


}
