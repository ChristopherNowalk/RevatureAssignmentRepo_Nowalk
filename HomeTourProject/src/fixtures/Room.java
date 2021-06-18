package fixtures;

import java.util.*;

public class Room extends Fixture {
	
	//try to make a Map to make a key value pair for exits
	Map<String, Room> exits = new HashMap<>();
	//another map for our list of objects, maybe i will just use a list, but probably not because ive already done this functionality
	//Map<String, Item> items = new HashMap<>();
	Item[] items;
	public Room(String name, String shortDescription, String longDescription, int numItems) {
		super(name, shortDescription, longDescription);
		items = new Item[numItems];
	}
	
	public void printRoom() {
		System.out.println(name);
		System.out.println(shortDescription);
		System.out.println(longDescription);
	}

	public Room getExit(String direction) {
		Room room;
		room = exits.get(direction);
		//if the exits map doesn't have the key we provided, then it will return null
		return room;
	}
	
	public Boolean getExitDirection(String direction) {
		Boolean contains;
		contains = exits.containsKey(direction);
		return contains;
	}

	public void setExits(Room exit, String exitDirection) {
		//this.exits = exits;
		this.exits.put(exitDirection, exit);
	}
	
	public void setItems(Item ... items) {
		for(int i = 0; i < this.items.length; i++) {
			this.items[i] = items[i];
		}
	}
	
	public Item getItem(String item) {
		Item returnItem;
		int i = 0;
		//lets try a do while loop
		do {
			if(item.equals(this.items[i].name)) {
				returnItem = this.items[i];
				break;
			}
			else {
				returnItem = null;
			}
			i++;
		}while(i < this.items.length);
		return returnItem;
	}
}
