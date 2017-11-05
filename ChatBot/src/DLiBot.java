  import java.util.Random;
 import java.util.Scanner;  
/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Daniel Li
 * @version October 2017
 */
public class DLiBot 
{
	String product = "";
	
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
	
	public String Greeting()
	{
		return "Nice to meet you. I am your personal skincare assistant, DermaBot. What is your name?";
	}
	
	String name="";
	
	public String getName(String name)
	{
		while(name.length()<1)
		{return "Please say something. I want to help you, but you need to tell me your name.";}
			
		String response= "Hello, " + name + ". Let's begin by finding out your skin type. What is your age?";
		return response;
	}
	
	int age=0;
	
	public String getAge(int age)
	{
		String confirmation= "";
		while(!confirmation.equals("yes"))
			{	while(age!=(int)age||age<=0)
				{System.out.println("Don't lie to me about your age. I want to help you, but you need to tell me your age.");}
				
				System.out.println("You are " + age + ". Is this correct?");
				Scanner confirmations = new Scanner(System.in);
				confirmation = confirmations.next();
				confirmation= confirmation.toLowerCase();
				
				if(findKeyword(confirmation, "no")>=0)
				{
					System.out.println("Enter your age again.");
					break;
				}
				
			}
		
		return "You are " + age + ". " + name + ", now how would you describe your skin condition. "
				+ "A good way to figure this out is to examine your face after a shower or during the middle of your day."
				+ "If your skin is shiny or oily, tell me your skin is oily. If your skin is dehydrated and/or flakes and/or peels, tell"
				+ " me your skin is dry. If you experience both these symptoms in different parts of your face, say both. If you experience"
				+ "neither, you are lucky and say none.";
	}
	
	String condition= "";
	public String getSkinCondition(String condition)
	{	
		String confirmation= "";
		while(!confirmation.equals("yes"))
			{	while(condition.length()==0)
				{
					System.out.println("Say something please. Please enter one of the options.");
					Scanner conditions = new Scanner(System.in);
					condition = conditions.next();
					condition = condition.toLowerCase();
				}
				
				if(findKeyword(condition.toLowerCase(), "dry")>=0)
				{
					System.out.println("You said that you have " + condition + " Is this correct?");
					Scanner confirmations = new Scanner(System.in);
					confirmation = confirmations.next();
					confirmation= confirmation.toLowerCase();
					if(findKeyword(confirmation, "no")>=0)
					{
						System.out.println("Enter one of the options again.");
						break;
					}
				}
				
				else if(findKeyword(condition.toLowerCase(), "oil")>=0)
				{
					System.out.println("You said that you have " + condition + " Is this correct?");
					Scanner confirmations = new Scanner(System.in);
					confirmation = confirmations.next();
					confirmation= confirmation.toLowerCase();
					if(findKeyword(confirmation, "no")>=0)
					{
						System.out.println("Enter one of the options again.");
						break;
					}
				}
				
				else if(findKeyword(condition.toLowerCase(), "both")>=0)
				{
					System.out.println("You said that you have " + condition + " Is this correct?");
					Scanner confirmations = new Scanner(System.in);
					confirmation = confirmations.next();
					confirmation= confirmation.toLowerCase();
					if(findKeyword(confirmation, "no")>=0)
					{
						System.out.println("Enter one of the options again.");
						break;
					}
				}
				
				else if(findKeyword(condition.toLowerCase(), "none")>=0||findKeyword(condition.toLowerCase(), "neither")>=0)
				{
					System.out.println("You said that you have " + condition + " Is this correct?");
					Scanner confirmations = new Scanner(System.in);
					confirmation = confirmations.next();
					confirmation= confirmation.toLowerCase();
					if(findKeyword(confirmation, "no")>=0)
					{
						System.out.println("Enter one of the options again.");
						break;
					}
				}
				
				else
				{
					System.out.println("I don't understand your response. Please either say oily, dry, both, or none.");
					break;
				}
				
			}
		return "You said that you have" + condition + "." + " Now, what is your primary skin concern. You can say acne, anti aging/wrinkles, dryness, oil/pores, or scarring/pigmentation.";
	}
		
		String concern=" ";
		public String topConcern(String concern)
		{
			String confirmation= " ";
			while(!confirmation.equals("yes"))
				{	while(concern.length()==0)
					{
						System.out.println("Say something please. Please enter one of the options.");
						Scanner concerns = new Scanner(System.in);
						concern = concerns.next();
						concern = concern.toLowerCase();
					}
					
					if(findKeyword(concern.toLowerCase(), "oil")>=0)
					{
						System.out.println("You said that you have " + concern + " Is this correct?");
						Scanner confirmations = new Scanner(System.in);
						confirmation = confirmations.next();
						confirmation= confirmation.toLowerCase();
						if(findKeyword(confirmation, "no")>=0)
						{
							System.out.println("Enter one of the options again.");
							break;
						}
					}
					
					else if(findKeyword(concern.toLowerCase(), "pigment")>=0||findKeyword(concern.toLowerCase(), "scar")>=0)
					{
						System.out.println("You said that you have " + concern + " Is this correct?");
						Scanner confirmations = new Scanner(System.in);
						confirmation = confirmations.next();
						confirmation= confirmation.toLowerCase();
						if(findKeyword(confirmation, "no")>=0)
						{
							System.out.println("Enter one of the options again.");
							break;
						}
					}
					
					else if(findKeyword(condition.toLowerCase(), "acne")>=0)
					{
						System.out.println("You said that you have " + condition + " Is this correct?");
						Scanner confirmations = new Scanner(System.in);
						confirmation = confirmations.next();
						confirmation= confirmation.toLowerCase();
						if(findKeyword(confirmation, "no")>=0)
						{
							System.out.println("Enter one of the options again.");
							break;
						}
					}
					
					else if(findKeyword(condition.toLowerCase(), "wrinkle")>=0||findKeyword(condition.toLowerCase(), "aging")>=0)
					{
						System.out.println("You said that you have " + condition + " Is this correct?");
						Scanner confirmations = new Scanner(System.in);
						confirmation = confirmations.next();
						confirmation= confirmation.toLowerCase();
						if(findKeyword(confirmation, "no")>=0)
						{
							System.out.println("Enter one of the options again.");
							break;
						}
					}
					
					else if(findKeyword(condition.toLowerCase(), "hydration")>=0||findKeyword(condition.toLowerCase(), "dry")>=0)
					{
						System.out.println("You said that you have " + condition + " Is this correct?");
						Scanner confirmations = new Scanner(System.in);
						confirmation = confirmations.next();
						confirmation= confirmation.toLowerCase();
						if(findKeyword(confirmation, "no")>=0)
						{
							System.out.println("Enter one of the options again.");
							break;
						}
					}
					else
					{
						System.out.println("I do not understand your response. What is your primary skin concern? You can say acne, anti aging/wrinkles, dryness, oil/pores, or scarring/pigmentation.");
						break;
					}
				}
			return "You said that you have" + concern + "." + " Now let me use my powers to solve your concerns.";
		}
	
		
	public String SkinDiagnosis()
	{
		if(age<=18&&findKeyword(condition.toLowerCase(), "oil")>=0)
		{
			String product= "oily";
			
			return "You have an oily skin type. For the products recommended, please be cautious as you are still young and your skin is sensitive.";
		}
	}
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	//public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
                	emotion--;
		}
		
		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream amiright?";
			emotion++;
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
		else
		{
			response = getRandomResponse();
		}
		
		return response;
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
	private String getProducts ()
	{
		Random r = new Random ();
		if (product.equals("oily"))
		{	
			System.out.println(NeutralResponses);
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] NeutralResponses = {"1.Double cleansing is a must",
			
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
