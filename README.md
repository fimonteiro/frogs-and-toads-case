# frogs-and-toads-case

<b>Programming language used:</b> Java

<b>Requirements:</b> minimum Java 17.

The solution requested in the home test is located at: <b><i>src/frogs_and_toads_case/FrogsAndToads.java</b></i>

## Solution:

First, I included a validation to ensure that we receive exactly 4 characters; otherwise, it returns a message indicating that 4 characters are required.

I stored frogs in an `ArrayList<Character>` and toads in a `HashSet<Character>`. Then, I used a `for` loop to iterate through the length of the `hiddenStr`, checking if the character at position `"i"` of the `hiddenStr` matches the character at position `"i"` of the `guessStr`. If they match, I add the character to the `ArrayList<Character>` because it represents a frog (a correct number in the correct position). Otherwise, if the character at position `"i"` of `guessStr` exists in `hiddenStr` but is not in the same position, it is a toad, and I add it to the `HashSet<Character>`.

I decided to use an `ArrayList<Character>` for frogs because it allows duplicate entries, which is necessary if there are two identical numbers in the correct positions, resulting in two frogs. I used `Hashset<Character>` for toads because I don't need to duplicate toads. 

Given that frogs are not toads, I called a `toadsList.removeAll(frogsList)`. So, I remove from the list of toads the number that it is frog, so in this case I never count as a toad what it is a frog, for instance: if `hidenStr` is 1705 and `guessStr` is 5555, the hint should show 1 frog and 0 toads. 

After that, I stored the sizes of the lists in the `frogs` and `toads` variables and formatted the hint message.

I also created test cases in the `t`stCases()` method to cover different combinations of frogs and toads, as well as unexpected inputs. Since the inputs in the method `getHint()` are strings, I chose not to validate data types (e.g., special characters or words). If someone inputs non-numeric characters, the result will be 0 frogs and 0 toads.

<b>Additionally</b>, I developed a console-based game that we can "play" with this solution. The code is located at: <b><i>src/frogs_and_toads_case/Game_FrogsAndToads.java</i></b> and the jar file is `Game_FrogsAndToads.jar`

To run the game, use the following command in the terminal:

<i>java -jar Game_FrogsAndToads.jar</i>

### Example running: 
<img src="/img/game.png">

## Solution:

To interact with the user in the terminal, I used `BufferedReader` to capture input. The `getInput()` method handles user input, using the `readLine()` function.

The `startGame()` method tracks how many attempts the user makes to solve the challenge. The user wins when he gets 4 frogs and 0 toads (4F0T). In a while loop, which runs until the user gets "4F0T", it collects new guesses and uses the `getHint()` method from the `FrogsAndToads class` to validate the number of frogs and toads. I also incremented the `attempt` variable to keep track of how many attempts the user has made.

Once the user guesses the correct number and receives the hint "4F0T", the loop ends, and the number of attempts is printed via the `printResultsMessage()` method. If the user wins on the first try, so `attempt` variable is equal 1 and the message <i>"You won on the first try! Congrats :)"</i> is displayed. If more than one attempt is required, the message will be: <i>"You won on your " + attempts + "th attempt! Congrats :)".</i>

I also added <b>unit tests</b> using JUnit5 for both classes. The tests are located at: <b><i>src/test/FrogsAndToadsTest.java</i></b> and <b><i>src/test/Game_FrogsAndToadsTest.java</i></b>
