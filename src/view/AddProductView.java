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

import model.Date;
import model.Product;
import model.RW.RWProduct;

public class AddProductView {
	
	private TableView<Product> table = new TableView<Product>();
	private ObservableList<Product> data = FXCollections.observableArrayList();
	
	Label supplier = new Label("Supplier: "); TextField suppliertf = new TextField();
	Label price = new Label("     Price: "); TextField pricetf = new TextField();
	Label purchase = new Label("Purchase Date: "); TextField purchasetf = new TextField();
	Label expire = new Label("     Expire Date: "); TextField expiretf = new TextField();
	Label quantity = new Label("Quantity: "); TextField quantitytf = new TextField();
	
	public void view(Stage st) {
		// Table - Column 0
		TableColumn<Product, Integer> column0 = new TableColumn<>("ID");
		column0.setMinWidth(170);
		column0.setCellValueFactory(new PropertyValueFactory<>("id")); //gets values
		column0.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 1
		TableColumn<Product, String> column1 = new TableColumn<>("Name");
		column1.setMinWidth(170);
		column1.setCellValueFactory(new PropertyValueFactory<>("name")); //gets values
		column1.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 2
		TableColumn<Product, String> column2 = new TableColumn<>("Barcode");
		column2.setMinWidth(170);
		column2.setCellValueFactory(new PropertyValueFactory<>("barcode")); //gets values
		column2.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 3
		TableColumn<Product, String> column3 = new TableColumn<>("Category");
		column3.setMinWidth(170);
		column3.setCellValueFactory(new PropertyValueFactory<>("category")); //gets values
		column3.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 4
		TableColumn<Product, String> column4 = new TableColumn<>("Supplier");
		column4.setMinWidth(170);
		column4.setCellValueFactory(new PropertyValueFactory<>("supplier")); //gets values
		column4.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 5
		TableColumn<Product, Double> column5 = new TableColumn<>("Price");
		column5.setMinWidth(170);
		column5.setCellValueFactory(new PropertyValueFactory<>("price")); //gets values
		column5.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 6
		TableColumn<Product, Date> column6 = new TableColumn<>("Purchase Date");
		column6.setMinWidth(170);
		column6.setCellValueFactory(new PropertyValueFactory<>("purchase")); //gets values
		column6.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 7
		TableColumn<Product, Double> column7 = new TableColumn<>("Expire Date");
		column7.setMinWidth(170);
		column7.setCellValueFactory(new PropertyValueFactory<>("expire")); //gets values
		column7.setStyle( "-fx-alignment: CENTER;");
		// Table - Column 8
		TableColumn<Product, Integer> column8 = new TableColumn<>("Quantity");
		column8.setMinWidth(170);
		column8.setCellValueFactory(new PropertyValueFactory<>("quantity")); //gets values
		column8.setStyle( "-fx-alignment: CENTER;");
				
		// Add products to the table
		table.getColumns().addAll(column0, column1, column2, column3, column4, column5, column6, column7, column8);
		data = getProduct();
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
				
		// HBox2 below the table
		HBox hb2 = new HBox();
		hb2.setSpacing(10);
		hb2.setPadding(new Insets(5, 10, 30, 20));
		hb2.setAlignment(Pos.CENTER);
				
		TextField nameInput = new TextField(); // Name input field
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		TextField categoryInput = new TextField(); // Category input field
		categoryInput.setPromptText("Category");
		categoryInput.setMinWidth(100);
		TextField barcodeInput = new TextField(); // Barcode input field
		barcodeInput.setPromptText("Barcode");
		barcodeInput.setMinWidth(100);
		TextField supplierInput = new TextField(); // Supplier input field
		supplierInput.setPromptText("Supplier");
		supplierInput.setMinWidth(100);
		TextField priceInput = new TextField(); // Price input field
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(100);
		TextField purchaseInput = new TextField(); // Purchase input field
		purchaseInput.setPromptText("Purchase Date");
		purchaseInput.setMinWidth(100);
		TextField expireInput = new TextField(); // Expire input field
		expireInput.setPromptText("Expire Date");
		expireInput.setMinWidth(100);
		TextField quantityInput = new TextField(); // Quantity input field
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
		
		// Add and Delete buttons
		Button addbt = new Button("Add");
		Button deletebt = new Button("Delete");
		Button editbt = new Button("Edit");
		addbt.setStyle("-fx-background-color: #90EE90; "); // Color button green
		deletebt.setStyle("-fx-background-color: #FF6347; "); // Color button red
		editbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue

		// Add elements in HBox2
		hb2.getChildren().addAll(nameInput, barcodeInput, categoryInput, supplierInput, priceInput, purchaseInput, expireInput, quantityInput, addbt, editbt, deletebt);
		
		// HBox3 contains Back button
		HBox hb3 = new HBox();
		Button backbt = new Button("<< Back");
		Button alertbt = new Button("Alerts");
		backbt.setStyle("-fx-background-color: #87CEEB; "); // Color button blue
		alertbt.setStyle("-fx-background-color: #FFA500; "); // Color button blue
		hb3.getChildren().addAll(alertbt, backbt);
		hb3.setSpacing(10);
		hb3.setPadding(new Insets(0, 10, 30, 20));
		hb3.setAlignment(Pos.TOP_LEFT);
			
		// GridPane2 contains HBox3
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
					(new xxView()).view(st);
				}
				catch (Exception e1){
					System.err.println("xxView not found!");
				}*/
			}
		});
		
		menuStat.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				/*try {
					(new xxView()).view(st);
				}
				catch (Exception e1){
					System.err.println("xxView not found!");
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
				RWProduct rwp = new RWProduct();
				
				String barcodePattern = "^[0-9]+$";
				String pricePattern = "^[0-9]+$";
				String quantityPattern = "^[0-9]+$";
			
				String name = nameInput.getText();
				String supplier = supplierInput.getText();
				String category = categoryInput.getText();
				String barcode = barcodeInput.getText();
				String price = priceInput.getText();
				String quantity = quantityInput.getText();
				Date purchase = new Date(purchaseInput.getText()); 
				Date expire = new Date(expireInput.getText()); 
	
				if(!barcodeInput.getText().matches(barcodePattern)) {
					Alert alert = new Alert(AlertType.ERROR, "Wrong Barcode Input Format!", ButtonType.OK);
	    			alert.show();	
				} else if(!priceInput.getText().matches(pricePattern)) {
					Alert alert = new Alert(AlertType.ERROR, "Wrong Price Input Format!", ButtonType.OK);
	    			alert.show();	
				} else if(!quantityInput.getText().matches(quantityPattern)) {
					Alert alert = new Alert(AlertType.ERROR, "Wrong Quantity Input Format!", ButtonType.OK);
	    			alert.show();	
				} else {
					rwp.addProduct(new Product(name, barcode, category, supplier, purchase, expire, price, quantity));
					data = getProduct();
					table.setItems(data);
    					
					Alert alert = new Alert(AlertType.CONFIRMATION, "Product added successfully!", ButtonType.OK);
					alert.show();
    			
					nameInput.clear(); supplierInput.clear(); categoryInput.clear(); barcodeInput.clear();
					priceInput.clear(); quantityInput.clear(); purchaseInput.clear(); expireInput.clear();
				}
			}
		});

		editbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// GridPane contains Labels and TextFields
				GridPane gp = new GridPane();
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));

				// Add elements in GridPane
				gp.add(supplier, 0, 0); gp.add(suppliertf, 1, 0);
				gp.add(price, 2, 0); gp.add(pricetf, 3, 0);
				gp.add(purchase, 0, 1); gp.add(purchasetf, 1, 1);
				gp.add(expire, 2, 1); gp.add(expiretf, 3, 1);
				gp.add(quantity, 0, 2); gp.add(quantitytf, 1, 2);
				
				gp.setHgap(10);
				gp.setVgap(10);
				gp.setPadding(new Insets(30, 5, 30, 5));
			
				// Buttons in HBox
				HBox hb = new HBox();
				Button savebt = new Button("Save Changes");
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
	            newWindow.setTitle("Supermarket Software - Edit Product");
	            newWindow.setScene(secondScene);
	            Image ico = new Image("image/img.png");
	            newWindow.getIcons().add(ico);
	            newWindow.initModality(Modality.WINDOW_MODAL); // Specify modality
	            newWindow.initOwner(st); // Specify parent window
	            newWindow.show();
	            
	            savebt.setOnAction(new EventHandler<ActionEvent>() {
	    			@Override
	    			public void handle(ActionEvent event) {
	    				RWProduct rwp = new RWProduct();
	    				Product p = (Product)table.getSelectionModel().getSelectedItems().get(0);

	    				rwp.getProductByID(p.getId()).setSupplier(suppliertf.getText());
	    				rwp.getProductByID(p.getId()).setPrice(pricetf.getText());
	    				rwp.getProductByID(p.getId()).setPurchase(new Date(purchasetf.getText()));
	    				rwp.getProductByID(p.getId()).setExpire(new Date(expiretf.getText()));
	    				rwp.getProductByID(p.getId()).setQuantity(quantitytf.getText());

	    				rwp.update();	
	    				
	    				data = getProduct();
	    				table.setItems(data);
		    					
		    			Alert alert = new Alert(AlertType.CONFIRMATION, "Product edited successfully!", ButtonType.OK);
		    			alert.show();	
		    			
		    			suppliertf.clear(); pricetf.clear(); purchasetf.clear(); expiretf.clear(); quantitytf.clear();
		    			
		    			newWindow.close();
	    			}
	    		});
	            
	           cancelbt.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    		public void handle(ActionEvent event) {
	    			newWindow.close();
	    		}
	    	});
	    }});
	
		deletebt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				Product p = (Product)table.getSelectionModel().getSelectedItems().get(0);
 				RWProduct rwp = new RWProduct();
 				// error if not selected
 				Product prd = (Product) rwp.getProductByID(p.getId());
 				rwp.deleteProduct(prd);
 				
 				data = getProduct();
 				table.setItems(data);
 			}
 		});
		
		alertbt.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
 			public void handle(ActionEvent event) {
 				data = table.getItems();
				for(Product item: data) {
					if(Integer.parseInt(item.getQuantity()) < 5) {
						Alert alert = new Alert(AlertType.WARNING, "Supply market with " + item.getBarcode() + " item!", ButtonType.OK);
		    			alert.show();
					}
				}
 			}
 		});
		
		backbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				(new EconomistView()).view(st);
			}
		});
		
		// Set scene
		Scene scene = new Scene(bp, 1800, 900);
		st.setScene(scene);
		Image ico = new Image("image/img.png");
		st.getIcons().add(ico);
		st.setTitle("Supermarket Software - Add Product");
		st.show();

		// Set scene alignment CENTER
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    st.setX((screenBounds.getWidth() - st.getWidth()) / 2); 
	    st.setY((screenBounds.getHeight() - st.getHeight()) / 2);  
	}
			
	public ObservableList<Product> getProduct() {
		RWProduct rwp = new RWProduct();
		Object[] list = rwp.getProduct().toArray();
		Text[] arr = new Text[list.length];
		
		for(int i = 0; i < list.length; i++)
			arr[i] = new Text("ID: " + ((Product)list[i]).getId() + " -> " + ((Product)list[i]).getName() + list[i].toString());
	
		ObservableList data = FXCollections.observableArrayList(list);

		return data;
	}
}
