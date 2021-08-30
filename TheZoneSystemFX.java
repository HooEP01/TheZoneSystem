/*
Name	: Hoo Ern Ping
ID		: B200152B
*/
package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class TheZoneSystemFX extends Application{
	//-----------------ArrayList---------------------
	ManageCustomer arrayList = new ManageCustomer();
	
	//-----------------UI control--------------------
	Button 	  pBtn = new Button("Premium"),
			  rBtn = new Button("Regular"),
			  dBtn = new Button("Delete"),
			  fBtn = new Button("Find"),
			  pABtn = new Button("Print"),
			  eBtn = new Button("Exit");
	TextArea  taTable = new TextArea(),
			  taTable02 = new TextArea(),
			  taTable03 = new TextArea();
	TextField id = new TextField(),
			  name = new TextField(),
			  qty = new TextField(),
			  rId = new TextField(), // remove id
			  fId = new TextField(); // find id
	MenuBar   fMenuBar = new MenuBar(),  
	          sMenuBar = new MenuBar(), 
	          tMenuBar = new MenuBar();
	Scene     fScene, 
	          sScene, 
	          tScene;
	VBox      fVBox, 
	          sVBox, 
	          tVBox;
	ComboBox<String> shippingType = new ComboBox<String>();
	
	@Override
	public void start(Stage primaryStage) {
	
	//-------------------fSceneStart-------------------
	
	//-----GridPane
	GridPane gp1 = new GridPane();
	gp1.setHgap(5);
	gp1.setVgap(5);
	gp1.setPadding(new Insets(20,20,20,20));
	
	//-----ComboBoxItems
	shippingType.getItems().add("Truck");
	shippingType.getItems().add("Rail");
	shippingType.getItems().add("Ship");
	shippingType.getItems().add("Customer Arranges Shipping");
	
	shippingType.setValue("Truck");
	
	//------GridPaneAdd
	gp1.add(new Label("Customer ID: "), 0, 0);
	gp1.add(id,1,0);
	gp1.add(new Label("Customer Name: "), 0, 1);
	gp1.add(name,1,1);
	gp1.add(new Label("Product Quantity: "), 0, 2);
	gp1.add(qty,1,2);
	gp1.add(new Label("Shipping Method: "), 0, 3);
	gp1.add(shippingType,1,3);
	gp1.add(pBtn, 0, 4);
	gp1.add(rBtn, 1, 4);
	
	//-----KeyPressEventHandling
	name.setOnKeyPressed(e -> {
		if(!(e.getCode().isLetterKey()) && !(e.getCode()==KeyCode.BACK_SPACE) && 
		!(e.getCode()==KeyCode.ENTER) && !(e.getCode()==KeyCode.LEFT) &&
		!(e.getCode()==KeyCode.RIGHT) && !(e.getCode()==KeyCode.SPACE) &&
		!(e.getCode()==KeyCode.CAPS)){
			Error("Error in Customer Name","Enter letter only");
			name.setText("");
		}
	});
	
	//-----GridPanePosition
	gp1.setAlignment(Pos.CENTER);
	id.setAlignment(Pos.BOTTOM_RIGHT);
	name.setAlignment(Pos.BOTTOM_RIGHT);
	qty.setAlignment(Pos.BOTTOM_RIGHT);
	
	//-----EventHandling
	pBtn.setOnAction(e -> Add("P"));
	rBtn.setOnAction(e -> Add("R"));
	
	//-----TextArea
	taTable.setPrefSize(400,400);
	taTable.setEditable(false);
	
	//-----ScrollPane
	ScrollPane sp = new ScrollPane(taTable);
	sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	
	//-----VBox
	fVBox = new VBox();
	fVBox.getChildren().addAll(menuBar(fMenuBar,primaryStage),gp1,sp);
	
	//-----Scene
	fScene = new Scene(fVBox,400,500);
	//-----fSceneEnd------------------------------------
	
	//-----sSceneStart----------------------------------
	
	//-----MenuBar
	sMenuBar = new MenuBar();
	
	//-----GridPane
	GridPane gp2 = new GridPane();
	gp2.setHgap(5);
	gp2.setVgap(5);
	gp2.setPadding(new Insets(20,20,20,20));
	
	//------GridPaneAdd
	gp2.add(new Label("Customer ID: "), 0, 0);
	gp2.add(fId,1,0);
	gp2.add(fBtn, 0, 1);
	gp2.add(dBtn, 1, 1);
	
	//-----GridPanePosition
	gp2.setAlignment(Pos.CENTER);
	fId.setAlignment(Pos.BOTTOM_RIGHT);
		
	//-----EventHandling
	fBtn.setOnAction(e -> Search());
	dBtn.setOnAction(e -> Delete());

	//-----TextArea
	taTable02.setPrefSize(400,400);
	taTable02.setEditable(false);
	
	//-----ScrollPane
	ScrollPane sp2 = new ScrollPane(taTable02);
	sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	
	//-----VBox
	sVBox = new VBox();
	sVBox.getChildren().addAll(menuBar(sMenuBar,primaryStage),gp2,sp2);
	
	//-----Scene
	sScene = new Scene(sVBox,400,500);
	//-----sSceneEnd-------------------------------------
	
	//-----tSceneStart-----------------------------------
	
	//-----MenuBar
	tMenuBar = new MenuBar();
	
	//-----GridPane
	GridPane gp3 = new GridPane();
	gp3.setHgap(5);
	gp3.setVgap(5);
	gp3.setPadding(new Insets(20,20,20,20));
	
	//-----GridPaneAdd
	gp3.add(pABtn, 0, 0);
	
	//-----EventHandling
	pABtn.setOnAction(e -> Print());
	
	//-----TextArea
	taTable03.setPrefSize(400,400);
	taTable03.setMaxSize(400, 10000);
	taTable03.setEditable(false);
		
	//-----ScrollPane
	ScrollPane sp3 = new ScrollPane(taTable03);
	sp3.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	sp3.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	
	//-----VBox
	tVBox = new VBox();
	tVBox.getChildren().addAll(menuBar(tMenuBar,primaryStage),gp3,sp3);
	
	//-----Scene
	tScene = new Scene(tVBox,400,500);
	
	//-----Stage-----------------------------------------
	primaryStage.setTitle("The Zone System");
	primaryStage.setScene(fScene);
	primaryStage.show();
	
	}
	
	public Node menuBar(MenuBar i, Stage j) {
		Menu addMenu = new Menu("ADD"),
			 deleteMenu = new Menu("DELETE"),
			 findMenu = new Menu("SEARCH"),
			 reportMenu = new Menu("REPORT"),
			 helpMenu = new Menu("EXIT");
					
		//Menu Item
		MenuItem exitItem = new MenuItem("Exit");
			
		//add Menu Items
		helpMenu.getItems().addAll(exitItem);
			
		//add Menu
		i.getMenus().addAll(addMenu, deleteMenu, findMenu, reportMenu, helpMenu);
				
		//switch scene
		addMenu.setOnAction(e -> j.setScene(fScene));
		deleteMenu.setOnAction(e -> j.setScene(fScene));
		findMenu.setOnAction(e -> j.setScene(sScene));
		reportMenu.setOnAction(e ->j.setScene(tScene));
		exitItem.setOnAction(e -> System.exit(0));
		return i;
		
	}
	
	
	public void Add(String e) {
		try {
			String print = ""; // print info to textArea
			String custId = id.getText();
			String custName = name.getText();
			int custQty = Integer.parseInt(qty.getText());
			String custShippingType = shippingType.getValue().toString();
			
			if(custId.length() < 5) {
				Error("Error in Customer ID","Enter atleast five characters.");
				Clear(1);
				
			}else if(custName.length() < 1) {
				Error("Error in Customer Name","Please enter your name.");
				Clear(2);

			}else if(custQty < 1) {
				Error("Error in Product Quantity","Enter atleast 1 quantity.");
				Clear(3);
				
			}else if(e.equals("P")) {
				print = arrayList.add(new Premium(custId,custName,custQty,custShippingType));
				taTable.setText(print);
				
			}else if(e.equals("R")) {
				print = arrayList.add(new Regular(custId,custName,custQty,custShippingType));
				taTable.setText(print);
				
			}else {
				//empty
			}
			
		}catch(NumberFormatException ex) {
			Error("Error in Product Quantity","Please enter integer number");
			Clear(3);
			
		}catch(Exception ex) {
			Error("Error","Error Occur");
			
		}
	}
	
	public void Print() {
		taTable03.setText(arrayList.toString());
	}
	
	public void Search() {
		String print = "";
		String custId = fId.getText();
		
		if(custId.length() < 5) {
			Error("Error in Customer ID","Enter atleast five characters.");
			Clear(4);
			
		}else {
			print = arrayList.search(custId);
			taTable02.setText(print);
			
		}
	}
	
	public void Delete() {
		String print = "";
		String custId = rId.getText();
		
		if(custId.length() < 5) {
			Error("Error in Customer ID","Enter atleast five characters.");
			Clear(5);
			
		}else {
			print = arrayList.remove(custId);
			taTable02.setText(print);
			
		}
	}
	
	public void Error(String e1, String e2) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(e1);
		alert.setHeaderText(null);
		alert.setContentText(e2);
		alert.show();
	}
	
	public void Clear(int option) {
		switch(option) {
			case 1: id.setText("");
					id.requestFocus();
					break;
			case 2:	name.setText("");
					name.requestFocus();
					break;
			case 3: qty.setText("");
					qty.requestFocus();
					break;
			case 4: rId.setText("");
					rId.requestFocus();
					break;
			case 5: fId.setText("");
					fId.requestFocus();
			default:
					break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

