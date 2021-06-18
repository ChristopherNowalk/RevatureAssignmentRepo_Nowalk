package fixtures;

public abstract class Fixture {
	String name;
	String shortDescription;
	String longDescription;
	
	Fixture(String name, String shortDescription, String longDescription){
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
}
