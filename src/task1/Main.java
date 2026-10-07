package task1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Иван", "AQA-007", 2);
        Student student2 = new Student("Петр", "AQA-001", 3);
        Student student3 = new Student("Ольга", "AQA-005", 1);
        Student student4 = new Student("Мария", "AQA-003", 2);

        Set<Student> students = new HashSet<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        student1.addGrade(4);
        student1.addGrade(3);
        student1.addGrade(5);
        student1.addGrade(5);
        student2.addGrade(3);
        student2.addGrade(2);
        student3.addGrade(3);
        student3.addGrade(3);
        student3.addGrade(3);
        student4.addGrade(5);
        student4.addGrade(4);
        student4.addGrade(5);

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);

        expulsion(students);
        transferToNextCourse(students);

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);
    }

    public static void transferToNextCourse(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void expulsion(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("На " + course + " курсе обучаются: ");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}

