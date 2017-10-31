import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version: The really mean and savage chat bot. Talk to it at your own risk.
 * @author Lily Li
 * @version October 30, 2017
 */
public class LLiBot
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

	public String getGreeting()
	{
		return "Whaddya want? Make it quick! I don't have all day for you!!! DX";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		String[] begPrompt = {"Who","What","Where","When","Why","How"};
		
		if (statement.length() == 0)
		{
			response = "(-_-) If you're not gonna talk, then leave!";
		}
		
		else 
		{
			for(int i = 5; i>=0; i--) {
				if (findKeyword(statement, begPrompt[i], 0) >= 0)
				{
					response = fiveW(statement, i);
					i=-1;
				}
			}
			if(response=="") {
				response = getRandomResponse();
			}
		}
		
		return response;
	}
	
	private String fiveW(String statement, int i)
	{
		//  Remove the final punctuation mark, if there is one
		int psn=0;
		String restOfStatement = "";
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")||lastChar.equals(",")||lastChar.equals("?")||lastChar.equals("!"))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		if (i == 0) {
			psn = findKeyword (statement, "who", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (i == 1) {
			psn = findKeyword (statement, "what", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (i == 2) {
			psn = findKeyword (statement, "where", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (i == 3) {
			psn = findKeyword (statement, "when", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (i == 4) {
			psn = findKeyword (statement, "why", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (i == 5) {
			psn = findKeyword (statement, "How", 0);
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};
			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(emotion) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		return statement;
	}
	
	private int findKeyword(String statement, String goal, int startPos)
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
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
