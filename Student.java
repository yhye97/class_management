/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmanagementsystem_2016104140;
import java.util.Scanner; 
/**
 *
 * @author yhye97
 */
public class Student {
    private String firstName;
    private String lastName;
    private int StudentId;
    private Date dateOfBirth;
    private int gender;
    private String email;
    private Subject mySubjects[]= new Subject[7];
    
    Student(){
     String name;
     Scanner sc=new Scanner(System.in);
     System.out.print("Name : ");
     name=sc.next();
     setName(name);
     
     String b_day;
     String [] bday;
     System.out.print("Date of Birth : ");
     b_day=sc.next();
     bday=b_day.split("/");
     int day = Integer.parseInt(bday[0]);
     int month=Integer.parseInt(bday[1]);
     int year=Integer.parseInt(bday[2]);
     Date d=new Date(month,day,year);
     
     String gender;
     System.out.print("Gender:");
     gender=sc.next();
     setGender(gender);
     
     String email;
     System.out.print("Email: ");
     email=sc.next();
     setEmail(email);
    }
    
    Student(String fname, String lname, int sid, Date bday, String gender, String email){
        setFirstName(fname);
        setLastName(lname);
        setStudentId(sid);
        setDateofBirth(bday);
        setGender(gender);
        setEmail(email);
    }
    
    Student(String Fullname, int StudentId, String Email)
    {
        setName(Fullname);
        setStudentId(StudentId);
        setEmail(Email);
    }
    
    void addSubject()
    {
        Subject s = new Subject();
    }
    
    void setName(String fullname)
    {
         String [] name;
         name=fullname.split(" ");
        if(name.length!=0)
        {
            setFirstName(fullname.substring(0,fullname.indexOf(name[name.length-1])));
            setLastName(name[name.length-1]);
        }
        else
        {
             setFirstName("");
            setLastName(fullname);
        }
    }
    void setFirstName(String firstname)
    {
        firstName=firstname;
    }
    
    void setLastName(String lastname)
    {
        lastName=lastname;
    }
    
    void setStudentId(int sid)
    {
        StudentId=sid;
    }

    void setGender(String g)
    {
        if(g.equals("male"))
        {
            gender=1;
        }
        else
        {
            gender=2;
        }
    }
    void setGender(int g)
    {
        gender=g;
    }
    void setDateofBirth(Date bday)
    {
       dateOfBirth=bday;
    }
    void setEmail(String email)
    {
        this.email=email;
    }
     String getName()
    {
        return firstName+" "+lastName;
    }
     String getFirstname()
     {
         return firstName;
     }
     String getLastName()
     {
         return lastName;
     }
     
     String getGender()
     {
         if(gender==1)
         {
             return "male";
         }
         else
         {
             return "female";
         }
        
     }
     void addMySubjects(Subject s)
     {
        for(int i=0; i<mySubjects.length;i++)
        {
            if(mySubjects[i]!=null)
            {
                mySubjects[i]=s;
                break;
            }
        }
     }
    
     Subject[] getMySubjects()
    {
        return mySubjects;
    }
    
     void displayMySubjects()
     {
        System.out.print("MySubjects: ");
        for(int i=0; i<mySubjects.length;i++)
        {
            System.out.println(mySubjects[i]+" ");
        }
     }
     
     //(String fname, String lname, int sid, Date bday, String gender, String email)
    void displayStudent()
    {
        System.out.println("Name: "+ firstName + " " +lastName);
        System.out.println("Student Id: "+ StudentId);
        System.out.println("Date of Birth: "+ dateOfBirth);
        System.out.println("Gender: "+ getGender());
        System.out.println("Email: "+ email);
        displayMySubjects();
    }
    
}

