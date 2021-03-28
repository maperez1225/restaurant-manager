package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Restaurant;
import model.User;

public class RestaurantGUI {
	private Restaurant restaurant;
	public RestaurantGUI(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	@FXML
    private Pane mainPane;
    @FXML
    private TextField txtLoginUser;
    @FXML
    private TextField txtLoginPassword;
    @FXML
    private TextField registerName;
    @FXML
    private TextField registerLastName;
    @FXML
    private TextField registerUsername;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private TextField registerId;
    @FXML
    public void backLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-screen.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void registerUser(ActionEvent event) {
    	User user = new User(registerUsername.getText(), registerPassword.getText(), registerName.getText(), registerLastName.getText(), Long.parseLong(registerId.getText()));
    	restaurant.addUser(user);
    }
    @FXML
    public void launchCreateUser(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-screen.fxml"));
		fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
    	mainPane.getChildren().add(userView);
    }

    @FXML
    public void login(ActionEvent event) {
    	
    }
}
