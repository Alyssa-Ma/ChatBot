import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version: The really mean and savage chat bot. Talk to it at your own risk.
 * @author Lily Li
 * @version October 30, 2017
 */
public class LLiBot
{
	//sass and emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int sass = 0;
	int botInterest = 0; 
	int psn=0;
	String restOfStatement = "";

	public String getGreeting()
	{
		return "Whaddya want? Make it quick! I don't have all day for you!!! DX";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		String[] questions = {"Who","What","Where","When","Why","How"};
		
		if (statement.length() == 0)
		{
			response = "(-_-) If you're not gonna talk, then leave!";
			sass++;
		}
		
		else 
		{
			for(int i = 5; i>=0; i--) {
				if (findKeyword(statement, questions[i], 0) >= 0)
				{
					response = transformedStatement(statement, i);
					i=-1;
				}
			}
			if(response=="") {
				response = getRandomResponse();
			}
		}
		
		return response;
	}
	
	private String removePunctuation(String statement)	//  Remove the final punctuation mark, if there is one
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")||lastChar.equals(",")||lastChar.equals("?")||lastChar.equals("!"))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		return statement;
	}
	
	private String transformedStatement(String statement, int i) {
		statement = removePunctuation(statement);
		if(i==0 || i == 2 || i == 3) {
			return(whoWhereWhenStatement(statement));
		}
		else if(i==1) {
			return(whatStatement(statement));
		}

		return statement;

	}	
	private String transformPronoun(String statement) {//pronouns
		String[] theySay = {" your"," are"," you"," me"};
		String[] myResp = {" my"," am"," I", " you"};
		
		for(int i = 0; i < theySay.length;i++) {
			statement = statement.replaceAll(theySay[i], myResp[i]);
			botInterest++;
			sass--;
		}
		if(botInterest % 5 == 0 && botInterest > 0) {
			return "Looks like you have a lot of interest in me... well don't! >:(";
		}
		
		return statement + ", you say?\n" + getRandomResponse();
	}
	private String whoWhereWhenStatement(String statement) {
		if(findKeyword (statement, "who")>= 0) {
			psn = findKeyword (statement, "who");
			restOfStatement = statement.substring(psn).trim();
			String[] whoSaidIt = {"Mr. Levin","Lily","Daniel","Alyssa","LingLi"};

			return "Well who else would it be? Of course it's " + whoSaidIt[Math.abs(sass) % 5] + "! (o-o) ... Now the question is " + restOfStatement + "?";
		}
		else if (findKeyword (statement, "where")>= 0) { // maybe we could use prepositions and noun
			psn = findKeyword (statement, "where");
			restOfStatement = statement.substring(psn).trim();
			String[] whereIsIt = {"Apple", "Bas", "Car"};

			return "The place you're looking for is " + whereIsIt[Math.abs(botInterest) % whereIsIt.length] + "! (*u*) ...";
		}
		else if (findKeyword (statement, "when")> 0) {
			psn = findKeyword (statement, "when");
			restOfStatement = statement.substring(psn).trim();
			String[] whenIsIt = {"sunset", "midnight", "sunrise"};

			return "It's at " + whenIsIt[Math.abs(botInterest) % whenIsIt.length] + "! (o3o) ...";
		}
		return getRandomResponse();
	
	}
	
	private String whatStatement(String statement) {
		statement = transformPronoun(statement);
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
		if (sass == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (sass < 0)
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
