package StudentManagementSystem;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int nameComparator = o1.getName().compareTo(o2.getName());
        if(nameComparator!=0)
            return nameComparator;
        int ageComparator = Integer.compare(o1.getAge(), o2.getAge());
        if(ageComparator!=0)
            return ageComparator;

        return Double.compare(o1.getGrade(),o2.getGrade());
    }
}