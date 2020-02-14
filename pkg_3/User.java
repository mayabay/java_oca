package pkg_3;

public class User {
	private 	String name;
	private  	String location;
	private 	String topic;
	
	public User(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void learn() {
		System.out.println(name + " is learning " + topic + " in " + this.location + ".");
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", location=" + location + "]\n";
	}
	
	
	
}
