/**
 * Class for course in a school/college
 * @author Ardent Sharma
 * @version 1.00
 */
public class Course
{
    //attributes of the class
    private String courseId;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    /*Constructor for class Course
     *Used to initialize instance variables during object creation
     */
    public Course(String courseId, String courseName, int duration)
    {
        this.courseId=courseId;
        this.courseName=courseName;
        this.duration=duration;
        this.courseLeader="";
    }
    
    //returns the Id of the course 
    public String getCourseId()
    {
        return this.courseId;
    }
    
     //returns the Name of the course
    public String getCourseName()
    {
        return this.courseName;
    }
    
     //returns the name of the leader for course 
    public String getCourseLeader()
    {
        return this.courseLeader;
    }
    
     //returns the duration of course
    public int getDuration()
    {
        return this.duration;
    }
    
     //sets the name of course leader
    public void setCourseLeader(String courseLeader)
    {
        this.courseLeader=courseLeader;
    }
    
     //display all the details of course
    public void display()
    {
        if (courseLeader!="") {
             System.out.print("\nThe leader for the course is: "+this.courseLeader+".");
        }
        System.out.print("\nThe ID for this course is: "+this.courseId+
            ".\nThe name of this course is: "+this.courseName+" and the duration is : "+this.duration+" years.");
        //check if course leader name is empty  
    }
}