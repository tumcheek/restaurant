package restaurant.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddNewDishes {
    private final VBox view;

    public AddNewDishes() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20)); // Отступы вокруг компоновки
        layout.setAlignment(Pos.CENTER); // Выравнивание по центру

        // Создаем надпись "Додавання нових страв"
        Label titleLabel = new Label("Додавання нових страв");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Создаем текстовое поле для ввода названия блюда
        TextField dishNameField = new TextField();
        dishNameField.setPromptText("Назва страви"); // Подсказка для пользователя
        dishNameField.getStyleClass().add("input-field"); // Применяем CSS класс
        dishNameField.setPadding(new Insets(10)); // Отступы вокруг поля
        dishNameField.setPrefWidth(120); // Уменьшаем ширину

        // Создаем текстовое поле для ввода цены блюда
        TextField priceField = new TextField();
        priceField.setPromptText("Ціна"); // Подсказка для пользователя
        priceField.getStyleClass().add("input-field"); // Применяем CSS класс
        priceField.setPadding(new Insets(10)); // Отступы вокруг поля
        priceField.setPrefWidth(120); // Уменьшаем ширину

        // Создаем кнопку "Додати"
        Button addButton = new Button("Додати");
        addButton.setPrefWidth(150); // Установка фиксированной ширины
        addButton.setOnAction(event -> {
            String dishName = dishNameField.getText();
            String priceText = priceField.getText();
            try {
                double price = Double.parseDouble(priceText);
                // Выполняем действия с введенными данными (например, добавляем новое блюдо)
                System.out.println("Назва страви: " + dishName);
                System.out.println("Ціна: " + price);
            } catch (NumberFormatException e) {
                System.out.println("Введена некорректная цена");
            }
        });

        // Создаем кнопку "Назад"
        Button backButton = new Button("Назад");
        backButton.setPrefWidth(150); // Установка фиксированной ширины

        backButton.setOnAction(event -> {
            MenuView menuView = new MenuView();
            Parent openMenuParent = menuView.getView();
            Stage menuStage = new Stage();
            menuStage.setScene(new Scene(openMenuParent, 600, 500));
            menuStage.show();
        });

        // Добавляем элементы в компоновку
        layout.getChildren().addAll(
                titleLabel,
                dishNameField,
                priceField,
                addButton,
                backButton
        );

        view = layout;
    }

    public Parent getView() {
        return view;
    }
}