package restaurant.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.stage.Stage;
import restaurant.controllers.DatabaseManager;


public class AddNewDishes {
    private final VBox view;
    private final TextField dishNameField;
    private final TextField priceField;

    public AddNewDishes(){
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Додавання нових страв");
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        dishNameField = new TextField();
        dishNameField.setPromptText("Страва");
        dishNameField.setMaxWidth(400);

        priceField = new TextField();
        priceField.setPromptText("Ціна");
        priceField.setMaxWidth(200);

        Button addButton = new Button("Додати");
        addButton.setPrefWidth(150);

        addButton.setOnAction(event -> addNewDish());

        Button backButton = new Button("Назад");
        backButton.setPrefWidth(150);

        backButton.setOnAction(event -> {
            MenuView menudishes = new MenuView ();
            Parent openMenuParent = menudishes.getView();
            Stage menuStage = new Stage();
            menuStage.setScene(new Scene(openMenuParent, 600, 500));
            menuStage.show();
        });

        layout.getChildren().addAll(titleLabel, dishNameField, priceField, addButton, backButton);
        view = layout;
    }

    public Parent getView() {
        return view;
    }

    private void addNewDish() {
        String dishName = dishNameField.getText();
        String priceText = priceField.getText();

        // Проверка на пустые поля
        if (dishName.isEmpty() || priceText.isEmpty()) {
            // Вывести сообщение об ошибке или предупреждение
            return;
        }

        try (Connection connection = DatabaseManager.getConnection()) {
            // Подготовка SQL-запроса
            String sql = "INSERT INTO menu (dishes, price) VALUES(?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, dishName);
                statement.setDouble(2, Double.parseDouble(priceText));
                // Выполнение запроса
                statement.executeUpdate();
                // Очистка полей
                dishNameField.clear();
                priceField.clear();
                // Вывести сообщение об успешном добавлении
            }
        } catch (SQLException e) {
            // Вывести сообщение об ошибке
            e.printStackTrace();
        }
    }
}