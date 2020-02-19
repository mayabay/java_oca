package pkg_3;

public class Spieler implements Comparable {

	private String name = "Hugo";
	private int level = 1;
	
	public Spieler() {}
	public Spieler(String name , int level) {
		this.name = name;
		this.level = level;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object o) { 
		if ( o == null  ) { return false; }
		if (! ( o instanceof Spieler) ) { return false; }
		
		Spieler s = (Spieler)o;
		
		if ( this.name.equals( s.getName() ) && this.level == s.getLevel() ) {
			return true;
		}else {
			return false;
		}
		
		
	}
	@Override
	public int hashCode() {
		return this.name.hashCode() * this.level;
	}
	
	@Override
	public int compareTo(Object o) {
		// Compares this object with the specified object for order. 
		// Returns a negative integer, zero, or a positive integer as this object
		// is less than, equal to, or greater than the specified object.
		
		if ( this.equals(o)  ) {
			return 0;
		}
		
		if (o == null) { return -1; }
		if ( !( o instanceof Spieler ) ) { return -1; } 
		
		Spieler s = (Spieler)o;
		//System.out.println("\tcompareTo()");
		return this.name.compareTo(s.getName());

	}
	@Override
	public String toString() {
		return "Spieler [name=" + name + ", level=" + level + "]";
	}
	
}
