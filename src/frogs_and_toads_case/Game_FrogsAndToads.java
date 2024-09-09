package frogs_and_toads_case;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game_FrogsAndToads {
	public static void main(String[] args) throws IOException {
		FrogsAndToads frogsAndToads = new FrogsAndToads();
	
		BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));

		 	System.out.println("WELCOME TO FROGS AND TOADS GAME!!");
		 	System.out.println("==================================================================================================================");
		 	System.out.println("The rule is: Player A thinks of a 4 digit hidden number and Player B should guess a 4 digit number based upon hints from Player A.");
		 	System.out.println("You win when you got a 4F0T (4 frogs and 0 toads)");
		 	System.out.println("==================================================================================================================");
		 	System.out.println("Let's start!!!!!!");
		 	System.out.println("==================================================================================================================");		 	
	       
		 	String hiddenNumber = getInput(reader, "Player A, what's the hidden number?");
	        System.out.println("Ok! Try to figure out the hidden number: ****");
		 	String guess = getInput(reader, "Player B - Your turn:");
	        int attempts = startGame(reader, frogsAndToads, hiddenNumber, guess);
	        System.out.println(printResultsMessage(attempts));
	}
	
    public static String getInput(BufferedReader reader, String prompt) throws IOException {
        System.out.println(prompt);
        return reader.readLine();
    }

    public static int startGame(BufferedReader reader, FrogsAndToads frogsAndToads, String hiddenNumber, String guess) throws IOException {        
        String result = frogsAndToads.getHint(hiddenNumber, guess);
        System.out.println("Hint: " + result);
        System.out.println("==================================================================================================================");
        int attempt = 1;
        while (!result.contains("4F0T")) {
            guess = getInput(reader, "Try again:");
            result = frogsAndToads.getHint(hiddenNumber, guess);
            System.out.println("Hint: " + result);
	        System.out.println("==================================================================================================================");
            attempt++;
        }
        return attempt;
    }

    public static String printResultsMessage(int attempts) {
        if (attempts == 1) {
            return "You won on the first try! Congrats :)";
        } else {
            return "You won on the " + attempts + "th attempt! Congrats :)";
        }
    }	
}
