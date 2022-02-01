import java.util.Scanner;

public class Main
{
	static Library lib = new Library();
	Main obj = new Main();
	static Scanner s =new Scanner(System.in);

	public static void admin()
	{
		int input;
		do
		{
			System.out.println("\n\t\t\t                Admin Panel                     ");
			System.out.print("\n\t\t\t\t 1.press 1 to show the Book List");
			System.out.print("\n\t\t\t\t 2.press 2 to add Book");
			System.out.print("\n\t\t\t\t 3.press 3 to remove Book");
			System.out.print("\n\t\t\t\t 4.press 4 to issue a Book");
			System.out.print("\n\t\t\t\t 5.press 5 to return Book");
			System.out.print("\n\t\t\t\t 6.press 6 to EXIT");
			System.out.print("\n\t\t\t\t Enter your choice: ");
			input = s.nextInt();
			switch(input)
			{
				case 1:
					lib.displayLibrary();
					break;
                case 2:
					lib.addBook();
					break;
				case 3: lib.removeBook();
					break;
				case 4: lib.issueBook();
					break;
				case 5:lib.returnBook();
					break;
				case 6:System.exit(1); System.out.println("\n\t\t\t                  Thank You!                  ");
					break;
				default : System.out.println("\n\t\t\t\t\t\t Invalid Choice!");
					break;
					}
		} while(true);
	}

	public static void student()
	{
		int choice;
		do
		{
	    	System.out.println("\n\t\t\t                       Student                           ");
			System.out.print("\n\t\t\t\t 1.press 1 to show the Book list");
			System.out.print("\n\t\t\t\t 2.press 2 to issue a Book");
			System.out.print("\n\t\t\t\t 3.press 3 to return Book");
			System.out.print("\n\t\t\t\t 4.press 4 to EXIT");
			System.out.print("\n\t\t\t\t Enter your choice : ");
			choice = s.nextInt();

			switch(choice)
			{
				case 1:
					admin();
					break;

				case 2:
					student();
					break;
				case 3:
					lib.returnBook();
					break;
				case 4:
					System.exit(1);System.out.println("\n\t\t\t                  Thank You                          ");
				    break;
				default :
					System.out.println("\n\t\t\t\t\t\t Invalid Choice!");
					break;
			}
		}
		while(true);
	}

	public static void main(String args[])
	{
		int input;
		do
		{
			System.out.print("\n\t\t\t\t Welcome to Library \n");
			System.out.print("\n\t\t\t\t 1.press 1 for Admin");
			System.out.print("\n\t\t\t\t 2.press 2 for Student");
			System.out.print("\n\t\t\t\t 3.press 3 to Exit");
			System.out.print("\n\t\t\t\t Enter your choice: ");
			input = s.nextInt();
			switch(input)
			{
				case 1:
					admin();
					break;
				case 2:
					student();
					break;
				case 3:
					System.exit(1);System.out.println("\n\t\t\t                     System Exit!                         ");
					break;
				default :
					System.out.println("\n\t\t\t\t\t\t Invalid Choice!");
					break;
			}
		}
		while(input!=0);
	}
}
