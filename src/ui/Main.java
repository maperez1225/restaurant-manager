package ui;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;
public class Main extends Application{
	private RestaurantGUI restaurantGUI;
	private Restaurant restaurant;
	public Main() {
		restaurant = new Restaurant();
		restaurantGUI = new RestaurantGUI(restaurant);
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		loader.setController(restaurantGUI);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("La Casa Dorada");
		primaryStage.show();
		restaurantGUI.backLogin(new ActionEvent());
		Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
	}
}