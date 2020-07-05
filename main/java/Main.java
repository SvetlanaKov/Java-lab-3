public class Main {

    public static void main(String[] args){
        Deanery deanery = new Deanery();
        deanery.JSONReadS("students.json");
        deanery.JSONReadG("groups.json");
       deanery.headSelection();
        deanery.marksMaker();
       deanery.printMarks();
       deanery.studentStatistics();
        deanery.printGroupsData();
      deanery.printStudentsInGroups();
       deanery.printStudentsInGroups();
        deanery.groupStatistics();
        deanery.findByIDInDeanery(3);
        deanery.delitedByDean(5);

       deanery.JSONWriter("result.json");
    }
}