package game;

import fixtures.Room;
import fixtures.Item;

public class RoomManager {
	//the room we start in
	Room startingRoom;
	
	public RoomManager() {
	}
	//this is where we will create all of the rooms in our house and their connections and fixtures
	public void init() {
		Room driveway = new Room("The Driveway",
				"A short driveway",
				"A short driveway with a path leading to the front door of a small blue house", 0);
		//this.rooms[0] = driveway;
		this.startingRoom = driveway;
		
		//room creation
		Room entranceHall = new Room("The Entrance Hall",
				"An entrance hall leading to the kitchen, the study, and the garage",
				"A Spacious entrance hall with hardwood floors, a family portrait hanging on the wall and an " + "\n"
				+ "antique vase with dried flowers sitting on a little table next to the front door." + "\n"
				+ " The kitchen in to the north, the garage is to the east, and the study is to the west, and the driveway " + "\n"
				+ "is to the south.", 2);
		//this.rooms[1] = entranceHall;
		
		Room kitchen = new Room("The Kitchen",
				"A nice kitchen with lots of sunlight, connected to the entrance hall",
				"A fancy little kitchen with a six burner range, granite countertops, and a stainless steel fridge " + "\n"
				+ "with a note stuck to the door, and lots of windows letting in sunlight. The entrance hall is to the south.", 3);
		
		Room garage = new Room("The Garage",
				"An garage with all sorts of odds and ends, connected to the entrance hall",
				"A two stall garage with one car in it. There are a lot of shelves along the walls filled with " + "\n"
				+ "random odds and ends and car parts. The garage door is closed so the only way back is west" + "\n"
				+ " to the entrance hall.", 2);
		
		Room study = new Room("The Study",
				"A study with a desk and safe, connected to the entrance hall",
				"A small study with one window and a desk in the middle of the room. The only thing on the desk is  " + "\n"
				+ "a computer workstation. Behind the desk is a large safe with a small keyhole in it. I wonder where the key is." + "\n"
				+ " The entrance hall is to the east.", 2);
		//item creation
		Item portrait = new Item("portrait", "A picture with parents, their two kids and the dog Illia.", false);
		Item vase = new Item("vase", "A jade vase from Madagascar with old dry orchids in it.", false);
		Item range = new Item("range", "Beautiful six burner range from France, it probably costs more than the house.", false);
		Item countertop = new Item("countertop", "Black and grey granite countertop. They are so polished you can ." + "\n"
		+ "see your reflection in them", false);
		Item fridge = new Item("fridge", "Medium sized stainless steel fridge. The note stuck to the door reads: 'TODO: buy food'", false);
		Item car = new Item("car", "An old and rather beat up red Jeep. The paint is faded and there is dog hair all over the inside.", false);
		Item shelves = new Item("shelves", "There is probably a hundred feet of shelving around the garage. You find a small key in an " + "\n"
		+ "an old coffee tin. I wonder where it fits", true);
		Item desk = new Item("desk", "The desk is a nicely carved oak peice with an old toshiba laptop on it. The computer was " + "\n"
		+ "probably quite nice in the past.", false);
		Item safe = new Item("safe", "A large, rusted, antique safe is hidden behind the desk. There is a small keyhole in the front." + "\n"
		+ "I wonder where that key is?", false);
			//setting the exits and items of of our rooms
			driveway.setExits(entranceHall, "north");
			
			entranceHall.setExits(driveway, "south");
			entranceHall.setExits(kitchen, "north");
			entranceHall.setExits(garage, "east");
			entranceHall.setExits(study, "west");
			entranceHall.setItems(portrait, vase);
			
			kitchen.setExits(entranceHall, "south");
			kitchen.setItems(range, countertop, fridge);
			
			garage.setExits(entranceHall, "west");
			garage.setItems(car, shelves);
			
			study.setExits(entranceHall, "east");
			study.setItems(desk, safe);
	}
}
