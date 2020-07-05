import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void addStudent() {
        Group test = new Group("new");
        Student testS = new Student(61, "Путилова Марианна Гаврииловна");
        test.addStudent(testS);
        assertEquals(testS, testS);
    }

    @Test
    public void findByID() {
        Group test1 = new Group("new");
        Student testS1 = new Student (10, "Бондарчук Парфен Савелиевич");
        test1.addStudent(testS1);
        assertEquals(testS1, testS1);
    }

    @Test
    public void findByFio() {
        Group test2 = new Group("new");
        Student testS2 = new Student (10, "Бондарчук Парфен Савелиевич");
        test2.addStudent(testS2);
        assertEquals(testS2, testS2);
    }

    @Test
    public void medianaGroupMark() {
        Group test3 = new Group("new");
        Student testS3 = new Student (10, "Бондарчук Парфен Савелиевич");
        Student testS4 = new Student (5, "Бессмертных Елена Лукьяновна");
        test3.addStudent(testS3);
        test3.addStudent(testS4);
        testS3.putMark(5);
        testS3.putMark(5);
        testS4.putMark(3);
        testS4.putMark(3);
        assertEquals(4.0F, test3.medianaGroupMark(), 0.001F);
    }

    @Test
    public void deleteStudent() {
        Group test5 = new Group("new");
        Student testS5 = new Student (10, "Бондарчук Парфен Савелиевич");
        test5.addStudent(testS5);
        test5.deleteStudent(10);
        assertEquals(testS5,testS5);
    }
}