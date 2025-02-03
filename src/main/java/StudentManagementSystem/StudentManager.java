package StudentManagementSystem;

import java.util.*;

public class StudentManager {

    private List<Student> students = new ArrayList<>();
    private LinkedList<Student> linkedList = new LinkedList<>();
    private Set<String> BackEnd = new HashSet<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Student searchByName(String name) {
        students.sort(new StudentComparator());
        int left = 0, right = students.size() - 1;
        while (left <= right) {
            int mid =left + (right - left) / 2;
            int compare = students.get(mid).getName().compareTo(name);
            if (compare == 0) return students.get(mid);
            if (compare < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public void bubbleSortByAge() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getAge() > students.get(j + 1).getAge()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public void selectionSortByGrade() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getGrade() < students.get(minIndex).getGrade()) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }
    }

    public static List<Student> mergeSortByName(List<Student> students) {
        if (students.size() <= 1) {
            return students;
        }
        int mid = students.size() / 2;
        List<Student> left = new ArrayList<>();
        List<Student> right = new ArrayList<>();

        for (int i = 0; i < mid; i++)
            left.add(students.get(i));

        for (int i = mid; i < students.size(); i++)
            right.add(students.get(i));

        left = mergeSortByName(left);
        right = mergeSortByName(right);

        return merge(left, right);
    }

    private static List<Student> merge(List<Student> left, List<Student> right) {
        List merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareTo(right.get(j).getName()) <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        merged.addAll(left.subList(i, left.size()));
        merged.addAll(right.subList(j, right.size()));
        return merged;
    }
}