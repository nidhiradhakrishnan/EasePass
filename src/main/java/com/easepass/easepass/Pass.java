package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.time.*;
import java.time.temporal.*;


@Entity
public class Pass {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id ;
    public String student;
    public Date onwardtime;
    public String conductoron;
    public Date returntime;
    public String conductorre;


    public Pass() {}

    public Pass(Integer id, String student,Date onwardtime, String conductoron,Date returntime,String conductorre) {
        this.id = id;
        this.student = student;
        this.onwardtime = onwardtime;
        this.conductoron = conductoron;
        this.returntime = returntime;
        this.conductorre = conductorre;

            }

}