/**
 * GUI to add, register, display and remove Academic and Non Academic course
 * @author Ardent Sharma
 * @version 1.00
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class INGCollege implements ActionListener{
    //instance variable for frame and courses
    private JFrame frame;
    private JPanel panel, panelac, panelnac;
    private JMenuBar bar;
    private JMenuItem news,save;
    private Course c;
    private ArrayList<Course> academicCourseList, nonAcademicCourseList;
    
    //label for academic course
    private JLabel titleAcademic,  courseId, courseIdac, courseName, duration, courseLeader, lecturerName, level, credit, startDate,
    completionDate, nofAssessments;
    //text field for academic course
    private JTextField courseIdText, courseIdTextac, courseNameText, durationText, courseLeaderText, lecturerNameText, levelText, creditText, startDateText,
        completionDateText, nofAssessmentsText;
    //button for academic course
    private JButton addAcademic, registerAcademic,displayAcademic;
    
    //label for non academic courses
    private JLabel titleNonAcademic, courseIdn, courseIdnac, courseNamenac, durationnac, courseLeadernac, instructorName, startDatenac, 
    completionDatenac, examDate, prerequisites;
    //text field for non academic course
    private JTextField courseIdnText, courseIdnacText, courseNamenacText, durationnacText, courseLeadernacText, instructorNameText, 
    startDatenacText, completionDatenacText, examDateText, prerequisitesText;
    //button for non academic course
    private JButton addNonAcademic, registerNonAcademic,displayNonAcademic,remove, clearText;
    
    /* the constructor to the INGCollege class
     * reponsive for instansiating values for all instance variable described above
     * also responsible for adding functionality to buttons and 
     * overall layout of the GUI
     */
    public INGCollege()
    {
        //frame
        frame = new JFrame("ING College Course Records");
        academicCourseList = new ArrayList<Course>();
        nonAcademicCourseList = new ArrayList<Course>();
        
        //Font for all labels
        Font f =  new Font("Serif",Font.BOLD, 22);
        
        //Default dimension for designed for some button
        Dimension dButton = new Dimension(200,50);
        
        //Main panel
        panel = new JPanel();
        CardLayout cl = new CardLayout();
        
        //set card layout for the panel
        panel.setLayout(cl);
        
        //Add border to the frame
        Border b = BorderFactory.createMatteBorder(8,8,8,8,Color.BLUE);
        panel.setBorder(b);
        
        //Panel for each course
        panelac = new JPanel(new GridBagLayout());
        panelnac = new JPanel(new GridBagLayout());
        
        //Default constraint for gridbag layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //Menu bar
        bar = new JMenuBar();
        JMenu options = new JMenu("File");
        options.setPreferredSize(new Dimension(100,40));
        options.setMnemonic(KeyEvent.VK_F);
        
        //To create new record
        news = new JMenuItem("New");
        news.setPreferredSize(new Dimension(120,40));
        news.addActionListener(this);
        //set shortcut kestroke to execute the action
        news.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        //Exit out of program
        JMenuItem exit = new JMenuItem("Exit");
        exit.setPreferredSize(new Dimension(120,40));
        //Peform action when clicked
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        }
        );
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        options.add(news);
        options.add(exit);

        //Get help
        JMenu info = new JMenu("Help");
        info.setPreferredSize(new Dimension(100,40));
        info.setMnemonic(KeyEvent.VK_H);
        info.addMenuListener(new MenuListener()
        {
            public void menuSelected(MenuEvent e)
            {
                JOptionPane.showMessageDialog(frame, "Contact at np01cp4s210045@islingtoncollege.edu.np for any queries or suggestions");
            }
            public void menuCanceled(MenuEvent e) {}
            public void menuDeselected(MenuEvent e) {}
        });
        
        //Add menu to menu bar
        bar.add(options);
        bar.add(Box.createHorizontalGlue());
        bar.add(info);
        frame.setJMenuBar(bar);
        
        //Academic GUI components
        //label for Academic Course
        //the x and y area the tile covers...used throughout the code with different value
        gbc.gridx = 3;
        gbc.gridy = 0;
        //starting point for title....used throughtout the code in different form
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        titleAcademic = new JLabel("Academic Course");
        //set the size and font of title
        titleAcademic.setPreferredSize(new Dimension(400, 80));
        titleAcademic.setFont(new Font("Verdana", Font.BOLD, 30));
        //add title to academic panel
        panelac.add(titleAcademic, gbc);
        
        //Academic course id
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        courseId = new JLabel("Course Id:");
        courseId.setFont(f);
        panelac.add(courseId,gbc);
        //Academic course id text
        gbc.gridx = 1;
        courseIdText = new JTextField(10);
        courseIdText.setFont(f);
        panelac.add(courseIdText, gbc);
        
        //Academic course name
        gbc.gridx = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        courseName = new JLabel("Course Name:");
        courseName.setFont(f);
        panelac.add(courseName,gbc);
        //Academic course name text
        gbc.gridx = 3;
        gbc.anchor= GridBagConstraints.PAGE_START;
        courseNameText = new JTextField(10);
        courseNameText.setFont(f);
        panelac.add(courseNameText, gbc);
        
        //Academic course duration
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        duration = new JLabel("Duration:");
        duration.setFont(f);
        panelac.add(duration, gbc);
        //Academic course duration text
        gbc.gridx = 5;
        durationText = new JTextField(10);
        durationText.setFont(f);
        panelac.add(durationText,gbc);
        
        //Academic course level
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        level = new JLabel("Level:");
        level.setFont(f);
        panelac.add(level,gbc);
        //Academic course level text
        gbc.gridx = 1;
        levelText = new JTextField(10);
        levelText.setFont(f);
        panelac.add(levelText,gbc);
        
        //Academic course credit
        gbc.gridx = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        credit = new JLabel("Credit:");
        credit.setFont(f);
        panelac.add(credit,gbc);
        //Academic course credit text
        gbc.gridx = 3;
        gbc.anchor= GridBagConstraints.PAGE_START;
        creditText = new JTextField(10);
        creditText.setFont(f);
        panelac.add(creditText, gbc);
        
        //Academic course nofAssessment
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        nofAssessments = new JLabel("No.of.Assessment:");
        nofAssessments.setFont(f);
        panelac.add(nofAssessments,gbc);
        //Academic course noFassessmentText
        gbc.gridx = 5;
        nofAssessmentsText = new JTextField(10);
        nofAssessmentsText.setFont(f);
        panelac.add(nofAssessmentsText,gbc);
        
        //Academic Add Button
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor= GridBagConstraints.PAGE_START;
        addAcademic = new JButton("Add");
        addAcademic.setPreferredSize(dButton);
        addAcademic.setFont(f);
        //Event handler when add button is clicked
        addAcademic.addActionListener(this);
        panelac.add(addAcademic,gbc);
        
        //Academic  course id
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        courseIdac = new JLabel("Course Id:");
        courseIdac.setFont(f);
        panelac.add(courseIdac, gbc);
        //Academic course id text
        gbc.gridx = 1;
        courseIdTextac = new JTextField(10);
        courseIdTextac.setFont(f);
        panelac.add(courseIdTextac,gbc);
        
        //Academic course leader
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        courseLeader = new JLabel("Course Leader:");
        courseLeader.setFont(f);
        panelac.add(courseLeader, gbc);
        //Academic course leader text
        gbc.gridx = 5;
        courseLeaderText = new JTextField(10);
        courseLeaderText.setFont(f);
        panelac.add(courseLeaderText, gbc);
        
        //Academic course lecturer name
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        lecturerName = new JLabel("Lecturer Name:");
        lecturerName.setFont(f);
        panelac.add(lecturerName,gbc);
        //Academic course lecturer name text
        gbc.gridx = 1;
        lecturerNameText = new JTextField(10);
        lecturerNameText.setFont(f);
        panelac.add(lecturerNameText,gbc);
        
        //Academic course start date
        gbc.gridx = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        startDate = new JLabel("Starting date:");
        startDate.setFont(f);
        panelac.add(startDate, gbc);
        //Academic course start date text
        gbc.gridx = 3;
        gbc.anchor= GridBagConstraints.PAGE_START;
        startDateText = new JTextField(10);
        startDateText.setFont(f);
        panelac.add(startDateText,gbc);
        
        //Academic course completion date
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        completionDate = new JLabel("Completion date:");
        completionDate.setFont(f);
        panelac.add(completionDate,gbc);
        //Academic course completion date text
        gbc.gridx = 5;
        completionDateText = new JTextField(10);
        completionDateText.setFont(f);
        panelac.add(completionDateText,gbc);
        
         //Academic registerButton
        gbc.gridx = 2;
        gbc.gridy = 6;
        registerAcademic = new JButton("Register");
        registerAcademic.setPreferredSize(dButton);
        registerAcademic.setFont(f);
        //Handle event when register button is clicked
        registerAcademic.addActionListener(this);
        panelac.add(registerAcademic, gbc);
        
        //Academic display Button
        gbc.gridx = 3;
        displayAcademic = new JButton("Display");
        displayAcademic.setPreferredSize(dButton);
        displayAcademic.setFont(f);
        //Handle event when display button is clicked
        displayAcademic.addActionListener(this);
        panelac.add(displayAcademic,gbc);

        //title for non academic course
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        titleNonAcademic = new JLabel("Non-Academic Course");
        titleNonAcademic.setPreferredSize(new Dimension(400,80));
        titleNonAcademic.setFont(new Font("Verdana", Font.BOLD, 30));
        panelnac.add(titleNonAcademic,gbc);

        //Non Academic course id
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        courseIdn = new JLabel("Course Id:");
        courseIdn.setFont(f);
        panelnac.add(courseIdn,gbc);
        //Non Academic course id text
        gbc.gridx = 1;
        courseIdnText = new JTextField(10);
        courseIdnText.setFont(f);
        panelnac.add(courseIdnText,gbc);
      
        //Non Academic course name
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        courseNamenac = new JLabel("Course Name:");
        courseNamenac.setFont(f);
        panelnac.add(courseNamenac,gbc);
        //Non Academic course name text
        gbc.gridx = 5;
        courseNamenacText = new JTextField(10);
        courseNamenacText.setFont(f);
        panelnac.add(courseNamenacText,gbc);
        
        //Non Academic course duration
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        durationnac = new JLabel("Duration:");
        durationnac.setFont(f);
        panelnac.add(durationnac,gbc);
        //Non academic course duration text
        gbc.gridx = 1;
        durationnacText = new JTextField(10);
        durationnacText.setFont(f);
        panelnac.add(durationnacText,gbc);
        
        //Non academic course prerequisite
        gbc.gridx = 4;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;
        prerequisites = new JLabel("Prerequisite:");
        prerequisites.setFont(f);
        panelnac.add(prerequisites,gbc);
        //Non academic course prerequsite text
        gbc.gridx = 5;
        prerequisitesText = new JTextField(10);
        prerequisitesText.setFont(f);
        panelnac.add(prerequisitesText,gbc);
        
        //Non academic course add button
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor= GridBagConstraints.PAGE_START;
        addNonAcademic = new JButton("Add");
        addNonAcademic.setPreferredSize(dButton);
        addNonAcademic.setFont(f);
        //Handle event when add button for non academic is clicked
        addNonAcademic.addActionListener(this);
        panelnac.add(addNonAcademic,gbc);
        
         //Non Academic  course id
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        courseIdnac = new JLabel("Course Id:");
        courseIdnac.setFont(f);
        panelnac.add(courseIdnac,gbc);
        
        //Academic course id text
        gbc.gridx = 1;
        courseIdnacText = new JTextField(10);
        courseIdnacText.setFont(f);
        panelnac.add(courseIdnacText,gbc);
        
        // Non Academic course leader
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        courseLeadernac = new JLabel("Course Leader:");
        courseLeadernac.setFont(f);
        panelnac.add(courseLeadernac,gbc);
        //Non Academic course leader text
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.PAGE_START;
        courseLeadernacText = new JTextField(10);
        courseLeadernacText.setFont(f);
        panelnac.add(courseLeadernacText,gbc);
        
        //Non Academic instructor Name
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        instructorName = new JLabel("Instructor Name:");
        instructorName.setFont(f);
        panelnac.add(instructorName,gbc);
        //Non Academic instructor Name text
        gbc.gridx = 5;
        instructorNameText = new JTextField(10);
        instructorNameText.setFont(f);
        panelnac.add(instructorNameText,gbc);
        
        
        //Non Academic course start date
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        startDatenac = new JLabel("Starting Date:");
        startDatenac.setFont(f);
        panelnac.add(startDatenac,gbc);
        //Non Academic course start date text
        gbc.gridx = 1;
        startDatenacText = new JTextField(10);
        startDatenacText.setFont(f);
        panelnac.add(startDatenacText,gbc);
        
        //NonAcademic course exam date
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        examDate = new JLabel("Exam date:");
        examDate.setFont(f);
        panelnac.add(examDate,gbc);
        //Non Academic course completion date text
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.PAGE_START;
        examDateText = new JTextField(10);
        examDateText.setFont(f);
        panelnac.add(examDateText,gbc);
        
        //NonAcademic course completion date
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        completionDatenac = new JLabel("Completion date:");
        completionDatenac.setFont(f);
        panelnac.add(completionDatenac,gbc);
        //Non Academic course completion date text
        gbc.gridx = 5;
        completionDatenacText = new JTextField(10);
        completionDatenacText.setFont(f);
        panelnac.add(completionDatenacText,gbc);
        
        //Non Academic registerButton
        gbc.gridx = 1;
        gbc.gridy = 6;
        registerNonAcademic = new JButton("Register");
        registerNonAcademic.setPreferredSize(dButton);
        registerNonAcademic.setFont(f);
        //Handle event when register button for non academic is clicked
        registerNonAcademic.addActionListener(this);
        panelnac.add(registerNonAcademic,gbc);
        
       
        //Non Academic display Button
        gbc.gridx = 3;
        displayNonAcademic = new JButton("Display");
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        displayNonAcademic.setPreferredSize(dButton);
        displayNonAcademic.setFont(f);
        //Handle event when display button for non academic is clicked
        displayNonAcademic.addActionListener(this);
        panelnac.add(displayNonAcademic,gbc);
        
        //Remove non academic course
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        remove = new JButton("Remove");
        remove.setPreferredSize(dButton);
        remove.setFont(f);
        //handle event when remove button is clicked
        remove.addActionListener(this);
        panelnac.add(remove,gbc);
        
        //default dimension for some buttons
        Dimension d = new Dimension(600,60);
        
        //Clear All text in screen
        clearText = new JButton("Clear Screen (Ctrl+N)");
        clearText.setFont(f);
        clearText.setPreferredSize(d);
        clearText.addActionListener(this);
        JPanel south = new JPanel(new GridLayout(1,1));
        south.add(clearText);
        
        // cardlayout...add each i.e. academic and non academic to different side of card layout
        panel.add(panelac, "1");
        panel.add(panelnac, "2");
        
        //initially show the academic
        cl.show(panel, "1");
        
        //jbutton to switch to Non Acadmic course
        JButton acSwitch = new JButton("Non-Academic Course");
        acSwitch.setPreferredSize(d);
        acSwitch.setFont(f);
        
        //jbutton to switch to academic course, initially checked
        JButton nacSwitch = new JButton("Academic Course");
        nacSwitch.setPreferredSize(d);
        //set font background and foreground color
        nacSwitch.setBackground(Color.BLUE);
        nacSwitch.setForeground(Color.WHITE);
        nacSwitch.setFont(f);
        
        //create panel for 2 switches/buttons and add them
        JPanel north = new JPanel(new GridLayout(1,2));
        north.add(nacSwitch);
        north.add(acSwitch);
        
        //event handler for non academic button
        acSwitch.addActionListener (new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //show next panel and change the foreground and background color
                cl.show(panel,"2");
                nacSwitch.setBackground(new JButton().getBackground());
                acSwitch.setBackground(Color.BLUE);
                acSwitch.setForeground(Color.WHITE);
                nacSwitch.setForeground(Color.BLACK);
            }
        });
        
        //event handler for academic button
        nacSwitch.addActionListener (new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //show next panel and change the foreground and background color
                cl.show(panel,"1");
                acSwitch.setBackground(new JButton().getBackground());
                nacSwitch.setBackground(Color.BLUE);
                nacSwitch.setForeground(Color.WHITE);
                acSwitch.setForeground(Color.BLACK);
            }
        });
        
        //manage frame with layout
        frame.setLayout(new BorderLayout());
        //add two buttons to north
        frame.add(north, BorderLayout.NORTH);
        //all remaining data to center
        frame.add(panel, BorderLayout.CENTER);
        //clear button to south
        frame.add(south, BorderLayout.SOUTH);
        
        //set default characterstics of frame for exit size and location
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1330, 780);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // handle all event
    public void actionPerformed(ActionEvent e)
    {
        // when add button is clicked for academic course
        if (e.getSource() == addAcademic)
        {
            //Check if any of the field is empty
            if (getData(courseIdText).equals("") || getData(durationText).equals("") || getData(courseNameText).equals("") ||
                getData(levelText).equals("") || getData(creditText).equals("") || getData(nofAssessmentsText).equals(""))
                {
                    JOptionPane.showMessageDialog(frame, "All the fields are required...Please fill them before adding","Error....Empty input field",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            
            // Get id and check if it already exists
            String id = getData(courseIdText);
            for (Course c : academicCourseList)
            {
                if (c.getCourseId().equals(id))
                {
                    JOptionPane.showMessageDialog(frame, "The id: "+id+" has already been added...enter a new id","Error....duplicate id",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            //Get course name and check if it has numbers
            String cn = getData(courseNameText);
            if(!checkString(cn))
            {
                JOptionPane.showMessageDialog(frame, "Course name cannot have string on it", "Error....invalid character", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Get duraiton and check if it is integer
            String dur = getData(durationText);
            if (!checkInt(dur))
            {
                JOptionPane.showMessageDialog(frame, "Please enter only integer value for duration!!",
                "Error...Invalid input",JOptionPane.ERROR_MESSAGE);
                return;  
            }
            
            //get level data
            String lvl = getData(levelText);
            
            //Get credit and check if is integer
            String credit = getData(creditText);
            if (!checkInt(credit))
            {
                JOptionPane.showMessageDialog(frame, "Please enter only integer value for credit!!",
                "Error...Invalid input",JOptionPane.ERROR_MESSAGE);
                return;  
            }
            
            //Get number of assessments and check if is integer
            String noa = getData(nofAssessmentsText);
            if (!checkInt(noa))
            {
                JOptionPane.showMessageDialog(frame, "Please enter only integer value for No Of Assessment!!",
                "Error...Invalid input",JOptionPane.ERROR_MESSAGE);
                return;  
            }

            // if every condition satisfied add course to the list
            c = new AcademicCourse(id, cn, Integer.parseInt(dur), lvl, Integer.parseInt(credit), Integer.parseInt(noa));
            academicCourseList.add(c);
            //display sucessfull message
            JOptionPane.showMessageDialog(frame, "The course with id: "+id+" has been successfully added!");
        } 
        
        //when register button is clicked for academic course
        if (e.getSource() == registerAcademic)
        {
            
            //Check if any text field is empty
            if (courseLeaderText.getText().isEmpty() || lecturerNameText.getText().isEmpty() || startDateText.getText().isEmpty() ||
                completionDateText.getText().isEmpty() || courseIdTextac.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "All the fields are required...Please fill them before adding","Error...empty input field",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            
            //Get the entered id to add 
            String idac = getData(courseIdTextac);
            //Loop until the end of academic course array list
            for (int i = 0; i < academicCourseList.size(); i++)
            {
                //Check if the entered id is has a course
                if ((academicCourseList.get(i).getCourseId()).equals(idac))
                {
                    //Casting parent to child object
                    AcademicCourse nac = (AcademicCourse)(academicCourseList.get(i));
                    
                    // If not registered then register the course
                    if (!nac.getIsRegistered())
                    {
                        //get courseleader name and check if name any numbers
                        String cl = getData(courseLeaderText);
                        if(!checkString(cl))
                        {
                            JOptionPane.showMessageDialog(frame, "Course leader name should only have alphabets", "Error...Invalid character",
                                JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        //get lecturer name and check if name has any numbers
                        String ln = getData(lecturerNameText);
                        if(!checkString(ln))
                        {
                            JOptionPane.showMessageDialog(frame, "Lecturer name should only have alphabets", "Error...invalid character",
                                JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //get start date
                        String sd = getData(startDateText);
                        //get completion date
                        String cd = getData(completionDateText);
                        //regsiter the course
                        nac.register(cl, ln, sd, cd);
                        JOptionPane.showMessageDialog(frame, "The course with id: "+idac+" has been successfully registered.");
                        return;
                    }
                    else
                    {
                        //course with given id already registered so display message
                        JOptionPane.showMessageDialog(frame, "The course with id: "+idac+" has already been registered.","Error....duplicate registration",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            // If the course was not registered, print courseId not found
            JOptionPane.showMessageDialog(frame, "The course with id: "+idac+" was not found!", "Error...id not found",
                JOptionPane.ERROR_MESSAGE);
            }
        
        //When display button is clicked for academic course
        if (e.getSource() == displayAcademic)
        {
            //Determine table title and value its gonna hold
            String [][]str = new String[academicCourseList.size()][11];
            String []title = {"Course Id", "Course Name", "CourseLeader", "Duration","Is Registered", "Lecturer Name", "Level", "Credit",
                "Starting Date", "Completion Date", "No.of.Assessments"};
                
            //Loop over the array to enter course values in 2d array
            for (int i =0; i < academicCourseList.size(); i++)
            {
                //store all the value in 2d list
                str[i][0] = academicCourseList.get(i).getCourseId();
                str[i][1] = academicCourseList.get(i).getCourseName();
                str[i][2] = academicCourseList.get(i).getCourseLeader();
                str[i][3] = String.valueOf(academicCourseList.get(i).getDuration());
                //down cast to AcademicCourse class
                AcademicCourse ac = (AcademicCourse)academicCourseList.get(i);
                str[i][4] = String.valueOf(ac.getIsRegistered());
                str[i][5] = ac.getLecturerName();
                str[i][6] = ac.getLevel();
                str[i][7] = String.valueOf(ac.getCredit());
                str[i][8] = ac.getStartingDate();
                str[i][9] = ac.getCompletionDate();
                str[i][10] = String.valueOf(ac.getNumberOfAssessments());
            }
             
            //Display table in new frame
            JFrame fr = new JFrame("Diplay Academic Records");
            JTable jt = new JTable(str, title);
            jt.getTableHeader().setFont(new Font("Serif",Font.BOLD, 22));
            jt.setRowHeight(30);
            jt.setFont(new Font("Arial",Font.BOLD, 18));
            JScrollPane sp=new JScrollPane(jt);    
            fr.add(sp);  
            fr.setSize(1800, 680);  
            fr.setVisible(true);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
        //When add button is clicked for non-academic course
        if (e.getSource() == addNonAcademic)
        {
            //check if any required field is empty
            if (courseIdnText.getText().isEmpty() || courseNamenacText.getText().isEmpty() || durationnacText.getText().isEmpty() ||
                prerequisitesText.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "All the fields are required...Please fill them before adding","Error....input field empty",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //get id to add
            String id = getData(courseIdnText);
            
            //check if id already exists
            for (Course c : nonAcademicCourseList)
            {
                if (c.getCourseId().equals(id))
                {
                    JOptionPane.showMessageDialog(frame, "The course with id "+c.getCourseId()+" has already been added.","Error...duplicate id",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            //course name and check if it has any numbers
            String cn = getData(courseNamenacText);
            if(!checkString(cn))
            {
                JOptionPane.showMessageDialog(frame, "Course name cannot have string on it", "Error...Invalid Character",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

            String dur = getData(durationnacText);
            //check if duration only has integer
            if (!checkInt(dur))
            {
              JOptionPane.showMessageDialog(frame, "Please enter only integer value for duration!!",
                "Error...Invalid input",JOptionPane.ERROR_MESSAGE);
                return;  
            }
            
            //if all condition satisfied add course
            String pre = getData(prerequisitesText);
            c = new NonAcademicCourse(id, cn, Integer.parseInt(dur),pre);
            nonAcademicCourseList.add(c);
            //display appropriate message
            JOptionPane.showMessageDialog(frame, "The course with id: "+id+" has been added!");
        }
        
        //When register button is clicked for Non academic course
        if (e.getSource() == registerNonAcademic)
        {
            //check if any of the required field is empty
            if (courseIdnacText.getText().isEmpty() || courseLeadernacText.getText().isEmpty() || instructorNameText.getText().isEmpty() ||
                startDatenacText.getText().isEmpty() || completionDatenacText.getText().isEmpty() || examDateText.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "All the fields are required...Please fill them before adding","Error...Empty Fields",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //id to register and check if exists
            String id = getData(courseIdnacText);
            for (int i = 0; i < nonAcademicCourseList.size(); i++)
            {
                if ((nonAcademicCourseList.get(i).getCourseId()).equals(id))
                {
                    NonAcademicCourse nac = (NonAcademicCourse)(nonAcademicCourseList.get(i));
                    
                    //register if not registered
                    if (!nac.getIsRegistered())
                    {
                        //get course leader and check if it has any numbers
                        String cl = getData(courseLeadernacText);
                        if(!checkString(cl))
                        {
                            JOptionPane.showMessageDialog(frame, "Course leader name cannot have string on it", "Error....Invalid character", 
                            JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        //get instructor name and check if it has any numbers
                        String in = getData(instructorNameText);
                        if(!checkString(in))
                        {
                            JOptionPane.showMessageDialog(frame, "Instructor name cannot have string on it", "Error....Invalid character",
                            JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //get starting date
                        String sd = getData(startDatenacText);
                        //get completion date
                        String cd = getData(completionDatenacText);
                        //get exam date
                        String ed = getData(examDateText);
                        //if all conditions are satisfied register the course
                        nac.register(cl, in, sd, cd,ed);
                        JOptionPane.showMessageDialog(frame, "The course with id: "+id+" has been registered.");
                        return;
                    }
                    else
                    {
                        // if id already registered return message
                        JOptionPane.showMessageDialog(frame, "Cannot register id: "+id+" already exists.","Error....duplicate registration",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            //if id could not be found
            JOptionPane.showMessageDialog(frame, "The course with id: "+id+" was not found!","Error....id not found", 
            JOptionPane.ERROR_MESSAGE);
        }
        
        //When display button is clicked for Non academic course
        if (e.getSource() == displayNonAcademic)
        {
            //Get title and value for the table
            String [][]str = new String[nonAcademicCourseList.size()][10];
            String []title = {"Course Id", "Course Name", "CourseLeader", "Duration","Is Registered", "Prerequisite", "Instructor Name",
                "Starting Date", "Completion Date", "Exam Date"};
                
            //run the loop until end of list
            for (int i =0; i < nonAcademicCourseList.size(); i++)
            {
                //store value in the 2d arrray
                str[i][0] = nonAcademicCourseList.get(i).getCourseId();
                str[i][1] = nonAcademicCourseList.get(i).getCourseName();
                str[i][2] = nonAcademicCourseList.get(i).getCourseLeader();
                str[i][3] = String.valueOf(nonAcademicCourseList.get(i).getDuration());
                //down cast to nonacademic course class
                NonAcademicCourse nac = (NonAcademicCourse)nonAcademicCourseList.get(i);
                str[i][4] = String.valueOf(nac.getIsRegistered());
                str[i][5] = nac.getPrerequisite();
                str[i][6] = nac.getInstructorName();
                str[i][7] = nac.getStartingDate();
                str[i][8] = nac.getCompletionDate();
                str[i][9] = nac.getExamDate();  
            }
            
            //add table to a new frame
            JFrame fr = new JFrame("Diplay Non-Academic Records");
            JTable jt = new JTable(str, title);
            jt.getTableHeader().setFont(new Font("Serif",Font.BOLD, 22));
            jt.setRowHeight(30);
            jt.setFont(new Font("Arial",Font.BOLD, 18));
            JScrollPane sp=new JScrollPane(jt);    
            fr.add(sp);  
            fr.setSize(1800, 840);  
            fr.setVisible(true);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
        //When remove button is clicked
        if (e.getSource() == remove)
        {
            //get course id to delete
            String id = getData(courseIdnacText);
            if (id.isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please enter an course id to delete","Error..No Id found",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //iterate through the list and delete the course with target id
            Iterator<Course> itr = nonAcademicCourseList.iterator();
            while (itr.hasNext())
            {
                Course c = itr.next();
                if (c.getCourseId().equals(id))
                {
                    NonAcademicCourse nac = (NonAcademicCourse)c;
                    //if not removed remove the id
                    if (!nac.getIsRemoved())
                    {
                        //call remove method from Non academic course class
                        nac.remove();
                        //remove the item from the array list as well
                        itr.remove();
                        JOptionPane.showMessageDialog(frame, "The course with id:" +id+" has been removed from the list");
                        return;
                    }    
                }
            }
            //if id has been already deleted or never existed display below message
            JOptionPane.showMessageDialog(frame, "The course with id:" +id+" does not exist in the list", "Error-Id does not exist",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        //when clearText button or new from menu bar is clicked
        if (e.getSource() == clearText || e.getSource() == news)
        {
            //call setData method to set all the fields empty
            setData(courseIdText);
            setData(courseIdTextac);
            setData(courseNameText);
            setData(durationText);
            setData(courseLeaderText);
            setData(lecturerNameText);
            setData(levelText);
            setData(creditText);
            setData(startDateText);
            setData(completionDateText);
            setData(nofAssessmentsText);
            setData(courseIdnText);
            setData(courseIdnacText);
            setData(courseNamenacText);
            setData(durationnacText);
            setData(courseLeadernacText);
            setData(instructorNameText);
            setData(startDatenacText);
            setData(completionDatenacText);
            setData(examDateText);
            setData(prerequisitesText);
        }  
    }

    
    //Check if a string has only letters and spaces
    public boolean checkString(String toCheck)
    {
        for(int i = 0; i < toCheck.length(); i++)
        {
            char c = toCheck.charAt(i);
            //if either character or empty space keep the loop running
            if (Character.isLetter(c) ||  c == ' ')
            {
                continue;
            }
            return false;
        }
        //if loop run till end without error return true
        return true;
    }
    
    //check if a string has only numbers
    public boolean checkInt(String toCheck)
    {
        // try to convert string to integer and return true if can false otherwise
        try
        {
            int convert = Integer.parseInt(toCheck);
            return true;
        }
        catch (Exception exp)
        {
            return false;
        } 
    }
    
    // set value to a textfield
    public void setData(JTextField f)
    {
        f.setText("");
    }
    
    //get value from a textfield
    public String getData(JTextField f)
    {
        return f.getText();
    }
    
    //execute the main function
    public static void main(String[] args)
    {
        //create an instance of INGCollege class
        INGCollege myCollege = new INGCollege();   
    }
}

