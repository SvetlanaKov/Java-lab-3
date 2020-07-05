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
        test.marksMaker();
        for (Student s : test.studentsArr) {
            assertNotNull(s.getMarks());
            assertEquals(10, s.getMarks().size());
        }
    }

   @Test
    public void moveStudent() {
        Deanery test1 = new Deanery();
       test1.JSONReadS("students.json");
       test1.JSONReadG("groups.json");
       test1.moveStudent(test1.findByIDInDeanery(10), test1.groupsArr.get(1));
       for (Group g : test1.groupsArr){
           assertEquals("Пуффендуй", test1.findByIDInDeanery(10).group.title);
       }
    }

    @Test
    public void findByFIOInDeanery() {
        Deanery test2 = new Deanery();
        Student testS4 = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS1 = new Student(5, "Бессмертных Елена Лукьяновна");
       test2.findByFIOInDeanery("Бондарчук Парфен Савелиевич");
        for (Student s : test2.studentsArr) {
            assertNotNull(s.getFio());
            assertEquals("Бондарчук Парфен Савелиевич", test2.findByFIOInDeanery(testS4.getFio()));
        }
    }

    @Test
    public void findByIDInDeanery() {
        Deanery test3 = new Deanery();
        Student testS5 = new Student(10, "Бондарчук Парфен Савелиевич");
        Student testS6 = new Student(5, "Бессмертных Елена Лукьяновна");
        test3.findByIDInDeanery(5);
        for (Student t : test3.studentsArr) {
            assertNotNull(t.getId());
            assertEquals(5, test3.findByIDInDeanery(testS6.getId()));
        }
    }

   @Test
    public void delitedByDean() {
        Deanery test4 = new Deanery();
        Student testS6 = new Student(10, "Бондарчук Парфен Савелиевич");
        test4.findByFIOInDeanery("Бондарчук Парфен Савелиевич");
       testS6.putMark(2);
        test4.delitedByDean(10);
       assertEquals(true, testS6.medianaMark() < 2.5);
    }

    @Test
    public void groupStatistics() {
        Deanery test5 = new Deanery();
        test5.JSONReadS("students.json");
        test5.JSONReadG("groups.json");
        for (Student u : test5.studentsArr){
            assertNotNull(u.medianaMark());
        }
    }

    @Test
    public void studentStatistics() {
        Deanery test6 = new Deanery();
        test6.JSONReadS("students.json");
        test6.JSONReadG("groups.json");
        for (Group p : test6.groupsArr){
            assertNotNull(p.medianaGroupMark());
        }
    }
}