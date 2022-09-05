package com.example.springproves.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    private String name;
    private int edad;
    private String born_date;


   /*public Player(Long id, String name, int edad, Date born_date) {
        this.Id = id;
        this.name = name;
        this.edad = edad;
        this.born_date = born_date;
    }

    public Player() {

    }*/

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBorn_date() {
        return born_date;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }
}
