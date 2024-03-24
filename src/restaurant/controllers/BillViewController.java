package restaurant.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import restaurant.view.BillView;
import restaurant.view.MenuView;
import restaurant.view.OrderView;

public class BillViewController {

    private final Stage stage;

    public BillViewController(Stage stage) {
        this.stage = stage;
    }

    public void handleGetBill() {
        BillView billView = new BillView();
        Parent billParent = billView.getView();
        Stage orderStage = new Stage();
        orderStage.setTitle("Чек");
        orderStage.setScene(new Scene(billParent, 600, 500));
        orderStage.show();
    }
}
