package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;
import java.io.File;
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
 * 
 * @author 
 *
 */
public class MainSceneController {
	private final String FILE_NAME = "res/toys.txt"; //
	
	ArrayList<Toy> toys; //
	
	Scanner UserInput; //
	
	@FXML
	ObservableList<String> categoriesList = FXCollections.observableArrayList("Animal", "Board Game", "Figure", "Puzzle"); //
	
	String sn; //
	
	String name; //
	 
	String brand; //
	
	double price; //
	
	int available_count; //
	
	int age_appropriate; //

	
	@FXML
	private RadioButton radioSn; //
	@FXML
	private RadioButton radioName; //
	@FXML
	private RadioButton radioType; //
	@FXML
	private Label lblSn; //
	@FXML
	private TextField txtSn; //
	@FXML
	private TextField txtName; //
	@FXML
	private TextField txtType; //
	@FXML
	private Label lblName; //
	@FXML
	private Label lblType; //
	@FXML
	private Button btnSearch; //
	@FXML
	private Button btnClear; //
	@FXML
	private Button btnBuy; //
	@FXML
	private ListView<Toy> listView; //
	@FXML
	private TextField txtSnAdd; //
	@FXML
	private TextField txtNameAdd; //
	@FXML
	private TextField txtBrand; //
	@FXML
	private TextField txtAgeAppropriate; //
	@FXML
	private TextField txtAvailableCount; //
	@FXML
	private TextField txtPrice; //
	@FXML
	private Button btnSave; //
	@FXML
	private TextField txtClassification; //
	@FXML
	private TextField txtPuzType; //
	@FXML
	private TextField txtMaterial; //
	@FXML
	private TextField txtSize; //
	@FXML
	private TextField txtMinNumOfPlayers; //
	@FXML
	private TextField txtMaxNumOfPlayers; //
	@FXML
	private TextField txtDesigners; //
	@FXML
	private ChoiceBox<String> categoryBox; //
	@FXML
	private TextField txtSnRemove; //
	@FXML
	private Button btnRemove; //
	
	/**
	 * 
	 * @throws Exception
	 */
	public MainSceneController() throws Exception {
		toys = new ArrayList<>();
		loadData();
	}
	
	@FXML
	//
	public void initialize() {
		ObservableList<Toy> strList = FXCollections.observableArrayList(toys);
		listView = new ListView<>(strList);
		categoryBox.setItems(categoriesList);
		ToggleGroup radioGroup = new ToggleGroup();
		radioSn.setToggleGroup(radioGroup);
		radioName.setToggleGroup(radioGroup);
		radioType.setToggleGroup(radioGroup);
	}


	// Event Listener on RadioButton[#radioSn].onAction
	@FXML
	public void radioSelectSn(ActionEvent event) {
		if (radioSn.isSelected()) {
			lblSn.setStyle("-fx-text-fill: red;");
		}
	}
	
	// Event Listener on RadioButton[#radioName].onAction
	@FXML
	public void radioSelectName(ActionEvent event) {
		if (radioName.isSelected()) {
			lblName.setStyle("-fx-text-fill: red;");
		}
	}
	
	// Event Listener on RadioButton[#radioType].onAction
	@FXML
	public void radioSelectType(ActionEvent event) {
		if (radioType.isSelected()) {
			lblType.setStyle("-fx-text-fill: red;");
		}
	}
	
	// Event Listener on Button[#btnSearch].onAction
	@FXML
	public void ClickSearch(ActionEvent event) {
		Toy t = (Toy) listView.getSelectionModel().getSelectedItem();
		for (Toy temp: toys) {
			if (temp.getSn() == t.getSn()) {
				// view list
			} else if (temp.getName() == t.getName()) {
				// view list
			} 
		}
	}
	
	// Event Listener on Button[#btnClear].onAction
	@FXML
	public void ClickClear(ActionEvent event) {
		listView.getItems().clear();
	}
	
	// Event Listener on Button[#btnBuy].onAction
	@FXML
	public void ClickBuy(ActionEvent event) throws Exception {
			Toy t = (Toy) listView.getSelectionModel().getSelectedItem();
			for (Toy temp: toys) {
				if (temp.getSn() == t.getSn()) {
				int newCount = t.getAvailableCount();
				newCount -= 1;
				t.setAvailableCount(newCount);
				save();
				break;
			}
		} 
	}
	
	// Event Listener on Button[#btnSave].onAction
	@FXML
	public void ClickSave(ActionEvent event) throws IOException {
		sn = txtSn.getText();
		addCommonAttributes();
		if (categoryBox.getValue().equals("Animal")) {
			String material = txtMaterial.getText();
			char size = txtSize.getText().charAt(0);
			Toy animals=new Animal(sn,name,brand,price,available_count,age_appropriate,material,size);
			((Animal) animals).format();
			toys.add(animals);
			save();
		}
		
		if (categoryBox.getValue().equals("Board Game")) {
			int minNumOfPlayers = Integer.parseInt(txtMinNumOfPlayers.getText());
			int maxNumOfPlayers = Integer.parseInt(txtMaxNumOfPlayers.getText());
			String numOfPlayers="" + minNumOfPlayers + "-" +maxNumOfPlayers;
			String designer = txtDesigners.getText();
			Toy boardgames=new BoardGame(sn,name,brand,price,available_count,age_appropriate,numOfPlayers,designer);
			((BoardGame) boardgames).format();
			toys.add(boardgames);
			save();
			
		}
		
		if (categoryBox.getValue().equals("Figure")) {
			char classification = txtClassification.getText().charAt(0);
			Toy figures=new Figure(sn,name,brand,price,available_count,age_appropriate,classification);
			((Figure) figures).format();
			toys.add(figures);
			save();
		}
		
		if (categoryBox.getValue().equals("Puzzle")) {
			char puzzleType = txtPuzType.getText().charAt(0);
			Toy puzzles=new Puzzle(sn,name,brand,price,available_count,age_appropriate,puzzleType);
			((Puzzle) puzzles).format();
			toys.add(puzzles);
			save();
		}
	}
	
	// Event Listener on Button[#btnRemove].onAction
	@FXML
	public void ClickRemove(ActionEvent event) throws IOException {
		sn = txtSnRemove.getText();
		
		Toy toy = null;
		
		for (Toy t : toys) {
			if (t.getSn().equals(sn)) {
				toy = t;
				toys.remove(toy);
				save();
			}
		}
	}
	
	/**
	 * 
	 */
	public void addCommonAttributes() {
		name = txtNameAdd.getText();
		brand = txtBrand.getText();
		price = Double.parseDouble(txtPrice.getText());
		available_count = Integer.parseInt(txtAvailableCount.getText());
		age_appropriate = Integer.parseInt(txtAgeAppropriate.getText());
	}
	
	/**
	 * 
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
	 * 
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