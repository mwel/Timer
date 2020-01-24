package timer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Presenter presenter = new Presenter();
        Model model = new Model();
        View view = new View(presenter);
        view.start(primaryStage);
        presenter.setModelAndView(model, view);
        Scene scene = new Scene(view.getRoot());

        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
