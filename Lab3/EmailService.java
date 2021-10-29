public class EmailService
{
    public void generateEmailForStudent(Student student, String faculty)
    {
        student.setEmail(student.getFirstName() + "." + student.getLastName() + "@" + faculty + ".pl");
    }
}