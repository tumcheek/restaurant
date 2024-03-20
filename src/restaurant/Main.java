package restaurant;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import restaurant.view.MainMenuView;

/**
 * The Main class is the entry point of the restaurant application.
 * It initializes the main stage and sets up the main menu view.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ресторан");

        MainMenuView mainMenuView = new MainMenuView(primaryStage);

        Scene scene = new Scene(mainMenuView.getView(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("/restaurant/styles/main.css").toExternalForm());
    }

    /**
     * The main method, which launches the JavaFX application.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
