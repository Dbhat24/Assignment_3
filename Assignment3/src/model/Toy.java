package model;

//toy class must be abstract class, no object will be created for this class
public abstract class Toy {
	protected String sn;
	protected String name;
	protected String brand;
	protected double price;
	protected int available_count;
	protected int age_appropriate;
	
	//super constructor with parameters 
	protected Toy(String sn,String name,String brand, double price,int available_count,int age_appropriate) {
		this.sn=sn;
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.available_count=available_count;
		this.age_appropriate=age_appropriate;
	}
	
	//super constructor without parameters
	protected Toy() {
	}
	
	public String getSn() {
		return sn;
	}
	
	public void setSn(String sn) {
		this.sn=sn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
		
	}
	
	public String getBrand(){ 
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public int getAvailableCount() {
		return available_count;
	}
	
	public void setAvailableCount(int available_count) {
		this.available_count=available_count;
	}
	
	//format output
	public String format() {
		String format="Serial Number : "+ sn +" Name : "+name +" Brand : "+brand+" Price : "+price+" Available Count : "+available_count+" Age : "+age_appropriate;
		return format;
	}
}