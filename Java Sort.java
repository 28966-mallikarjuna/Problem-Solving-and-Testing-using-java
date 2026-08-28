import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        // Sort according to the required rules
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student a, Student b) {

                // 1. Higher CGPA first
                int cgpaCompare = Double.compare(b.getCgpa(), a.getCgpa());

                if (cgpaCompare != 0) {
                    return cgpaCompare;
                }

                // 2. Alphabetical name
                int nameCompare = a.getName().compareTo(b.getName());

                if (nameCompare != 0) {
                    return nameCompare;
                }

                // 3. Lower ID first
                return Integer.compare(a.getId(), b.getId());
            }
        });

        // Print names
        for (Student student : students) {
            System.out.println(student.getName());
        }

        sc.close();
    }
}
