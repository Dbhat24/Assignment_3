package mru.tsc.model;

public class Puzzle extends Toy {
	private char puzzleType;
	
	//constructor without parameters
	public Puzzle(String sn,String name,String brand,double price,int available_count,int age_appropriate,char puzzleType) {
		super(sn,name,brand,price,available_count,age_appropriate);
		this.puzzleType=puzzleType;
	}
	
	//constructor without parameters.
	public Puzzle() {
		super();
	}
	
	public char getPuzzleType() {
		return puzzleType;
	}
	
	public void setPuzzleType(char puzzleType) {
		this.puzzleType=puzzleType;
	}
	
	public String toString() {
		return "Category:" + "Puzzle" + "," + " Serial Number:" + sn + "," + " Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," +" Age:" + age_appropriate + "," + " Puzzle Type:" + puzzleType;
	}
	
	//format and add the toy to a list
		public String format() {
			String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+puzzleType);
			return s;
		}
}
