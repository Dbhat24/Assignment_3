package mru.tsc.model;

/**
 * Puzzle class that extends Toy super class
 * Includes getters and setters with toString and format methods
 * @author Faizan and Raj
 */
public class Puzzle extends Toy {
	// puzzle type variable
	private char puzzleType;

	/**
	 * Constructor with appropriate variables
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count for toy
	 * @param age_appropriate toy rating
	 * @param puzzleType toy puzzle type
	 */
	public Puzzle(String sn,String name,String brand,double price,int available_count,int age_appropriate,char puzzleType) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.puzzleType=puzzleType;
	}

	/**
	 * constructor with no variables
	 */
	public Puzzle() {
		super();
	}

	/**
	 * getter for toy puzzleType variable
	 * @return toy puzzle type
	 */
	public char getPuzzleType() {
		return puzzleType;
	}

	/**
	 * setter for toy puzzleType variable
	 * @param puzzleType toy puzzle type
	 */
	public void setPuzzleType(char puzzleType) {
		this.puzzleType=puzzleType;
	}

	/**
	 * Used to format puzzle
	 */
	@Override
	public String toString() {
		return "Category:" + "Puzzle" + "," + " Serial Number:" + sn + "," + " Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," +" Age:" + age_appropriate + "," + " Puzzle Type:" + puzzleType;
	}

	/**
	 * Used to format puzzle in text file
	 */
	@Override
	public String format() {
		String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+puzzleType);
		return s;
	}
}