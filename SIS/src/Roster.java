import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Roster
	{
		static ArrayList<Student> roster = new ArrayList<Student>();	
		
		public static void fillRoster() throws IOException
			{
				Scanner myFile = new Scanner(new File("Class.txt"));
				
				while(myFile.hasNextLine())
					{
						String line = myFile.nextLine();
						
						String [] studentAtributes = line.split(" ");
						
						roster.add(new Student(studentAtributes[0], studentAtributes[1], 
								studentAtributes[2], studentAtributes[3], studentAtributes[4],
								studentAtributes[5], studentAtributes[6], studentAtributes[7],
								calGpa(studentAtributes[3], studentAtributes[5], studentAtributes[7])));
					}
			}
					

				public static String calGpa(String a, String b, String c)
				{
			
					double gradePoint = 0;
					String[] grades = {a,b,c};
					
					for (int i = 0; i < grades.length; i++) {
						if (grades[i].equals("A+") || grades[i].equals("A")) gradePoint += 4.;
						else if (grades[i].equals("A-")) gradePoint += 3.67;
						else if (grades[i].equals("B+")) gradePoint += 3.33;
						else if (grades[i].equals("B")) gradePoint += 3.;
						else if (grades[i].equals("B-")) gradePoint += 2.67;
						else if (grades[i].equals("C+")) gradePoint += 2.33;
						else if (grades[i].equals("C")) gradePoint += 2.;
						else if (grades[i].equals("C-")) gradePoint += 1.67;
						else if (grades[i].equals("D+")) gradePoint += 1.33;
						else if (grades[i].equals("D")) gradePoint += 1.;
						else if (grades[i].equals("D-")) gradePoint += .67;
					}
				
					double gpa = (gradePoint) / 3;
					DecimalFormat d = new DecimalFormat("0.00");
					
					return d.format(gpa);
			}				

	
				public static void printRoster()
				{
					
					// Format for the table
					String tableFormat = format("| %-2d | %-8s | %-10s | %-7s | %-2s | %-7s | %-2s | %-7s | %-2s | %-4s |%n");
					final String a = "\u2502";
					System.out.println(format("a====b==========b============b=========b====b=========b====b=========b====b======c"));
					System.out.println("\u001B[1m" + format(a)+" ID "+format(a)+"First Name"+format(a)+" Last Name  "+format(a)
					+" Class 1 "+format(a)+"Grd "+format(a)
					+" Class 2 "+format(a)+"Grd "+format(a)
					+" Class 3 "+format(a)+"Grd "+format(a)
					+" GPA  "+format(a) + "\u001B[0m");
					System.out.println(format("j====e==========e============e=========e====e=========e====e=========e====e======f"));

					for(int i =0; i < roster.size(); i++)
						{
						System.out.printf(tableFormat,i+1,roster.get(i).getFirstName(),roster.get(i).getLastName(),
								roster.get(i).getFirstClass(),roster.get(i).getFirstGrade(),
								roster.get(i).getSecondClass(),roster.get(i).getSecondGrade(),
								roster.get(i).getThirdClass(),roster.get(i).getThirdGrade(),
								roster.get(i).getGPA());
						}
					System.out.println(format("g====h==========h============h=========h====h=========h====h=========h====h======i"));
				}
				
				private static String format(String string) {
					return string.replace("a", "\u250c")
							.replace("b", "\u252c")
							.replace("c", "\u2510")
							.replace('j', '\u251c')
			                .replace('e', '\u253c')
			                .replace('f', '\u2524')
			                .replace('g', '\u2514')
			                .replace('h', '\u2534')
			                .replace('i', '\u2518')
							.replace("=", "\u2500")
							.replace('|', '\u2502');
				}


				public static void resetRoster() throws IOException {
					for (int i = 0; i < roster.size();) {
						roster.remove(i);
					}
					fillRoster();
				}
				
// Fake pull request 4

}
