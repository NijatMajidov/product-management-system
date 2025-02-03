package StudentManagementSystem;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private int age;
    private double grade;

    public Student(){}
    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Double.compare(student.grade, grade) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grade);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id,o.id);
    }
    @Override
    public String toString() {
        return "Student{ id=" + id + ", name='" + name + '\'' + ", age=" + age + ", grade=" + grade + '}';
    }
}