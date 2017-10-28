import java.util.Random;
/*
 *Lingli Zou
 *Mr. Levin Pd.2 
 *Relationship Failure ChatBot
 */
public class LZouBot
{
	int emotion = 0;

	public String intial()
	{
		return "Hey! Welcome to the Relationship Bot! ";
	}

	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Please tell me what happened so I can help you.";
		}

		else if (findKeyword(statement, "sad") >= 0)
		{
			response = "Why are you sad?";
                	emotion--;
		}
		
		else if (findKeyword(statement, "broke up") >= 0)
		{
			response = "Everything will get better, trust me.";
					emotion--;
		}

		else if (findKeyword(statement, "thank") >= 0)
		{
			response = "I will always be here for you!";
					emotion++;
		}
		
		else if (findKeyword(statement, "wrong") >= 0)
		{
			response = "There is nothing wrong with you.";
					emotion--;
		}
		
		else if (findKeyword(statement, "I feel", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}	
		else if (findKeyword(statement, "I wish",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}	
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}

	private String newTopic(String statement)
	{
		String response="";
		if(statement.length()<4)
		{
			response="Let's take a step back. Is there other people that you cared about in your life?";
		}
		if(statement.equals("yes"))
		{
			response="Who may they be?";
		}
		if(statement.equals("no"))
		{
			response="Is there anyone that cares about you? Your family, friends, relatives, teachers, pets?";
		}
		else
		{
			response="Sorry please repeat that. Is that a 'yes' or 'no'?";
		}
		return response;
	}
	
	private String otherSupports(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "my", 0);
		String restOfStatement = statement.substring(x + 9).trim();
		return "How would your" + restOfStatement + "feel if they saw you like this?";
	}
	
	private String transformIWantToStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "I feel", 0);
		String restOfStatement = statement.substring(x + 9).trim();
		return "Why do you feel" + restOfStatement + "?";
	}

	private String transformIWantStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(x + 6).trim();
		return "Are you sure you will be happier if you had" + restOfStatement + "?";
	}
	
	private String transformIYouStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int xOfI = findKeyword (statement, "I", 0);
		int xOfYou = findKeyword (statement, "you", xOfI);
		
		String restOfStatement = statement.substring(xOfI + 1, xOfYou).trim();
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
	
	private String [] randomNeutralResponses = {"Go on. Tell me more.",
												"I see.",
												"What can you change about it?",
												"Take a moment to refresh your mind.",
												"Is that what you really think?",
												"What do you think?",
												"Let it out."
												};
	private String [] randomSadResponses = {"Don't say that!", 
											"You will be fine", 
											"That is not true!", 
											":(",
											"Don't lose hope.",
											};
	private String [] randomHappyResponses = {"I am so glad you feel this way!", 
											"Always Smile :)", 
											"You will be alright",
											"I promise you that tomorrow will be better",
											"When you can't look at the bright side, I will sit with you in dark!",
											"Every day is a new day!"};
	
}
