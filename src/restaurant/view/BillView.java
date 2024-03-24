package restaurant.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BillView {

    private final VBox view;

    public BillView() {
        Label billSavedLabel = new Label("Чек збережено!");
        Label dishLabel = new Label("Блюдо:");
        Label priceLabel = new Label("Ціна:");
        Label totalPriceLabel = new Label("Загальна сума:");
        Button backButton = new Button("Назад");

        billSavedLabel.setStyle("-fx-font-size: 20px;");
        dishLabel.setStyle("-fx-font-size: 16px;");
        priceLabel.setStyle("-fx-font-size: 16px;");
        totalPriceLabel.setStyle("-fx-font-size: 16px;");
        backButton.setStyle("-fx-font-size: 16px;");

        VBox dishList = new VBox(5);
        dishList.getChildren().addAll(
                new HBox(10, dishLabel, new Label(" "), priceLabel)
        );

        HBox totalBox = new HBox(10, totalPriceLabel, new Label());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(billSavedLabel, dishList, totalBox, backButton);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);

        view = layout;
    }

    public Parent getView() {
        return view;
    }
}