import java.util.Random;
import java.util.Scanner;

/**
 * Chatbot on emotions?
 * @author Alyssa
 * vague topic kinda? casual talking???
 */
public class AMaBot
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

	public String getGreeting()
	{
		return "Thanks for choosing me! How are you feeling?";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "What's wrong? Are you getting bored?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why do you say no?";
			emotion--;
		}
		
		else if (findKeyword(statement, "happy") >= 0)
		{
			response = "I'm glad you are. I'm fulfilling my purpose well.";
			emotion++;
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Alright.";
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "I hate",0) >= 0)
		{
			response = transformIhate(statement);
		}
		//game response
		else if (findKeyword(statement, "game", 0) >=0)
		{
			response = guessGame();
			emotion++;
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}
	
	
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}
/**
 * attempting to make a guessing number game
 */
	private String guessGame()
	{
		System.out.println("Alright, guess a number between 0 and 1000!");
		/**
		 * fixed placement of this statement so it doesn't repeat every time you guess 
		 */
		int r = (int )(Math.random()*1001);
		/**need to have parentheses or else it will always be zero 
		 * also the number does not include, so you always need one more than your range
		 */
		int tries = 0;
		Scanner input = new Scanner(System.in);
		/**
		 * tested using in.close(); not neccesary, will stop the loop after the first instance
		 */
		int guess;
		boolean right = false;
		while(right == false)
		{
			guess = input.nextInt();
			tries++;
			
			if(guess == r)
			{
				right = true;
			}
			else if (guess > r)
			{
				System.out.println("Your guess is a bit too high! xD");
			}
			else if (guess < r)
			{
				System.out.println("Your guess is a bit too low! ;p");
			}
		}
		System.out.println("Yay you got it right!");
		System.out.println("The correct number was " + r);
		System.out.println("The number of tries it took you to win was " + tries + "!");
		return("To play again, just say game again!");
		}
	
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	private String transformIhate(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I hate", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Why do you hate " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomSadResponses [r.nextInt(randomSadResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Do you really feel that way?",
			"I see.",
			"What else do you want to talk about?",
			"I understand.",
			"School is difficult.",
			"I'm a bit tired, but please continue.",
			"I wonder..."
	};
	private String [] randomSadResponses = {"Why are you being like this?", "I only wanted to help...", "..."};
	private String [] randomHappyResponses = {"I'm so glad I could be of use!", "Finally, I'm fulfilling my purpose!", "Haha, I feel a bit light."};
	
}
