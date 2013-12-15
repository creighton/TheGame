import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//Andy was here.  I made it this far finally :)  I will see about doing more later. Thus endeth the Andy.
import models.character.Character;
import models.character.Character.Gender;
import models.character.attributes.AbilityScores;
import models.character.race.CreatureFactory;
import models.character.race.Race;
import models.character.race.Race.PlayerRaces;


public class Game {
	
	public static AbilityScores roll() {
		Random r = new Random();
		return new AbilityScores(getStat(r),getStat(r),getStat(r),getStat(r),getStat(r),getStat(r));
	}
	
	private static int getStat(Random r) {
		int stat = Math.max(r.nextInt(75) + 25, r.nextInt(75) + 25);
		
		if (r.nextInt(100) > 75) 
			stat = Math.max(r.nextInt(75) + 25, stat);
		return stat;
	}
	
	private static void printit(Character c){
		System.out.println("------------------");
		System.out.println(c);
		System.out.println("------------------");
	}
	
	public Game() {}
	
	private void gameloop() {
		boolean stop = false;
		while (!stop) {
			
		}
	}
	
	private void showWelcome() {
		System.out.println("Hello human");
		System.out.println("You don't have a character.. how 'bout you make one");
	}
	
	private Character getCharacter(Scanner scan) {
		return new Character(getName(scan), getRace(scan), getGender(scan), getHeight(scan), getWeight(scan), getAbilities());
	}
	
	private String getName(Scanner scan) {
		String name = "";
		do {
			System.out.println("Let's start with a name for your character");
			name = scan.nextLine();
		}
		while("".equals(name));
		return name;
	}
	
	private Race getRace(Scanner scan) {
		ArrayList<PlayerRaces> races = new ArrayList<PlayerRaces>(Arrays.asList(PlayerRaces.values()));
		PlayerRaces race = null;
		System.out.println("Now, what race do you want?");
		boolean ok = false;
		while (! ok) {
			System.out.println("Pick from: " + races);
			try {
				race = PlayerRaces.valueOf(scan.nextLine().toUpperCase());
				ok = true;
			}
			catch (IllegalArgumentException iae){/* bad input */}
		}
		
		return CreatureFactory.getPlayerRace(race);
	}
	
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
	
	private int getHeight(Scanner scan) {
		int height = 0;
		
		while (height == 0) {
			System.out.println("How tall");
			height = scan.nextInt();
		}
		return height;
	}
	
	private int getWeight(Scanner scan) {
		int weight = 0;
		
		while (weight == 0) {
			System.out.println("How heavy");
			weight = scan.nextInt();
		}
		return weight;
	}
	
	private AbilityScores getAbilities() {
		Scanner scan = new Scanner(System.in);
		String inpt = "";
		AbilityScores ab = null;
		for (int i = 0; i < 5; i++){
			ab = roll();
			System.out.println(ab);
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

}
