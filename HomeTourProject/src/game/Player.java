package game;

import fixtures.Room;
import fixtures.Item;
public class Player {
	//the room the player is currently in
	Room currentRoom;
	//TODO: add an inventory to the player so they can pick up a key somewhere and unlock a safe in another room
	
	
	public void printCurrentRoom() {
		currentRoom.printRoom();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room aRoom) {
		currentRoom = aRoom;
	}
	public void investigate(Item item) {
		item.interact();
	}
	//method used to move from room to room, should take an input of a string that we collect from our scanner object
	public void move(Room aRoom) {
		this.setCurrentRoom(aRoom);
		printCurrentRoom();
	}
	
}
