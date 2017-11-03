import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	
	public static void main(String[] args)
	{
		String statement;
		System.out.println("Good Morning!");
		Scanner main = new Scanner(System.in);
		String morning = main.nextLine();
		
		while(morning.length()>0 || statement.equals("Bye")){
			System.out.println("Hello, welcome to the main menu!\n0. Exit\n1.Potato\n2.Potato\n3.Potato\n4. Potato\nPlease pick a selection: ");
			Scanner selection = new Scanner(System.in);
			String choice = selection.nextLine();
			
			switch(choice) {
				case "0":
					
					break;
				case "1":
					
					break;
				case "2":
					
					break;
			}
		
		}
		
		
		LZouBot chatbot1 = new LZouBot();
		
		System.out.println (chatbot1.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
		
	}
	public static String gameinput()
	{
		Scanner ga = new Scanner(System.in);
		return ga.nextLine();
	}
}
