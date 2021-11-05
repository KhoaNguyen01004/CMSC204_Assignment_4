import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

    LinkedList<CourseDBElement>[] hashTable;
    
    /**
     * Default constructor that that create a hash table with size of 10
     */
    public CourseDBStructure()
    {
        hashTable = new LinkedList[10];
    }

    public CourseDBStructure(int estSize) {
        hashTable = new LinkedList[estSize];
    }

    // Used only for testing
    public CourseDBStructure(String testing, int size) {
        hashTable = new LinkedList[size];
    }

    @Override
    public void add(CourseDBElement element) {
        int hasCode = element.hashCode();
        int i = hasCode % hashTable.length;

        if(hashTable[i] == null)
        {
            hashTable[i] = new LinkedList<>();
            hashTable[i].add(element);
        }
        else if (hashTable[i] != null)
        {
            hashTable[i].add(element);
        }
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        String stringCrn = Integer.toString(crn);
        int hashCode = stringCrn.hashCode();
        int i = hashCode % hashTable.length;

        for (int j = 0; j < hashTable.length; j++) {

            if (hashTable[i].get(j).getCRN() == crn) {
                return hashTable[i].get(j);
            }
        }
        throw new IOException();

    }

    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
