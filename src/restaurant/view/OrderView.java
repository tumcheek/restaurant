package restaurant.view;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * The OrderView class represents the view for making an order in the restaurant application.
 * It provides a layout containing components necessary for creating an order.
 */
public class OrderView {

    private final VBox view;

    /**
     * Constructs an OrderView object.
     * Initializes the layout and sets up necessary components for the order view.
     */
    public OrderView() {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Тут будуть замовлення"));
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        view = layout;
    }

    /**
     * Retrieves the parent node containing the order view components.
     * @return The parent node representing the order view.
     */
    public Parent getView() {
        return view;
    }
}
