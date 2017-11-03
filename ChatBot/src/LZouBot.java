import java.util.Random;
import java.util.Scanner;
/*
 *Lingli Zou
 *Mr. Levin Pd.2 
 *
 *Relationship Failure ChatBot
 */
public class LZouBot
{

	int emotion = 0;

	public String getGreeting()
	{
		return "Welcome to the Breakup Bot! ";
	}

	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() < 2)
		{
			response = "Please tell me what happened so I can help you.";
		}
		
		else if(findKeyword(statement.toLowerCase(), "game")>=0)
		{
			System.out.println(GuessGame());
					emotion++;
		}
		
		else if(findKeyword(statement.toLowerCase(), "okay")>=0)
		{
			System.out.println("Would you like to tell me why you liked that person?");
					emotion++;
					
			in = new Scanner (System.in);
			statement = in.nextLine();
					
					if(findKeyword(statement.toLowerCase(), "because")>=0)
					{
						System.out.println("How about now? Is the person still acts the same?");
								
							in = new Scanner (System.in);
							statement = in.nextLine();
							
						if(findKeyword(statement, "no") >= 0)
						{
							System.out.print("Then it is time to move on.");
					
						}
					}
					else if (findKeyword(statement, "no") >= 0)
					{
						System.out.print("Then let's talk about something else.");
					}
		}
		
		else if(findKeyword(statement.toLowerCase(), "ok")>=0)
		{
			System.out.println("Is there someone else that you care about or someone that cares about you?");
			
			in = new Scanner (System.in);
			statement = in.nextLine();
			
					if(findKeyword(statement.toLowerCase(), "no")>=0)
					{
						System.out.print("There has to be at least one person.");
					}
					else if(findKeyword(statement.toLowerCase(),"yes") >= 0)
					{
						System.out.print("Who may he/she be?");
							emotion++;
					}
		}
		else if (findKeyword(statement, "I am") >= 0)
		{
			response = transformIAmStatement(statement);
                	emotion--;
		}
		
		else if(findKeyword(statement.toLowerCase(), "hi")>=0 || findKeyword(statement.toLowerCase(),"hello") >= 0)
		{
			response = "Hello! What would you like to talk about today?";
		}
		
		else if(findKeyword(statement.toLowerCase(), "my", 0)>=0)
		{
			response=transformOtherSupports(statement);
		}
		
		else if(findKeyword(statement.toLowerCase(),"no") >= 0)
		{
			response = "Then don't make them feel this way.";
						emotion++;
		}
		
		else if(findKeyword(statement.toLowerCase(),"no it won't") >= 0)
		{
			response = "That is not true!";
						emotion--;
		}
		
		else if (findKeyword(statement.toLowerCase(),"fine") >= 0)
		{
			response = "You are not fine. I will help you.";
						emotion--;
		}	

		else if (findKeyword(statement, "broke up") >= 0)
		{
			System.out.println("Everything will get better."); 
			
			in = new Scanner (System.in);
			statement = in.nextLine();
							
					if(findKeyword(statement.toLowerCase(), "no")>=0)
					{
						System.out.print("Don't say no because it will. Trust me.");
							emotion--;
					}
					
					else if(findKeyword(statement.toLowerCase(),"ok") >= 0 || findKeyword(statement.toLowerCase(),"okay") >= 0)
					{
						System.out.print("Great! Now you are one step closer to moving on!");
							emotion++;
					}
		}
		
		else if (findKeyword(statement.toLowerCase(),"hurt") >= 0 || findKeyword(statement.toLowerCase(),"pain") >= 0)
		{
			response = "It pains me when you are hurt.";
						emotion--;
		}	
		
		else if (findKeyword(statement, "wrong") >= 0)
		{
			response = "No one is ever wrong in love.";
					emotion--;
		}
		
		else if(findKeyword(statement, "will")>=0)
		{
			response= transformWillStatement(statement);
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
			response = "I can't help you if you don't tell me about your situation.";
						emotion--;
		}	
		
		else if (findKeyword(statement, "thank") >= 0)
		{
			response = "I will always be here for you!";
					emotion++;
		}
		
		else if (findKeyword(statement, "because") >= 0)
		{
			response = "Exactly. If you can't smile for yourself, at least smile for that person.";
					emotion++;
		}
		
		else if(findKeyword(statement, "I love")>=0)
		{
			response=transformILoveStatement(statement);
		}
		
		else if(findKeyword(statement, "yay")>=0 || findKeyword(statement.toLowerCase(),"!") >= 0)
		{
			response="Now cheer up! You are amazing!";
					emotion++;
		}
		
		else
		{
			response = getRandomResponse();
		}
		
		return response;
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
		String restOfStatement = statement.substring(x +2).trim();
		return "How would your " + restOfStatement + " feel if your " +restOfStatement +" saw you like this?";
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
	
	private String transformWillStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "will", 0);
		String restOfStatement = statement.substring(x + 4).trim();
		return "Are you willing to see someone you care about " + restOfStatement + "?";
	}
	private String transformILoveStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "I love", 0);
		String restOfStatement = statement.substring(x + 6).trim();
		return "I understand that you love " + restOfStatement + " but when it does not work out, it might be time to move on.";
	}
	
	private String transformIAmStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int x = findKeyword (statement, "I am", 0);
		String restOfStatement = statement.substring(x + 4).trim();
		return "Why are you " + restOfStatement + "?";
	}
	
	private String GuessGame()
	{			
		System.out.println("I picked a number from 0-10. Try to guess my number!");

		boolean correct=false;
		int myNumber=(int)(Math.random()*11);
		in = new Scanner (System.in);
		int guess;
		int tries=0;
		
		while(correct == false)
		{			
			guess=in.nextInt();
			tries++;

				if(guess<myNumber)
				{
					System.out.println("Your guess is smaller than my secret number! Try again!");
				}
	
				else if(guess>myNumber)
				{
					System.out.println("Your guess is greater than my secret number! Try again.");
				}
				else if(guess==myNumber)
				{
					System.out.println("Congratulations! Your guess is correct!");	
					break;
				}
		}

			return "It took you " +tries+ " tries. Well done!";
				
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
					.compareTo("z") > 0)) 
					
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
												"Oh..."
												};
	
	private String [] randomSadResponses = {"Don't say that!", 
											"That is not true!", 
											"Everything happens for a reason.",
											"Don't lose hope!",
											"It is time to pull yourself together.",
											"Love yourself!",
											"You got this!",
											"It is time to move on.",
											"Everything will pass.",
											"You will be okay. I promise."
											};
	
	private String [] randomHappyResponses = {"I am so glad you feel this way!", 
											"What appears to be the end may really be a new beginning!", 
											"You will be alright",
											"Stay strong! Don't give up.",
											"Smile! You will be in love again with someone much better.",
											"Tomorrow will be better",
											"When you can't look at the bright side, I will sit with you in dark!",
											"Every day is a new day!"};

	private Scanner in;
	
}
