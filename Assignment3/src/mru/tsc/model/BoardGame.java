package mru.tsc.model;

/**
 * Board Game class that extends Toy super class
 * Includes getters and setters with toString and format methods
 * @author Faizan and Raj
 */
public class BoardGame extends Toy {
	// designer variable
	private String designer;
	// number of players variable
	private String noOfPlayers;

	/**
	 * Constructor with appropriate variables
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count for toy
	 * @param age_appropriate toy rating
	 * @param noOfPlayers number of players
	 * @param designer toy designer(s) name(s)
	 */
	public BoardGame(String sn,String name,String brand,double price,int available_count,int age_appropriate,String noOfPlayers,String designer) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.designer=designer;
		this.noOfPlayers=noOfPlayers;
	}

	/**
	 * constructor with no parameters
	 */
	public BoardGame() {
		super();
	}

	/**
	 * getter for toy designer(s) variable
	 * @return toy designer(s)
	 */
	public String getDesigner() {
		return designer;
	}

	/**
	 * setter for toy designer(s) variable
	 * @param designer toy designer(s)
	 */
	public void setDesigner(String designer) {
		this.designer=designer;
	}

	/**
	 * Used to format board game
	 */
	@Override
	public String toString() {
		return "Category:" +"Board Game" + "," + " Serial Number:" + sn + "," + " Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" +age_appropriate + "," + " # of players:" + noOfPlayers + "," + " Designer:" + designer;
	}

	/**
	 * Used to format board game in text file
	 */
	@Override
	public String format() {
		String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+noOfPlayers+";"+designer);
		return s;
	}
}