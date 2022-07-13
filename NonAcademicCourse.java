/**
 * Class that defines non-academic courses
 * @author Ardent Sharma
 * @version 1.00
 */
public class NonAcademicCourse extends Course
{
    //attributes of the class NonAcademicCourse
    private String instructorName;
    private String startingDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;
    
    /*Constructor for class NonAcademicCourse
     *Used to initialize instance variables during object creation
     */
    public NonAcademicCourse(String courseId, String courseName, int duration, String prerequisite)
    {
        super(courseId,courseName,duration); //call to parent class
        this.prerequisite=prerequisite;
        this.instructorName="";
        this.startingDate="";
        this.completionDate="";
        this.examDate="";
        this.isRegistered=false;
        this.isRemoved=false;
    }
    
    //returns the name of the instructor for non-academic course
    public String getInstructorName()
    { 
        return this.instructorName;
    }
    
    //returns the starting date of the non-academic course
    public String getStartingDate()
    {
        return this.startingDate;
    }
    
    //returns the completion date of the non-academic course
    public String getCompletionDate()
    {
        return this.completionDate;
    }
    
    //returns the date for the exam of the non-academic ocurse
    public String getExamDate()
    {
        return this.examDate;
    }
    
    //returns the prerequisites for the non-academic course
    public String getPrerequisite()
    {
        return this.prerequisite;
    }
    
    //returns whether non-academic course is already registered or not
    public boolean getIsRegistered()
    {
        return this.isRegistered;
    }
    
    //returns whether the non-academic course is already removed or not
    public boolean getIsRemoved()
    {
        return this.isRemoved;
    }
    
    //sets name of the instructor only if the non-academic course is not already registered*/
    public void setInstructorName(String instructorName)
    {
        //check whether the class is already registered
        if(!isRegistered) {
            this.instructorName=instructorName;
        }
        else {     //get course Id from the parent class using getCourseId method and instructor name from the same class
            System.out.println("\nIt is not possible to alter the instructor's name as the course "+super.getCourseId()+
            " has been already registered with "+this.instructorName+" as the instructor.");
        }
    }
    
     //registers a non-academic course
    public void register(String courseLeader, String instructorName, String startingDate, String completionDate, String examDate)
    {
        //check whether already registered
        if(!isRegistered) { 
            super.setCourseLeader(courseLeader);  //call setCourseLeader method of parent class
            setInstructorName(instructorName);
            this.startingDate=startingDate;
            this.completionDate=completionDate;
            this.examDate=examDate;
            isRegistered=true;
        }
        else { //get course id from parent class using getCourseId method
            System.out.println("\nThe course "+super.getCourseId()+" has already been registered"+".");
        }
    }
    
     //removes a non-academic course
    public void remove()
    {
        //first check whether it is already removed
        if(isRemoved) { //get course id from parent class using getCourseId method
            System.out.println("\nThe course "+super.getCourseId()+" has already been removed"+".");
        }
        else {
            super.setCourseLeader("");    //call setCourseLeader method of parent class and assign empty string
            instructorName="";
            startingDate="";
            completionDate="";
            examDate="";
            isRegistered=false;
            isRemoved=true;
        }
    }
    
     //displays the details of a non-academic course
    public void display()
    {
        super.display(); //call display method of parent class
        
        if(isRegistered) {  //display only if already registered
            System.out.print("\nThe name of the instructor for this course is: "+instructorName+".\nThe starting date of the course is: "+
            startingDate+", the completion date is: "+completionDate+" and the exam date is: "+examDate+".");
        }
    }
}