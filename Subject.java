/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmanagementsystem_2016104140;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author yhye97
 */
public class Subject {
    private int semester;
    private Date startDate;
    private Date lecturesDate[]= new Date[18];
    private Student Students[]= new Student[45];
    
    Subject()
    {
     int semester;
     Scanner sc=new Scanner(System.in);
     System.out.print("Semester : ");
     semester=sc.nextInt();
     setSemester(semester);
     
     String s_date;
     String [] sdate;
     System.out.print("startDate : ");
     s_date=sc.next();
     sdate=s_date.split("/");
     int day = Integer.parseInt(sdate[0]);
     int month=Integer.parseInt(sdate[1]);
     int year=Integer.parseInt(sdate[2]);
     Date d=new Date(month,day,year);
     setStartDate(d);
    
    }
    Subject(int semester, Date startDate)
    {
        setSemester(semester);
        setStartDate(startDate);
    }
    void create_instance(String courseTitle, String courseCode, Date startDate)
    {
        Title t=new Title(courseTitle);
        Code c=new Code(courseCode);
        this.startDate=startDate;
    }
    
    void setSemester(int semester)
    {
        this.semester=semester;
    }
    void setStartDate(Date startDate)
    {
        this.startDate=startDate;
    }
    void setLectureDate(Date lectureDate)
    {
        this.lecturesDate=lecturesDate;
    }
    
    void populateLecture()
    {
       lecturesDate[0]=(startDate);
       for(int i=1;i<lecturesDate.length;i++)
       {
           lecturesDate[i].addOneWeek(lecturesDate[i-1]);
       }
    }
    
    void addStudent(Student s)
    {
        Students[Students.length]=s;
    }
    
    class Title
    {
        private String title;
        Title(String title)
        {
           this.title=title;
        }
       
        String getTitle()
        {
            return title;
        }
    }
    class Code
    {
        private String classCode;
        Code(String classCode)
        {
            this.classCode=classCode;
        }
        
        String getCode()
        {
            return classCode;
        }
   
    }
   
    
}
