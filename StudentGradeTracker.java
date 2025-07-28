import java.util.*;
public class StudentGradeTracker
{
        public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < numStudents; i++)
        {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            Student s = new Student(name);

            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();

            for (int j = 0; j < numSubjects; j++)
            {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                int mark = sc.nextInt();
                s.addMark(mark);
            }

            sc.nextLine(); 
            students.add(s);
        }

        System.out.println("\n==== Summary Report ====");
        for (Student s : students)
        {
            System.out.println("Name: " + s.name);
            System.out.println("Average Score: " + s.getAverage());
            System.out.println("Highest Score: " + s.getHighest());
            System.out.println("Lowest Score: " + s.getLowest());
            System.out.println("------------------------");
        }
        sc.close();
    }
}