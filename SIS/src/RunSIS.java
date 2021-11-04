import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.IOException;

public class RunSIS {

	// Random comment
	public static void main(String[] args) throws IOException
		{
		
		
		Roster.fillRoster();
		
		//displaymenu
		boolean editing = true;
		do {
			switch (MainMenu.mainMenu()) {
			case 1: 
				switch (addDeleteStudent.addOrDeletePrompt()) {
				case 1: addDeleteStudent.addStudent(); break;
				case 2: addDeleteStudent.delStudent(); break;
				}
				break;
			case 2: 
				switch (ChangeGrades.gradesOrSchedulePrompt()) {
				case 1: ChangeGrades.changeGrades(); break;
				case 2: ChangeGrades.switchClasses(); break;
				case 3: ChangeGrades.changeAllGrades(); break;
				}
				break;
			case 3: 
				switch (SortStudents.prompt()) {
				case 1: Roster.roster.sort(Comparator.comparing(Student::getLastName)); break;
//					Collections.sort(Roster.roster, new LastNameComparator()); 
				case 2: Roster.roster.sort(Comparator.comparing(Student::getGPA).reversed()); break;
//					Collections.sort(Roster.roster, new GpaComparator()); break;
				case 3: 
					switch (SortStudents.classSorterPrompt()) {
					case 1: Roster.roster.sort(Comparator.comparing(Student::getFirstClass).thenComparing(Student::getLastName)); break;
					case 2: Roster.roster.sort(Comparator.comparing(Student::getSecondClass).thenComparing(Student::getLastName)); break;
					case 3: Roster.roster.sort(Comparator.comparing(Student::getThirdClass).thenComparing(Student::getLastName)); break;
					}
					break; 
				}
				System.out.println("Do you want to print the roster? (y/n)");
				Scanner userInput = new Scanner(System.in);
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
				break;
			case 4: Roster.printRoster(); break;
			case 5: Roster.resetRoster(); break;
			case 6: editing = false; break;
			}
		} while (editing);
		System.out.println("\nExiting...");
		
	}
}

