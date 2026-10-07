package task1;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public double getAverageGrade() {
        double sum = 0;
        if (grades.size() > 0) {
            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            return sum / grades.size();
        } else {
            return 0;
        }
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }
}