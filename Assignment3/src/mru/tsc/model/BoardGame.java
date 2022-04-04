package mru.tsc.model;

public class BoardGame extends Toy {
	private String designer;
	private String noOfPlayers;
	
	//constructor with parameters
	public BoardGame(String sn,String name,String brand,double price,int available_count,int age_appropriate,String noOfPlayers,String designer) {
		super(sn,name,brand,price,available_count,age_appropriate);
	this.designer=designer;
	this.noOfPlayers=noOfPlayers;
	}
	
	//constructor without parameters
	public BoardGame() {
		super();
	}
	
	public String getDesigner() {
		return designer;
	}
	
	public void setDesigner(String designer) {
		this.designer=designer;
	}

	public String toString() {
		return "Category:" +"Board Game" + "," + " Serial Number:" + sn + "," + " Name:" + name + "," + " Brand:" + brand + "," + " Price:" + price + "," + " Available Count:" + available_count + "," + " Age:" +age_appropriate + "," + " # of players:" + noOfPlayers + "," + " Designer:" + designer;
	}
	
	//format and add the toy to a list
		public String format() {
			String s=String.format(sn+";"+name+";"+brand+";"+price+";"+available_count+";"+age_appropriate+";"+noOfPlayers+";"+designer);
			return s;
		}
}