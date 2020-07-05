import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deanery {
    ArrayList<Student> studentsArr;
    ArrayList<Group> groupsArr;

    Deanery() {
        this.studentsArr = new ArrayList<Student>();
        this.groupsArr = new ArrayList<Group>();
    }
    public void JSONReadS(String fileName){
        try{
            Object obj = new JSONParser().parse(new FileReader(fileName));
            JSONObject jo = (JSONObject) obj;
            JSONArray stud = (JSONArray) jo.get("students");
            Iterator studItr = stud.iterator();
            int idi = 1;
            while(studItr.hasNext()){
                JSONObject buf = (JSONObject)studItr.next();
                Student temp = new Student(idi, buf.get("fio").toString());
                studentsArr.add(temp);
                idi++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public void JSONReadG(String fileName){
        try{
            Object obj = new JSONParser().parse(new FileReader(fileName));
            JSONObject jo = (JSONObject) obj;
            JSONArray grp = (JSONArray) jo.get("groups");
            Iterator grpItr = grp.iterator();
            int len = 0;
            int i = 0;
            int j = 0;
            int d = studentsArr.size() / grp.size();
            while(grpItr.hasNext()){
                len += d;
                JSONObject buf = (JSONObject)grpItr.next();
                Group temp = new Group(buf.get("title").toString());
                groupsArr.add(temp);
                for (; i < len; i++){
                    groupsArr.get(j).addStudent(studentsArr.get(i));
                }
                j++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public void marksMaker(){
        int markNumber = 10;
        for (Student student: studentsArr){
            Random random = new Random();
            for (int i = 0; i < markNumber; i++){
                student.putMark(random.nextInt(5) + 2);
            }
        }
    }

    public void headSelection(){
        for (Group group: groupsArr){
            group.setHead();
        }
    }
   public void moveStudent(Student student, Group group) {
       student.group.deleteStudent(student.getId());
       student.addToGroup(group);
       System.out.println("Студент " + student.getFio() + " переведен в группу " + group.title);
   }
    public Student findByFIOInDeanery(String fio) {
        if (studentsArr != null) {
            for (Student student : studentsArr) {
                if (student.getFio().equals(fio)) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student findByIDInDeanery(int id) {
        if (studentsArr != null) {
            for (Student student : studentsArr) {
                if (student.getId() == id) {
                    return student;
                } System.out.println(student.getFio());
            }
        }
        return null;
    }
    public void delitedByDean(int id) {
        double minAaleableMark = 2.5;
        for (Group group : groupsArr) {
            if (studentsArr != null) {
                Iterator<Student> iter = studentsArr.iterator();
                while (iter.hasNext()) {
                    Student nextStudent = iter.next();
                    if (nextStudent.medianaMark() < minAaleableMark) {
                        nextStudent.group.deleteStudent(nextStudent.getId());
                        iter.remove();
                        System.out.println("Студент " + nextStudent.getFio() + ", ID: " + nextStudent.getId() + " отчислен за неуспеваемость! Средний балл: " + nextStudent.medianaMark());
                    }
                }
            }
        }
    }
    public void printStudentsInGroups() {
        if (groupsArr != null) {
            System.out.println();
            for (Student s : studentsArr) {
                s.printBD();
            }
            for (Group group : groupsArr) {
                System.out.println("В группе " + group.title + " числятся:");
                if (group.getStudents() != null) {
                    for (int k = 0, count = 1; k < group.getStudents().size(); k++, count++) {
                        System.out.println(count + ". ID:" + group.getStudents().get(k).getId());
                        System.out.println("    FIO: " + group.getStudents().get(k).getFio());
                        System.out.println("    Средний балл: " + group.getStudents().get(k).medianaMark());
                        System.out.println("    Все оценки: " + group.getStudents().get(k).getMarks());
                    }

                }
            }
        }
    }
    public void groupStatistics() {
        if (groupsArr != null) {
            for (Group group : groupsArr) {
                group.medianaGroupMark();
                System.out.println("Средняя оценка в группе " + group.title + ": " + group.medianaGroupMark());
            }
            System.out.println();
        }
    }

    public void studentStatistics() {
        if (studentsArr != null) {
            for (Student student : studentsArr) {
                student.medianaMark();
            }
        }
    }
    public void printMarks() {
        for (Student student: studentsArr) {
            student.printBD();
            student.printMarks();
        }
    }
    public void printGroupsData() {
        for (Group group: groupsArr) {
            group.printGroupData();
        }
    }

  public void JSONWriter(String newFileName) {
      if (studentsArr.isEmpty()) {
          return;
      }
      JSONObject object = new JSONObject();
      JSONArray s = new JSONArray();
      for (Student student: studentsArr){
          JSONObject st = new JSONObject();
          st.put("id", student.getId());
          st.put("name", student.getFio());
          st.put("mediana", String.format("%.2f", student.medianaMark()));
          s.add(st);
      }
      object.put("students", s);

      try (FileWriter writer = new FileWriter(newFileName)) {
          writer.write(object.toJSONString());
          writer.flush();
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}