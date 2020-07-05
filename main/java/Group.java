import java.util.ArrayList;
import java.util.Random;

public class Group {

    String title;
    private ArrayList<Student> studentsG = new ArrayList<Student>();
    protected Student head;

    public Group (String title) {
        this.title = title;
    }

    public void addStudent(Student newStudent) {
        studentsG.add(newStudent);
        newStudent.addToGroup(this);
    }

    public void setHead() {
        if(studentsG!=null) {
            Random randomHead = new Random();
            head = studentsG.get(randomHead.nextInt(studentsG.size()));
        }
    }
    public Student findByID(int id) {
        if(studentsG!=null) {
            for (Student s : studentsG) {
                if (s.getId() == id) {
                    return s;
                }
            }
        }
        return null;
    }

    public Student findByFio(String fio) {
        if(studentsG!=null) {
            for (Student s : studentsG) {
                if (s.getFio().equals(fio)) {
                    return s;
                }
            }
        }
        return null;
    }
    void printGroupData() {
       String headS;
       headS = this.head.getFio();
        System.out.println();
        System.out.println(title + ", число студентов " + studentsG.size() + ", староста группы " + headS);

        System.out.println();
    }

    public String getTitle(){
        return this.title;
    }
    public ArrayList<Student> getStudents(){
        return this.studentsG;
    }
    public Student getHead(){
        return this.head;
    }
    public float medianaGroupMark() {
            float sum = 0;
            for (Student i : studentsG) {
                sum += i.medianaMark();
            }
            return sum / studentsG.size();
    }

    public boolean deleteStudent(int id) {
        if (studentsG != null) {
            for (Student s: studentsG) {
                if (s.getId() == id) {
                    studentsG.remove(s);
                    if (head != null && id == head.getId()) {
                        setHead();
                        System.out.println("Новый староста группы " + title + ": " + head.getFio());
                    }
                    return true;
                }
            }
        }
        return false;
    }
}