package au.carrental.assets;

public class CoffeeMachine {
	
	private String name;
	
	public CoffeeMachine(String name) {
		super();
		this.name = name;
	}

	public Liquid getLiquid() {
		return new Liquid();
	}

	@Override
	public String toString() {
		return "CoffeeMachine [name=" + name + "]";
	}
	
	
}
