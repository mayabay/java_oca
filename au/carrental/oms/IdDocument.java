/*
 * IdDocument
 * v0.1
 * form of personal identification document
 * 
 * */
package au.carrental.oms;

public class IdDocument {
	private		String	 name = "travel passport";
	private		String	 id = "0123456789";
	
	public IdDocument(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IdDocument [name=" + name + ", id=" + id + "]";
	}
	
	
	
}
