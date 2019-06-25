/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmanagementsystem_2016104140;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author yhye97
 */
public class StudentRecorderTest {
   private static String[] LastNames= {"Yoon", "Kim", "Lee", "Chung", "Kang", "Yoo", "Choi", "Obama", "Curry", "Moon"};
   private static String [] FirstNames={"Kelly","Jennifer","Michelle","Sasha","Maggie","Jake","Michael","Stephen","Billy", "Kevin"};
   private String [] CourseTitles= {"C++","Java","Python","OpenSource","Data Structure","Algorithm","IoT","AI","Big Data", "Cloud Computing"};
   private String [] CourseCodes= {"CE01","CE02","CE03","CE04","CE05","CE06","CE07","CE08","CE09","CE10"};
   private int studentid=0;
   private int studentcount=0;
   
   String setEmailbyName(String fullName)
     {
         String name=fullName.replaceAll(" ","_");
         String email=name+"@khu.ac.kr";
         return email;
     }
   String getRandomName(int gender)
   {
       if(gender==1)
       {
           Random r=new Random();
           int l_index= r.nextInt(10);
           int f_index=r.nextInt(5)+5;
           return FirstNames[f_index]+" "+LastNames[l_index];
       }
       else
       {
           Random r=new Random();
           int l_index= r.nextInt(10);
           int f_index=r.nextInt(5);
           return FirstNames[f_index]+" "+LastNames[l_index];
       }
   }
   
Date randomstartDate()
   {
        //Korean University's months start at first week of March or Sep
       Random r=new Random();
       int day=r.nextInt(7)+1;
       int month=r.nextInt(2);
      
       if(month==0)
       {
           month=3;
       }
       else
       {
           month=9;
       }
       int year=2019;
       
       Date s_date=new Date(month,day,year);
       return s_date;
   }
   
Subject[] randomCourses()
   {
       int [] t_array=new int[10];
       Subject [] courses=new Subject[7];
       for(int i=0; i<10; i++)
       {
           t_array[i]=i;
       }
       
       for(int i=0; i<7; i++)
       {
           Random r=new Random();
           
           int index=r.nextInt(10);
           while(t_array[index]==-1)
           {
               index=r.nextInt(10);
           }
           Subject s= new Subject();
           s.create_instance(CourseTitles[index], CourseCodes[index], randomstartDate());
           displayCourse(CourseTitles[index], CourseCodes[index], randomstartDate());
           courses[i]=s;
           t_array[index]=-1;
       }
       return courses;
   }
 void displayCourse(String title, String code, Date date)
 {
     System.out.println("Title: "+title);
     System.out.println("Code: "+code);
     date.displayDate();
 }
int randomStudentId()
   {
       //Usually Korean University Students get accepted when they are 20-23 years old
       //studentId: year accepted+studentcountnumber; ex)20161 (first studentid that was accepted at year 2016)
       Random r=new Random();
       int syear=r.nextInt(4);
       studentcount++;
       studentid=(2019-syear)*10+studentcount;
       return studentid;
   }
   
 Student[] randomStudents()
   {
      Student [] randomstudents100=new Student [100];
      for(int i=0; i<100;i++)
       {
           Random r=new Random();
           int gender=r.nextInt(2)+1;
           int sid=randomStudentId();
           String name=getRandomName(gender);
           String email=setEmailbyName(name);
           Student s=new Student(name,sid,email);
           randomstudents100[i]=s;
        }
       return randomstudents100;
   }
   
   public void main (String args[])
   {
      System.out.println("Class Management System: ");
      randomCourses();
      for(int i=0; i<100;i++)
      {
          randomStudents()[i].displayStudent();
          Random r=new Random();
          int num=r.nextInt(7)+1;
          for (int j=0; j<num; j++)
          {
            int index= r.nextInt(7);
            randomStudents()[i].addMySubjects(randomCourses()[index]);
          }
          randomStudents()[i].displayMySubjects();
      }
   }
}
