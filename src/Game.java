import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//Andy was here.  I made it this far finally :)  I will see about doing more later. Thus endeth the Andy.
import models.character.Character;
import models.character.Character.Gender;
import models.character.attributes.AbilityScores;
import models.character.race.Race;

//this is the game class
public class Game {
	
	//this returns the array with valid scores
	public static AbilityScores roll() {
		Random r = new Random();
		return new AbilityScores(getStat(r),getStat(r),getStat(r),getStat(r),getStat(r),getStat(r));
	}
	
	//this returns the greatest number of three random numbers for the ability score
	private static int getStat(Random r) {
		//the highest of two random numbers
		int stat = Math.max(r.nextInt(75) + 25, r.nextInt(75) + 25);
		//to continue the randomness - 25% of the time checks a third random number
		if (r.nextInt(100) > 75) 
			stat = Math.max(r.nextInt(75) + 25, stat);
		return stat;
	}
	
	//this prints the Character information - one giant string
	private static void printit(Character c){
		System.out.println("------------------");
		System.out.println(c);
		System.out.println("------------------");
	}
	
	//This is where the constructor for the Game goes
	public Game() {}
	
	//Here's a loop for later use
	private void gameloop() {
		boolean stop = false;
		while (!stop) {
			//stuff goes in here eventually
		}
	}
	
	//Prints the greeting to the gamer
	//Any interest in having a login and a way to come back to the same character again?
	//okay so that's a firm maybe - for later
	private void showWelcome() {
		System.out.println("Hello human");
		System.out.println("You don't have a character.. how 'bout you make one");
	}
	
	//Makes a Character with a Name, a Race, a Gender, a Height, a Weight, and Abilities
	private Character getCharacter(Scanner scan) {
		return new Character(getName(scan), getRace(scan), getGender(scan), getHeight(scan), getWeight(scan), getAbilities());
	}
	
	//gets the name from the gamer
	//returns any name not empty
	private String getName(Scanner scan) {
		String name = "";
		do {
			System.out.println("Let's start with a name for your character");
			name = scan.nextLine();
		}
		while("".equals(name));
		return name;
	}
	
	
	/**
	 * @param scan
	 * @return
	 */
	private Race getRace(Scanner scan) {
		//race and races are two different variables
		//races is a array of the available races to test against
		//race is the race for this character
		ArrayList<Race> races = new ArrayList<Race>(Arrays.asList(Race.getCharacterRaces()));
		Race race = null;
		System.out.println("Now, what race do you want?");
		//reads and tests the race from the gamer
		//loops until good data
		//catches error messages for bad data and when it gets good data is stops
		boolean ok = false;
		while (! ok) {
			//print out the choices
			System.out.println("Pick from: " + races);
			try {
				//read and assign the characters race to the variable race
				race = Race.valueOf(scan.nextLine().toUpperCase());
				ok = true;
			}
			catch (IllegalArgumentException iae){/* bad input */}
		}
		//okay I haven't read enough to follow where this goes and what this does
		return race;
	}
	
	//fairly straightforward get, test and assign Gender
	private Gender getGender(Scanner scan) {
		String gender = "";
		do {
			System.out.println("M or F?");
			gender = scan.nextLine().toLowerCase();
		}
		while(!"m".equals(gender) && ! "f".equals(gender));
		
		if ("m".equals(gender))
			return Gender.MALE;
		return Gender.FEMALE;	
	}

	//gets the height from the gamer
	//this doesn't set any limits on the height other than non-zero
	//Do you want to have height be positive? or above some other limit?
	//I don't see how to make height limits for different races
	//without a lot of complicated stuff
	//I'm not sure how interested you are in any of that right now or ever??
	private float getHeight(Scanner scan) {
		float height = 0;
		
//		while (height == 0) {//no min height and no max height
//			System.out.println("How tall");
//			height = scan.nextFloat();
//		}
		
//		boolean goodHeight = false;
		do {
			System.out.println("How tall");
			height = scan.nextFloat();
//			if ((height >= 1000.0f) && (height <= 20000.0f)) {
//				goodHeight = true;
//			}
//			goodHeight = ((height >= 1.5f) && (height <= 100f));
		} while ((height <= 1.5f) || (height >= 100f));
		
		return height;
	}
	
	//get the weight of the character from the gamer
	//same questions as with height:
	//this doesn't set any limits on the height other than non-zero
	//Do you want to have height be positive? or above some other limit?
	//I don't see how to make height limits for different races
	//without a lot of complicated stuff
	//I'm not sure how interested you are in any of that right now or ever??
	private int getWeight(Scanner scan) {
		int weight = 0;
		
		while (weight == 0) {
			System.out.println("How heavy");
			weight = scan.nextInt();
		}
		return weight;
	}
	
	//gets the scores for the charatcer's abilities at once 
	//and gives the games up to four choices of five options
	private AbilityScores getAbilities() {
		Scanner scan = new Scanner(System.in);
		String inpt = "";
		AbilityScores ab = null;
		//five tries - break and stop when the gamer accepts
		//the fifth questioning is unnecessary ??
		for (int i = 0; i < 5; i++){
			//calls and assigns random numbers
			ab = roll();
			//prints stats
			System.out.println(ab);
			//checks with gamer for acceptance
			System.out.println("like these stats. y or n (try " + (i+1) + " outta 5)");
			inpt = scan.nextLine().toLowerCase();
			if ("y".equals(inpt)) break;
		}
		return ab;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
//		Character frodo = new Character("Frodo", new Halfing(), Gender.MALE, 3, 140, roll());
//		printit(frodo);
//		Character smaug = new Character("Smaug", new Dragon(), Gender.MALE, 24, 5000, roll());
//		printit(smaug);
//		Character lego = new Character("Legolas", new Elf(), Gender.MALE, 6, 130, roll());
//		printit(lego);
//		Character gim = new Character("Gimli", new Dwarf(), Gender.MALE, 4, 300, roll());
//		printit(gim);
//		Character strider = new Character("Aragorn", new Human(), Gender.MALE, 6, 185, roll());
//		printit(strider);
		
		Scanner scan = new Scanner(System.in);
		
		game.showWelcome();
		Character player = game.getCharacter(scan);
		System.out.println("here's your character");
		printit(player);
	}

}  //okay that's my walkthrough for now of Game - time to walk the doggie
