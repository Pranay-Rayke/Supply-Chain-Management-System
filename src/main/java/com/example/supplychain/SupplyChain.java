package com.example.supplychain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SupplyChain extends Application {

    public static int width = 700, height = 500, headerBar = 50;

    Pane bodyPane = new Pane();

    Login login = new Login();

    ProductDetails productDetatils = new ProductDetails();

    Button globalLoginButton;

    Button globalSignUpButton;
    Label customerEmailLabel = null;

    String customerEmail = null;



    private GridPane headerBar(){

        TextField searchText = new TextField();
        Button searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = searchText.getText();
                //clear body and put this new pane in the body
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(productDetatils.getProductsByName(productName));
            }
        });


        globalLoginButton = new Button("Log In");

        globalSignUpButton = new Button("Sign Up");
        globalLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(loginPage());
                globalLoginButton.setDisable(true);
                customerEmailLabel.setText("Welcome : " + customerEmail);
            }
        });

        globalSignUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(signUpPage());
                globalSignUpButton.setDisable(true);
                customerEmailLabel.setText("Welcome User");
            }
        });

        customerEmailLabel = new Label("Welcome User!");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),headerBar-10);
        gridPane.setVgap(5);
        gridPane.setHgap(7);
        gridPane.setStyle("-fx-background-color : orange");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(searchText,0,0);
        gridPane.add(searchButton,1,0);
        gridPane.add(globalLoginButton,2,0);
        gridPane.add(globalSignUpButton,3,0);
        gridPane.add(customerEmailLabel,4,0);

        return gridPane;

    }

    private GridPane loginPage(){

        Label emailLabel = new Label("Email");
        Label passwordLabel = new Label("Password");
        Label messageLabel = new Label("Hello User!");

        TextField emailTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Log In");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String email = emailTextField.getText();
                String password = passwordField.getText();
                //messageLabel.setText(email + " $$ " + password);
                if(login.customerLogin(email,password)){
                    messageLabel.setText("Login Successful");
                    customerEmail = email;
                    globalLoginButton.setDisable(true);
                    customerEmailLabel.setText("Welcome : " + customerEmail);
                    bodyPane.getChildren().clear();
                    bodyPane.getChildren().add(productDetatils.getAllProducts());
                }
                else{
                    messageLabel.setText("Invalid email or password");
                }
            }
        });


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),bodyPane.getMinHeight());
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        //gridPane.setStyle("-fx-background-color : ");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(loginButton,0,2);
        gridPane.add(messageLabel,1,2);

        return gridPane;
    }

    private GridPane signUpPage(){

        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label city = new Label("City");
        Label mobileNumber = new Label("Mobile No.");
        Label userEmail = new Label("Email");
        Label userPassword = new Label("Password");
        Label messageLabel = new Label("Hello User");

        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField cityTextField = new TextField();
        TextField mobileNumberTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField passwordField = new PasswordField();

        Button signUp = new Button("Sign Up");

        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String city = cityTextField.getText();
                String mobileNumber = mobileNumberTextField.getText();
                String userEmail = emailTextField.getText();
                String userPassword = passwordField.getText();

                if (SignUp.customerSignUp(firstName, lastName, city, mobileNumber, userEmail, userPassword)) {
                    messageLabel.setText("Sign Up Successful");
                    globalLoginButton.setDisable(true);
                } else {
                    messageLabel.setText("Invalid Details");
                }

            }

        });


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),bodyPane.getMinHeight());
        gridPane.setVgap(5);
        gridPane.setHgap(30);
        // gridPane.setStyle("-fx-background-color : #C0C0C0");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(firstName,0,0);
        gridPane.add(firstNameTextField,1,0);
        gridPane.add(lastName,0,1);
        gridPane.add(lastNameTextField,1,1);
        gridPane.add(city,0,2);
        gridPane.add(cityTextField,1,2);
        gridPane.add(mobileNumber,0,3);
        gridPane.add(mobileNumberTextField,1,3);
        gridPane.add(userEmail,0,4);
        gridPane.add(emailTextField,1,4);
        gridPane.add(userPassword,0,5);
        gridPane.add(passwordField,1,5);
        gridPane.add(signUp,1,6);
        gridPane.add(messageLabel,1,7);
        return gridPane;
    }

    private GridPane footerBar(){

        //Button addToCartButton = new Button("Add to cart");
        Button buyNowButton = new Button("Buy Now");

        Label messageLabel = new Label("");

        buyNowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product selectedProduct = productDetatils.getSelectedProduct();
                if(Order.placeOrder(customerEmail, selectedProduct)){
                    messageLabel.setText("Order Placed");
                }
                else{
                    messageLabel.setText("Order Failed");
                }
            }
        });


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),headerBar-10);
        gridPane.setVgap(5);
        gridPane.setHgap(50);
        gridPane.setStyle("-fx-background-color : orange");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setTranslateY(headerBar+height+5);

        //gridPane.add(addToCartButton,0,0);
        gridPane.add(buyNowButton,0,0);
        gridPane.add(messageLabel,1,0);
        return gridPane;

    }


    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width,height+2*headerBar);
        bodyPane.setMinSize(width,height);
        bodyPane.setTranslateY(headerBar);
        bodyPane.getChildren().addAll(productDetatils.getAllProducts());
        root.getChildren().addAll(headerBar() , bodyPane, footerBar());
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());

        stage.getIcons().add(new Image(SupplyChain.class.getResourceAsStream("amazon.png")));
        stage.setTitle("Mini Amazon !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}