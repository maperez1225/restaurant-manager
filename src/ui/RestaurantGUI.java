package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import model.Customer;
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
    private TableView<Customer> tvCustomers;
    @FXML
    private TableColumn<Customer, String> tcName;
    @FXML
    private TableColumn<Customer, String> tcLastName;
    @FXML
    private TableColumn<Customer, String> tcID;
    @FXML
    private TableColumn<Customer, String> tcAdress;
    @FXML
    private TableColumn<Customer, String> tcMobilePhone;
    @FXML
    private TableColumn<Customer, String> tcObservations;
    @FXML
    private TextField createCustomerName;

    @FXML
    private TextField createCustomerLastName;

    @FXML
    private TextField createCustomerID;

    @FXML
    private TextField createCustomerPhone;

    @FXML
    private TextField createCustomerAddress;

    @FXML
    private TextArea createCustomerObservations;

    @FXML
    public void createCustomer(ActionEvent event){
    	//Customer customer = new Customer(createCustomerName.getText(), createCustomerLastName.getText(), Long.parseLong(createCustomerID.getText()), createCustomerAddress.getText(), Long.parseLong(createCustomerPhone.getText()), createCustomerObservations.getText());
    	
    }
    @FXML
    public void backMain(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }
    @FXML
    public void backLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-screen.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
		txtLoginUser.clear();
		txtLoginPassword.clear();
    }
    @FXML
    public void registerUser(ActionEvent event) {
    	User user = new User(registerUsername.getText(), registerPassword.getText(), registerName.getText(), registerLastName.getText(), Long.parseLong(registerId.getText()));
    	if (!restaurant.userExists(user.getUsername())) {
    		restaurant.addUser(user);
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Autenticación");
			alert.setHeaderText(null);
			alert.setContentText("Usuario creado exitosamente.");
			alert.show();
			registerUsername.clear();
			registerPassword.clear();
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El nombre de usuario ya existe.");
			alert.show();
			registerUsername.clear();
			registerPassword.clear();
    	}
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
    public void login(ActionEvent event) throws IOException {
    	if (restaurant.userExists(txtLoginUser.getText())) {
    		if (restaurant.authenticateUser(restaurant.getUser(txtLoginUser.getText()), txtLoginPassword.getText())) {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	    	fxmlLoader.setController(this);
    			Parent userView = fxmlLoader.load();
    			mainPane.getChildren().clear();
    			mainPane.getChildren().add(userView);
    		}
    		else {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("La contraseña es incorrecta.");
    			alert.show();
    			txtLoginPassword.clear();
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El usuario no existe.");
			alert.show();
			txtLoginUser.clear();
			txtLoginPassword.clear();
    	}
    }
    public void manageCustomers(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-manage.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void manageIngredients(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void manageOrders(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void manageProducts(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void manageUsers(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }
    
    @FXML
    public void addCustomer(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-create.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }

    @FXML
    public void editCustomer(ActionEvent event) {
    	
    }

    @FXML
    public void loadCustomerList(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers-list.fxml"));
    	fxmlLoader.setController(this);
		Parent userView = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userView);
    }
}
