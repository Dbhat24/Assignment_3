package mru.tsc.model;

/**
 * Figure class that extends Toy super class
 * Includes getters and setters with toString and format methods
 * @author Faizan and Raj
 */
public class Figure extends Toy {
	// classification variable
	private char classification;

	/**
	 * Constructor with appropriate variables
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count for toy
	 * @param age_appropriate toy rating
	 * @param classification toy classification
	 */
	public Figure(String sn,String name,String brand,double price,int available_count,int age_appropriate,char classification) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.classification=classification;
	}

	/**
	 * constructor with no parameters
	 */
	public Figure() {
		super();
	}

	/**
	 * getter for toy classification variable
	 * @return toy classification
	 */
	public char getClassification() {
		return classification;
	}

	/**
	 * setter for toy classification variable
	 * @param classification toy classification
	 */
	public void setClassification(char classification) {
		this.classification=classification;
	}

	/**
	 * Used to format figure
	 */
	@Override
	public String toString() {
		return "Category:" + "Figure" + "," + " Serial Number:" + sn + "," +" Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" + age_appropriate + "," +" Classification:" + classification;
	}

	/**
	 * Used to format figure in text file
	 */
	@Override
	public String format() {
		String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+classification);
		return s;
	}
}
