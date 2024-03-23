package restaurant.view;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AddNewDishes {
    private final VBox view;

    public AddNewDishes(){
        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Тут будуть додавання страв"));
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        view = layout;
    }
    public Parent getView() {
        return view;
    }
}
