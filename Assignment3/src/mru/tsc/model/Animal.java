package mru.tsc.model;

/**
 * Animal class that extends Toy super class
 * Includes getter and setters with toString and format methods
 * @author Faizan and Raj
 */
public class Animal extends Toy {
	// material variable
	private String material;
	// size variable
	private char size;

	/**
	 * Constructor with appropriate variables
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count of toy
	 * @param age_appropriate toy rating
	 * @param material toy material
	 * @param size toy size
	 */
	public Animal(String sn,String name,String brand,double price,int available_count,int age_appropriate,String material,char size) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.material=material;
		this.size=size;
	}

	/**
	 * constructor with no parameters
	 */
	public Animal() {
		super();
	}

	/**
	 * getter for toy material variable
	 * @return toy material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * setter for toy material variable
	 * @param material toy material
	 */
	public void setMaterial(String material) {
		this.material=material;
	}

	/**
	 * getter for toy size
	 * @return toy size
	 */
	public char getSize() {
		return size;
	}

	/**
	 * setter for toy material variable
	 * @param size toy size
	 */
	public void setSize(char size) {
		this.size=size;
	}

	/**
	 * Used to format animal
	 */
	@Override
	public String toString() {
		return "Category:" + "Animal," + " Serial Number:" + sn + "," +" Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" + age_appropriate + "," + " Material:"+ material+ "," +  " Size:" + size;
	}

	/**
	 * Used to format animal in text file
	 */
	@Override
	public String format() {
		String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+material+";"+size);
		return s;
	}
}