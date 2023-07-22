import java.io.FileNotFoundException;
import java.util.Scanner;

public class DomainChecker
{
	/**
	 * Repeatedly reads a domain interactively from the user and checks to
	 * see if that domain has been blocked.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		DomainBlocker blocker = new DomainBlocker();
		Scanner scan = new Scanner(System.in);

		String domain;
		String input;
		String choice = "y";

		System.out.println("Domain Checker and Editor");

		// Asks user what they want to do
		// Loops until user asks to exit
		while (choice == "y"){
			System.out.println("Choose one: Check, List, Add, Remove, or Exit:");
			input = scan.nextLine();
			// Takes user input and checks it against the blocked list
			// Loops until user says 'Done'
			if (input.equalsIgnoreCase("CHECK")){
				do
				{
					System.out.print("Enter a domain (DONE to quit): ");
					domain = scan.nextLine();

					// Calls method to check blocked list against input
					if (!domain.equalsIgnoreCase("DONE"))
					{
						if (blocker.domainIsBlocked(domain))
							System.out.println("That domain is blocked.");
						else
							System.out.println("That domain is fine.");
					}
				} while (!domain.equalsIgnoreCase("DONE"));
			}
			// Takes user input and shows complete list
			else if (input.equalsIgnoreCase("LIST")){
				blocker.showBlocked();
			}
			// Takes user input and adds desired domain to blocked list
			// Loops until user says 'Done'
			else if (input.equalsIgnoreCase("ADD")){
				do
				{
					System.out.print("Enter a domain to add to blocked list (DONE to quit): ");
					domain = scan.nextLine();
		
					// Calls method to add a domain to blocked list
					if (!domain.equalsIgnoreCase("DONE"))
					{
						if (blocker.domainIsBlocked(domain))
							System.out.println("That domain is already blocked.");
						else{
							blocker.addDomain(domain);
							System.out.println("The domain " + domain + " has been added to the blocked list.");
						}
					}
				} while (!domain.equalsIgnoreCase("DONE"));
			}
			// Takes user input and removes desired domain from blocked list
			// Loops until user says 'Done'
			else if (input.equalsIgnoreCase("REMOVE")){
				do
				{
					System.out.print("Enter a domain to remove from the blocked list(DONE to quit): ");
					domain = scan.nextLine();
		
					// Calls method to remove desired domain from blocked list
					if (!domain.equalsIgnoreCase("DONE"))
					{
						if (blocker.domainIsBlocked(domain)){
							blocker.removeDomain(domain);
							System.out.println("The domain " + domain + " has been removed from the blocked list.");
						}
						else
							System.out.println("That domain is not on the blocked list.");
					}
				} while (!domain.equalsIgnoreCase("DONE"));
			}
			// Breaks loop so user can exit program
			else if(input.equalsIgnoreCase("EXIT")){
				break;
			}
		}
		System.out.println("Bye!");
	}
	
}

