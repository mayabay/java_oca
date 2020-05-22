package hanu_8;
public class Bear {
	private String name;
	public Bear(){
		this("unnamed");
	}
	public Bear(String name){
		this.name = name;
	}
	protected String getName(){
		return name;
	}
}
