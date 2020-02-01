/* 
 * CEN 215 - Object Oriented Programming - Supermarket Software project
 * Fall 2019 - Computer Engineering - Epoka University
 * 
 * Created by Anila - January 2020
 * 
 * */

package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EconomistView {

	public void view(Stage st) {
		// Image
		Image img = new Image("image/img.png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(256);
		iv.setFitHeight(256);
		
		// GridPane1 elements
		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		gp1.setPadding(new Insets(40, 5, 5, 5));
		
		// HBox1 contains buttons
		HBox hb1 = new HBox();
		Button addProduct = new Button(">> Manage Products");
		Button suppliers = new Button(">> Manage Suppliers");
		addProduct.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		suppliers.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
				
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		hb1.setPadding(new Insets(10, 10, 10, 10));
		hb1.getChildren().addAll(addProduct, suppliers);
		
		// HBox2 contains buttons
		HBox hb2 = new HBox();
		
		Button performance = new Button(">> Performance");
		Button statistics = new Button(">> Statistics");
		performance.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		statistics.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
								
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.CENTER);
		hb2.setPadding(new Insets(10, 10, 10, 10));
		hb2.getChildren().addAll(performance, statistics);
		
		// HBox3 contains button
		HBox hb3 = new HBox();
		Button exit = new Button("<< Exit");
		exit.setStyle("-fx-background-color: #FF6347; "); // Color button blue				
		
		// HBox3 set alignment and elements
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.CENTER);
		hb3.setPadding(new Insets(10, 10, 10, 10));
		hb3.getChildren().addAll(exit);
		
		// GridPane1 add elements
		gp1.add(hb1, 0, 0);
		gp1.add(hb2, 0, 1);
		gp1.add(hb3, 0, 2);
		
		// GridPane1 alignment
		gp1.setAlignment(Pos.CENTER);

		// VBox1 contains Image and GridPane1
		VBox vb1 = new VBox();
		vb1.getChildren().addAll(iv, gp1);
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(10, 10, 10, 10));
		
		// StackPane contains VBox1
		StackPane sp = new StackPane();
		sp.getChildren().add(vb1);
		
		// Button actions
		addProduct.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				(new AddProductView()).view(st);
			}
		});

		suppliers.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				(new AddSupplierView()).view(st);
			}
		});
		
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					(new LoginView()).start(st);
				} catch (Exception e) {
					System.err.println("LoginView not found!");
				}
			}
		});
		
		// Set the scene
		Scene sc = new Scene(sp, 600, 600);
		st.setScene(sc);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Economist");
		st.show();

		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
}
