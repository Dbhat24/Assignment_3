package mru.tsc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ChoiceBox;

/**
 * controller class that includes event listeners and other methods
 * @author Faizan and Raj
 *
 */
public class MainSceneController {
	private final String FILE_NAME = "res/toys.txt"; //
	
	ArrayList<Toy> toys; // arraylist of toy
	
	Scanner UserInput; // scanner object
	
	Scanner scan; // scanner object
	
	FileReader file; // file reader object
	
	BufferedReader input; // buffered reader object
	
	String sn; // toy serial number
	 
	String name; // toy name
	 
	String brand; // toy brand
	
	static protected double price; // price of toy
	
	int available_count; // amount of stock for toy
	
	int age_appropriate; // age rating for toy

	
	@FXML
	private RadioButton radioSn; // radiobutton for serial number
	@FXML
	private RadioButton radioName; // radiobutton for name
	@FXML
	private RadioButton radioType; // radiobutton for type
	@FXML
	private Label lblSn; // serial number label
	@FXML
	private TextField txtSn; // textfield serial number
	@FXML
	private TextField txtName; // textfield name
	@FXML
	private TextField txtType; // textfield type
	@FXML
	private Label lblName; // name label
	@FXML
	private Label lblType; // type label
	@FXML
	private Button btnSearch; // search button
	@FXML
	private Button btnClear; // clear button
	@FXML
	private Button btnBuy; // buy button
	@FXML
	private ListView<Toy> listView; // list view home tab
	@FXML
	private TextField txtSnAdd; // serial number add tab
	@FXML
	private TextField txtNameAdd; // name add tab
	@FXML
	private TextField txtBrand; // brand add tab
	@FXML
	private TextField txtAgeAppropriate; // age appropriate add tab
	@FXML
	private TextField txtAvailableCount; // available count add tab
	@FXML
	private TextField txtPrice; // price add tab
	@FXML
	private Button btnSave; // save button
	@FXML
	private TextField txtClassification; // classification add tab
	@FXML
	private TextField txtPuzType; // puzzle type add tab
	@FXML
	private TextField txtMaterial; // material add tab
	@FXML
	private TextField txtSize; // size add tab
	@FXML
	private TextField txtMinNumOfPlayers; // minimum number of players add tab
	@FXML
	private TextField txtMaxNumOfPlayers; // maximum number of players add tab
	@FXML
	private TextField txtDesigners; // designer(s) add tab
	@FXML
	private ChoiceBox<String> categoryBox; // category box containing types of toys
	@FXML
	private TextField txtSnRemove; // serial number remove tab
	@FXML
	private Button btnRemove; // remove button 

	@FXML
	private ListView<Toy> listView2; // list view remove tab
	@FXML
	private Button search2; // search button remove tab
	
	ToggleGroup radioGroup = new ToggleGroup(); // group radio buttons together
	
	/**
	 * constructor that creates new arraylist and loads data from text file
	 * @throws Exception
	 */
	public MainSceneController() throws Exception {
		toys = new ArrayList<>();
		loadData();
	}
	
	@FXML
	/**
	 * Initialize method that creates categories for category box and items in toggle group
	 */
	public void initialize() {
		ObservableList<String> toyTypes = FXCollections.observableArrayList("Animal", "Board Game", "Figure", "Puzzle"); // categories for categorybox
		categoryBox.setItems(toyTypes);
		radioSn.setToggleGroup(radioGroup);
		radioName.setToggleGroup(radioGroup);
		radioType.setToggleGroup(radioGroup);
	}


	// Event Listener on RadioButton[#radioSn].onAction
	@FXML
	public void radioSelectSn(ActionEvent event) {
		if (radioSn.isSelected()) {
			lblSn.setStyle("-fx-text-fill: red;");
			lblName.setStyle("-fx-text-fill: black;");
			lblType.setStyle("-fx-text-fill: black;");
			txtType.setEditable(false);
			txtName.setEditable(false);
			txtSn.setEditable(true);
		}
	}
	
	// Event Listener on RadioButton[#radioName].onAction
	@FXML
	public void radioSelectName(ActionEvent event) {
		if (radioName.isSelected()) {
			lblName.setStyle("-fx-text-fill: red;");
			lblType.setStyle("-fx-text-fill: black;");
			lblSn.setStyle("-fx-text-fill: black;");
			txtSn.setEditable(false);
			txtType.setEditable(false);
			txtName.setEditable(true);
		}
	}
	
	// Event Listener on RadioButton[#radioType].onAction
	@FXML
	public void radioSelectType(ActionEvent event) {
		if (radioType.isSelected()) {
			lblType.setStyle("-fx-text-fill: red;");
			lblSn.setStyle("-fx-text-fill: black;");
			lblName.setStyle("-fx-text-fill: black;");
			txtName.setEditable(false);
			txtSn.setEditable(false);
			txtType.setEditable(true);
		}
	}
	
	// Event Listener on Button[#btnSearch].onAction
	@FXML
	public void ClickSearch(ActionEvent event) throws Exception {
		for (Toy t : toys) {
			if (radioSn.isSelected()) {
				if (txtSn.getText().contains(t.getSn())) {
					sn = txtSn.getText();
					t.setSn(sn);
					ObservableList<Toy> strList = FXCollections.observableArrayList(t);
					listView.setItems(strList);
				}
			}
		}
		
		for (Toy t : toys) {
			if (radioName.isSelected()) {
				if (txtName.getText().contains(t.getName())) {
					name = txtName.getText();
					t.setName(name);
					ObservableList<Toy> strList = FXCollections.observableArrayList(t);
					listView.setItems(strList);
				}
			}
		}
		
		if (radioType.isSelected()) {
		
		// file object
		File db = new File(FILE_NAME);
		// scanner object
		UserInput = new Scanner(System.in);
		
		// variable to store category type
		String toyType = txtType.getText();

		// used to read string
		String valueString;
		// each value contains different information about toy
		String[] value;
		
		if(toyType.equalsIgnoreCase("Figure")) {
			if (db.exists()) {
				Scanner fileReader = new Scanner(db);
				while (fileReader.hasNextLine()) {
					valueString = fileReader.nextLine();
					value = valueString.split(";");
					char figur = value[0].charAt(0);
					if (figur == '0' || figur == '1') {
						String sn=value[0];
						String name=value[1];
						String brand=value[2];
						double price=Double.parseDouble(value[3]);
						int availCount=Integer.parseInt(value[4]);
						int age=Integer.parseInt(value[5]);
						char classification=value[6].charAt(0);
						Toy figure=new Figure(sn,name,brand,price,availCount,age,classification);
						figure.toString();
						ObservableList<Toy> strList = FXCollections.observableArrayList(figure);
						listView.setItems(strList);
					}
				}
			}
		}
		
		if(toyType.equalsIgnoreCase("Animal")) {
			if (db.exists()) {
				Scanner fileReader = new Scanner(db);
				while (fileReader.hasNextLine()) {
					valueString = fileReader.nextLine();
					value = valueString.split(";");
					char anima = value[0].charAt(0);
					if (anima == '2' || anima == '3') {
						String sn=value[0];
						String name=value[1];
						String brand=value[2];
						double price=Double.parseDouble(value[3]);
						int availCount=Integer.parseInt(value[4]);
						int age=Integer.parseInt(value[5]);
						String material=value[6];
						char size=value[7].charAt(0);
						Toy animal=new Animal(sn,name,brand,price,availCount,age,material,size);
						animal.toString();
						ObservableList<Toy> strList = FXCollections.observableArrayList(animal);
						listView.setItems(strList);
					}
				}
			}
		}
		
		if(toyType.equalsIgnoreCase("Puzzle")) {
			if (db.exists()) {
				Scanner fileReader = new Scanner(db);
				while (fileReader.hasNextLine()) {
					valueString = fileReader.nextLine();
					value = valueString.split(";");
					char puzzl = value[0].charAt(0);
					if (puzzl == '4' || puzzl == '5' || puzzl == '6') {
						String sn=value[0];
						String name=value[1];
						String brand=value[2];
						double price=Double.parseDouble(value[3]);
						int availCount=Integer.parseInt(value[4]);
						int age=Integer.parseInt(value[5]);
						char puzzleType=value[6].charAt(0);
						Toy puzzle = new  Puzzle(sn,name,brand,price,availCount,age,puzzleType);
						puzzle.toString();
						ObservableList<Toy> strList = FXCollections.observableArrayList(puzzle);
						listView.setItems(strList);
					}
				}
			}
		}
		
		if(toyType.equalsIgnoreCase("Board Game")) {
			if (db.exists()) {
				Scanner fileReader = new Scanner(db);
				while (fileReader.hasNextLine()) {
					valueString = fileReader.nextLine();
					value = valueString.split(";");
					char boardGam = value[0].charAt(0);
					if (boardGam == '7' || boardGam == '8' || boardGam == '9') {
						String sn=value[0];
						String name=value[1];
						String brand=value[2];
						double price=Double.parseDouble(value[3]);
						int availCount=Integer.parseInt(value[4]);
						int age=Integer.parseInt(value[5]);
						String numPlayers=value[6];
						String designer=value[7];
						Toy boardgame=new BoardGame(sn,name,brand,price,availCount,age,numPlayers,designer);
						boardgame.toString();
						ObservableList<Toy> strList = FXCollections.observableArrayList(boardgame);
						listView.setItems(strList);
					}
				}
			}
		}
	}
}
	// Event Listener on Button[#btnClear].onAction
	@FXML
	public void ClickClear(ActionEvent event) throws Exception {
		listView.getItems().clear();
		radioGroup.selectToggle(null);
		lblSn.setStyle("-fx-text-fill: black;");
		lblName.setStyle("-fx-text-fill: black;");
		lblType.setStyle("-fx-text-fill: black;");
		txtSn.clear();
		txtName.clear();
		txtType.clear();
	}
	
	// Event Listener on Button[#btnBuy].onAction
	@FXML
	public void ClickBuy(ActionEvent event) throws Exception {
			Toy t = (Toy) listView.getSelectionModel().getSelectedItem();
			for (Toy to: toys) {
				if (to.getSn() == t.getSn()) {
				int newAvailableCount = t.getAvailableCount();
				newAvailableCount -= 1;
				t.setAvailableCount(newAvailableCount);
				save();
				break;
			}
		} 
	}
	
	// Event Listener on Button[#btnSave].onAction
	@FXML
	public void ClickSave(ActionEvent event) throws Exception {
		UserInput = new Scanner(System.in);
		sn = txtSnAdd.getText();
		
		addCommonAttributes();
		
		if (categoryBox.getValue().equals("Animal")) {
			String material = txtMaterial.getText();
			
			char size = txtSize.getText().charAt(0);
			
			Toy animals=new Animal(sn,name,brand,price,available_count,age_appropriate,material,size);
			((Animal) animals).format();
			toys.add(animals);
		}
		
		if (categoryBox.getValue().equals("Board Game")) {
			int minNumOfPlayers = Integer.parseInt(txtMinNumOfPlayers.getText());
			int maxNumOfPlayers = Integer.parseInt(txtMaxNumOfPlayers.getText());
			
			String numOfPlayers="" + minNumOfPlayers + "-" +maxNumOfPlayers;
			String designer = txtDesigners.getText();
			
			Toy boardgames=new BoardGame(sn,name,brand,price,available_count,age_appropriate,numOfPlayers,designer);
			((BoardGame) boardgames).format();
			toys.add(boardgames);
		}
		
		if (categoryBox.getValue().equals("Figure")) {
		char classification = txtClassification.getText().charAt(0);
			Toy figures=new Figure(sn,name,brand,price,available_count,age_appropriate,classification);
			((Figure) figures).format();
			toys.add(figures);
		}
		
		if (categoryBox.getValue().equals("Puzzle")) {
			char puzzleType = txtPuzType.getText().charAt(0);
			
			Toy puzzles=new Puzzle(sn,name,brand,price,available_count,age_appropriate,puzzleType);
			((Puzzle) puzzles).format();
			toys.add(puzzles);
		}
		save();
	}
	
	// Event Listener on Button[#search2].onAction
	@FXML
	public void ClickSearch2(ActionEvent event) {
		for (Toy t : toys) {
			if (txtSnRemove.getText().contains(t.getSn())) {
				sn = txtSnRemove.getText();
				t.setSn(sn);
				ObservableList<Toy> strList = FXCollections.observableArrayList(t);
				listView2.setItems(strList);
			}
		}
	}
	
	// Event Listener on Button[#btnRemove].onAction
	@FXML
	public void ClickRemove(ActionEvent event) throws Exception {
		Toy t = (Toy) listView2.getSelectionModel().getSelectedItem();
		for (Toy to: toys) {
			if(to.getSn() == t.getSn()) {
				to = t;
				toys.remove(to);
				save();
			}
		}
	}
	
	/**
	 * groups all common attributes
	 */
	public void addCommonAttributes() {
		name = txtNameAdd.getText();
		brand = txtBrand.getText();
		price = Double.parseDouble(txtPrice.getText());
		available_count = Integer.parseInt(txtAvailableCount.getText());
		age_appropriate = Integer.parseInt(txtAgeAppropriate.getText());
	}
	
	/**
	 * load data method that loads the data from the text file
	 * @throws IOException
	 */
	public void loadData() throws IOException {
		File db = new File(FILE_NAME); 
		String currentLine;
		String [] splittedLine;
		
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				
				char id = splittedLine[0].charAt(0);
				
				if (id == '0' || id == '1') {
					String sn = splittedLine[0];
					String name = splittedLine[1];
					String brand = splittedLine[2];
					double price = Double.parseDouble(splittedLine[3]);
					int avlCount = Integer.parseInt(splittedLine[4]);
					int ageApp = Integer.parseInt(splittedLine[5].split("[;:-]")[0]);	
					char classification = splittedLine[6].charAt(0);
					Figure f = new Figure(sn,name,brand,price,avlCount,ageApp,classification);
					f.toString();
					toys.add(f);
					
				}
				if (id =='2'||id =='3') {
					String sn = splittedLine[0];
					String name = splittedLine[1];
					String brand = splittedLine[2];
					double price = Double.parseDouble(splittedLine[3]);
					int avlCount = Integer.parseInt(splittedLine[4]);
					int ageApp = Integer.parseInt(splittedLine[5].split("[;:-]")[0]);		
					String material = splittedLine[6];
					char size = splittedLine[7].charAt(0);
					Animal a = new Animal(sn,name,brand,price,avlCount,ageApp,material,size);
					a.toString();
					toys.add(a);
					
				}
				if (id == '4' || id == '5' || id == '6') {
					String sn = splittedLine[0];
					String name = splittedLine[1];
					String brand = splittedLine[2];
					double price = Double.parseDouble(splittedLine[3]);
					int avlCount = Integer.parseInt(splittedLine[4]);
					int ageApp = Integer.parseInt(splittedLine[5].split("[;:-]")[0]);	
					char puzType = splittedLine[6].charAt(0);
					Puzzle p = new Puzzle(sn,name,brand,price,avlCount,ageApp,puzType);
					p.toString();
					toys.add(p);
			
				}
				if (id == '7' || id == '8' || id == '9' ) {
					String sn = splittedLine[0];
					String name = splittedLine[1];
					String brand = splittedLine[2];
					double price = Double.parseDouble(splittedLine[3]);
					int avlCount = Integer.parseInt(splittedLine[4]);
					int ageApp = Integer.parseInt(splittedLine[5].split("[;:-]")[0]);	
					String numPlayers = splittedLine[6];
					String designer = splittedLine[7].split("[;:-]")[0];
					BoardGame bg = new BoardGame(sn,name,brand,price,avlCount,ageApp,numPlayers,designer);
					bg.toString(); 
					toys.add(bg);
				} 
			}
			fileReader.close();
		}
	}
	
	/**
	 * save method that saves data into text file
	 * @throws IOException
	 */
	public void save() throws IOException {
		File db = new File(FILE_NAME);
		PrintWriter pw = new PrintWriter(db);
		
		System.out.println("Saving Data Into Database...");
		System.out.println("\n********** THANKS FOR VISITING US! **********");
		
		for (Toy t : toys) {
			pw.println(t.format());
		}
		pw.close();
	}
}