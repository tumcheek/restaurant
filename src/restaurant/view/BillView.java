package restaurant.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BillView {

    private final VBox view;

    public BillView() {

        Label billSavedLabel = new Label("Чек збережено!");
        Label dishLabel = new Label("Блюдо");
        Label priceLabel = new Label("Ціна");
        Label totalPriceLabel = new Label("Загальна сума:");
        Button backButton = new Button("Назад");

        billSavedLabel.setStyle("-fx-font-size: 20px;");
        dishLabel.setStyle("-fx-font-size: 16px;");
        priceLabel.setStyle("-fx-font-size: 16px;");
        totalPriceLabel.setStyle("-fx-font-size: 16px;");
        backButton.setStyle("-fx-font-size: 16px;");

        GridPane dishGrid = new GridPane();
        dishGrid.setHgap(10);
        dishGrid.setVgap(5);
        dishGrid.addRow(0, dishLabel, priceLabel);

        // Example dishes and their prices
        Label pastaLabel = new Label("Паста");
        Label pastaPrice = new Label("50 грн");

        Label saladLabel = new Label("Салат");
        Label saladPrice = new Label("30 грн");

        dishGrid.addRow(1, pastaLabel, pastaPrice);
        dishGrid.addRow(2, saladLabel, saladPrice);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(billSavedLabel, dishGrid, totalPriceLabel, backButton);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);

        view = layout;
    }

    public Parent getView() {
        return view;
    }
}