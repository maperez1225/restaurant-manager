package ui;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import model.Customer;
import model.Ingredient;
import model.Order;
import model.Product;
import model.ProductType;
import model.Restaurant;
import model.User;
public class RestaurantGUI {
	private Restaurant restaurant;
	public RestaurantGUI(Restaurant r) {
		restaurant = r;
		try {
			restaurant.loadData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		Thread timerThread = new Thread(() -> {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				final String time = simpleDateFormat.format(new Date());
				Platform.runLater(() -> {
					dateTime.setText(time);
				});
			}
		});
		timerThread.start();
	}
	private Order pendingOrder;
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
    private TableColumn<Customer, String> tcCustomerName;
    @FXML
    private TableColumn<Customer, String> tcCustomerLastName;
    @FXML
    private TableColumn<Customer, String> tcCustomerID;
    @FXML
    private TableColumn<Customer, String> tcCustomerAddress;
    @FXML
    private TableColumn<Customer, String> tcCustomerPhone;
    @FXML
    private TableColumn<Customer, String> tcCustomerObservations;
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
    private TextField createIngredientName;
    @FXML
    private CheckBox createIngredientEnable;
	@FXML
	private TextField editCustomerSearchText;
	@FXML
	private TextField editCustomerName;
	@FXML
	private TextField editCustomerLastName;
	@FXML
	private TextField editCustomerID;
	@FXML
	private TextField editCustomerPhone;
	@FXML
	private TextField editCustomerAddress;
	@FXML
	private TextArea editCustomerObservations;
	@FXML
    private TextField createTypeName;
	@FXML
    private TextField txtCreateProductPrice;
    @FXML
    private TextField txtCreateProductName;
    @FXML
    private TextField txtCreateProductSize;
    @FXML
    private TextField txtCustomerPhoneNumber;
    @FXML
    private TextField txtProductAmount;
    @FXML
    private ListView<Ingredient> lvCreateProductIngredients;
    @FXML
    private ChoiceBox<ProductType> choiceCreateProductType;
    @FXML
    private TableView<Product> tvProductsList;
    @FXML
    private TableColumn<Product, String> tcProductName;
    @FXML
    private TableColumn<Product, String> tcProductType;
    @FXML
    private TableColumn<Product, String> tcProductIngredients;
    @FXML
    private TableColumn<Product, String> tcProductSize;
    @FXML
    private TableColumn<Product, String> tcProductPrice;
    @FXML
    private TableColumn<Product, String> tcProductEnabled;
    @FXML
    private ChoiceBox<Product> choiceProductOrder;
    @FXML
	private TableView<Order> tvUpdateOrder;
	@FXML
	private TableColumn<Order, String> tcUpdateName;	
	@FXML
	private TableColumn<Order, String> tcUpdateStatus;
	@FXML
	private Label dateTime;
	@FXML
    private TableView<Product> tvCreateOrderProducts;
    @FXML
    private TableColumn<Product, String> tcCreateOrderPName;
    @FXML
    private TableColumn<Product, String> tcCreateOrderPCost;
	@FXML
    public void addType(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("type-create.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void createType(ActionEvent event) {
    	ProductType type = new ProductType(createTypeName.getText());
    	try {
			restaurant.addType(type);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@FXML
    public void backMain(ActionEvent event){
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
    	fxmlLoader.setController(this);
		Parent userView;
		try {
			userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void backLogin(ActionEvent event){
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-screen.fxml"));
    	fxmlLoader.setController(this);
		Parent userView;
		try {
			userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
			txtLoginUser.clear();
			txtLoginPassword.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
	public void login(ActionEvent event){
		if (restaurant.getUser(txtLoginUser.getText()) >= 0) {
			if (restaurant.authenticateUser(restaurant.getUser(txtLoginUser.getText()), txtLoginPassword.getText())) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area-main.fxml"));
		    	fxmlLoader.setController(this);
				try {
					Parent userView = fxmlLoader.load();
					mainPane.getChildren().clear();
					mainPane.getChildren().add(userView);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
	@FXML
	public void manageUsers(ActionEvent event){
		
	}
	@FXML
	public void launchCreateUser(ActionEvent event){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-screen.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
    public void registerUser(ActionEvent event){
    	User user = new User(registerUsername.getText(), registerPassword.getText(), registerName.getText(), registerLastName.getText(), Long.parseLong(registerId.getText()));
    	if (restaurant.getUser(user.getUsername()) < 0) {
    		try {
				restaurant.addUser(user);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Autenticación");
				alert.setHeaderText(null);
				alert.setContentText("Usuario creado exitosamente.");
				alert.show();
				registerName.clear();
				registerLastName.clear();
				registerUsername.clear();
				registerPassword.clear();
				registerId.clear();
				backLogin(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
    public void manageCustomers(ActionEvent event){
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-manage.fxml"));
    	fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
	public void addCustomer(ActionEvent event){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-create.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void createCustomer(ActionEvent event){
		Customer customer = new Customer(createCustomerName.getText(), createCustomerLastName.getText(), Long.parseLong(createCustomerID.getText()), createCustomerAddress.getText(), Long.parseLong(createCustomerPhone.getText()), createCustomerObservations.getText(), restaurant.getUser(restaurant.getUser(txtLoginUser.getText())));
		if (restaurant.getCustomer(customer.getPhone()) < 0)
			try {
				restaurant.addCustomer(customer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El cliente ya existe.");
			alert.show();
		}
	}
	@FXML
	public void editCustomer(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-edit.fxml"));
    	fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void editCustomerSearch(ActionEvent event) {
		try {
			int index = restaurant.getCustomer(Long.parseLong(editCustomerSearchText.getText()));
			if (index >= 0) {
				Customer customer = restaurant.getCustomers().get(index);
				editCustomerName.setText(customer.getName());
				editCustomerLastName.setText(customer.getLastName());
				editCustomerID.setText(String.valueOf(customer.getId()));
				editCustomerPhone.setText(String.valueOf(customer.getPhone()));
				editCustomerAddress.setText(customer.getAddress());
				editCustomerObservations.setText(customer.getObservations());
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("El número no fue encontrado.");
				alert.show();
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Número inválido.");
			alert.show();
		}
	}
	
	@FXML
	public void saveCustomer(ActionEvent event) {
		try {
			int index = restaurant.getCustomer(Long.parseLong(editCustomerSearchText.getText()));
			Customer customer = new Customer(editCustomerName.getText(), editCustomerLastName.getText(), Long.valueOf(editCustomerID.getText()), editCustomerAddress.getText(), Long.valueOf(editCustomerPhone.getText()), editCustomerObservations.getText(), restaurant.getUser(restaurant.getUser(txtLoginUser.getText())));
			restaurant.deleteCustomer(index);
			restaurant.addCustomer(customer);
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Número inválido.");
			alert.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void loadCustomerList(ActionEvent event){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers-list.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
			ObservableList<Customer> observableList = FXCollections.observableArrayList(restaurant.getCustomers());
			tvCustomers.setItems(observableList);
			tcCustomerName.setCellValueFactory(new PropertyValueFactory<Customer,String>("name")); 
			tcCustomerLastName.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
			tcCustomerID.setCellValueFactory(new PropertyValueFactory<Customer,String>("id"));
			tcCustomerAddress.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
			tcCustomerPhone.setCellValueFactory(new PropertyValueFactory<Customer,String>("phone"));
			tcCustomerObservations.setCellValueFactory(new PropertyValueFactory<Customer,String>("observations"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
    public void manageIngredients(ActionEvent event){
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredient-manage.fxml"));
    	fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
	public void addIngredient(ActionEvent event) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredient-create.fxml"));
    	fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void createIngredient(ActionEvent event) {
		Ingredient ingredient = new Ingredient(createIngredientName.getText(),createIngredientEnable.isSelected(), restaurant.getUser(restaurant.getUser(txtLoginUser.getText())));
		if (restaurant.getIngredient(ingredient.getName()) < 0)
			try {
				restaurant.addIngredient(ingredient);
				createIngredientName.clear();
				createIngredientEnable.setSelected(true);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Operación Exitosa");
				alert.setHeaderText(null);
				alert.setContentText("Ingrediente creado exitosamente.");
				alert.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El ingrediente ya existe.");
			alert.show();
		}
	}
	@FXML
	public void editIngredient(ActionEvent event) {
		
	}
	@FXML
	public void loadIngredientList(ActionEvent event) {
		
	}
	@FXML
	public void manageOrders(ActionEvent event){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-manage.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
    public void createOrderWindow(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-create.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
			choiceProductOrder.setItems(FXCollections.observableArrayList(restaurant.getProducts()));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void manageOrder(ActionEvent event) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-manage.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	@FXML
	public void updateOrder(ActionEvent event) {
		tvUpdateOrder.getSelectionModel().getSelectedItem().updateStatus();
	}
	@FXML
	public void backOrderManage(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-manage.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void createOrder(ActionEvent event) {
		
	}
	@FXML
	public void orderCustomerSearch(ActionEvent event) {
		try {
			int index = restaurant.getCustomer(Long.parseLong(txtCustomerPhoneNumber.getText()));
			if (index < 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Cliente no encontrado.");
				alert.show();
			}
			else {
				pendingOrder = new Order(restaurant.getUser(restaurant.getUser(txtLoginUser.getText())), restaurant.getCustomer(index));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void manageProducts(ActionEvent event){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-manage.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void createProduct(ActionEvent event) {
		Product product = new Product(txtCreateProductName.getText(), choiceCreateProductType.getValue(), null, txtCreateProductSize.getText(), Integer.valueOf(txtCreateProductPrice.getText()));
		if (restaurant.getProduct(product.getName()) < 0)
			try {
				restaurant.addProduct(product);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Operación Exitosa");
				alert.setHeaderText(null);
				alert.setContentText("Producto creado exitosamente.");
				alert.show();
				backMain(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El producto ya existe.");
			alert.show();
		}
	}
	@FXML
	public void addProduct(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-create.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
			choiceCreateProductType.setItems(FXCollections.observableArrayList(restaurant.getTypes()));
			lvCreateProductIngredients.setItems(FXCollections.observableArrayList(restaurant.getIngredients()));
			lvCreateProductIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void addProductToOrder(ActionEvent event) {
		pendingOrder.addProduct(choiceProductOrder.getValue());
		ObservableList<Product> observableList = FXCollections.observableArrayList(pendingOrder.getProducts());
		tvCreateOrderProducts.setItems(observableList);
		tcCreateOrderPName.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
		tcCreateOrderPCost.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));
	}
	@FXML
	public void loadProductList(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products-list.fxml"));
		fxmlLoader.setController(this);
		try {
			Parent userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
			ObservableList<Product> observableList = FXCollections.observableArrayList(restaurant.getProducts());
			tvProductsList.setItems(observableList);
			tcProductName.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
			tcProductType.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
			tcProductIngredients.setCellValueFactory(new Callback<CellDataFeatures<Product, String>, ObservableValue<String>>() {
			     public ObservableValue<String> call(CellDataFeatures<Product, String> p) {
			         return new ReadOnlyObjectWrapper<String>(Arrays.toString(p.getValue().getIngredients()));
			     }
			  });
			tcProductSize.setCellValueFactory(new PropertyValueFactory<Product,String>("size"));
			tcProductPrice.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));
			tcProductEnabled.setCellValueFactory(new PropertyValueFactory<Product,String>("enabled"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}