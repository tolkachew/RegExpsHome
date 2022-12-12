import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        ArrayList<Integer> myList = new ArrayList<Integer>(hashSet);
        Collections.sort(myList);
        System.out.println(myList);
        HashSet<Student> empHash = new HashSet<Student>();
        empHash.add(new Student("Дмитрий", 6, "Математика"));
        empHash.add(new Student("Михаил", 5, "Математика"));
        empHash.add(new Student("Владислав", 4, "Математика"));
        empHash.add(new Student("Александр", 9, "Математика"));
        empHash.add(new Student("Александр2", 8, "Математика"));
        ArrayList<Student> empList = new ArrayList<Student>(empHash);
        Collections.sort(empList);
        System.out.println(empList);
    }
}

class Student implements Comparable<Student> {
    String name;
    int mark;
    String subject;

    public Student(String name, int mark, String subject) {
        super();
        this.name = name;
        this.mark = mark;
        this.subject = subject;
    }
    @Override
    public int compareTo(Student o) {
        if (this.mark < o.mark) {
            return -1;
        } else if (this.mark > o.mark) {
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", mark=" + mark + ", subject=" + subject + "]";
    }
}
