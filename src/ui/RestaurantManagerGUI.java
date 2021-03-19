package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RestaurantManagerGUI {

    @FXML
    private TableView<?> tvProductsList;

    @FXML
    private TableColumn<?, ?> tcProduct;

    @FXML
    private TableColumn<?, ?> tcSize;

    @FXML
    private TableColumn<?, ?> tcPrize;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPassword;

    @FXML
    private TableView<?> tvCustomer;

    @FXML
    private TableColumn<?, ?> tcName;

    @FXML
    private TableColumn<?, ?> tcLastName;

    @FXML
    private TableColumn<?, ?> tcID;

    @FXML
    private TableColumn<?, ?> tcAdress;

    @FXML
    private TableColumn<?, ?> tcMobilePhone;

    @FXML
    private TableColumn<?, ?> tcObservations;
    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void manageCustomers(ActionEvent event) {

    }

    @FXML
    void manageIngredients(ActionEvent event) {

    }

    @FXML
    void manageOrders(ActionEvent event) {

    }

    @FXML
    void manageProducts(ActionEvent event) {

    }

    @FXML
    void manageUsers(ActionEvent event) {

    }

    @FXML
    void backProductFromManager(ActionEvent event) {

    }

    @FXML
    void createProduct(ActionEvent event) {

    }

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void disableProduct(ActionEvent event) {

    }

    @FXML
    void showProductsList(ActionEvent event) {

    }

    @FXML
    void updateProduct(ActionEvent event) {

    }
    @FXML
    private TextField txtProductName;

    @FXML
    void addProduct(ActionEvent event) {

    }

    @FXML
    void backAddProductToProductManager(ActionEvent event) {

    }
}