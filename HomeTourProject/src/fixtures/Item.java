package fixtures;

public class Item implements Interactable {
	
	String name;
	String shortDescription;
	Boolean hasKey;
	
	public Item(String name, String shortDescription, Boolean hasKey) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.hasKey = hasKey;
	}
	@Override
	public void interact() {
		System.out.println(shortDescription);
		if(this.hasKey == true) {
			this.hasKey = false;
		}
	}
}
