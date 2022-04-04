package model;

public class Animal extends Toy {
	private String material;
	private char size;
	
	//constructor with parameters
	public Animal(String sn,String name,String brand,double price,int available_count,int age_appropriate,String material,char size) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.material=material;
		this.size=size;
	}
	//constructor without parameters
	public Animal() {
		super();
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material=material;
	}
	
	public char getSize() {
		return size;
	}
	
	public void setSize(char size) {
		this.size=size;
	}
	
	// add animal to the file
	public String toString() {
		return "Category:" + "Animal," + " Serial Number:" + sn + "," +" Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" + age_appropriate + "," + " Material:"+ material+ "," +  " Size:" + size;
	}
	
	//format and add the toy to a list
	public String format() {
		String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+material+";"+size);
		return s;
	}
}	