import java.util.Scanner;
import java.util.ArrayList;

public class ABMain {

	public static Scanner input = new Scanner(System.in);
	public static ArrayList<ABEntry> myAddresses = new ArrayList<>();
	private static final String[] mainOptions = {"1. Add contact","2. Remove contact","3. Search for contact","4. Print all","5. Delete all","6. Quit"};
	private static final String[] searchOptions = {"1. Search by first name","2. Search by last name","3. Search by phone number","4. Search by email address","5. Return to main menu"};
	private static final String hRule = "--------------------";
	
	public static void main(String[] args) {

		boolean notDone = true;
		
		do {
			switch (getOption(mainOptions)) {
				case 1:
					abAdd();
					break;
				case 2:
					abRemove();
					break;
				case 3:
					abSearch();
					break;
				case 4:
					abPrint();
					break;
				case 5:
					abClear();
					break;
				case 6:
					System.out.println("Thanks for using the address book. See you soon!");
					notDone = false;
					input.close();
			}

		} while (notDone);

	}
	
	public static void abAdd() {
		
		System.out.println("Adding new entry ...\nPlease enter the contact's email address:");

		String email = input.nextLine().toLowerCase();

		for (ABEntry contact : myAddresses) {
			if (contact.getEmail().equals(email)) {
				System.out.println("Error: A contact with this email address is already in your book.");
				return;
			}
		}

		System.out.println("Please enter the contact's first name:");
		String fName = input.nextLine();
		System.out.println("Please enter the contact's last name:");
		String lName = input.nextLine();
		System.out.println("Please enter the contact's phone number:");
		String phone = input.nextLine();
		
		ABEntry addContact = new ABEntry(fName, lName, phone, email);
		myAddresses.add(addContact);
		
		System.out.println("This contact has been added:\n" + hRule + "\n" + addContact.toString() + "\n" + hRule);

	}
	
	public static void abRemove() {

		if (myAddresses.isEmpty()) {
			noContacts();
			return;
		}
		
		int i = 0;
		String query = "";
		boolean found = false;
		
		System.out.println("Select the email address for the contact you wish to remove:");
		query = input.nextLine();

		for (ABEntry contact : myAddresses) {
			if (contact.getEmail().equals(query)) {
				found = true;
				myAddresses.remove(i);
				System.out.println("This entry has been removed:\n" + hRule + "\n" + contact.toString() + "\n" + hRule);
				break;
			}
			i++;
		}

		if (!found) System.out.println("No contact with that email address was found. Enter \"4\" to see all contacts.");
		
	}
	
	public static void abSearch() {
		
		if (myAddresses.isEmpty()) {
			noContacts();
			return;
		}
				
		boolean wasFound = false;
		int searchType = getOption(searchOptions);
		
		if (searchType == 5) return;
		
		System.out.println("Search for records that begin with:");
		String query = input.nextLine().toLowerCase();
		
		for (ABEntry contact : myAddresses) {
			switch (searchType) {
			case 1:
				if (contact.getfName().toLowerCase().startsWith(query)) {
					System.out.println(hRule + "\n" + contact.toString());
					wasFound = true;
				}
				break;
			case 2:
				if (contact.getlName().toLowerCase().startsWith(query)) {
					System.out.println(hRule + "\n" + contact.toString());
					wasFound = true;
				}
				break;
			case 3:
				if (contact.getPhone().startsWith(query)) {
					System.out.println(hRule + "\n" + contact.toString());
					wasFound = true;
				}
				break;
			case 4:
				if (contact.getEmail().startsWith(query)) {
					System.out.println(hRule + "\n" + contact.toString());
					wasFound = true;
				}
				break;
			}
		}

		System.out.println(wasFound ? hRule : "No contacts found matching your query.");

	}

	public static void abPrint() {

		if (myAddresses.isEmpty()) {
			noContacts();
			return;
		}

		for (ABEntry contact : myAddresses) {
			System.out.println(hRule + "\n" + contact.toString());
		}

		System.out.println(hRule);

	}
	
	public static void abClear() {

		if (myAddresses.isEmpty()) {
			noContacts();
			return;
		}
		
		myAddresses.clear();
		System.out.println("All contacts removed.");			

	}
	
	public static int getOption(String[] options) {
		
		int option = 0;

		for (String item : options) System.out.println(item);
		
		System.out.println("Please enter your selection:");
		
		do {
			
			try {
				option = Integer.parseInt(input.nextLine());
				if (option > 0 && option <= options.length) break;
			} catch (Exception e) {}

			System.out.println("Invalid selection. Please try again.");

		} while (true);
		
		return option;

	}
	
	public static void noContacts() {
		System.out.println("No contacts in your list.");
	}
	
}
