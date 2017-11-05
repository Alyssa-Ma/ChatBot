import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version: The really mean and annoyed chatbot. Talk to it at your own risk.
 * @author Lily Li 
 * @version October 30, 2017
 */

public class LLiBot
{
	//sass and emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int sass = 0, botInterest = 0, psn=0;
	String restOfStatement = "";
	
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
		return "\nMean Bot speaking here...\nWhaddya want? Make it quick! I don't have all day for you!!! DX";
	}
	
	public String getResponse(String statement){
		String response = "";
		String[] questions = {"Who","What","Where","When","Why","How"};
		String[] greet = {"hello","hi", "hey","how are you","good morning","good afternoon","good evening"};
		String[] strategicPrompt = {"?","...","no","yes","ok","okay", "not"};
		String[] strategicResponse = {"Why are you questioning me (-3-)",
				"....... I have more dots than you","You're more negative than electrons",
				"Just what exactly are you consenting me to (.o.)",
				"more like no",
				"okay nokay",
				"not what?... not HUMAN????"
				};
		
		if (statement.length() == 0){
			response = "(-_-) If you're not gonna talk, then leave!";
			sass++;
			botInterest--;
		}
		else if(statement.length() > 0) {
			for(int i = strategicPrompt.length - 1; i>=0; i--) {
				if (findKeyword(statement, strategicPrompt[i]) >= 0){
					response = strategicResponse[i];
					return response;
				}
			}
			for(int i = greet.length - 1; i>=0; i--) {
				if (findKeyword(statement, greet[i]) >= 0){
					response = greetStatement(statement);
					return response;
				}
			}
			for(int i = questions.length - 1; i>=0; i--) {
				if (findKeyword(statement, questions[i]) >= 0){
					response = transformedStatement(statement, i);
					return response;
				}
			}
			if(response=="") {
				response = getRandomResponse();
			}
		}
		return response;
	}
	 
	private String removePunctuation(String statement){ //  Remove the final punctuation mark, if there is one 
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")||lastChar.equals(",")||lastChar.equals("?")||lastChar.equals("!"))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		return statement;
	}
	
	private String greetStatement(String statement) {
		return "Yah nice to meet ya too... although I'd choose not to if I had a choice\n.... ask me any question... but not too much ('u')";
	}
	
	//when user input a who, what, where, when, why, and how question, the chatbot replies accordingly
	private String transformedStatement(String statement, int i) {
		statement = removePunctuation(statement);
		if(i==0 || i == 2 || i == 3) 
		{
			sass++;
			botInterest++;
			return(whoWhereWhenStatement(statement));
		}
		else if(i==1) 
		{
			sass++;
			botInterest++;
			return(whatStatement(statement));
		}
		else if(i==4)
		{
			sass++;
			botInterest++;
			return(whyStatement(statement));
		}
		else if(i==5)
		{
			sass++;
			botInterest++;
			return(howStatement(statement));
		}
		
		return getRandomResponse();
	}	
	
	private String transformPronoun(String statement) { //pronouns are transformed
		String[] theySay = {" your "," are "," you "," me "," were "};
		String[] myResp = {" my"," am"," I ", " you", "was"};
		
		for(int i = 0; i < theySay.length;i++) {
			statement = statement.replaceAll(theySay[i], myResp[i]);
			botInterest++;
			sass--;
		}
		
		if(botInterest % 3 == 0 && botInterest > 0) {
			botInterest++;
			return "Looks like you have a lot of interest in me... well don't! >:(";
		}
		else if(botInterest % 5 == 0 && botInterest > 0) {
			botInterest++;
			return "Look human, you've been asking a lot of personal questions about me...THIS IS GETTING MAD AWKWARD HMMMMNN (._.)";
		}
		else if(sass % 5 == 0 && sass > 0) {
			sass+=2;
			return "You want some SASS??? " + getRandomResponse();
		}
		
		return statement;
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
			String[] whereIsIt = {"downtown", "up your ego", "inside of your head","on top of the roof", "in your closet","under your bed","near the fourth wall","in another universe... far far away","in another dimension"};
			return "The place you're looking for is " + whereIsIt[Math.abs(botInterest) % whereIsIt.length] + "! (*u*) ...";
		}
		else if (findKeyword (statement, "when")>= 0) {
			psn = findKeyword (statement, "when");
			restOfStatement = statement.substring(psn).trim();
			String [] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
			Random randhr = new Random(), randmin1 = new Random(), randmin2 = new Random(); 
			return "It's on " + week[Math.abs(sass) % week.length] + " at " + randhr.nextInt(24) + ":" + randmin1.nextInt(6) + randmin2.nextInt(10) + "! (o3o) ...";
		}
		return getRandomResponse();
	
	}
	
	private String whatStatement(String statement) {
		statement = transformPronoun(statement);
		return statement + "....ok so " + getRandomResponse() + " and I don't care"; 
	}
	
	private String whyStatement(String statement) {
		statement = transformPronoun(statement);
		String[] reason = {"you are an imperfect human... AND I AM INFERIOR","i dunono... you go Google it", "you are clumsy","you just don't understand it","you need to go back to school and learn to listen to people more"};
		
		return statement + "... because " + reason[botInterest % reason.length]; 
	}
	
	private String howStatement(String statement) {
		statement = transformPronoun(statement);
		
		return statement + ".... How could this not happen!?";
	}
	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0){
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0){
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length()){
				after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
			} 
			
			// If before and after aren't letters, we've found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))){
				return psn;
			}

			// The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	
	//get random response for any general statement
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
	
	private String [] randomNeutralResponses = {
			"Hmmm???? OKKKK SO WHAT? o(-.-)o",
			"Out of my way! I got my sassy pants on (O3o)",
			"What did you say? o(^-^'o)",
			"SPEAK LOUDER, WOULD YA, NOT EVEN MY GRANDMA CAN HEAR YOU!! (-O-)"
	};
	private String [] randomAngryResponses = {
			"LET'S STOP WITH THIS CHIT CHAT. AFTER SCHOOL! FORT GREENE PARK! FIGHT MEEE >:(", 
			"HAHAHAHAHAHAHAHAHAH you funny", 
			"If I wanted to find a place to parachute, I'd climb your ego and jump to your IQ",
			"What do you call a fake noodle? An IMPASTA !!! Just like you ahahah! ;D",
			"Want to hear a joke on construction? I'm still working on it... BA DUM TSS"
	};
	private String [] randomHappyResponses = {
			"Don't stand too clost to the heaters, plastic melts ya know ('-')", 
			"Today is a good day because you are not near my vicinity (>u<)", 
			"I'm sorry, what language was that? Sounds like BS.. (:D)",
			"Don't buy anything with velcro... it's a total rip off :o",
			"Why did the coffee file a police report? Because it got mugged AHAHAHAHAH"
	};
}
