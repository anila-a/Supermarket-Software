/* 
 * CEN 215 - Object Oriented Programming - Supermarket Software project
 * Fall 2019 - Computer Engineering - Epoka University
 * 
 * Created by Anila - January 2020
 * 
 * */

package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

import model.Administrator;
import model.Cashier;
import model.Economist;
import model.Product;
import model.User;
import model.RW.RWUser;

public class LoginView extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage st) throws Exception {
		// Image
		Image img = new Image("image/img.png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(256);
		iv.setFitHeight(256);
		
		// GridPane elements
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(40, 5, 5, 5));
		
		Text text1 = new Text();
		text1.setText("Supermarket Software");
		text1.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
		text1.setTextAlignment(TextAlignment.CENTER);
		
		Text text2 = new Text();
		text2.setText("Please enter your username and password:");
		text2.setTextAlignment(TextAlignment.CENTER);

		// HBox1 contains text
		HBox hb1 = new HBox();
		hb1.setSpacing(5);
		hb1.getChildren().addAll(text1);
		hb1.setAlignment(Pos.CENTER);
		hb1.setPadding(new Insets(40, 10, 0, 10));
		
		// HBox3 contains text
		HBox hb3 = new HBox();
		hb3.setSpacing(5);
		hb3.getChildren().addAll(text2);
		hb3.setAlignment(Pos.CENTER);
		hb3.setPadding(new Insets(40, 10, 0, 10));
		
		Label username = new Label("Username: ");
		Label password = new Label("Password: ");
		TextField usernametf = new TextField();
		PasswordField passwordpf = new PasswordField();

		// GridPane add elements
		gp.add(username, 0, 0);
		gp.add(usernametf, 1, 0);
		gp.add(password, 0, 1);
		gp.add(passwordpf, 1, 1);
		
		// GridPane alignment
		gp.setAlignment(Pos.CENTER);
		username.setAlignment(Pos.BOTTOM_RIGHT);
		usernametf.setAlignment(Pos.BOTTOM_LEFT);
		password.setAlignment(Pos.BOTTOM_RIGHT);
		passwordpf.setAlignment(Pos.BOTTOM_LEFT);
				
		// Buttons in HBox2 
		HBox hb2 = new HBox();
		Button loginbt = new Button("Login");
		Button exitbt = new Button("Exit");
		loginbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		exitbt.setStyle("-fx-background-color: #FF6347; "); // Color button red
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.CENTER);
		hb2.setPadding(new Insets(20, 10, 10, 10));
		hb2.getChildren().addAll(loginbt, exitbt);
		
		// VBox contains Image, HBox1, GridPane, and HBox2
		VBox vb = new VBox();
		vb.getChildren().addAll(iv, hb1, hb3, gp, hb2);
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(10, 10, 10, 10));

		// StackPane contains VBox
		StackPane sp = new StackPane();
		sp.getChildren().addAll(vb);
		
		// Button actions
		exitbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		loginbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RWUser rwu = new RWUser();
				
				String username = usernametf.getText();
				String password = passwordpf.getText();
				
				User user = rwu.checkLogin(username, password);
				
				if(user instanceof Cashier) {
					(new CashierView()).view(st);
				} else if(user instanceof Economist) {
					(new EconomistView()).view(st);
				} else if(user instanceof Administrator) {
					(new AdministratorView()).view(st);
				} else {
					Alert alert = new Alert(AlertType.ERROR, "Incorrect username or password!", ButtonType.OK);
					alert.show();
				}
			}
		});

		// Set the scene
		Scene sc = new Scene(sp, 700, 700);
		st.setScene(sc);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Login");
		st.show();	

		// Set scene alignment after
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
}
