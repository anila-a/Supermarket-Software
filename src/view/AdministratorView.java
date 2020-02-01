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

public class AdministratorView {
	
	public void view(Stage st) {
		// Image
		Image img = new Image("image/img.png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(256);
		iv.setFitHeight(256);
		
		// GridPane elements
		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		gp1.setPadding(new Insets(40, 5, 5, 5));
		
		// HBox1 contains buttons
		HBox hb1 = new HBox();
		Button manageUsers = new Button(">> Manage Users");
		Button incomes = new Button(">> Incomes");
		manageUsers.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		incomes.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		hb1.setPadding(new Insets(10, 10, 10, 10));
		hb1.getChildren().addAll(manageUsers, incomes);

		// HBox2 contains Exit button
		HBox hb2 = new HBox();
		Button exitbt = new Button("<< Exit");
		exitbt.setStyle("-fx-background-color: #FF6347; "); // Color button blue				
		
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.CENTER);
		hb2.setPadding(new Insets(10, 10, 10, 10));
		hb2.getChildren().addAll(exitbt);

		gp1.add(hb1, 0, 0);
		gp1.add(hb2, 0, 1);
		
		// GridPane alignment
		gp1.setAlignment(Pos.CENTER);

		// Vertical box
		VBox vb1 = new VBox();
		vb1.getChildren().addAll(iv, gp1);
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(10, 10, 10, 10));
		
		StackPane sp = new StackPane();
		sp.getChildren().add(vb1);

		// Button actions
		manageUsers.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent arg0) {
    			try {
					(new ManageUserView()).view(st);
				} catch (Exception e) {
					System.err.print("ManageUserView not found.");
				}
    	}});
		
		exitbt.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    		public void handle(ActionEvent arg0) {
	    			try {
						(new LoginView()).start(st);
					} catch (Exception e) {
						System.err.print("LoginView not found.");
					}
	    }});
		 
		// Set the scene
		Scene sc = new Scene(sp, 600, 600);
		st.setScene(sc);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Administrator");
		st.show();	
		
		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
}
