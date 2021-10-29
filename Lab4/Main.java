import java.util.Arrays;

class Main {

	public static void main(String[] args) 
	{
        Student studentAdam = new Student.Builder()
            .firstName("Adam")
            .lastName("Abacki")
            .indexNumber(123456)
            .grade(5.0)
            .grade(3.5)
            .build();

        System.out.println(studentAdam);

        // Student student = new Student("Tomasz", "Babacki", 123456); //nie powinno się skompilować
        double grades[] = studentAdam.getGrades();
        grades[0] = 2.0;
        System.out.println(Arrays.toString(grades));
        System.out.println(studentAdam);

        Student studentJacek = new Student.Builder()
            .firstName("Jacek")
            .lastName("Cacki")
            .indexNumber(777777)
            .build();

        System.out.println(studentJacek);

        Student studentAntoni = new Student.Builder()
            .firstName("Antoni")
            .indexNumber(321321)
            .build();

        Student studentJacek2 = new Student.Builder()
            .firstName("Jacek")
            .lastName("Cacki")
            .indexNumber(777777)
            .build();

        System.out.println("studentJacek == studentJacek2: " + (studentJacek == studentJacek2));
        System.out.println("studentJacek.equals(studentJacek2): " + studentJacek.equals(studentJacek2));
    }

}