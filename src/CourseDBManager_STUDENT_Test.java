
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 * @author alexander
 *
 */
public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    /**
     * Create an instance of CourseDBManager
     * 
     * @throws Exception
     */
    @Before
    public void setUp() {
        dataMgr = new CourseDBManager();
    }

    /**
     * Set dataMgr reference to null
     * 
     * @throws Exception
     */
    @After
    public void tearDown() {
        dataMgr = null;
    }

    /**
     * To resolve problem test not pass when run in a whole
     */
    @AfterEach
    public void nullInitialize()
    {
        dataMgr = null;
    }

    /**
     * Test for the add method
     */
    @Test
    public void testAddToDB() {
        try {
            dataMgr.add("CMSC204", 30504, 4, "SC450", "Joey Bag-O-Donuts");
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    /**
     * Test for the showAll method
     */
    @Test
    public void testShowAll() {
        dataMgr.add("CMSC204", 30504, 4, "SC450", "haha");
        dataMgr.add("CMSC204", 30503, 4, "SC450", "hoho");
        dataMgr.add("CMSC203", 30559, 4, "SC450", "hihi");
        ArrayList<String> list = dataMgr.showAll();

        assertEquals( "\nCourse:CMSC204 CRN:30503 Credits:4 Instructor:hoho Room:SC450", list.get(0));
        assertEquals( "\nCourse:CMSC204 CRN:30504 Credits:4 Instructor:haha Room:SC450", list.get(1));
        assertEquals( "\nCourse:CMSC203 CRN:30559 Credits:4 Instructor:hihi Room:SC450", list.get(2));
    }

    /**
     * Test for the read method
     */
    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
            inFile.print("CMSC203 30503 4 SC450 Jill B. Who-Dunit");

            inFile.close();
            dataMgr.readFile(inputFile);
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}