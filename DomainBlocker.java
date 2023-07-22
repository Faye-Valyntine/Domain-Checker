import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A URL domain blocker.
 * 
 * @author Skyler Barringer
 * 5/18/23
 */
public class DomainBlocker
{
	private TreeSet<String> blockedSet;
	
	/**
	 * Sets up the domain blocker by reading in the blocked domain names from
	 * a file and storing them in a TreeSet.
	 * @throws FileNotFoundException
	 */
	public DomainBlocker() throws FileNotFoundException
	{
		blockedSet = new TreeSet<String>();
		
		File inputFile = new File("blockedDomains.txt");
		Scanner scan = new Scanner(inputFile);
		
		while (scan.hasNextLine())
		{
			blockedSet.add(scan.nextLine());
		}
	}
	
	// Method that shows complete list of blocked domains
	public void showBlocked(){
		for (String set : blockedSet){
			System.out.println(set);
		}
	}

	// Method that creates a file writer and adds the domain to the .txt file
	public void domainAdd(String domain){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("blockedDomains.txt"));
			for(String set : blockedSet){
				bufferedWriter.write(set + "\n");
			}
			bufferedWriter.write(domain);
			bufferedWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}

	// Method that creates a file writer 
	// and removes the domain from the .txt file and blockedSet
	public void domainRemove(String domain){
		blockedSet.remove(domain);
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("blockedDomains.txt"));
			for(String set : blockedSet){
				bufferedWriter.write(set + "\n");
			}
			bufferedWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Checks to see if the specified domain has been blocked.
	 * 
	 * @param domain the domain to be checked
	 * @return true if the domain is blocked and false otherwise
	 */
	public boolean domainIsBlocked(String domain)
	{
		return blockedSet.contains(domain);
	}

	// Calls method that adds domain to blockedSet TreeSet
	// and edits .txt file
	public boolean addDomain(String domain){
		domainAdd(domain);
		return blockedSet.add(domain);
	}

	// Calls method that removes domain from blockedSet TreeSet
	// and edits .txt file
	public boolean removeDomain(String domain){
		domainRemove(domain);
		return blockedSet.remove(domain);
	}
}
