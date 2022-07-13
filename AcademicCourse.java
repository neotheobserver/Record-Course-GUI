/**
 * Class that defines academic courses
 * @author Ardent Sharma
 * @version 1.00
 */
public class AcademicCourse extends Course
{
    //attributes of the class AcademicCourse
    private String lecturerName;
    private String level;
    private int credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;
    
    /*Constructor for class AcademicCourse
     *Used to initialize instance variables during object creation
     */
    public AcademicCourse(String courseId, String courseName, int duration, String level, int credit,int numberOfAssessments)
    {
        super(courseId,courseName,duration); //call to the parent class
        this.level=level;
        this.credit=credit;
        this.numberOfAssessments=numberOfAssessments;
        this.lecturerName="";
        this.startingDate="";
        this.completionDate="";
        this.isRegistered=false;
    }
    
    //returns the name of lecturer for academic course
    public String getLecturerName()
    { 
        return this.lecturerName;
    }
    
    //returns the level of the academic course
    public String getLevel()
    {
        return this.level;
    }
    
    //returns the credit value of the academic course
    public int getCredit()
    {
        return this.credit;
    }
    
    //returns the starting date of the academic course
    public String getStartingDate()
    {
        return this.startingDate;
    }
    
    //returns the ending date of the academic course
    public String getCompletionDate()
    {
        return this.completionDate;
    }
    
    //returns the total number of assessments provided in the academic course
    public int getNumberOfAssessments()
    {
        return this.numberOfAssessments;
    }
    
    //returns whether the academic course is registered or not
    public boolean getIsRegistered()
    {
        return this.isRegistered;
    }
    
    //sets the name of the lecturer
    public void setLecturerName(String lecturerName)
    {
        this.lecturerName=lecturerName;
    }
    
    //sets the number of assessments provided
    public void setNumberOfAssessments(int numberOfAssessments)
    {
        this.numberOfAssessments=numberOfAssessments;
    }
    
    // registers an academic course if not already registered
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate)
    {
        //check if already registered
        if(isRegistered) {                     
            System.out.println("\nThe course is already registered and the instructor for the class is "+this.lecturerName+
            ".\nIt is scheduled to start by "+this.startingDate+" and predicted to end by "+this.completionDate+".");
        }
        else {
            super.setCourseLeader(courseLeader); //call setCourseLeader method of parent class
            this.lecturerName=lecturerName;
            this.startingDate=startingDate;
            this.completionDate=completionDate;
            isRegistered=true;
        }
    }
    
    //display the details about an academic course*/
    public void display()
    {
        super.display(); //call display method of parent class
        
        if(isRegistered) {   //display only if already registered
            System.out.print("\nThe name of the lecturer is: "+this.lecturerName+".\nThe level of this course is: "+this.level+
            ".\nThe credit value this course carries is: "+this.credit+".\nThe starting date is: "+this.startingDate+
            " and the ending date is: "+this.completionDate+".\nThe total number of assessments provided is: "+this.numberOfAssessments+".");  
        }
    }
}