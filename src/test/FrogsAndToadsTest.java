package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import frogs_and_toads_case.FrogsAndToads;

class FrogsAndToadsTest {

	@Test
	@DisplayName("Validate if return 1 attempt when the user win on the first try")
	void testGetHinFirstTry() {
		String hiddenStr = "1705";
	    String correctGuess = "1705";
	    
	    String[] guesses = {correctGuess}; 

	 
	    FrogsAndToads frogsAndToads = new FrogsAndToads();

	    int attempts = 0;
	    String currentGuess = guesses[0];
	    String result = frogsAndToads.getHint(hiddenStr, currentGuess);
	    
	    while (!result.contains("4F0T")) {
	        attempts++;
	        currentGuess = guesses[attempts];
	        result = frogsAndToads.getHint(hiddenStr, currentGuess);
	    }
	 
	    attempts++;  

	    assertEquals(1, attempts);
	}

	
	@Test
	@DisplayName("Validate if return 3 attempts when the user win on the 3th attemp")
	void testGetHint() {
		String hiddenStr = "1705";
	    String correctGuess = "1705";
	    
	    String[] guesses = {"1701", "1702", correctGuess}; 

	 
	    FrogsAndToads frogsAndToads = new FrogsAndToads();

	    int attempts = 0;
	    String currentGuess = guesses[0];
	    String result = frogsAndToads.getHint(hiddenStr, currentGuess);
	    
	    while (!result.contains("4F0T")) {
	        attempts++;
	        currentGuess = guesses[attempts];
	        result = frogsAndToads.getHint(hiddenStr, currentGuess);
	    }
	 
	    attempts++;  

	    assertEquals(3, attempts);
	}

}
