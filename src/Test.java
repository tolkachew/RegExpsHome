import java.util.*;
/*
Студенты нескольких групп сдают экзамен по одному предмету, который оценивается по шкале от 1 до 10.
Вывести список студентов и их оценок для выбранной группы с сортировкой по фамилиям; по оценкам.
После списка группы вывести статистику (количество студентов, получивших 10 баллов, 9 баллов и т.д.;
среднюю успеваемость по выбранной группе).
 */
public class Test {
    public static void main(String[] args) {
        Group grp = new Group("FirstGroup");
        grp.addList(new Student("Дмитрий", 6, "Математика"));
        grp.addList(new Student("Михаил", 5, "Информатика"));
        grp.addList(new Student("Владислав", 4, "Математика"));
        grp.addList(new Student("Александр", 9, "Математика"));
        grp.addList(new Student("Мария", 9, "Математика"));

        System.out.println("Абитуриенты:");
        grp.printStudent();

        System.out.println("Сортировка абитуриентов по имени: ");
        grp.sortByName();

        System.out.println("Сортировка абитуриентов по оценке: ");
        grp.sortByMark();

        System.out.println("Сортировка по предмету: ");
        grp.sortBySub();

        System.out.println("Статистика по оценкам: ");
        grp.map();

    }
}
class Student {
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
    public String toString() {
        return "Студент [Имя = " + name + ", оценка = " + mark + ", предмет = " + subject + "]";
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public String getSubject() {
        return subject;
    }
}
class Group {
    private String nameG;
    private LinkedList<Student> studentList = new LinkedList<>();
    public void map(){
        Map<Integer, Integer> digits = new HashMap<>();
        int sum = 0, result = 0, avgmark = 0;
        for (Student st : studentList) {
            sum = sum + st.getMark();
            result++;
            if(digits.keySet().contains(st.getMark())){
                digits.put(st.getMark(),digits.get(st.getMark())+1);
            }else {
                digits.put(st.getMark(),1);
            }
        }
        for(Map.Entry<Integer, Integer> item : digits.entrySet()){
            System.out.printf("Оценка: %d  Количество : %d \n", item.getKey(), item.getValue());
        }
        avgmark = sum/result;
        System.out.printf("Средняя оценка : " +avgmark);

    }
    public void addList(Student student) {
        studentList.add(student);
    }

    public Group(String nameG) {
        this.nameG = nameG;
    }

    public void printStudent() {
        for (Student st : studentList) {
            System.out.println(st.toString());
        }
    }

    public void sortByMark(){
        studentList.sort(Comparator.comparing(Student::getMark));
        printStudent();
    }

    public void sortBySub(){
        studentList.sort(Comparator.comparing(Student::getSubject));
        printStudent();
    }

    public void sortByName(){
        studentList.sort(Comparator.comparing(Student::getName));
        printStudent();
    }
}