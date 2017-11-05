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
		String statement = "";
		System.out.println("Good Morning!");
		Scanner main = new Scanner(System.in);
		String welcome = main.nextLine();
		int i = 0;
		i= welcome.length();
		String closure ="" ;
		
		while( i > 0 || closure.equals("Bye")){
			System.out.print("Welcome to the main menu! Please pick a selection for the chat bot you wish to speak to. \nTo return to the main menu, please say your good byes to the chatbot first!\n\n0. Exit\n1. Mean Bot\n2. Gamer Info Bot\n3. Relationship Breakup Bot\n4. DermaBot\n\nSelection: ");
			Scanner selection = new Scanner(System.in);
			String choice = selection.nextLine();
			closure = "";
			switch(choice) {
				case "0":
					System.out.println("Until Next Time!!!");
				    i = 0;
					statement = "Bye";
					break;
				case "1":
					//i=0;
					LLiBot chatbot1 = new LLiBot();
					
					System.out.println (chatbot1.getGreeting());
					Scanner in = new Scanner (System.in);
					statement = in.nextLine();
					while (!closure.equals("Bye"))
					{
						System.out.println (chatbot1.getResponse(statement));
						statement = in.nextLine();
						closure = chatbot1.returnToMianMenu(statement);
					}
					break;
				case "2":
					AMaBot chatbot3 = new AMaBot();
					
					System.out.println (chatbot3.getGreeting());
				    in = new Scanner (System.in);
					statement = in.nextLine();
					while (!closure.equals("Bye"))
					{
						System.out.println (chatbot3.getResponse(statement));
						statement = in.nextLine();
						closure = chatbot3.returnToMianMenu(statement);
					}
					break;
				case "3":
					LZouBot chatbot4 = new LZouBot();
					
					System.out.println (chatbot4.getGreeting());
				    in = new Scanner (System.in);
					statement = in.nextLine();
					while (!closure.equals("Bye"))
					{
						System.out.println (chatbot4.getResponse(statement));
						statement = in.nextLine();
						closure = chatbot4.returnToMianMenu(statement);
					}	
					break;
				case "4":
					DLiBot chatbot2 = new DLiBot();
					
					System.out.println (chatbot2.Greeting());
				    in = new Scanner (System.in);
					statement = in.nextLine();
					while (!closure.equals("Bye"))
					{
						System.out.println (chatbot2.getSkinCondition(statement));
						statement = in.nextLine();
						closure = chatbot2.returnToMianMenu(statement);
					}
					break;	
			}
		
		}
		
		main.close();
	}
	public static String gameinput()
	{
		Scanner ga = new Scanner(System.in);
		return ga.nextLine();
	}
}
