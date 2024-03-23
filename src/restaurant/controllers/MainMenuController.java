package restaurant.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import restaurant.view.MenuView;
import restaurant.view.OrderView;


/**
 * The MainMenuController class controls the actions performed in the main menu of the restaurant application.
 * It handles events triggered by user interactions with the main menu buttons.
 */
public class MainMenuController {

    private final Stage stage;

    /**
     * Constructs a MainMenuController object.
     * @param stage The primary stage of the application.
     */
    public MainMenuController(Stage stage) {
        this.stage = stage;
    }

    /**
     * Handles the action to make an order.
     * Creates an OrderView and displays it in a new stage.
     */
    public void handleMakeOrder() {
        OrderView orderView = new OrderView();
        Parent orderParent = orderView.getView();
        Stage orderStage = new Stage();
        orderStage.setTitle("Замовлення");
        orderStage.setScene(new Scene(orderParent, 600, 500));
        orderStage.show();
    }

    /**
     * Handles the action to open the menu.
     * Creates a MenuView and displays it in a new stage.
     */
    public void handleOpenMenu() {
        MenuView menuView = new MenuView();
        Parent openMenuParent = menuView.getView();
        Stage menuStage = new Stage();
        menuStage.setTitle("Меню");
        menuStage.setScene(new Scene(openMenuParent, 600, 500));
        menuStage.show();
    }
}
