public class Main {
    public static void main(String[] args) {
        StudentManagementService studentManagementService = new StudentManagementService();

        Student studentTomasz = new Student(123456, "Tomasz", "Abacki");
        studentManagementService.addStudent(studentTomasz);
        studentManagementService.addStudent(studentTomasz);
        Student studentWojciech = new Student(297999, "Wojciech", "Babacki");
        studentManagementService.addStudent(studentWojciech);
        Student studentMarek = new Student(300123, "Marek", "Cacki");
        studentManagementService.addStudent(studentMarek);

        System.out.println();
        System.out.println(studentMarek);
        System.out.println();

        studentManagementService.printAllStudents();
        System.out.println();

        EmailService emailService = new EmailService();

        System.out.println("Tomasz's mail (before set): " + studentTomasz.getEmail());
        emailService.generateEmailForStudent(studentTomasz, Faculty.WFIIS);
        System.out.println("Tomasz's mail: " + studentTomasz.getEmail());
        emailService.generateEmailForStudent(studentWojciech, Faculty.WMS);
        System.out.println("Wojciech's mail: " + studentWojciech.getEmail());
        emailService.generateEmailForStudent(studentMarek, "WIMiR");
        System.out.println("Marek's mail: " + studentMarek.getEmail());

        System.out.println();

        studentMarek.addGrade(4.5);
        studentMarek.addGrade(3.5);
        studentMarek.addGrade(5.0);
        studentTomasz.addGrade(3.0);
        studentManagementService.removeStudent(studentWojciech);
        studentManagementService.removeStudent(studentWojciech);
        System.out.println();
    
        studentManagementService.printAllStudents();
        System.out.println();

        System.out.println("Tomasz's average: " + studentTomasz.getAverage());
        System.out.println("Wojciech's average: " + studentWojciech.getAverage());
        System.out.println("Marek's average: " + studentMarek.getAverage());
        System.out.println("The best student is: " + studentManagementService.findStudentWithTheHighestAverage());
        System.out.println();

        Student studentWojciech2 = new Student(297999, "Wojciech", "Babacki");
        emailService.generateEmailForStudent(studentWojciech2, Faculty.WMS);
        Student studentTomasz2 = new Student(123456, "Tomasz", "Abacki");
        System.out.println("studentWojciech == studentWojciech2: " + (studentWojciech == studentWojciech2)); // false
        System.out.println("studentWojciech.equals(studentWojciech2): " + studentWojciech.equals(studentWojciech2)); // true
        System.out.println("studentTomasz.equals(studentTomasz2): " + studentTomasz.equals(studentTomasz2)); // false, bo brakuje ocen i e-maila

    }
}