public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    StudentWFiIS2(String firstName, String lastName, int id, int year, Object... args)
    {
        rok = year;
        przedmioty = extractCourses(args);
        stud = new Student(firstName, lastName, id, extractGrades(args));
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
        return "[" + rok + "] " + stud.toString();
    }

    public double srednia()
    {
        return stud.average();
    }

    public void listaPrzedmiotow()
    {
        for(int i = 0; i < przedmioty.length; i++)
        {
            System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + stud.getGrade(i));
        }
    }
}
