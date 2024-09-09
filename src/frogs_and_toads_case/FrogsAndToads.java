package frogs_and_toads_case;

import java.util.ArrayList;
import java.util.HashSet;

public class FrogsAndToads {

	public static void main(String[] args) {
		FrogsAndToads frogsAndToads = new FrogsAndToads();
		frogsAndToads.testCases();
	}
	
	public String getHint(String hiddenStr, String guessStr) {
		if (hiddenStr.length() != 4 || guessStr.length() != 4) {
            return "You should to pass 4 characteres as arguments";
        }
		
		String frogsAndToadsCount;
		int frogs;
		int toads;
		
	    ArrayList<Character> frogsList = new ArrayList<Character>();
	    HashSet<Character> toadsList = new HashSet<Character>();

			for(int i = 0; i < hiddenStr.length(); i++) {
				if(hiddenStr.charAt(i) == guessStr.charAt(i)) {
					frogsList.add(guessStr.charAt(i));
				} else if (hiddenStr.indexOf(guessStr.charAt(i)) >= 0){
					toadsList.add(guessStr.charAt(i));
				}		
			}
			toadsList.removeAll(frogsList);
			frogs = frogsList.size();
			toads = toadsList.size();
			
		frogsAndToadsCount = frogs+"F"+toads+"T";
		return frogsAndToadsCount;
	}

	
	public boolean assertHint(int caseNumber, String results, String expected) {
		boolean correct = results.equals(expected);
		System.out.println("Expected value = " + expected + "\nActual value = " + results);
		System.out.println("\nCase " + caseNumber + " = " + (correct ? "passed" : "fail"));
		System.out.println("------------------------------------------");
		return results.equals(expected);
	}
	
	public void testCases() {
		String case1 = getHint("1807", "7810");
		assertHint(1, case1, "1F3T");
		
		String case2 = getHint("1807", "2805");
		assertHint(2, case2, "2F0T");
		
		String case3 = getHint("1807", "9807");
		assertHint(3, case3, "3F0T");

		String case4 = getHint("1807", "777");
		assertHint(4, case4, "You should to pass 4 characteres as arguments");
		
		String case5 = getHint("1807", "1807");
		assertHint(5, case5, "4F0T");
		
		String case6 = getHint("1807", "7777");
		assertHint(6, case6, "1F0T");
		
		String case7 = getHint("4185", "5555");
		assertHint(7, case7, "1F0T");
		
		String case8 = getHint("4185", "5454");
		assertHint(8, case8, "0F2T");
		
		String case9 = getHint("4185", "54545");
		assertHint(9, case9, "You should to pass 4 characteres as arguments");
		
		String case10 = getHint("1827", "0000");
		assertHint(10, case10, "0F0T");
		
		String case11 = getHint("1827", "abcd");
		assertHint(11, case11, "0F0T");
		
		String case12 = getHint("1701", "1701");
		assertHint(12, case12, "4F0T");
		
		String case13 = getHint("1701", "7101");
		assertHint(13, case13, "2F1T");
		
		String case14 = getHint("4441", "4441");
		assertHint(14, case14, "4F0T");
		
	}
}
