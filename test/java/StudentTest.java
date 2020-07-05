import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testPutMark() {
        Student test = new Student(5,"Бессмертных Елена Лукьяновна");
        test.putMark(5);
        test.putMark(5);
        assertEquals(2, test.getMarks().size());
        assertEquals((long) 5, (long) test.getMarks().get(1));
        Student test2 = new Student(10, "Бондарчук Парфен Савелиевич");
        test2.putMark(2);
        assertEquals(1, test2.getMarks().size());
        assertEquals((long) 2, (long) test2.getMarks().get(0));
    }
       @org.junit.Test
    public void medianaMark() {
        Student test3 = new Student(5, "Бессмертных Елена Лукьяновна");
        test3.putMark(4);
        test3.putMark(2);
        assertEquals(3.0F, test3.medianaMark(), 0.001F);
        Student test4 = new Student(10, "Бондарчук Парфен Савелиевич");
        test4.putMark(3);
        test4.putMark(5);
        assertEquals(4.0F, test4.medianaMark(), 0.001F);
    }


}