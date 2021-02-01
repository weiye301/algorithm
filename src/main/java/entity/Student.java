package entity;

/**
 * @author weiye
 * @date 2021/1/26 10:58
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) {
            return true;
        }
        if (student == null) {
            return false;
        }
        if (!(student instanceof Student)) {
            return false;
        }
        Student another = (Student) student;
        return this.name.equals(another.name);
    }

    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
