package mru.tsc.model;

/**
 * Abstract class, gets extended by types of toy classes
 * @author Faizan and Raj
 *
 */
public abstract class Toy {
	protected String sn;
	protected String name;
	protected String brand;
	protected double price;
	protected int available_count;
	protected int age_appropriate;
	
	/**
	 * Super constructor containing common variables shared among different types of toys
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count for toy
	 * @param age_appropriate toy rating
	 */
	
	/**
	 * Used to preventing the user from creating the instance of this class
	 * @param sn toy serial number
	 * @param name toy name
	 * @param brand toy brand
	 * @param price toy price
	 * @param available_count available count for toy
	 * @param age_appropriate toy rating
	 */
	protected Toy(String sn,String name,String brand, double price,int available_count,int age_appropriate) {
		this.sn=sn;
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.available_count=available_count;
		this.age_appropriate=age_appropriate;
	}
	
	/*
	 * super constructor without parameters
	 */
	protected Toy() {
		
	}
	
	/**
	 * getter for toy serial number
	 * @return toy serial number
	 */
	public String getSn() {
		return sn;
	}
	
	/*
	 * setter for toy serial number
	 */
	public void setSn(String sn) {
		this.sn=sn;
	}
	
	/**
	 * getter for toy name
	 * @return toy name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter for toy name
	 * @param name toy name
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * getter for toy brand
	 * @return toy brand
	 */
	public String getBrand(){ 
		return brand;
	}
	
	/**
	 * setter for toy brand
	 * @param brand toy brand
	 */
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	/**
	 * getter for toy price
	 * @return toy price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * setter for toy price
	 * @param price toy price
	 */
	public void setPrice(double price) {
		this.price=price;
	}
	
	/**
	 * getter for toy available count
	 * @return toy available count
	 */
	public int getAvailableCount() {
		return available_count;
	}
	
	/**
	 * setter for toy available count
	 * @param available_count toy available count
	 */
	public void setAvailableCount(int available_count) {
		this.available_count=available_count;
	}
	
	/**
	 * format output
	 * @return string format for toy
	 */
	public String format() {
		String format = "Serial Number : "+ sn +" Name : "+name +" Brand : "+brand+" Price : "+price+" Available Count : "+available_count+" Age : "+age_appropriate;
		return format;
	}
}