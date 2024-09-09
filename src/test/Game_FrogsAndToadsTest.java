package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import frogs_and_toads_case.FrogsAndToads;
import frogs_and_toads_case.Game_FrogsAndToads;

class Game_FrogsAndToadsTest {

	@Test
	@DisplayName("Validate if it's returning field to fill the numbers of hidden or guess")
	void testGetInput() throws IOException {
        String simulatedInput = "1701";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
       
        BufferedReader guess = new BufferedReader(new InputStreamReader(inputStream));
        String result = Game_FrogsAndToads.getInput(guess, "Player A, what's the hidden number?");
        
        assertEquals("1701", result);
	}

	@Test
	@DisplayName("Validate if return 1 attempt when the user win on the first try")
	void testStartGameFirstTry() throws IOException {
		String simulatedInput = "1701";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        FrogsAndToads frogsAndToads = new FrogsAndToads();
       
        BufferedReader guess = new BufferedReader(new InputStreamReader(inputStream));
        int attempts = Game_FrogsAndToads.startGame(guess, frogsAndToads, simulatedInput, simulatedInput);
        
        assertEquals(1, attempts);
	}
	
	@Test
	@DisplayName("Validate if return 3 attempts when the user win on the 3th attemp")
	void testStartGameMoreTries() throws IOException {

		String hiddenStr = "1705";
	    String correctGuess = "1705";
	    
	    String[] guesses = {"1701", correctGuess};

	    ByteArrayInputStream inputStream = new ByteArrayInputStream(String.join("\n", guesses).getBytes());
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	    FrogsAndToads frogsAndToads = new FrogsAndToads();
	    
	    int attempts = Game_FrogsAndToads.startGame(reader, frogsAndToads, hiddenStr, guesses[0]);
	    
	    assertEquals(3, attempts);
	}

	@Test
	@DisplayName("Validate if return 'You won on the first try! Congrats :)' when attempt is 1")
	void testPrintResultsMessage() {
		String resultAttempt = Game_FrogsAndToads.printResultsMessage(1);
		assertEquals("You won on the first try! Congrats :)", resultAttempt);
	}
	
	@Test
	@DisplayName("Validate if return 'You won on the 10th attempt! Congrats :)' when attempt is 10")
	void testPrintResultsMessageWithMoreAttempts() {
		String resultAttempt = Game_FrogsAndToads.printResultsMessage(10);
		assertEquals("You won on the 10th attempt! Congrats :)", resultAttempt);
	}

}
