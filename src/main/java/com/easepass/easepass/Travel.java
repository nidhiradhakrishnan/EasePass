package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Travel {

    @Id
    public Integer id;
    public String from;
    public String to;
    public Integer fare;

    public Travel() {}

    public Travel(Integer id, String from, String to, Integer fare) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.fare = fare;
    }

}