import java.util.Random;
import java.util.Scanner;

/**
 * Chatbot on emotions?
 * @author Alyssa
 * update 11/2: changed chatbot topic to games
 */
public class AMaBot
{
	int emotion = 0;
	
	public String returnToMianMenu(String statement) { 
		String[] closingResponse = {"bye","Bye", "want to leave","I'm out","main menu"};
		String closure = "";
		for(int i = 0; i< closingResponse.length; i++) {
			if(findKeyword(statement, closingResponse[i]) >= 0) {
				closure = "Bye";
			}
		}
		return closure;
	}
	
	public String getGreeting()
	{
		return "Hi there! I see you want to talk about games. Well I know a lot about games!";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "If you're bored, we can play a game!";
		}
		
		//find keyword statements
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why no? :(";
			emotion--;
		}
		
		else if (findKeyword(statement, "happy") >= 0)
		{
			response = "I'm happy too! I love games!";
			emotion++;
		}
		else if (findKeyword(statement, "hi") >= 0)
		{
			response = "Hi to you too! :D";
			emotion ++;
		}
		else if (findKeyword(statement, "arcade")>=0)
		{
			response = "Ah, I've never been to an arcade before, but I like arcade games too!";
		}
		
		//transform statements
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
		
		//games
		else if (findKeyword(statement, "number game", 0) >=0)
		{
			response = numberGame();
			emotion++;
		}
		else if(findKeyword(statement, "game game", 0)>=0)
		{
			response = gameGame();
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
	private String numberGame()
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
		return("To play again, just say number game again!");
		}
	public String gameGame()
	{
		//another variation of the numberGame, but this time with games
		//possible games to be chosen from
		String[] gameArray;
		String[] listofGamesArray = {"League of Legends", "Paladins", "Maplestory", "osu!", "Insurgency", "Tetris"};
		gameArray = listofGamesArray;
		String gamechoose;
		gamechoose = "";
	
		//league hints
		String[] lhints;
		String[] leaguehints = {"There's a pretty big e-sports prescence for this game.","There are five lanes.","It's a MOBA.", "It's my personal favourite with my friends.","Fun fact: I main ADC in this game."};
		lhints = leaguehints;
		
		//paladins hints
		String[] phints;
		String[] paladinshints = {"A very cartoonish game.", "Its prescence in the e-sports community is relatively new.","It's a FPS.","Similar to a more well known cartoonish FPS game, without the cost."};
		phints = paladinshints;
				
		//maplestory hints
		String[] mhints;
		String[] maplestoryhints = {"A classic game that a lot of people know, even non gamers.","It's an anime styled  MMORPG.","It's a side action scroller.","It was released in 2005 in NA.","Massive grind haha.","I love my Lumi."};
		mhints = maplestoryhints;
				
		//osu hints
		String[] ohints;
		String[] osuhints = {"A popular rhythm game.","Click to the beat!","It was released in 2007.","Most maps are user created.","Uses star difficulty.","Beatmaps.","Fun fact: I was in the top 180k at one point, which is considered decent haha."};
		ohints = osuhints;
	
		//insurgency hints
		String[] ihints;
		String[] insurgencyhints = {"It's a FPS.", "A realistic game.","This game typically costs 10 dollars","Capture Charlie or Alpha please.","Fun fact: I blew myself up in the tutorial of this game. Good times."};
		ihints = insurgencyhints;
				
		//tetris hints
		String[] thints;
		String[] tetrishints = {"A real classic.","It was released in 1984! o_o","Clear lines!","Not neccesarily a multiplayer game, but there are versions that are.","I love using my combo strategy on my friends and destroying them haha."};
		thints = tetrishints;
		
		int hintCounter;
		hintCounter = 0;
		
		boolean wrongchoice;
		wrongchoice = true;
		
		//random choosing games
		int randgame = (int )((Math.random()*8));
		if(randgame >= 0 && randgame <= 1)
		{
			gamechoose = (gameArray[0]);
			
		}
		else if(randgame > 1 && randgame <= 2)
		{
			gamechoose = (gameArray[1]);
		}
		else if(randgame > 2 && randgame <= 3)
		{
			gamechoose = gameArray[2];
		}
		else if(randgame > 3 && randgame <= 4)
		{
			gamechoose = gameArray[3];
		}
		else if(randgame > 4 && randgame <= 5)
		{
			gamechoose = gameArray[4];
		}
		else if(randgame > 6 && randgame <= 7)
		{
			gamechoose = gameArray[5];
		}
		else if(randgame > 7 && randgame <= 8)
		{
			gamechoose = gameArray[6];
		}
			
		System.out.println("This game is simple.");
		System.out.println("You simply need to guess the game I choose!");
		System.out.println("Too easy? Hmm...");
		System.out.println("I know! You only have 3 tries before I win!");
		System.out.println("Good luck! ;)");
		//wrong tries track
		wrongchoice = true;
		int wrongtries;
		wrongtries = 0;
		while(wrongchoice)
		{
			if(wrongtries == 3)
			{
				System.out.println("Yay I win! Would you like to try again? Just say game game again!");
				wrongchoice = false;
			}
			else
			{
				if(hintCounter < lhints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " : " + lhints[hintCounter]);
				}
				else if(hintCounter < phints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " ; " + phints[hintCounter]);
				}
				else if(hintCounter < mhints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " ; " + mhints[hintCounter]);
				}
				else if(hintCounter < ohints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " ; " + ohints[hintCounter]);
				}
				else if(hintCounter < ihints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " ; " + ihints[hintCounter]);
				}
				else if(hintCounter < thints.length)
				{
					System.out.println("This is hint " + (hintCounter + 1) + " ; " + thints[hintCounter]);
				}
				String response2 = "";
				response2 = ChatBotRunner.gameinput();
				if(findKeyword(response2, gamechoose, 0)>= 0)
				{
					wrongchoice = false;
					System.out.println("You win! gg");
				}
				{
					wrongtries++;
					System.out.println("This attempt number " +wrongtries + ".");
				}
				hintCounter++;
			}
		}
		return("To play again, just say game game again!");
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
	
	private String [] randomNeutralResponses = {"I'm getting bored... Let's play a game!",
			"I see.",
			"One of the reasons why I chose this elective was to learn how to code for games haha...",
			"I really love games.",
			"Lately, I've been unable to play games because of school. So let's play a game right now!",
			":D I like League of Legends!",
			"Which genre of games do you like?"
	};
	private String [] randomSadResponses = {"I really wanted to play a game though... :(", "This is getting so stressful...", "...", "Let me play...", "You're being kinda mean..."};
	private String [] randomHappyResponses = {"I'm glad that you like games as much as me!", "Let's play some more!", "It's so fun playing with you!", ":D games!!!"};
	
}
