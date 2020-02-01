/* 
 * CEN 215 - Object Oriented Programming - Supermarket Software project
 * Fall 2019 - Computer Engineering - Epoka University
 * 
 * Created by Anila - January 2020
 * 
 * */

package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import model.Bill;
import model.Product;
import model.RW.RWBill;
import model.RW.RWProduct;

public class CashierView {
	
	ObservableList<Product> pr = FXCollections.observableArrayList();

	public void view(Stage st) {
		// Table 
		TableView<Product> table = new TableView<>();
		// Table - Column 0
		TableColumn<Product, String> column0 = new TableColumn<>("Barcode");
		column0.setMinWidth(200);
		column0.setStyle( "-fx-alignment: CENTER;");
		column0.setCellValueFactory(new PropertyValueFactory<>("barcode")); //gets values
		// Table - Column 1
		TableColumn<Product, String> column1 = new TableColumn<>("Name");
		column1.setMinWidth(200);
		column1.setStyle( "-fx-alignment: CENTER;");
		column1.setCellValueFactory(new PropertyValueFactory<>("name")); //gets values
		// Table - Column 2
		TableColumn<Product, Double> column2 = new TableColumn<>("Price");
		column2.setMinWidth(200);
		column2.setStyle( "-fx-alignment: CENTER;");
		column2.setCellValueFactory(new PropertyValueFactory<>("price")); //gets values
		// Table - Column 3
		TableColumn<Product, Integer> column3 = new TableColumn<>("Quantity");
		column3.setMinWidth(200);
		column3.setStyle( "-fx-alignment: CENTER;");
		column3.setCellValueFactory(new PropertyValueFactory<>("quantity")); //gets values
		// Add to table
		table.getColumns().addAll(column0, column1, column2, column3);
			
		// VBox1 contains the table
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.TOP_LEFT);
		vb1.setPadding(new Insets(30, 10, 30, 20));
		vb1.setMinWidth(632);
		vb1.setSpacing(10);
		vb1.getChildren().addAll(table);
				
		// GridPane2 contains Labels and TextFields
		GridPane gp2 = new GridPane();
		gp2.setHgap(10);
		gp2.setVgap(10);
		gp2.setPadding(new Insets(30, 5, 30, 5));
			
		// GridPane2 - Column 1
		Label amount = new Label("Amount: "); 
		TextField amounttf = new TextField();
		amounttf.setEditable(false);

		// GridPane2 - Column 2
		Label tax = new Label("     Tax: ");
		TextField taxtf = new TextField();
		taxtf.setEditable(false);
		Label total = new Label("     Total: ");
		TextField totaltf = new TextField();
		total.setStyle("-fx-font-weight: bold; ");
		totaltf.setEditable(false);
				
		// Add elements in GridPane2
		gp2.add(amount, 0, 0); gp2.add(amounttf, 1, 0);
		gp2.add(tax, 2, 0); gp2.add(taxtf, 3, 0);
		gp2.add(total, 2, 2); gp2.add(totaltf, 3, 2);
				
		// GridPane2 alignment
		gp2.setAlignment(Pos.TOP_RIGHT);
		amount.setAlignment(Pos.BOTTOM_RIGHT); amounttf.setAlignment(Pos.BOTTOM_LEFT);
		tax.setAlignment(Pos.BOTTOM_RIGHT); taxtf.setAlignment(Pos.BOTTOM_LEFT);
			
		// HBox4 contains Total Label and TextField
		HBox hb4 = new HBox();
		hb4.setAlignment(Pos.TOP_CENTER);
		hb4.setPadding(new Insets(1, 10, 20, 10));
		hb4.getChildren().addAll(total, totaltf);
				
		// HBox1 contains buttons
		HBox hb1 = new HBox();
		Button totalbt = new Button("Total");
		Button printbt = new Button("Print");
		Button resetbt = new Button("Reset");
		totalbt.setStyle("-fx-background-color: #90EE90; "); // Color button green
		printbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		resetbt.setStyle("-fx-background-color: #FF6347; "); // Color button red
				
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		hb1.setPadding(new Insets(10, 10, 10, 10));
		hb1.getChildren().addAll(totalbt, printbt, resetbt);
				
		// VBox2 contains Gridpane2, HBox4, and HBox1
		VBox vb2 = new VBox();
		vb2.getChildren().addAll(gp2, hb4, hb1);
		vb2.setAlignment(Pos.TOP_RIGHT);
		vb2.setPadding(new Insets(120, 10, 10, 10));
				
		// HBox2 below the table
		HBox hb2 = new HBox();
		hb2.setSpacing(10);
		hb2.setPadding(new Insets(5, 10, 30, 20));
				
		TextField barcodeInput = new TextField(); // Barcode input field
		barcodeInput.setPromptText("Barcode");
		barcodeInput.setMinWidth(100);
		TextField quantityInput = new TextField(); // Quantity input field
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
				
		// Add and Delete buttons
		Button addbt = new Button("Add");
		Button deletebt = new Button("Delete");
		addbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		deletebt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		
		// Add elements in HBox2
		hb2.getChildren().addAll(barcodeInput, quantityInput, addbt, deletebt);
				
		// HBox3 contains Exit button
		HBox hb3 = new HBox();
		Button backbt = new Button("<< Back");
		hb3.getChildren().addAll(backbt);
		hb3.setPadding(new Insets(5, 10, 30, 20));
		backbt.setStyle("-fx-background-color: #FF6347; "); // Color button red
				
		// GridPane1 contains VBox1 and VBox2
		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		gp1.add(vb1, 0, 0);
		gp1.add(vb2, 1, 0);
				
		vb1.setAlignment(Pos.BOTTOM_LEFT);
		vb2.setAlignment(Pos.TOP_RIGHT);
		gp1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.BOTTOM_LEFT);
				
		// GridPane3 contains GridPane1, HBox2, and HBox3  
		GridPane gp3 = new GridPane();
		gp3.add(gp1, 0, 0);
		gp3.add(hb2, 0, 1);
		gp3.add(hb3, 0, 2);
		gp3.setAlignment(Pos.CENTER);
				
		// StackPane contains GridPane3
		StackPane sp = new StackPane();
		sp.getChildren().addAll(gp3);
		
		// Button actions
		addbt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				RWProduct rwp = new RWProduct();
 				if(rwp.getProductByBarcode(barcodeInput.getText()) == null) {
 					Alert alert = new Alert(AlertType.ERROR, "Product does not exist!", ButtonType.OK);
 	    			alert.show();
 				} else { 
 					//RWProduct.changeQuantityByBarcode(String.valueOf(barcodeInput), Integer.parseInt(quantityInput.getText()));
 					pr.add(rwp.getProductByBarcode(barcodeInput.getText()));
 					ObservableList<Product> products = FXCollections.observableArrayList(pr);
 					
 					table.setItems(products);
 					barcodeInput.clear(); quantityInput.clear();
 				}
 			}
 		});
		
		deletebt.setOnAction(new EventHandler<ActionEvent>() {
	 		@Override
	 		public void handle(ActionEvent event) {
	 			table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
	 				
	 			Alert alert = new Alert(AlertType.CONFIRMATION, "Product deleted successfully!", ButtonType.OK);
	    		alert.show();
	 		}
	 	});
		
		totalbt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				pr = table.getItems();
 				double amount = 0; 
 				for(Product item: pr) {
 					double price = 0;
 					price += Double.parseDouble(item.getPrice());
 					amount += price * Integer.parseInt(item.getQuantity());
 				}
 				amounttf.setText(String.valueOf(amount));
 				double tax = (amount * 15) / 100;
 				taxtf.setText(String.valueOf(tax));
 				double total = amount + tax;
 				totaltf.setText(String.valueOf(total));
 			}
		});

		
		printbt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				//RWBill rwb = new RWBill();
				Bill.writeBill(Bill.getNrBills(), pr, Double.parseDouble(totaltf.getText()));
 			}
		});
 				
		resetbt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				amounttf.clear(); taxtf.clear(); totaltf.clear();
 				
	 			table.getItems().clear();
 			}
 		});
		
		backbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					(new LoginView()).start(st);
				} catch (Exception e) {
					System.err.println("LoginView not found!");
				}
			}
		});
	
		Scene scene = new Scene(sp, 1500, 600);
		st.setScene(scene);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Cashier");
		st.show();

		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}

	/*public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList(pr);
	
		return products;
	}*/		
}
