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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import model.Supplier;
import model.RW.RWSupplier;

public class AddSupplierView {

	private TableView<Supplier> table = new TableView<Supplier>();
	private ObservableList<Supplier> data = FXCollections.observableArrayList();

	public void view(Stage st) {
		// Table - Column 1
		TableColumn<Supplier, Integer> column0 = new TableColumn<>("ID");
		column0.setMinWidth(170);
		column0.setCellValueFactory(new PropertyValueFactory<>("id")); //gets values
		column0.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 1
		TableColumn<Supplier, String> column1 = new TableColumn<>("Name");
		column1.setMinWidth(170);
		column1.setCellValueFactory(new PropertyValueFactory<>("name")); //gets values
		column1.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 2
		TableColumn<Supplier, String> column2 = new TableColumn<>("Surname");
		column2.setMinWidth(170);
		column2.setCellValueFactory(new PropertyValueFactory<>("surname")); //gets values
		column2.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 3
		TableColumn<Supplier, String> column3 = new TableColumn<>("Email");
		column3.setMinWidth(170);
		column3.setCellValueFactory(new PropertyValueFactory<>("email")); //gets values
		column3.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 4
		TableColumn<Supplier, String> column4 = new TableColumn<>("Phone");
		column4.setMinWidth(170);
		column4.setCellValueFactory(new PropertyValueFactory<>("phone")); //gets values
		column4.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 5
		TableColumn<Supplier, String> column5 = new TableColumn<>("Address");
		column5.setMinWidth(170);
		column5.setCellValueFactory(new PropertyValueFactory<>("address")); //gets values
		column5.setStyle( "-fx-alignment: CENTER;");
		
		// Add products to the table
		table.getColumns().addAll(column0, column1, column2, column3, column4, column5);
		data = getSupplier();
		table.setItems(data);
		table.setEditable(true);
		
		// VBox1 contains the table
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(0, 10, 30, 20));
		vb1.setSpacing(10);
		vb1.getChildren().addAll(table);
		
		// GridPane1 contains VBox1
		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		gp1.add(vb1, 0, 0);	
		vb1.setAlignment(Pos.CENTER);
		gp1.setAlignment(Pos.CENTER);
				
		// HBox2 below the table
		HBox hb2 = new HBox();
		hb2.setSpacing(10);
		hb2.setPadding(new Insets(5, 10, 30, 20));
		hb2.setAlignment(Pos.CENTER);
				
		TextField nameInput = new TextField(); // Name input field
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		TextField surnameInput = new TextField(); // Name input field
		surnameInput.setPromptText("Surname");
		surnameInput.setMinWidth(100);
		TextField emailInput = new TextField(); // Name input field
		emailInput.setPromptText("Email");
		emailInput.setMinWidth(100);
		TextField phoneInput = new TextField(); // Name input field
		phoneInput.setPromptText("Phone");
		phoneInput.setMinWidth(100);
		TextField addressInput = new TextField(); // Name input field
		addressInput.setPromptText("Address");
		addressInput.setMinWidth(100);
		
		// Add and Delete buttons
		Button addbt = new Button("Add");
		Button deletebt = new Button("Delete");
		addbt.setStyle("-fx-background-color: #90EE90; "); // Color button blue
		deletebt.setStyle("-fx-background-color: #FF6347; "); // Color button blue
		
		// Add elements in HBox2
		hb2.getChildren().addAll(nameInput, surnameInput, emailInput, phoneInput, addressInput, addbt, deletebt);
		Button backbt = new Button("<< Back");	
		backbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		
		// HBox3 contains Back button
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(backbt);
		hb3.setSpacing(10);
		hb3.setPadding(new Insets(0, 10, 30, 20));
		hb3.setAlignment(Pos.TOP_LEFT);
				
		// GridPane2 contains HBox3 and HBox4
		GridPane gp2 = new GridPane();
		gp2.setHgap(10);
		gp2.setVgap(10);
		gp2.add(hb3, 0, 0);
		
		// VBox2 contains GridPane1, HBox2, and GridPane2
		VBox vb2 = new VBox();
		vb2.getChildren().addAll(gp1, hb2, gp2);
		vb2.setAlignment(Pos.CENTER);
		vb2.setPadding(new Insets(120, 10, 10, 10));

		// GridPane3 contains VBox2
		GridPane gp3 = new GridPane();
		gp3.setHgap(10);
		gp3.setVgap(10);
		gp3.add(vb2, 0, 0);
		gp3.setAlignment(Pos.CENTER);
		
		// Menu Bar
		MenuBar menuBar = new MenuBar();
				
		Label menuProd = new Label(">> Manage Products");
		Menu menuP = new Menu("", menuProd);
		Label menuSup = new Label(">> Manage Supplier");
		Menu menuS = new Menu("", menuSup);
		Label menuPerf = new Label(">> Performance");
		Menu menuPe = new Menu("", menuPerf);
		Label menuStat = new Label(">> Statistics");
		Menu menuSt = new Menu("", menuStat);
				
		// Set menus
		menuBar.getMenus().add(menuP);
		menuBar.getMenus().add(menuS);
		menuBar.getMenus().add(menuPe);
		menuBar.getMenus().add(menuSt);
				
		// Menu actions
		menuProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				try {
					(new AddProductView()).view(st);
				} catch(Exception ex){
					System.err.println("AddProductView not found!");
				}
			}
		});
				
		menuSup.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				try {
					(new AddSupplierView()).view(st);
				} catch(Exception ex){
					System.err.println("AddSupplierView not found!");
				}
			}
		});
				
		menuPerf.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				/*try {
							(new AddSupplierView()).view(st);
						}
						catch (Exception e1){
							System.err.println("AddSupplierView not found!");
						}*/
			}
		});
				
		menuStat.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
						/*try {
							(new AddSupplierView()).view(st);
						}
						catch (Exception e1){
							System.err.println("AddSupplierView not found!");
						}*/
			}
		});
				
		// BorderPane contains GridPane3
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		bp.setCenter(gp3);
		
		// Button actions
		addbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RWSupplier rws = new RWSupplier();
				
				String phonePattern = "\\(\\d{3}\\)\\d{9}";
				
				String name = nameInput.getText();
				String surname = surnameInput.getText();
				String email = emailInput.getText();
				String phone = phoneInput.getText();
				String address = addressInput.getText();
				
				if(!phoneInput.getText().matches(phonePattern)) {
					Alert alert = new Alert(AlertType.ERROR, "Wrong Phone Input Format!", ButtonType.OK);
	    			alert.show();	
				} else {	
					rws.addSuppliers(new Supplier(name, surname, email, phone, address));
					data = getSupplier();
					table.setItems(data);
    					
					Alert alert = new Alert(AlertType.CONFIRMATION, "Supplier added successfully!", ButtonType.OK);
					alert.show();	
    			
					nameInput.clear(); surnameInput.clear(); emailInput.clear();
					phoneInput.clear(); addressInput.clear();
				}
			}
		});
		
		deletebt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				Supplier s = (Supplier)table.getSelectionModel().getSelectedItems().get(0);
 				RWSupplier rws = new RWSupplier();
 				// error if not selected
 				Supplier ctg = (Supplier) rws.getSupplierByID(s.getId());
 				rws.deleteSuppliers(ctg);
 				
 				data = getSupplier();
 				table.setItems(data);
 				
 				
    			Alert alert = new Alert(AlertType.CONFIRMATION, "Supplier deleted successfully!", ButtonType.OK);
    			alert.show();
 			}
 		});
		
		backbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				(new EconomistView()).view(st);
			}
		});
        
		// Set scene
		Scene scene = new Scene(bp, 1400, 600);
		st.setScene(scene);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Suppliers List");
		st.show();

		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
			
	public ObservableList<Supplier> getSupplier() {
		RWSupplier rws = new RWSupplier();
		Object[] list = rws.getSuppliers().toArray();
		Text[] arr = new Text[list.length];
		
		for(int i = 0; i < list.length; i++)
			arr[i] = new Text("ID: " + ((Supplier)list[i]).getId() + " -> " + ((Supplier)list[i]).getName() + list[i].toString());
	
		ObservableList data = FXCollections.observableArrayList(list);

		return data;
	}
}

