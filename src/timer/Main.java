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
        view.initView();
        presenter.setModelAndView(model, view);
        Scene scene = new Scene(view.getRoot(), 300, 400); // why is this initialised in the main and not in the view?

        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
