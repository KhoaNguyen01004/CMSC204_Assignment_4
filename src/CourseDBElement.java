
public class CourseDBElement implements Comparable {

    String courseID;
    int crn;
    int numCred;
    String roomNum;
    String professorName;

    public CourseDBElement(String courseID, int crn, int credits, String roomNum, String professor) {
        this.courseID = courseID;
        this.crn = crn;
        this.numCred = credits;
        this.roomNum = roomNum;
        this.professorName = professor;
    }

    public CourseDBElement() {
    }

    //Setter methods
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public void setNumCred(int numCred) {
        this.numCred = numCred;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }


    //getter methods
    public String getCourseID() {
        return courseID;
    }

    public int getCRN() {
        return crn;
    }

    public int getNumCred() {
        return numCred;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getProfessorName() {
        return professorName;
    }


    //compare methods
    @Override
    public int compareTo(CourseDBElement element) {
        
        if (element.getCRN() < this.getCRN())
            return 1;
        else if(element.getCRN() > this.getCRN())
            return -1;
        return 0;
    }
}
