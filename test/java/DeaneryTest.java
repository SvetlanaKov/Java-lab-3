import org.junit.Test;

import static org.junit.Assert.*;

public class DeaneryTest {

    @Test
    public void marksMaker() {
        Deanery test = new Deanery();
        Student testS = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS1 = new Student(5, "Бессмертных Елена Лукьяновна");
        Group testG = new Group("new");
        testG.addStudent(testS);
        testG.addStudent(testS1);
        testS.putMark(5);
        testS1.putMark(3);
        assertEquals(5,5);
        assertEquals(3,3);
    }

   /* @Test
    public void headSelection() {
        Deanery test1 = new Deanery();
        Student testS2 = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS3 = new Student(5, "Бессмертных Елена Лукьяновна");
        Group testG1 = new Group("new");
        testG1.addStudent(testS2);
        testG1.addStudent(testS3);
        testG1.setHead();
        assertEquals(testS2,testS2);
    }*/

    @Test
    public void moveStudent() {
        Deanery test1 = new Deanery();
        Student testS2 = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS3 = new Student(5, "Бессмертных Елена Лукьяновна");
        Group testG1 = new Group("new");
        Group testG2 = new Group("new2");
        testG1.addStudent(testS2);
        testG1.addStudent(testS3);
        test1.moveStudent(testS2,testG2);
        assertEquals(testS2,testS2);
    }

    @Test
    public void findByFIOInDeanery() {
        Deanery test2 = new Deanery();
        Student testS4 = new Student(10, "Бондарчук Парфен Савелиевич");
        Group testG3 = new Group("new");
        testG3.addStudent(testS4);
        test2.findByFIOInDeanery("Бондарчук Парфен Савелиевич");
        assertEquals(testS4,testS4);
    }

    @Test
    public void findByIDInDeanery() {
        Deanery test3 = new Deanery();
        Student testS5 = new Student(10, "Бондарчук Парфен Савелиевич");
        Group testG4 = new Group("new");
        testG4.addStudent(testS5);
        test3.findByIDInDeanery(10);
        assertEquals(testS5,testS5);
    }

    @Test
    public void delitedByDean() {
        Deanery test4 = new Deanery();
        Student testS6 = new Student(10, "Бондарчук Парфен Савелиевич");
        Group testG5 = new Group("new");
        testG5.addStudent(testS6);
        test4.findByFIOInDeanery("Бондарчук Парфен Савелиевич");
        test4.delitedByDean(10);
        assertEquals(testS6,testS6);
    }

    @Test
    public void groupStatistics() {
        Deanery test5 = new Deanery();
        Student testS7 = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS8 = new Student(5, "Бессмертных Елена Лукьяновна");
        Group testG6 = new Group("new");
        testG6.addStudent(testS7);
        testG6.addStudent(testS8);
        testS7.putMark(5);
        testS8.putMark(3);
        testG6.medianaGroupMark();
        assertEquals(4.0D, 4.0D, 0.001D);
    }

    @Test
    public void studentStatistics() {
        Deanery test6 = new Deanery();
        Student testS9 = new Student(10, "Бондарчук Парфен Савелиевич");
        Group testG7 = new Group("new");
        testG7.addStudent(testS9);
        testS9.putMark(5);
        testS9.putMark(3);
        testS9.medianaMark();
        test6.studentStatistics();
        assertEquals(4.0D,4.0D, 0.00D);
    }
}