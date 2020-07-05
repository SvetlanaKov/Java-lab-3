import java.util.ArrayList;

public class Student {
    private int id;
    private String fio;
    public Group group;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(int id, String fio) {
        this.fio = fio;
        this.id = id;
    }
    public void addToGroup(Group group) {
        this.group = group;
    }
    public void putMark(int newMark) {
        marks.add(newMark);
    }
    public ArrayList<Integer> getMarks() {
        return marks;
    }
    void printMarks() {
        System.out.print("Оценки: ");
        for (Integer mark: marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
    public float medianaMark() {
        float sum = 0;
        for (Integer i : marks) {
            sum += i;
        }
        return sum / marks.size();
    }
    public int getId() {
        return id;
    }
    public String getFio() {
        return fio;
    }

    void printBD(){
        System.out.println("[ " + id + " ]" + " " + fio + ", " + group.getTitle());
    }
}