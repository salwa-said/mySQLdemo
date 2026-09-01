package com.cl.mysqldemo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    private String location;


    @OneToMany
    List<Student> students;


    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

}
