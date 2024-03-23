package restaurant.view;

import java.sql.*;

import restaurant.controllers.DatabaseManager;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MenuView {
    private final BorderPane view;

    /**
     * Constructs a MenuView object.
     * Initializes the layout and sets up necessary components for the menu view.
     */
    public MenuView() {
        BorderPane layout = new BorderPane();

        // Label для текста "Меню"
        Label menuLabel = new Label("Меню");
        menuLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        menuLabel.setAlignment(Pos.CENTER);

        // Создаем TableView с двумя колонками
        TableView<MenuEntry> tableView = new TableView<>();
        TableColumn<MenuEntry, String> firstColumn = new TableColumn<>("Назва страви");
        TableColumn<MenuEntry, Double> secondColumn = new TableColumn<>("Ціна(грн)");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Привязываем данные к соответствующим свойствам объекта MenuEntry
        firstColumn.setCellValueFactory(cellData -> {
            MenuEntry entry = cellData.getValue();
            String dishName = entry.getDishName();
            return new SimpleStringProperty(dishName);
        });
        secondColumn.setCellValueFactory(cellData -> {
            MenuEntry entry = cellData.getValue();
            double price = entry.getPrice();
            return new SimpleDoubleProperty(price).asObject();
        });

        // Устанавливаем ширину первой колонки в два раза больше, чем второй
        firstColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.67));
        secondColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.33));

        firstColumn.setStyle("-fx-alignment: CENTER;");
        secondColumn.setStyle("-fx-alignment: CENTER;");

        // Добавляем колонки к таблице
        tableView.getColumns().addAll(firstColumn, secondColumn);

        // Создаем контейнер для кнопок
        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        addButton.setPrefSize(100, 50);
        subtractButton.setPrefSize(100, 50);

        buttonsBox.getChildren().addAll(addButton, subtractButton);

        subtractButton.setOnAction(event -> {
            MenuEntry selectedEntry = tableView.getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                tableView.getItems().remove(selectedEntry);
            }
        });
        addButton.setOnAction(event -> {
            AddNewDishes newdishes = new AddNewDishes();
            Parent openMenuParent = newdishes.getView();
            Stage menuStage = new Stage();
            menuStage.setScene(new Scene(openMenuParent, 600, 500));
            menuStage.show();
        });

        // Размещаем элементы в BorderPane
        layout.setTop(menuLabel);
        layout.setCenter(tableView);
        layout.setBottom(buttonsBox);

        // Устанавливаем отступы для BorderPane
        BorderPane.setAlignment(menuLabel, Pos.CENTER);
        BorderPane.setMargin(menuLabel, new Insets(10, 0, 0, 0)); // Отступы сверху
        BorderPane.setMargin(tableView, new Insets(60, 120, 70, 120));  // Отступы TableView
        BorderPane.setMargin(buttonsBox, new Insets(10)); // Отступы кнопок

        // Добавление информации в таблицу
        try (Connection connection = DatabaseManager.getConnection()) {
            // Подготовка SQL-запроса
            String sql = "SELECT dishes, price FROM menu";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                // Обработка результатов запроса
                while (resultSet.next()) {
                    String dishName = resultSet.getString("dishes");
                    double price = resultSet.getDouble("price");
                    // Создаем объект MenuEntry и добавляем его в таблицу
                    MenuEntry entry = new MenuEntry(dishName, price);
                    tableView.getItems().add(entry);
                }
            }
        } catch (SQLException e) {
            // Обработка ошибок, если они возникнут
            e.printStackTrace();
        }
        view = layout;
    }

    /**
     * Retrieves the parent node containing the menu view components.
     *
     * @return The parent node representing the menu view.
     */
    public Parent getView() {
        return view;
    }

    // Класс для представления элементов меню
    public static class MenuEntry {
        private String dishName;
        private Double price;

        public MenuEntry(String dishName, Double price) {
            this.dishName = dishName;
            this.price = price;
        }

        public String getDishName() {
            return dishName;
        }

        public Double getPrice() {
            return price;
        }
    }

}