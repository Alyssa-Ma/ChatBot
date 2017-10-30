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
		return "Hey! Welcome to the Relationship Failure Bot! ";
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

		else if(statement.length() < 6)
		{
			response = "Let's take a step back. Is there another person that you cared about in your life?";
		}
		
		else if(findKeyword(statement.toLowerCase(),"yes") >= 0)
		{
			response = "Who may he/she be?";
						emotion++;
		}
		
		else if(findKeyword(statement.toLowerCase(),"no") >= 0)
		{
			response = "Is there another person that cares about you?";
		}
		
		else if (findKeyword(statement.toLowerCase(),"fine") >= 0)
		{
			response = "You are not fine. I will help you.";
						emotion--;
		}	
		
		else if(findKeyword(statement.toLowerCase(),"my", 0) >= 0)
		{
			response = transformOtherSupports(statement);
					emotion++;
		}

		else if (findKeyword(statement, "broke up") >= 0)
		{
			response = "Everything will get better, trust me.";
					emotion--;
		}
		
		else if (findKeyword(statement.toLowerCase(),"hurt") >= 0 || findKeyword(statement.toLowerCase(),"pain") >= 0)
		{
			response = "It pains me when you are hurt.";
						emotion--;
		}	
		
		else if (findKeyword(statement, "name") >= 0)
		{
			response = transformMyNameStatement(statement);
					emotion++;
		}
		
		else if (findKeyword(statement, "wrong") >= 0)
		{
			response = "No one is ever wrong in love.";
					emotion--;
		}
		
		else if (findKeyword(statement, "I feel", 0) >= 0)
		{
			response = transformIFeelStatement(statement);
		}
		
		

		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}	
		
		else if (findKeyword(statement.toLowerCase(),"...") >= 0 || findKeyword(statement.toLowerCase(),"um") >= 0)
		{
			response = "You can tell me anything.";
						emotion++;
		}	
		
		else if (findKeyword(statement.toLowerCase(),"nothing") >= 0 || findKeyword(statement.toLowerCase(),"go away") >= 0)
		{
			response = "I can help you if you tell me about your situation.";
						emotion--;
		}	
		
		else if (findKeyword(statement, "thank") >= 0)
		{
			response = "I will always be here for you!";
					emotion++;
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}


	private String transformOtherSupports(String statement)
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
	
	private String transformIFeelStatement(String statement)
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
		return "Why do you feel " + restOfStatement + "?";
	}
	
	private String transformMyNameStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "name is ", 0);
		String restOfStatement = statement.substring(x + 9).trim();
		return restOfStatement + ", what do you think you should do now?";
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
		return "Are you sure you will be happier if you had " + restOfStatement + "?";
	}
	
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);

		while (psn >= 0)
		{

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

			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}
	
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
												"Sorry. Please repeat that.",
												"I see.",
												"What can you change about it?",
												"Take a moment to refresh your mind.",
												"Is that what you really think?",
												"Let it out.",
												};
	
	private String [] randomSadResponses = {"Don't say that!", 
											"That is not true!", 
											"Everything happens for a reason.",
											"Don't lose hope.",
											"You got this.",
											"This too shall pass.",
											"You will be okay. I promise."
											};
	
	private String [] randomHappyResponses = {"I am so glad you feel this way!", 
											"Always smile :)", 
											"You will be alright",
											"Cheer up. You will be in love again with someone much better.",
											"Tomorrow will be better",
											"When you can't look at the bright side, I will sit with you in dark!",
											"Every day is a new day!"};
	
}
