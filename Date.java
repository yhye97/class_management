/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmanagementsystem_2016104140;

/**
 *
 * @author yhye97
 */

public class Date {
     private int month;
     private int day;
     private int year;
     
    public Date(int m, int d, int y){
        /*m/day/year*/
        month=m;
        day=d;
        year=y;
    }
    void setMonth(int m)
    {
        month=m;
    }
    void setDay(int d)
    {
        day=d;
    }
    void setYear(int y)
    {
        year=y;
    }
    int getMonth()
    {
        return month;
    }
    int getDay()
    {
        return day;
    }
    int getYear()
    {
        return year;
    }
    void displayDate()
    {
        System.out.println(month+"/"+day+"/"+year);
    }
    Date addOneWeek(Date d)
    {
        d.setDay(d.getDay()+7);
        if(d.getDay()>=29)
        {
            if(d.getDay()>31)
            {
                if(d.getMonth()==1 || d.getMonth()==3 ||d.getMonth()==5 ||d.getMonth()==7 ||d.getMonth()==8 || d.getMonth()==10 ||d.getMonth()==12)
                { 
                    d.setDay(d.getDay()-31);
                }
                else if(d.getMonth()==4 || d.getMonth()==6 ||d.getMonth()==9 ||d.getMonth()==11)
                {
                     d.setDay(d.getDay()-30);
                }
            }
            
            if(d.getMonth()==2 && d.getMonth()%4==0 && d.getDay()>29)
            {
                d.setMonth(d.getMonth()+1);
                d.setDay(d.getDay()-29);
            }
            else if(d.getMonth()==2 && d.getMonth()%4!=0 && d.getDay()>28)
            {
                d.setMonth(d.getMonth()+1);
                d.setDay(d.getDay()-28);
            }
        }
        
        if(d.getMonth()+1>12)
        {
           d.setMonth(1);
           d.setYear(d.getYear()+1);
        }
        
        return d;
    }
    boolean valid_date(Date d)
    {
        if(d.getMonth()==1 || d.getMonth()==3 ||d.getMonth()==5 ||d.getMonth()==7 ||d.getMonth()==8 || d.getMonth()==10 ||d.getMonth()==12)
        { 
            if(d.getDay()>31)
                return false;
        }
                
        else if(d.getMonth()==4 || d.getMonth()==6 ||d.getMonth()==9 ||d.getMonth()==11)
        {
            if(d.getDay()>30)
                return false;   
        }
        else if(d.getMonth()==2 && d.getMonth()%4==0 && d.getDay()>29)
        {
            return false;
        }
        else if(d.getMonth()==2 && d.getMonth()%4!=0 && d.getDay()>28)
        {
            return false;
        }
        return true;
    } 

    
}

