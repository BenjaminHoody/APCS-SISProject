import java.util.*;
import java.io.*;

public class ChangeGrades {

	public static int gradesOrSchedulePrompt() {
		System.out.println("\nChange Student Grades/Schedule"
				+ "\n\t(1) Change Grade"
				+ "\n\t(2) Switch Classes"
				+ "\n\t(3) Change everyones grade in a class!");
		Scanner userInput = new Scanner(System.in);
		return MainMenu.inputChecks(userInput, 3, 1);
		
	}
	
	public static void changeGrades() {
		System.out.println("\nSelect a Student");
		for (int i=0;i<Roster.roster.size();i++) {
			System.out.println("\t(" + (i+1) + ") " + Roster.roster.get(i).getFirstName() + " " + Roster.roster.get(i).getLastName());
		}
		Scanner userInput = new Scanner(System.in);
		// Do Input Checks!!
		String input = userInput.nextLine();
		if (input.toLowerCase().equals("e")) {
			System.out.println("\nExiting...");
			System.exit(0);
		}
		int studentNum = Integer.parseInt(input);
		
		System.out.println("\nSelect a Class");
		System.out.println("\t(1) " + Roster.roster.get(studentNum-1).getFirstClass()
				+ "\n\t(2) " + Roster.roster.get(studentNum-1).getSecondClass()
				+ "\n\t(3) " + Roster.roster.get(studentNum-1).getThirdClass());
		switch (MainMenu.inputChecks(userInput, 3, 1)) {
		case 1: 
			System.out.println("Enter the new " + Roster.roster.get(studentNum-1).getFirstClass() + " grade here");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setFirstGrade(userInput.nextLine());
			break;
		case 2: 
			System.out.println("Enter the new " + Roster.roster.get(studentNum-1).getSecondClass() + " grade here");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setSecondGrade(userInput.nextLine());
			break;
		case 3: 
			System.out.println("Enter the new " + Roster.roster.get(studentNum-1).getThirdClass() + " grade here");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setThirdGrade(userInput.nextLine());
			break;
		}
		
		Roster.roster.get(studentNum-1).setGPA(Roster.calGpa(Roster.roster.get(studentNum-1).getFirstGrade(), Roster.roster.get(studentNum-1).getSecondGrade(), Roster.roster.get(studentNum-1).getThirdGrade()));
	}
	
	public static void changeAllGrades()
	{
		System.out.println("\nSelect a Class");
		String grade;
		System.out.println("\t(1) Algebra"
				+ "\n\t(2) Biology"
				+ "\n\t(3) English");
		
		Scanner userInput = new Scanner(System.in);

		switch (MainMenu.inputChecks(userInput, 3, 1)) {
		case 1: 
			System.out.println("Enter the grade you want everyone to have here");
			// Do Input Checks!!
			grade = userInput.nextLine();
			for(int i = 0; i < Roster.roster.size(); i++)
				{
					if(Roster.roster.get(i).getFirstClass().equals("Algebra"))
						{
							Roster.roster.get(i).setFirstGrade(grade);
						}
					else if(Roster.roster.get(i).getSecondClass().equals("Algebra"))
						{
							Roster.roster.get(i).setSecondGrade(grade);
						}
					else if(Roster.roster.get(i).getThirdClass().equals("Algebra"))
						{
							Roster.roster.get(i).setThirdGrade(grade);
						}
				}
			break;
		case 2: 
			System.out.println("Enter the grade you want everyone to have here");
			// Do Input Checks!!
			grade = userInput.nextLine();
			for(int i = 0; i < Roster.roster.size(); i++)
				{
					if(Roster.roster.get(i).getFirstClass().equals("Biology"))
						{
							Roster.roster.get(i).setFirstGrade(grade);
						}
					else if(Roster.roster.get(i).getSecondClass().equals("Biology"))
						{
							Roster.roster.get(i).setSecondGrade(grade);
						}
					else if(Roster.roster.get(i).getThirdClass().equals("Biology"))
						{
							Roster.roster.get(i).setThirdGrade(grade);
						}
				}
			break;
		case 3: 
			System.out.println("Enter the grade you want everyone to have here");
			// Do Input Checks!!
			grade = userInput.nextLine();
			for(int i = 0; i < Roster.roster.size(); i++)
				{
					if(Roster.roster.get(i).getFirstClass().equals("English"))
						{
							Roster.roster.get(i).setFirstGrade(grade);
						}
					else if(Roster.roster.get(i).getSecondClass().equals("English"))
						{
							Roster.roster.get(i).setSecondGrade(grade);
						}
					else if(Roster.roster.get(i).getThirdClass().equals("English"))
						{
							Roster.roster.get(i).setThirdGrade(grade);
						}
				}
			break;	
		}
		
		for(int i = 0; i < Roster.roster.size(); i++)
			{
				Roster.roster.get(i).setGPA(Roster.calGpa(Roster.roster.get(i).getFirstGrade(), Roster.roster.get(i).getSecondGrade(), Roster.roster.get(i).getThirdGrade()));
			}
		
		System.out.println("Do you want to print the roster? (y/n)");
		boolean entering = true;
		do {
			String yesOrNo = userInput.nextLine().toLowerCase();
			if (yesOrNo.equals("y")) {
				Roster.printRoster();
				entering = false;
			}
			else if (!yesOrNo.equals("n") && !yesOrNo.equals("y")) {
				System.out.println("Please only enter the letters \"y\" or \"n\".");
			}
			else {
				entering = false;
			}
		} while (entering);
		
	}
	
	public static void switchClasses() {
		System.out.println("\nSelect a Student");
		for (int i=0;i<Roster.roster.size();i++) {
			System.out.println("\t(" + (i+1) + ") " + Roster.roster.get(i).getFirstName() + " " + Roster.roster.get(i).getLastName());
		}
		Scanner userInput = new Scanner(System.in);
		// Do Input Checks!!
		String input = userInput.nextLine();
		if (input.toLowerCase().equals("e")) {
			System.out.println("\nExiting...");
			System.exit(0);
		}
		int studentNum = Integer.parseInt(input);
		
		System.out.println("\nSelect a Class to Change");
		System.out.println("\t(1) " + Roster.roster.get(studentNum-1).getFirstClass()
				+ "\n\t(2) " + Roster.roster.get(studentNum-1).getSecondClass()
				+ "\n\t(3) " + Roster.roster.get(studentNum-1).getThirdClass());
		switch (MainMenu.inputChecks(userInput, 3, 1)) {
		case 1:
			System.out.println("Enter the new class here:");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setFirstClass(userInput.nextLine());
			break;
		case 2: 
			System.out.println("Enter the new class here:");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setSecondClass(userInput.nextLine());
			break;
		case 3: 
			System.out.println("Enter the new class here:");
			// Do Input Checks!!
			Roster.roster.get(studentNum-1).setThirdClass(userInput.nextLine());
			break;
		}
	}
}
