package model;

public class Figure extends Toy {
	private char classification;

		//constructor with parameters
	public Figure(String sn,String name,String brand,double price,int available_count,int age_appropriate,char classification) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.classification=classification;
	}
	
	//constructor without parameters
	public Figure() {
		super();
	}
	
	public char getClassification() {
		return classification;
	}
	
	public void setClassification(char classification) {
		this.classification=classification;
	}

	public String toString() {
		return "Category:" + "Figure" + "," + " Serial Number:" + sn + "," +" Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" + age_appropriate + "," +" Classification:" + classification;
	}
	
	//format and add the toy to a list
		public String format() {
			String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+classification);
			return s;
		}
}
