import java.util.Arrays;

public class Student
{
    private final int index;
    private final String firstName;
    private final String lastName;
    private final double[] grades;

    private Student(String firstName, String lastName, int index, double[] grades)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
        this.grades = grades;
    }

    public double[] getGrades()
    {
        return Arrays.copyOf(grades, grades.length);
    }

    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!obj.getClass().equals(this.getClass())) return false;

        Student other = (Student)obj;
        if(!firstName.equals(other.firstName)) return false;
        if(!lastName.equals(other.lastName)) return false;
        if(index != other.index) return false;
        
        if(Arrays.mismatch(grades, other.grades) != -1) return false;

        // if(grades.length != other.grades.length) return false;
        // for(int i = 0; i < grades.length; i++)
        // {
        //     if(grades[i] != other.grades[i]) return false;
        // }

        return true;
    }

    public String toString()
    {
        String str = firstName + " " + lastName + " (" + index + ")";
        if(grades.length != 0)
        {
            str += " -";

            for(int i = 0; i < grades.length; i++)
            {
                str += " " + grades[i];
            }
        }
        return str;
    }

    public static class Builder
    {
        private String firstName = null;
        private String lastName = null;
        private int index = 0;
        private double[] grades = new double[0];

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            
            return this;
        }
        public Builder indexNumber(int index)
        {
            this.index = index;
            
            return this;
        }

        public Builder grade(double grade)
        {
            double[] temp = grades;
            grades = new double[temp.length + 1];
            for(int i = 0; i < temp.length; i++)
            {
                grades[i] = temp[i];
            }
            grades[temp.length] = grade;

            return this;
        }
        
        public Student build()
        {
            if(firstName == null)
            {
                System.out.println("First name is required!");
                return null;
            }

            if(lastName == null)
            {
                System.out.println("Last name is required!");
                return null;
            }

            if(index == 0)
            {
                System.out.println("Index number is required!");
                return null;
            }

            return new Student(firstName, lastName, index, grades);
        }
    }
}