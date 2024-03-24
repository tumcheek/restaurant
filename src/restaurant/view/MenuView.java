package restaurant.view;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * The MenuView class represents the view for displaying the restaurant menu in the application.
 * It provides a layout containing components necessary for showcasing the menu items.
 */
public class MenuView {
    private final VBox view;

    /**
     * Constructs a MenuView object.
     * Initializes the layout and sets up necessary components for the menu view.
     */
    public MenuView() {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Тут буде меню"));
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        view = layout;
    }

    /**
     * Retrieves the parent node containing the menu view components.
     * @return The parent node representing the menu view.
     */
    public Parent getView() {
        return view;
    }
}
