package game;

public class Main {
	
	private static RoomManager manager = new RoomManager();
	
	private static Boolean running = false;
	
	private static Player player = new Player();
	
	private static Input inputObj = new Input();
	
	public static void main(String[] args) {
		//this is the main method where our game will be running
		running = true;
		manager.init();
		player.setCurrentRoom(manager.startingRoom);
		welcome();
		instructions();
		player.printCurrentRoom();
		//this will be the body of our game loop
		while(running) {
			String[] input;
			//getting the players input
			input = inputObj.getInput();
			
			if(input[0].equals("go")) {
				//checking to see if the direction is a valid exit for that room
				if(player.currentRoom.getExitDirection(input[1])) {
					player.move(player.currentRoom.getExit(input[1]));
				}
				else {
					System.out.println("That is not a valid direction to go.");
				}
			}
			else if(input[0].equals("interact")) {
				if(player.currentRoom.getItem(input[1]) != null){
					player.investigate(player.currentRoom.getItem(input[1]));
				}
				else {
					System.out.println("That is not a valid item to interact with");
				}
			}
			else if(input[0].equals("help")) {
				instructions();
			}
			else if(input[0].equals("quit")) {
				running = false;
			}
			else {
				System.out.println("Please enter a valid command. Type help if you need the instructions again.");
			}					
			
		}

	}
	
	//welcome message method
	private static void welcome() {
		System.out.println("Welcome to Christopher Nowalk's Home Tour");
	}
	//instruction manual, can be called later to repeat instructions if needed
	private static void instructions() {
		//to be added to once the game comes farther along
		System.out.println("Type in a command consisting of a first condition 'go' then follow that " + "\n"
		+ "with a cardinal direction (north, south, east, or west). If the current room you are in is connected to another" + "\n"
		+ "room, you will move into that room and there will be a description of the new room with items to inspect and" + "\n"
		+ "other rooms to go to. If you type 'interact' then follow that with the name of the object you want to interact with." + "\n"
		+ "A description of that item should come up and you are free to go to another room or interact with another object." + "\n"
		+ "You start in the driveway only being able to go north into the house. If you need help type 'help' and these instructions" + "\n"
		+ "will be printed again. If you want to stop the program type 'quit' and the program will stop.");

	}

}
