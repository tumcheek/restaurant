package restaurant.view;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import restaurant.controllers.BillViewController;
import javafx.stage.Stage;
import restaurant.controllers.MainMenuController;

/**
 * The OrderView class represents the view for making an order in the restaurant application.
 * It provides a layout containing components necessary for creating an order.
 */
public class OrderView {

    private final VBox view;
    private final BillViewController billController;

    /**
     * Constructs an OrderView object.
     * Initializes the layout and sets up necessary components for the order view.
     */
    public OrderView(Stage stage) {
        this.billController = new BillViewController(stage);
        ListView<String> menuList = new ListView<>();

        Button addDishToOrderButton = new Button("Додати страву");
        Button removeDishFromOrderButton = new Button("Видалити страву");
        Button getBill = new Button("Вивести рахунок");

        getBill.setOnAction(e -> billController.handleGetBill());

        addDishToOrderButton.setStyle("-fx-font-size: 16px;" + "-fx-width: 120px;");
        removeDishFromOrderButton.setStyle("-fx-font-size: 16px;" + "-fx-width: 120px;");
        getBill.setStyle("-fx-font-size: 16px;" + "-fx-width: 120px;");

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addDishToOrderButton, removeDishFromOrderButton);
        HBox.setHgrow(addDishToOrderButton, Priority.ALWAYS);
        HBox.setHgrow(removeDishFromOrderButton, Priority.ALWAYS);

        HBox buttonContainer = new HBox(145);
        buttonContainer.getChildren().addAll(buttonBox, getBill);

        VBox.setMargin(buttonContainer, new Insets(10, 0, 0, 0));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuList, buttonContainer);
        layout.setPadding(new Insets(15));
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
