package masterMind;
import java.util.*; //for Random & Scanner method
public class MasterMind {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		char[] color = new char[5];
		char[] symbol = new char[5];
		char[] guess = new char[5];

		System.out.println("\t\t*** Master Mind ***\ncolors symbol;D");
		System.out.println("orange:O \t pink:P \t green:T \t red:R");
		System.out.println("violet:V \t blue:Q \t yello:U \t white:S");

		int end = 1;
		while (end == 1) {// going to beginning & end game(win/lose)
			/*
			 * store random colors symbol in array
			 *(a,b)-> int x = rand.nextInt(b-a + 1) + a;
			 */
			for (int i = 0; i < 5; i++)
				color[i] = (char) (rand.nextInt(8) + 79);

			System.out.print("Enter your guess count:");
			int count = scan.nextInt();

			int loop = 1;
			while (loop <= count) { // count guesses & manage inputs
				System.out.print(loop + ". guess:");
				String input = scan.next();

				if (input.equals("0"))
					break;// break while & go to beginning

				else if (input.equals("1")) {
					System.out.print("right answer:)");
						System.out.print(color);
					// sleep for 1s by Thread class
					try {
						Thread.sleep(1000);
					}

					catch (Exception e) {
					}
					loop++;
					System.out.println("\n\n\n\n\n\n\n\n\n\n");// clear console
					continue;// skip value 1
				} else {// ordinary inputs
						// String -> charArray
					for (int i = 0; i < input.length(); i++)
						guess[i] = input.charAt(i);
					// for symbol -> check each guess array cell
					for (int each = 0; each < 5; each++) {
						int condition = 0;
						// check existence at main char array
						for (int i = 0; i < 5; i++)
							if (guess[each] == color[i])
								condition = 1;
						// assign a symbol
						if (color[each] == guess[each])
							symbol[each] = '#';
						else if (condition == 1)
							symbol[each] = '+';
						else
							symbol[each] = '-';
					}
					loop++;
					int hashtag = 0; // output
					System.out.print(".........");
					for (int s = 0; s < 5; s++) {
						System.out.print(symbol[s]);
						if (symbol[s] == '#')
							hashtag++;// about win
					}
					System.out.print("\n");

					if (hashtag == 5) {// win
						end = 100;
						System.out.print("that\'s right;D \n");
						break;
					} else if (loop > count) {// lose
						System.out.print("Game over:(");
						end = 0;
						break;
					}
				}
			}
		}
		scan.close();
	}
}
