package edu.gatech.team7339.vetchain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private String petname;
    @Column(nullable = false)
    private String species;
    @Column(nullable = false)
    private String sex;
    @Column (nullable = false)
    private String age;
    @Column
    private String xrayUrl;
    @Column
    private String RecordUrl;


}
