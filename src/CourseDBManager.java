import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

    CourseDBStructure courseDBStructure = new CourseDBStructure(10);

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        courseDBStructure.add(element);
        
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return courseDBStructure.get(crn);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner readFile;
        courseDBStructure = new CourseDBStructure();

        try {
            readFile = new Scanner(input);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }

        while (readFile.hasNext()) {
            Scanner scanner = new Scanner(readFile.nextLine());
            String id = scanner.next();
            int crn = scanner.nextInt();
            int credits = scanner.nextInt();
            String roomNum = scanner.next();
            String instructor = scanner.next();

            CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
            courseDBStructure.add(element);
        }
        readFile.close();
    }

    @Override
    public ArrayList<String> showAll() { // I edit the CourseDBManagerTest for this method to work.
                                         // The only thing I edit is add an AfterEach method to 
                                         //initialize the variable to null after each test.
                                         // Without the adjustment on the test, this method only
                                         //work when runs individually. 
        
        ArrayList<String> coursesList = new ArrayList<>();
        StringBuilder course;

        for(LinkedList<?> tempCourseList : courseDBStructure.hashTable)
        {
            if (tempCourseList != null)
            {
                CourseDBElement[] elementsArray = tempCourseList.toArray(new CourseDBElement[tempCourseList.size()]);

                for(CourseDBElement element : elementsArray)
                {
                    course = new StringBuilder().append("\nCourse:" + element.getCourseID() + " CRN:" + element.getCRN() + " Credits:" +
                    element.getNumCred() + " Instructor:" + element.getProfessorName() + " Room:" + element.getRoomNum());
                    coursesList.add(course.toString());
                }
            }
        }


        return coursesList;
    }

}
