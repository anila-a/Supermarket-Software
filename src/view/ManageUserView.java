/* 
 * CEN 215 - Object Oriented Programming - Supermarket Software project
 * Fall 2019 - Computer Engineering - Epoka University
 * 
 * Created by Anila - January 2020
 * 
 * */

package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import model.Cashier;
import model.Date;
import model.Economist;
import model.User;
import model.RW.RWUser;

public class ManageUserView {

	private TableView<User> table = new TableView<User>();
	private ObservableList<User> data = FXCollections.observableArrayList();
	
	Label name = new Label("Name: "); TextField nametf = new TextField();
	Label surname = new Label("     Surname: "); TextField surnametf = new TextField();
	Label password = new Label("     Password: "); TextField passwordtf = new TextField();
	Label username = new Label("Username: "); TextField usernametf = new TextField();
	Label bday = new Label("Birthday: "); TextField bdaytf = new TextField();
	Label email = new Label("     Email: "); TextField emailtf = new TextField();
	Label phone = new Label("Phone: "); TextField phonetf = new TextField();
	Label address = new Label("     Address: "); TextField addresstf = new TextField();
	Label level = new Label("Level: "); TextField leveltf = new TextField();
	Label salary = new Label("     Salary: "); TextField salarytf = new TextField();

	public void view(Stage st) {
		// Table - Column 0
		TableColumn<User, Integer> column0 = new TableColumn<>("ID");
		column0.setMinWidth(170);
		column0.setStyle( "-fx-alignment: CENTER;");
		column0.setCellValueFactory(new PropertyValueFactory<>("id")); //gets values
		// Table - Column 1
		TableColumn<User, String> column1 = new TableColumn<>("Name");
		column1.setMinWidth(170);
		column1.setStyle( "-fx-alignment: CENTER;");
		column1.setCellValueFactory(new PropertyValueFactory<>("name")); //gets values
		// Table - Column 2
		TableColumn<User, String> column2 = new TableColumn<>("Surname");
		column2.setMinWidth(170);
		column2.setStyle( "-fx-alignment: CENTER;");
		column2.setCellValueFactory(new PropertyValueFactory<>("surname")); //gets values
		// Table - Column 3
		TableColumn<User, String> column3 = new TableColumn<>("Username");
		column3.setMinWidth(170);
		column3.setStyle( "-fx-alignment: CENTER;");
		column3.setCellValueFactory(new PropertyValueFactory<>("username")); //gets values
		// Table - Column 4
		TableColumn<User, String> column4 = new TableColumn<>("Level");
		column4.setMinWidth(170);
		column4.setStyle( "-fx-alignment: CENTER;");
		column4.setCellValueFactory(new PropertyValueFactory<>("level")); //gets values
		// Table - Column 5
		TableColumn<User, Date> column5 = new TableColumn<>("Birthday");
		column5.setMinWidth(170);
		column5.setStyle( "-fx-alignment: CENTER;");
		column5.setCellValueFactory(new PropertyValueFactory<>("bday")); //gets values
		// Table - Column 6
		TableColumn<User, String> column6 = new TableColumn<>("Email");
		column6.setMinWidth(170);
		column6.setStyle( "-fx-alignment: CENTER;");
		column6.setCellValueFactory(new PropertyValueFactory<>("email")); //gets values
		// Table - Column 7
		TableColumn<User, String> column7 = new TableColumn<>("Phone");
		column7.setMinWidth(170);
		column7.setStyle( "-fx-alignment: CENTER;");
		column7.setCellValueFactory(new PropertyValueFactory<>("phone")); //gets values
		// Table - Column 8
		TableColumn<User, String> column8 = new TableColumn<>("Address");
		column8.setMinWidth(170);
		column8.setStyle( "-fx-alignment: CENTER;");
		column8.setCellValueFactory(new PropertyValueFactory<>("address")); //gets values
		// Table - Column 9
		TableColumn<User, String> column9 = new TableColumn<>("Salary");
		column9.setMinWidth(170);
		column9.setStyle( "-fx-alignment: CENTER;");
		column9.setCellValueFactory(new PropertyValueFactory<>("salary")); //gets values
		
		// Add products to the table
		table.getColumns().addAll(column0, column1, column2, column3, column4, column5, column6, column7, column8, column9);
		data = getUser();
		table.setItems(data);
		table.setEditable(true);
		
		// VBox1 contains the table
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(0, 20, 30, 20));
		vb1.setSpacing(10);
		vb1.getChildren().addAll(table);
		
		// GridPane1 contains VBox1
		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		gp1.add(vb1, 0, 0);	
		vb1.setAlignment(Pos.CENTER);
		gp1.setAlignment(Pos.CENTER);
		
		// Menu Bar
		MenuBar menuBar = new MenuBar();
				
		Label menuManage = new Label(">> Manage Users");
		Menu menuM = new Menu("", menuManage);
		Label menuInc = new Label(">> Incomes");
		Menu menuI = new Menu("", menuInc);
				
		// Set menus
		menuBar.getMenus().add(menuM);
		menuBar.getMenus().add(menuI);

		// Menu actions
		menuManage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				try {
					(new ManageUserView()).view(st);
				} catch(Exception ex){
					System.err.println("ManageUserView not found!");
				}
			}
		});
				
		menuInc.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				/*try {
					(new AddSupplierView()).view(st);
				} catch(Exception ex){
					System.err.println("AddSupplieView not found!");
				}
			}*/
		}});
				
		// Buttons
		// HBox contains Add, Edit, and Delete buttons
		HBox hb = new HBox();
		Button addbt = new Button("Add");
		Button editbt = new Button("Edit");
		Button deletebt = new Button("Delete");
		addbt.setStyle("-fx-background-color: #90EE90; "); // Color button green
		editbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		deletebt.setStyle("-fx-background-color: #FF6347; "); // Color button red
			
		hb.getChildren().addAll(addbt, editbt, deletebt);
		hb.setSpacing(10);
		hb.setPadding(new Insets(5, 10, 30, 20));
		hb.setAlignment(Pos.CENTER_LEFT);
				
		// HBox2 contains Back button
		HBox hb2 = new HBox();
		Button backbt = new Button("<< Back");
		backbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		hb2.getChildren().addAll(backbt);
		hb2.setSpacing(10);
		hb2.setPadding(new Insets(0, 10, 30, 20));
		hb2.setAlignment(Pos.TOP_LEFT);
					
		// GridPane2 contains HBox and HBox2
		GridPane gp2 = new GridPane();
		gp2.setHgap(10);
		gp2.setVgap(10);
		gp2.add(hb, 0, 0);
		gp2.add(hb2, 0, 1);
		
		// VBox2 contains GridPane1, HBox2, and GridPane2
		VBox vb2 = new VBox();
		vb2.getChildren().addAll(gp1, hb, hb2);
		vb2.setAlignment(Pos.CENTER);
		vb2.setPadding(new Insets(120, 10, 10, 10));

		// GridPane3 contains VBox2
		GridPane gp3 = new GridPane();
		gp3.setHgap(10);
		gp3.setVgap(10);
		gp3.add(vb2, 0, 0);
		gp3.setAlignment(Pos.CENTER);
		
		// VBox contains GridPane3
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(0, 20, 30, 20));
		vb.setSpacing(10);
		vb.getChildren().addAll(gp3);
				
		// BorderPane contains VBox
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		bp.setCenter(vb);
				
		// Button actions
		addbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// GridPane contains Labels and TextFields
				GridPane gp = new GridPane();
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));

				// Add elements in GridPane
				gp.add(name, 0, 0); gp.add(nametf, 1, 0);
				gp.add(surname, 2, 0); gp.add(surnametf, 3, 0);
				gp.add(username, 0, 1); gp.add(usernametf, 1, 1);
				gp.add(password, 2, 1); gp.add(passwordtf, 3, 1);
				gp.add(bday, 0, 2); gp.add(bdaytf, 1, 2);
				gp.add(email, 2, 2); gp.add(emailtf, 3, 2);
				gp.add(phone, 0, 3); gp.add(phonetf, 1, 3);
				gp.add(address, 2, 3); gp.add(addresstf, 3, 3);
				gp.add(level, 0, 4); gp.add(leveltf, 1, 4);
				gp.add(salary, 2, 4); gp.add(salarytf, 3, 4);
				
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));
			
				// Buttons in HBox
				HBox hb = new HBox();
				Button savebt = new Button("Save");
				Button cancelbt = new Button("Cancel");
				savebt.setStyle("-fx-background-color: #90EE90; "); // Color button green
				cancelbt.setStyle("-fx-background-color: #FF6347; "); // Color button red
				hb.setSpacing(10);
				hb.setAlignment(Pos.CENTER);
				hb.setPadding(new Insets(5, 10, 10, 10));
				hb.getChildren().addAll(savebt, cancelbt);
				
				// VBox contains GridPane and HBox
				VBox vb = new VBox();
				vb.getChildren().addAll(gp, hb);
				vb.setAlignment(Pos.CENTER);
				gp.setAlignment(Pos.CENTER);
				vb.setPadding(new Insets(0, 0, 0, 0));
					
				// StackPane contains VBox
				StackPane st2 = new StackPane();
				st2.getChildren().addAll(vb);
				
				Scene secondScene = new Scene(st2, 750, 500);
			
				// New window (Stage)
	            Stage newWindow = new Stage();
	            newWindow.setTitle("Supermarket Software - Add User");
	            newWindow.setScene(secondScene);
	            Image ico = new Image("image/img.png");
	            newWindow.getIcons().add(ico);
	            newWindow.initModality(Modality.WINDOW_MODAL); // Specify modality
	            newWindow.initOwner(st); // Specify parent window
	            newWindow.show();
	            
	            savebt.setOnAction(new EventHandler<ActionEvent>() {
	    			@Override
	    			public void handle(ActionEvent event) {
	    				RWUser rwu = new RWUser();
	    				
	    				String phonePattern = "\\(\\d{3}\\)\\d{9}";
	    				String salaryPattern = "^[0-9]+$";
	    				//String bdayPattern = "[0-9]{1,2} + [/-] + [0-9]{1,2} + [/-] + [0-9]{1,9}";
	    				
	    				String name = nametf.getText();
	    				String surname = surnametf.getText();
	    				String username = usernametf.getText();
	    				String password = passwordtf.getText();
	    				Date bday = new Date(bdaytf.getText());
	    				String email = emailtf.getText();
	    				String phone = phonetf.getText();
	    				String address = addresstf.getText();
	    				String level = leveltf.getText();
	    				String salary = salarytf.getText();
	    				
	    				if(!phonetf.getText().matches(phonePattern)) {
	    					Alert alert = new Alert(AlertType.ERROR, "Wrong Phone Input Format!", ButtonType.OK);
			    			alert.show();	
	    				} else if(!salarytf.getText().matches(salaryPattern)) {
	    					Alert alert = new Alert(AlertType.ERROR, "Wrong Salary Input Format!", ButtonType.OK);
			    			alert.show();	
	    				} else {
	    					if(level.equals("Economist")) {
	    						rwu.addUser(new Economist(username, password, name, surname,
	    								bday, email, phone, address, level, salary));
	    					} else if(level.equals("Cashier")) {
	    						rwu.addUser(new Cashier(username, password, name, surname,
	    								bday, email, phone, address, level, salary));
	    					}
	    				
	    				data = getUser();
	    				table.setItems(data);
		    					
		    			Alert alert = new Alert(AlertType.CONFIRMATION, "User added successfully!", ButtonType.OK);
		    			alert.show();	
		    			newWindow.close();
		    			
		    			nametf.clear(); surnametf.clear(); usernametf.clear(); passwordtf.clear(); bdaytf.clear();
		    			emailtf.clear(); phonetf.clear(); addresstf.clear(); leveltf.clear(); salarytf.clear();
	    			}}
	    		});
	            
	           cancelbt.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    		public void handle(ActionEvent event) {
	    			newWindow.close();
	    		}
	    	});
	    }});

		editbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// GridPane contains Labels and TextFields
				GridPane gp = new GridPane();
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));

				// Add elements in GridPane
				gp.add(username, 0, 0); gp.add(usernametf, 1, 0);
				gp.add(password, 2, 0); gp.add(passwordtf, 3, 0);
				
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));
			
				// Buttons in HBox
				HBox hb = new HBox();
				Button savebt = new Button("Save Changes");
				Button cancel2bt = new Button("Cancel");
				savebt.setStyle("-fx-background-color: #90EE90; "); // Color button green
				cancel2bt.setStyle("-fx-background-color: #FF6347; "); // Color button red
				hb.setSpacing(10);
				hb.setAlignment(Pos.CENTER);
				hb.setPadding(new Insets(5, 10, 10, 10));
				hb.getChildren().addAll(savebt, cancel2bt);
				
				// VBox contains GridPane and HBox
				VBox vb = new VBox();
				vb.getChildren().addAll(gp, hb);
				vb.setAlignment(Pos.CENTER);
				gp.setAlignment(Pos.CENTER);
				vb.setPadding(new Insets(0, 0, 0, 0));
					
				// StackPane contains VBox
				StackPane st2 = new StackPane();
				st2.getChildren().addAll(vb);
				
				Scene secondScene = new Scene(st2, 750, 500);
			
				// New window (Stage)
	            Stage newWindow = new Stage();
	            newWindow.setTitle("Supermarket Software - Edit User");
	            newWindow.setScene(secondScene);
	            Image ico = new Image("image/img.png");
	            newWindow.getIcons().add(ico);
	            newWindow.initModality(Modality.WINDOW_MODAL); // Specify modality
	            newWindow.initOwner(st); // Specify parent window
	            newWindow.show();
	            
	            savebt.setOnAction(new EventHandler<ActionEvent>() {
	    			@Override
	    			public void handle(ActionEvent event) {
	    				RWUser rwu = new RWUser();
	    				User u = (User)table.getSelectionModel().getSelectedItems().get(0);

	    				rwu.getUserByID(u.getId()).setUsername(usernametf.getText());
	    				rwu.getUserByID(u.getId()).setPassword(passwordtf.getText());
	    				
	    				rwu.update();	
	    				
	    				data = getUser();
	    				table.setItems(data);
		    					
		    			Alert alert = new Alert(AlertType.CONFIRMATION, "User edited successfully!", ButtonType.OK);
		    			alert.show();	
		    			
		    			newWindow.close();
	    			}});
	            
	           cancel2bt.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    		public void handle(ActionEvent event) {
	    			newWindow.close();
	    		}
	    	});
	    }});

		 deletebt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				RWUser rwu = new RWUser();
 				User u = (User)table.getSelectionModel().getSelectedItems().get(0);
 				User usr = (User) rwu.getUserByID(u.getId());
 				
 				rwu.deleteUser(usr);
 				
 				data = getUser();
 				table.setItems(data);
 				
 				Alert alert = new Alert(AlertType.CONFIRMATION, "User deleted successfully!", ButtonType.OK);
    			alert.show();
 			}
 		});
		 
		backbt.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    		public void handle(ActionEvent event) {
	    			try {
						(new AdministratorView()).view(st);
					} catch (Exception e) {
						System.err.println("AdministratorView not found!");
					}
	    		}
	    	});

		// Set scene
		Scene scene = new Scene(bp, 1800, 900);
		st.setScene(scene);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Manage Users");
		st.show();

		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
			
	private ObservableList<User> getUser() {
		RWUser rwu = new RWUser();
		Object[] list = rwu.getUser().toArray();
		Text[] arr = new Text[list.length];
		
		for(int i = 0; i < list.length; i++)
			if(list[i] instanceof Economist)
				arr[i] = new Text("ID: " + ((Economist)list[i]).getId() + " -> " + ((Economist)list[i]).getLevel() + list[i].toString());
			else if(list[i] instanceof Cashier)
				arr[i] = new Text("ID: " + ((Cashier)list[i]).getId() + " -> " + ((Cashier)list[i]).getLevel() + list[i].toString());
		
		ObservableList data = FXCollections.observableArrayList(list);
		
		return data;
	}
}
