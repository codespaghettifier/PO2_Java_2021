import java.util.ArrayList;

public class StudentManagementService
{
    private ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student student)
    {
        if(students.contains(student))
        {
            System.out.println("Student is already in database!");
        }
        else
        {
            students.add(student);
        }
    }

    public void printAllStudents()
    {
        System.out.println("*** Students ***");
        for(int i = 0; i < students.size(); i++)
        {
            System.out.println(students.get(i));
        }
    }

    public void removeStudent(Student student)
    {
        if(students.contains(student))
        {
            students.remove(student);
        }
        else
        {
            System.out.println("Student is not exist in database!");
        }
    }

    public Student findStudentWithTheHighestAverage()
    {
        if(students.size() == 0) return null;

        Student highestAverageStudent = students.get(1);
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getAverage() > highestAverageStudent.getAverage()) highestAverageStudent = students.get(i);
        }

        return highestAverageStudent;
    }
}