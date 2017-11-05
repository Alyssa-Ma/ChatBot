 
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
	
	public String returnToMainnMenu(String statement) { 
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
	
		
	public String[] SkinDiagnosis()
	{
		String []x= getProducts();
		
		if(age<=18&&findKeyword(condition.toLowerCase(), "oil")>=0)
		{
			System.out.println("You have an oily skin type with " + concern +". For the products recommended, please be cautious as you are still young and your skin is sensitive.");
		}
		
		else if(age>18&&age<40&&findKeyword(condition.toLowerCase(), "oil")>=0)
		{
			System.out.println("You have an oily skin type with " + concern);
		}
		
		else if(age>40&&findKeyword(condition.toLowerCase(), "oil")>=0)
		{
			System.out.println("You have an oily skin type with " + concern +". For the products recommended, please be cautious as your skin has matured and your skin is sensitive. Look for products with anti-aging.");
		}
		
		else if(age<=18&&findKeyword(condition.toLowerCase(), "dry")>=0)
		{
			System.out.println("You have a dry skin type with " + concern +". For the products recommended, please be cautious as you are still young and your skin is sensitive.");
		}
		
		else if(age>18&&age<40&&findKeyword(condition.toLowerCase(), "dry")>=0)
		{
			System.out.println("You have a dry skin type with " + concern);
		}
		
		else if(age>40&&findKeyword(condition.toLowerCase(), "dry")>=0)
		{
			System.out.println("You have a dry skin type with " + concern +". For the products recommended, please be cautious as your skin has matured and your skin is sensitive. Look for products with anti-aging.");
		}
		
		else if(age<=18&&findKeyword(condition.toLowerCase(), "none")>=0)
		{
			System.out.println("You have a normal skin type with " + concern +". For the products recommended, please be cautious as you are still young and your skin is sensitive.");
		}
		
		else if(age>18&&age<40&&findKeyword(condition.toLowerCase(), "none")>=0)
		{
			System.out.println("You have a normal skin type with " + concern);
		}
		
		else if(age>40&&findKeyword(condition.toLowerCase(), "none")>=0)
		{
			System.out.println("You have a normal skin type with " + concern +". For the products recommended, please be cautious as your skin has matured and your skin is sensitive. Look for products with anti-aging.");
		}
		
		else if(age<=18&&findKeyword(condition.toLowerCase(), "both")>=0)
		{
			System.out.println("You have a combination skin type with " + concern +". For the products recommended, please be cautious as you are still young and your skin is sensitive. Also, the products mentioned will still work. Do not mix products based on different skin types.");
		}
		
		else if(age>18&&age<40&&findKeyword(condition.toLowerCase(), "both")>=0)
		{
			System.out.println("You have a combination skin type with " + concern+ ". Also, the products mentioned will still work. Do not mix products based on different skin types.");
		}
		
		else if(age>40&&findKeyword(condition.toLowerCase(), "both")>=0)
		{
			System.out.println("You have a combination skin type with " + concern +". For the products recommended, please be cautious as your skin has matured and your skin is sensitive. Look for products with anti-aging. Also, the products mentioned will still work. Do not mix products based on different skin types.");
		}
		return x;
		
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
	private String[] getProducts ()
	{
		return Products;
	}
	
	private String [] Products = {"Here is my recommended nighttime routine.\r\n" + 
			"Warning:Please take caution when using these products. These products will not work for everyone. Always try a little bit on your skin to see how you react to it first. These products have shown results to many but it may not work for you. Do not expect a miracle. Besides these products, patience and living a healthy lifestyle will improve your skin health and allow the products to work better. \r\n" + 
			"1.Double cleansing is a must especially if you put on makeup. Start off with a cleansing balm or cleansing oil. I recommend using the Heimish All Clean Balm or Manyo Factory Cleansing Oil.\r\n" + 
			"2.After removing all the excess oil, makeup, and dirt off your face, use a gentle low PH cleanser. Low PH cleansers are gentle on the face, since our face generally has a low PH naturally. For oily skin, to avoid breakouts and clogged pores, use a low PH salicylic acid cleanser or other cleansers with BHA (beta hydroxy acids). BHAs help deep cleanse your pores on the inside and remove the dirt from within the pores. Tea tree oil in cleansers also helps calm acne. I recommend the CosrX Salicylic Acid Cleanser or Dr.G Clear Foam Cream. For dry skin types, a cleanser should not strip away your moisture levels and give you that squeaky clean feeling. I recommend the CosrX Low PH Morning Gel Cleanser or the Glossier Milky Jelly Cleanser. For normal skin types, I would recommend just using any cleanser with a low PH and is gentle on your skin. I would recommend the Klavuu Pearl Cleansing Foam. For mature skin types, higher end brands tend to work better because of the anti-aging properties. A very popular anti-aging ingredient is ginseng. This can be seen in the Sulwhasoo cleanser. After cleansing, pat the water in your face. Drying your face with a towel or paper towel is not ideal. You want to make sure your face is hydrated and to avoid transepidermal water loss.\r\n" + 
			"3.Once a week, exfoliate your skin so that your skin will have a smoother surface and so that products can easily penetrate in. Exfoliating helps clear the layer of dead skin cells on your face. Exfoliating too often will cause irritation to the skin. I recommend using SkinFood sugar scrub. However, scrubs can be too sensitive for some people so peeling pads work as well. I recommend NeoGen peeling pads or Dr.Grand+ Milk Moisture Pads. Another option are peeling gels/gommage type exfoliators like the Innisfree Gommage Mask and the Secret Key Lemon Peeling Gel.\r\n" + 
			"4.For oily skin types especially, including a clay mask at this step will help absorb the excess sebum in your pores, make your pores appear smaller, and give your skin a smoother surface. I recommend the Innisfree Mousse Clay Mask or the Glossier Galaxy Mask.\r\n" + 
			"5. After cleansing comes hydration, it is important for every skin type to stay hydrated as it is like drinking water for the body everyday. Apply a toner. Toner helps balance the PH level of your skin and provides extra hydration. I recommend the Pyunkang Yul Essence Toner or the Isntree Hylauronic Acid Toner. Pat this in your face. DO NOT RUB. Use your hands or a cotton pad. When looking for hydrating products look for ingredients like aloe, hylauronic acid, etc. Also look for humectants like glycerin.\r\n" + 
			"4. This step is optional but recommended if your skin is especially dry and dehydrated. I recommend using an essence like the Secret Key essence, SKII essence or Missha essence. Pat this in your face. DO NOT RUB. Use your hands or a cotton pad. \r\n" + 
			"5.The products I am about to mention are not for everyone as these can be extremely sensitive to your skin. Always stick to one of these products at a time to not over stress the skin. Pigmentation/acne scars result from a overproduction of melanin to protect the wound. Therefore, “shedding” the skin layer by layer will help remove that excess melanin. Retinol would be a good ingredient to use. However, please show caution when using this product. Retinol is not for everyone and it could have serious side effects. Retinol also tends to dehydrate your skin. I recommend the Differin Gel. Use at your own discretion. Another ingredient would be Vitamin C. Vitamin C brightens up your complexion, battles pigmentation, and can even out skin tone. I recommend using the Cosrx Triple C Lightning Liquid. For acne, use a clindamycin gel prescribed by a dermatologist. This will help prevent the growth of bacteria as this is what clogs up your pores to begin with that cause acne. \r\n" + 
			"6. Now seal all the products you just put on by using a moisturizer. I recommend using Cosrx snail cream or the Hado Labo hylauronic acid lotion. \r\n" + 
			"7. The last step is eye cream. The eye skin is the thinnest skin on your body. Therefore, using a moisturizer specific to that part of the eye is necessary. I recommend the Innisfree Orchid Eye Cream or the Clinique Eye Cream.\r\n" + 
			"You can remove steps as you wish because there are a lot but these products have shown results.\r\n" 
			
	};
	
}
