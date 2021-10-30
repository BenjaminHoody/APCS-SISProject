import java.util.Scanner;

public class addDeleteStudent {

	public static int addOrDeletePrompt() {
		System.out.println("\nAdd or Delete a Student"
				+ "\n\t(1) Add Student"
				+ "\n\t(2) Delete Student");
		Scanner userInput = new Scanner(System.in);
		return Kaitlyn.inputChecks(userInput, 2, 1);
		
	}
	
	public static void addStudent() {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("\nEnter the student's first name.");
		String fn = userInput.nextLine();
		System.out.println("\nEnter the student's last name.");
		String ln = userInput.nextLine();
		System.out.println("\nEnter the student's first class.");
		String fc = userInput.nextLine();
		System.out.println("\nEnter the student's grade for the first class.");
		String fg = userInput.nextLine();
		System.out.println("\nEnter the student's second class.");
		String sc = userInput.nextLine();
		System.out.println("\nEnter the student's grade for the second class.");
		String sg = userInput.nextLine();
		System.out.println("\nEnter the student's third class.");
		String tc = userInput.nextLine();
		System.out.println("\nEnter the student's grade for the third class.");
		String tg = userInput.nextLine();
		String gpa = Roster.calGpa(fg, sg, tg);
		
		Roster.roster.add(new Student(fn,ln,fc,fg,sc,sg,tc,tg,gpa));
		System.out.println("\nAdded " + Roster.roster.get(Roster.roster.size()-1).getFirstName() + " " + Roster.roster.get(Roster.roster.size()-1).getLastName());
		
	}
	
	public static void delStudent() {
		System.out.println("\nSelect a Student");
		for (int i=0;i<Roster.roster.size();i++) {
			System.out.println("\t(" + (i+1) + ") " + Roster.roster.get(i).getFirstName() + " " + Roster.roster.get(i).getLastName());
		}
		Scanner userInput = new Scanner(System.in);
		// Do Input Checks!!
		int studentNum = userInput.nextInt();
		userInput.nextLine();
		
		System.out.println("Removed " + Roster.roster.get(studentNum-1).getFirstName() + " " + Roster.roster.get(studentNum-1).getLastName() + ".");
		Roster.roster.remove(studentNum-1);
	}
}