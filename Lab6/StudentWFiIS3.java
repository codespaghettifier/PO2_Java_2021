public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    StudentWFiIS3(String firstName, String lastName, int id, int year, Object... args)
    {
        super(firstName, lastName, id, extractGrades(args));

        int rok = year;
        String[] przedmioty = extractCourses(args);

        stud = new StudentUSOS()
        {
            public String toString()
            {
                return "[" + rok + "] ";
            }

            public double srednia()
            {
                return average();
            }

            public void listaPrzedmiotow()
            {
                for(int i = 0; i < przedmioty.length; i++)
                {
                    System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + getGrade(i));
                }
            }
        };
    }

    private static double[] extractGrades(Object... args)
    {
        double[] grades = new double[args.length / 2];
        for(int i = 0; i * 2 + 1 < args.length; i ++)
        {
            grades[i] = (double)args[i * 2 + 1];
        }
        return grades;
    }

    private static String[] extractCourses(Object... args)
    {
        String[] courses = new String[args.length / 2 + args.length % 2];
        for(int i = 0; i * 2 < args.length; i++)
        {
            courses[i] = (String)args[i * 2];
        }
        return courses;
    }

    public String toString()
    {
        return stud.toString() + super.toString();
    }

    public double srednia()
    {
        return stud.srednia();
    }

    public void listaPrzedmiotow()
    {
        stud.listaPrzedmiotow();
    }
}
