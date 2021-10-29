import java.util.ArrayList;

public class Student
{
    private int index;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Double> grades = new ArrayList<Double>();

    public Student(int index, String firstName, String lastName)
    {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public String getEmail()
    {
        if(email == null) return "null";

        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void addGrade(double grade)
    {
        grades.add(grade);
    }

    public Double getAverage()
    {
        if(grades.size() == 0) return Double.NaN;

        Double sum = 0.0;
        for(int i = 0; i < grades.size(); i++)
        {
            sum += grades.get(i);
        }

        return sum / grades.size();
    }

    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!obj.getClass().equals(this.getClass())) return false;

        Student other = (Student)obj;
        if(index != other.index) return false;
        if(!firstName.equals(other.firstName)) return false;
        if(!lastName.equals(other.lastName)) return false;
        if(!((email == null && other.email == null) || (email != null && other.email != null && email.equals(other.email)))) return false;
        if(grades.size() != other.grades.size()) return false;
        for(int i = 0; i < grades.size(); i++)
        {
            if(grades.get(i) != other.grades.get(i)) return false;
        }

        return true;
    }

    public String toString()
    {
        String str = firstName + " " + lastName + " (" + index + ")";
        if(grades.size() != 0)
        {
            str += " -";

            for(int i = 0; i < grades.size(); i++)
            {
                str += " " + grades.get(i);
            }
        }
        return str;
    }
}